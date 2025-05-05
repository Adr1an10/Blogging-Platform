package io.github.angel.raa.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que representa una respuesta estándar para las solicitudes HTTP.
 * Contiene información sobre el estado de la operación, un mensaje y los datos de respuesta.
 * @param <T>
 */
public class Response <T> implements  Serializable{
    private static final long serialVersionUID = -2367332115723472367L;
    private String message;
    private T data;
    private boolean success;
    private int code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime  timestamp;
    public Response() {
        this.timestamp = LocalDateTime.now();
    }
    public Response(String message, T data, boolean success, int code) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.code = code;
        this.timestamp = LocalDateTime.now();
    }


    public Response<T> message(String message) {
        this.message = message;
        return this;
    }
    public Response<T> data(T data) {
        this.data = data;
        return this;
    }
    public Response<T> success(boolean success) {
        this.success = success;
        return this;
    }
    public Response<T> code(int code) {
        this.code = code;
        return this;
    }
    public Response<T> timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public Response<T> buildResponse() {
        return new Response(message, data, success, code);
    }
    @Contract(" -> new")
    public static <T> @NotNull Response<T> builder() {
        return new Response<>();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



}
