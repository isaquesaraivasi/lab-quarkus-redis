package br.com.lab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemplateErrorDTO {

    private List<ErroDTO> errors;

    public TemplateErrorDTO(List<ErroDTO> errors) {
        this.errors = errors;
    }
}
