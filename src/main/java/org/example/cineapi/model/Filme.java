package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    @NotBlank(message = "Preencha o título")
    private String titulo;

    @NotBlank(message = "Preencha o gênero")
    private String genero;

    @NotBlank(message = "Preencha o diretor")
    private String diretor;

    @NotNull(message = "Preencha o ano")
    @Min(value = 1895)
    @Max(value = 2026)
    private Integer ano;

    @NotNull(message = "Preencha a duração")
    @Positive
    private Integer duracao;

    @Min(value = 0)
    @Max(value = 5)
    private Integer nota;

    public Filme(){}
}
