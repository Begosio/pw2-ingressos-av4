package br.com.etechoracio.ingressos.controller;

import br.com.etechoracio.ingressos.entity.Sala;
import br.com.etechoracio.ingressos.repositories.SalaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> listar(){
        return salaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> BuscarPorID(@PathVariable Long id){
        var sala = salaRepository.findById(id);
        if(sala.isPresent()){
            return ResponseEntity.ok(sala.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Sala> CadastrarSala(@RequestBody Sala sala){
        var sala1 = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(sala1);
    }
}
