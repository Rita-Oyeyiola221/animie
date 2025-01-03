package com.atos.anime.models;

import lombok.*;
import lombok.Data;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private String statusCode;
    private String statusMessage;
    private String transactionId;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
