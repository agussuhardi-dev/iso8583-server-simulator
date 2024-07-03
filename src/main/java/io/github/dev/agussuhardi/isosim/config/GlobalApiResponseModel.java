package io.github.dev.agussuhardi.isosim.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author agussuhardii
 * {@code @created} 29/08/2023 :12
 * {@code @project} inventory
 */
@Getter
public class GlobalApiResponseModel<T> {

    private final HttpStatus status;
    private final long timestamp = System.currentTimeMillis();
    private final int statusCode;
    private final String message;

    private T data;
    private Object errors;

    public GlobalApiResponseModel(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
        this.statusCode = status.value();
        this.message = status.is2xxSuccessful() ? "Success" : status.getReasonPhrase();
    }


    public GlobalApiResponseModel(T data, HttpStatus status, String message) {
        this.status = status;
        this.data = data;
        this.statusCode = status.value();
        this.message = message;
    }


    public GlobalApiResponseModel(HttpStatus status) {
        this.status = status;
        this.statusCode = status.value();
        this.message = status.is2xxSuccessful() ? "Success" : status.getReasonPhrase();
    }


    public GlobalApiResponseModel(String message, HttpStatus status) {
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
    }


    public GlobalApiResponseModel(Object errors, String message, HttpStatus status) {
        this.status = status;
        this.statusCode = status.value();
        this.message = message == null ? status.getReasonPhrase() : message;
        this.errors = errors;
    }


}
