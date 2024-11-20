package com.example.stream.service;

import com.example.stream.model.Contenido;
import com.example.stream.repository.ContenidoRepository;
import com.example.stream.repository.HistorialVisualizacionRepository; // Importa el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private HistorialVisualizacionRepository historialVisualizacionRepository; // Declara el repositorio

    // Obtener todos los contenidos
    public List<Contenido> findAll() {
        return contenidoRepository.findAll();
    }

    // Buscar un contenido por ID
    public Optional<Contenido> findById(Long id) {
        return contenidoRepository.findById(id);
    }

    // Crear un nuevo contenido
    public Contenido save(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    // Actualizar un contenido existente por ID
    public Optional<Contenido> update(Long id, Contenido contenido) {
        return contenidoRepository.findById(id)
                .map(contenidoExistente -> {
                    contenidoExistente.setTitulo(contenido.getTitulo());
                    contenidoExistente.setDescripcion(contenido.getDescripcion());
                    // Actualiza otros campos según sea necesario
                    return contenidoRepository.save(contenidoExistente);
                });
    }

    // Eliminar un contenido por ID
    public boolean delete(Long id) {
        if (contenidoRepository.existsById(id)) {
            contenidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Contenido> getMostViewedContentByUser (Long usuarioId) {
        return historialVisualizacionRepository.findMostViewedContentByUser (usuarioId); // Usa el repositorio correctamente
    }

    public List<String> getMostViewedGenresByUser (Long usuarioId) {
        return historialVisualizacionRepository.findMostViewedGenresByUser (usuarioId);
    }
}