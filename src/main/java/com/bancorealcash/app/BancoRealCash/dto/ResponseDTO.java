package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
    private String code;
    private T data;
}
