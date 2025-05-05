package io.github.angel.raa.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Map;

public class ErrorResponse implements Serializable {
    private String message;
    private int status;
    private String path;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private String timestamp;
    private Map<String, String> errors; // Para almacenar errores de validación

    public ErrorResponse() {
    }
    public ErrorResponse(String message, int status, String path, String timestamp) {
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;


    }
    public ErrorResponse status(org.springframework.http.HttpStatus status) {
        this.status = status.value();
        return this;
    }
    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }
    public ErrorResponse path(String path) {
        this.path = path;
        return this;
    }
    public ErrorResponse timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    public ErrorResponse errors(Map<String, String> errors) {
        this.errors = errors;
        return this;
    }
    public ErrorResponse build() {
        return new ErrorResponse(message, status, path, timestamp);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", path='" + path + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
