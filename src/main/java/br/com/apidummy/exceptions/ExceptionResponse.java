package br.com.apidummy.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@RequiredArgsConstructor
@Data
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Date timestamp;
    private final String message;
    private final String details;

}
