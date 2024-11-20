package com.example.stream.controller;

import com.example.stream.model.ListaDeReproduccion;
import com.example.stream.service.ListaDeReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaDeReproduccionController {

    @Autowired
    private ListaDeReproduccionService listaService;

    @GetMapping
    public List<ListaDeReproduccion> getAllListas() {
        return listaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeReproduccion> getListaById(@PathVariable Long id) {
        return listaService.findById(id)
                .map(lista -> ResponseEntity.ok(lista))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}") // Nuevo endpoint para obtener listas por usuario
    public ResponseEntity<List<ListaDeReproduccion>> getListasByUsuario(@PathVariable Long usuarioId) {
        List<ListaDeReproduccion> listas = listaService.findPlaylistsByUser (usuarioId);
        if (listas.isEmpty()) {
            return ResponseEntity.noContent().build(); // No hay listas para este usuario
        }
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/detalladas") // Nuevo endpoint para obtener listas con usuario y contenidos
    public ResponseEntity<List<ListaDeReproduccion>> getAllListasConDetalles() {
        List<ListaDeReproduccion> listas = listaService.findAllWithUsuarioAndContenidos();
        if (listas.isEmpty()) {
            return ResponseEntity.noContent().build(); // No hay listas disponibles
        }
        return ResponseEntity.ok(listas);
    }

    @PostMapping
    public ListaDeReproduccion createLista(@RequestBody ListaDeReproduccion lista) {
        return listaService.save(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDeReproduccion> updateLista(@PathVariable Long id, @RequestBody ListaDeReproduccion lista) {
        return listaService.update(id, lista)
                .map(updatedLista -> ResponseEntity.ok(updatedLista))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        if (listaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}