package com.molt.desafiorickandmorty.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {

    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private int statusCode;

    public ErrorInfo(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}