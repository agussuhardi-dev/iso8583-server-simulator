package io.github.dev.agussuhardi.isosim.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SuppressWarnings("unchecked")
@Slf4j
public class GlobalApiResponse<T> extends ResponseEntity<T> {

    public GlobalApiResponse(T data, HttpStatus status) {
        super((T) new GlobalApiResponseModel<>(data, status), status);
    }

    public GlobalApiResponse(T data, HttpStatus status, String message) {
        super((T) new GlobalApiResponseModel<>(data, status, message), status);
    }

    public GlobalApiResponse(HttpStatus status) {
        super((T) new GlobalApiResponseModel<>(status), status);
    }

    public GlobalApiResponse(String message, HttpStatus status) {
        super((T) new GlobalApiResponseModel<>(message, status), status);
    }

    public GlobalApiResponse(Object errors, String message, HttpStatus status) {
        super((T) new GlobalApiResponseModel<>(errors, message, status), status);
    }

    public String toJson() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this.getBody());
        } catch (JsonProcessingException e) {
            return "{}";
        }

    }

}
