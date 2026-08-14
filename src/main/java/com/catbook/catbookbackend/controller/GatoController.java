package com.catbook.catbookbackend.controller;

import com.catbook.catbookbackend.entity.GatoEntity;
import com.catbook.catbookbackend.Repository.GatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
@CrossOrigin("*") // Isso aqui é MÁGICO! Libera o seu HTML/JS para acessar a API sem dar erro de bloqueio (CORS)
public class GatoController {

    @Autowired
    private GatoRepository repository;

    // 1. POST (Criar/Salvar um novo gatinho no banco)
    @PostMapping
    public ResponseEntity<GatoEntity> salvarGato(@RequestBody GatoEntity gato) {
        // Validação básica (exigência do professor)
        if (gato.getUrlImagem() == null || gato.getUrlImagem().isEmpty()) {
            return ResponseEntity.badRequest().build(); // Retorna erro se tentar salvar sem imagem
        }
        GatoEntity gatoSalvo = repository.save(gato);
        return ResponseEntity.ok(gatoSalvo);
    }

    // 2. GET (Listar todos os gatinhos salvos)
    @GetMapping
    public ResponseEntity<List<GatoEntity>> listarGatos() {
        List<GatoEntity> gatos = repository.findAll();
        return ResponseEntity.ok(gatos);
    }

    // 3. PUT (Atualizar o nome de um gatinho, por exemplo)
    @PutMapping("/{id}")
    public ResponseEntity<GatoEntity> atualizarGato(@PathVariable Long id, @RequestBody GatoEntity gatoAtualizado) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Se o gato não existir, avisa que não achou
        }
        gatoAtualizado.setId(id); // Garante que vai atualizar o gato certo
        GatoEntity gatoSalvo = repository.save(gatoAtualizado);
        return ResponseEntity.ok(gatoSalvo);
    }

    // 4. DELETE (Deletar um gatinho do banco)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGato(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}