package br.com.axel.exceptions.response;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private Integer code;
    private String error;
    private String exception;
    private List<String> errors;

}
