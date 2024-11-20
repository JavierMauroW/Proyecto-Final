package com.example.stream.service;

import com.example.stream.model.ListaDeReproduccion;
import com.example.stream.repository.ListaDeReproduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDeReproduccionService {

    @Autowired
    private ListaDeReproduccionRepository listaRepository;

    // Obtener todas las listas de reproducción
    public List<ListaDeReproduccion> findAll() {
        return listaRepository.findAll();
    }

    // Buscar una lista de reproducción por ID
    public Optional<ListaDeReproduccion> findById(Long id) {
        return listaRepository.findById(id);
    }

    // Crear una nueva lista de reproducción
    public ListaDeReproduccion save(ListaDeReproduccion lista) {
        return listaRepository.save(lista);
    }

    // Actualizar una lista de reproducción existente por ID
    public Optional<ListaDeReproduccion> update(Long id, ListaDeReproduccion lista) {
        return listaRepository.findById(id)
                .map(listaExistente -> {
                    listaExistente.setNombre(lista.getNombre());
                    listaExistente.setContenidos(lista.getContenidos());
                    // Actualiza otros campos según sea necesario
                    return listaRepository.save(listaExistente);
                });
    }

    // Eliminar una lista de reproducción por ID
    public boolean delete(Long id) {
        if (listaRepository.existsById(id)) {
            listaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener listas de reproducción por ID de usuario
    public List<ListaDeReproduccion> findPlaylistsByUser (Long usuarioId) {
        return listaRepository.findPlaylistsByUser (usuarioId);
    }
    public List<ListaDeReproduccion> findAllWithUsuarioAndContenidos() {
        return listaRepository.findAllWithUsuarioAndContenidos();
    }

}