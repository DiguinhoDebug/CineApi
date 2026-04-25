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
    private String titulo;
    private String genero;
    private String diretor;
    private Integer ano;
    private Integer duracao;
    private Integer nota;

    public Filme(){}
}
