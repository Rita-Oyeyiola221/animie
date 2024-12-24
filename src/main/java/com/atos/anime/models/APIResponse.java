package com.atos.anime.models;

import lombok.*;
import lombok.Data;
@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse <T> {
    private String statusCode;
    private String statusMessage;
    private String transactionId;
    private T data;
}
