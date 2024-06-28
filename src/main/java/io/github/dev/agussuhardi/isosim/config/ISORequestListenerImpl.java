package io.github.dev.agussuhardi.isosim.config;


import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.*;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
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
public class ISORequestListenerImpl implements ISORequestListener {


    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() throws Exception {
        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));
        ISOPackager packager = new GenericPackager("classpath:packager.xml");
//        ServerChannel channel = new XMLChannel(packager);
//        ServerChannel channel = new ASCIIChannel(packager);
        ServerChannel channel = new ChannelConfig(packager);
        ((LogSource) channel).setLogger(logger, "channel");
        ISOServer isoServer = new ISOServer(3000, channel, null);
        isoServer.setLogger(logger, "server");
        isoServer.addISORequestListener(this);
        new Thread(isoServer).start();
    }

    @Override
    public boolean process(ISOSource sender, ISOMsg request) {
        try {
            ISOMsg response = (ISOMsg) request.clone();
            response.set(39, "00");
            sender.send(response);
        } catch (Exception e) {
            log.error("IsoRequestListener =>{}", e.getMessage());
        }
        return true;
    }
}
