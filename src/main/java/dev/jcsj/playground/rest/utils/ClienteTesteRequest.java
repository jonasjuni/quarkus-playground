package dev.jcsj.playground.rest.utils;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteTesteRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "300")
    @Length(min = 0, message = "200")
    @Length(max = 10, message = "Maxxioooo")
    public String nomeCliente;

    @FutureOrPresent
    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    public LocalDate aniversario;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @FutureOrPresent
    public LocalDate casamento = LocalDate.of(9999, 12, 31);

    @NotNull
    public Integer qtdFilhos;

}
