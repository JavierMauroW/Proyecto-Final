package com.example.stream.repository;

import com.example.stream.model.ListaDeReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion, Long> {

    @Query("SELECT l FROM ListaDeReproduccion l WHERE l.usuario.id = :usuarioId ORDER BY l.fechaCreacion ASC")
    List<ListaDeReproduccion> findPlaylistsByUser(@Param("usuarioId") Long usuarioId);

    @Query("SELECT l FROM ListaDeReproduccion l JOIN FETCH l.usuario u JOIN FETCH l.contenidos c")
    List<ListaDeReproduccion> findAllWithUsuarioAndContenidos();
}
