package br.com.lab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDTO {

    private String message;

    public ErroDTO(String message) {
        this.message = message;
    }
}
