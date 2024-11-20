package com.example.stream.controller;

import com.example.stream.model.Contenido;
import com.example.stream.model.HistorialVisualizacion;
import com.example.stream.service.HistorialVisualizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialVisualizacionController {

    @Autowired
    private HistorialVisualizacionService historialService;

    @GetMapping
    public List<HistorialVisualizacion> getAllHistoriales() {
        return historialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialVisualizacion> getHistorialById(@PathVariable Long id) {
        return historialService.findById(id)
                .map(historial -> ResponseEntity.ok(historial))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HistorialVisualizacion createHistorial(@RequestBody HistorialVisualizacion historial) {
        return historialService.save(historial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialVisualizacion> updateHistorial(@PathVariable Long id, @RequestBody HistorialVisualizacion historial) {
        return historialService.update(id, historial)
                .map(updatedHistorial -> ResponseEntity.ok(updatedHistorial))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable Long id) {
        if (historialService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Nuevo endpoint para obtener el contenido más visto por usuario
    @GetMapping("/usuario/{usuarioId}/contenido-mas-visto")
    public ResponseEntity<List<Contenido>> getMostViewedContentByUser (@PathVariable Long usuarioId) {
        List<Contenido> contenidos = historialService.findMostViewedContentByUser (usuarioId);
        if (contenidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contenidos);
    }

    // Nuevo endpoint para obtener los géneros más vistos por usuario
    @GetMapping("/usuario/{usuarioId}/generos-mas-vistos")
    public ResponseEntity<List<String>> getMostViewedGenresByUser (@PathVariable Long usuarioId) {
        List<String> generos = historialService.findMostViewedGenresByUser (usuarioId);
        if (generos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(generos);
    }
}