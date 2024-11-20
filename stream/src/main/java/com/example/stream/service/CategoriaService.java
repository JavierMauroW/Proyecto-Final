package com.example.stream.service;

import com.example.stream.model.Categoria;
import com.example.stream.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Buscar una categoría por ID
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    // Crear una nueva categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría existente por ID
    public Optional<Categoria> update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(categoriaExistente -> {
                    categoriaExistente.setNombre(categoria.getNombre());
                    categoriaExistente.setDescripcion(categoria.getDescripcion());
                    return categoriaRepository.save(categoriaExistente);
                });
    }

    // Eliminar una categoría por ID
    public boolean delete(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Obtener categorías con al menos un contenido asociado
    public List<Categoria> findCategoriasWithContenidos() {
        return categoriaRepository.findByContenidosIsNotEmpty(); // Cambiado a 'findByContenidosIsNotEmpty()'
    }
}