package br.com.lab.dto;

import lombok.Getter;

@Getter
public class ResponseDTO {

    private String id;

    public ResponseDTO(String id) {
        this.id = id;
    }
}
