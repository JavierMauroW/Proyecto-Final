package com.example.stream.repository;

import com.example.stream.model.Contenido;
import com.example.stream.model.HistorialVisualizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistorialVisualizacionRepository extends JpaRepository<HistorialVisualizacion, Long> {


    @Query("SELECT hv.contenido FROM HistorialVisualizacion hv WHERE hv.usuario.id = :usuarioId GROUP BY hv.contenido.id ORDER BY COUNT(hv) DESC")
    List<Contenido> findMostViewedContentByUser (@Param("usuarioId") Long usuarioId);

    // Nuevo método para encontrar los géneros más vistos por usuario
    @Query("SELECT hv.contenido.genero FROM HistorialVisualizacion hv WHERE hv.usuario.id = :usuarioId GROUP BY hv.contenido.genero ORDER BY COUNT(hv) DESC")
    List<String> findMostViewedGenresByUser (@Param("usuarioId") Long usuarioId);
}
