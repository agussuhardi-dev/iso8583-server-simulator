package io.github.dev.agussuhardi.isosim.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.packager.GenericPackager;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Iso8583Util {

    public static String getValue(Map<Object, Object> map, int key) {
        if (map.containsKey(key)) return String.valueOf(map.get(key));
        return null;
    }

    public static Map<String, Object> isoToMap(ISOMsg isoMsg) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("MTI", isoMsg.getMTI());
            for (int i = 1; i <= isoMsg.getMaxField(); i++) {
                if (isoMsg.hasField(i)) {
                    map.put(String.valueOf(i), isoMsg.getString(i));
                }
            }
        } catch (ISOException e) {
            log.error("isoToMap =>{}", e.getMessage());
            throw new RuntimeException(e);
        }
        return map;
    }

    @SneakyThrows
    public static ISOMsg mapToIso(Map<String, Object> map) {
        ISOPackager packager = new GenericPackager("classpath:packager.xml");
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setMTI(String.valueOf(map.get("MTI")));
        for (var item : map.entrySet()) {
            if (item.getKey().equalsIgnoreCase("MTI")) continue;
            isoMsg.set(item.getKey(), String.valueOf(item.getValue()));
        }
        return isoMsg;
    }
}
