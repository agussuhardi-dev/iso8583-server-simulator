package io.github.dev.agussuhardi.isosim.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;

import java.util.Map;

/**
 * @author agussuhardi
 * {@code @created} 6/18/24 5:26 AM
 * {@code @project} svc-ovo
 */
public class ObjectMapperUtil {
    private static ObjectMapper mapper = null;

    private ObjectMapperUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static ObjectMapper getInstance() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
        }
        return mapper;
    }

    @SneakyThrows
    public static <T> T toObject(String obj, Class<T> clazz) {
        return getInstance().readValue(obj, clazz);
    }

    @SneakyThrows
    public static String toJson(Object obj) {
        return getInstance().writeValueAsString(obj);
    }

    @SneakyThrows
    public static Map<String, Object> toMap(String json) {
        return getInstance().readValue(json, new TypeReference<>() {
        });
    }

    @SneakyThrows
    public static JsonNode getJsonNode(String json) {
        return getInstance().readTree(json);
    }
}
