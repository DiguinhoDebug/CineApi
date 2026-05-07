package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.AvaliacaoResponseDTO;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.AvaliacaoService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController (FilmeService service, AvaliacaoService avaliacaoService){
        this.service = service;
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }

    @GetMapping("/{idFilme}")
    public FilmeResponseDTO buscarId(@PathVariable Long idFilme){
        return service.buscarId(idFilme);
    }

    @DeleteMapping("/{idFilme}")
    public void deletar(@PathVariable Long idFilme){
        service.deletar(idFilme);
    }

    @PutMapping("/{idFilme}")
    public FilmeResponseDTO atualizar(@PathVariable Long idFilme, @RequestBody @Valid FilmeRequestDTO dto){
        return service.atualizar(idFilme, dto);
    }

    @GetMapping("/{idFilme}/avaliacoes")
    public List<AvaliacaoResponseDTO> listarAvaliacoesPorFilme(@PathVariable Long idFilme){
        return avaliacaoService.listarPorFilme(idFilme);
    }
}
