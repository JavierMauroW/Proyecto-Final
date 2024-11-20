package com.example.stream.controller;

import com.example.stream.model.Contenido;
import com.example.stream.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<Contenido> getAllContenidos() {
        return contenidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> getContenidoById(@PathVariable Long id) {
        return contenidoService.findById(id)
                .map(contenido -> ResponseEntity.ok(contenido))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contenido createContenido(@RequestBody Contenido contenido) {
        return contenidoService.save(contenido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> updateContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        return contenidoService.update(id, contenido)
                .map(updatedContenido -> ResponseEntity.ok(updatedContenido))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenido(@PathVariable Long id) {
        if (contenidoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
