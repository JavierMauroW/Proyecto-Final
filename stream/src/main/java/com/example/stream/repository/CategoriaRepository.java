package com.example.stream.repository;

import com.example.stream.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Método para encontrar categorías que tienen contenidos asociados
    List<Categoria> findByContenidosIsNotEmpty(); // Asegúrate de que 'contenidos' sea una propiedad válida
}