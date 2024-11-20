package com.example.stream.service;

import com.example.stream.model.Contenido;
import com.example.stream.model.HistorialVisualizacion;
import com.example.stream.repository.HistorialVisualizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialVisualizacionService {

    @Autowired
    private HistorialVisualizacionRepository historialRepository;

    // Obtener todos los historiales de visualización
    public List<HistorialVisualizacion> findAll() {
        return historialRepository.findAll();
    }

    // Buscar un historial de visualización por ID
    public Optional<HistorialVisualizacion> findById(Long id) {
        return historialRepository.findById(id);
    }

    // Crear un nuevo historial de visualización
    public HistorialVisualizacion save(HistorialVisualizacion historial) {
        return historialRepository.save(historial);
    }

    // Actualizar un historial de visualización existente por ID
    public Optional<HistorialVisualizacion> update(Long id, HistorialVisualizacion historial) {
        return historialRepository.findById(id)
                .map(historialExistente -> {
                    // Actualiza los campos necesarios
                    historialExistente.setContenido(historial.getContenido());
                    historialExistente.setUsuario(historial.getUsuario());
                    return historialRepository.save(historialExistente);
                });
    }

    // Eliminar un historial de visualización por ID
    public boolean delete(Long id) {
        if (historialRepository.existsById(id)) {
            historialRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Método para obtener el contenido más visto por usuario
    public List<Contenido> findMostViewedContentByUser (Long usuarioId) {
        return historialRepository.findMostViewedContentByUser (usuarioId);
    }

    // Método para obtener los géneros más vistos por usuario
    public List<String> findMostViewedGenresByUser (Long usuarioId) {
        return historialRepository.findMostViewedGenresByUser (usuarioId);
    }
}