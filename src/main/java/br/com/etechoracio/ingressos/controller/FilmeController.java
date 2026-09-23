package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Filme;
import br.com.etechoracio.ingressos.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingressos.enums.SimNaoEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @GetMapping
    public List<Filme> listar(){
        Filme filme1 = Filme.builder()
                .id(1L)
                .nome("Matrix")
                .classificacao(ClassificacaoIndicativaEnum.A16)
                .emCartaz(SimNaoEnum.S)
                .build();
        Filme filme2 = Filme.builder()
                .id(2L)
                .nome("Homem aranha")
                .classificacao(ClassificacaoIndicativaEnum.A16)
                .emCartaz(SimNaoEnum.S)
                .build();
        return List.of(filme1, filme2);
    }
    List<Long> idsExistentes = List.of(1L, 2L, 3L);
    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        if(idsExistentes.contains(id)) {
            Filme filme1 = Filme.builder()
                    .id(id)
                    .nome("Matrix")
                    .classificacao(ClassificacaoIndicativaEnum.A16)
                    .emCartaz(SimNaoEnum.S)
                    .build();
            return ResponseEntity.ok(filme1);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme){
        filme.setId(100L);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme,
                           @PathVariable Long id){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if(idsExistentes.contains(id)) {
            return ResponseEntity.ok().build();
        }
         return ResponseEntity.notFound().build();
    }
}
