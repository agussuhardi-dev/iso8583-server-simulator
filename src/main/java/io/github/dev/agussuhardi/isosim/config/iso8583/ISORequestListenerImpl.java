package io.github.dev.agussuhardi.isosim.config.iso8583;


import io.github.dev.agussuhardi.isosim.entity.History;
import io.github.dev.agussuhardi.isosim.repository.HistoryRepository;
import io.github.dev.agussuhardi.isosim.repository.Iso8583Repository;
import io.github.dev.agussuhardi.isosim.util.Iso8583Util;
import io.github.dev.agussuhardi.isosim.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.*;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author agussuhardi
 * {@code @created} 6/28/24 7:11 AM
 * {@code @project} isosim
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ISORequestListenerImpl implements ISORequestListener {

    private final HistoryRepository historyRepository;
    private final Iso8583Repository iso8583Repository;

    @Value("${vars.server.port}")
    private int port;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() throws Exception {
        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));
        ISOPackager packager = new GenericPackager("classpath:packager.xml");
//        ServerChannel channel = new XMLChannel(packager);
//        ServerChannel channel = new ASCIIChannel(packager);
        ServerChannel channel = new ChannelConfig(packager);
        ((LogSource) channel).setLogger(logger, "channel");
        ISOServer isoServer = new ISOServer(port, channel, null);
        isoServer.setLogger(logger, "server");
        isoServer.addISORequestListener(this);
        new Thread(isoServer).start();
    }

    @Override
    public boolean process(ISOSource sender, ISOMsg request) {

        var mapRequest = Iso8583Util.isoToMap(request);
        var jsonb = ObjectMapperUtil.toJson(mapRequest);
        historyRepository.save(
                History.builder()
                        .acquirerCode("BNI")
                        .request(jsonb)
                        .build()
        );

        var optional = iso8583Repository.findByEnabledIsTrue();


        try {
            if (optional.isEmpty()) {
                ISOMsg response = (ISOMsg) request.clone();
                response.set(39, "99");
                sender.send(response);
                return true;
            }
            var content = optional.get();
            var mapResponse = ObjectMapperUtil.toMap(content.getResponse());
            var response = Iso8583Util.mapToIso(mapResponse);
            response.setMTI(content.getMti());
            response.set(39, content.getRc());
            sender.send(response);
        } catch (Exception e) {
            log.error("IsoRequestListener =>{}", e.getMessage());
        }
        return true;
    }
}
