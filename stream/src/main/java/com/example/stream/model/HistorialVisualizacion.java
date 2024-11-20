package com.example.stream.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistorialVisualizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaVisualizacion;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "contenidoId")
    private Contenido contenido;

    public HistorialVisualizacion() {
    }

    public HistorialVisualizacion(Date fechaVisualizacion, Usuario usuario, Contenido contenido, Long id) {
        this.fechaVisualizacion = fechaVisualizacion;
        this.usuario = usuario;
        this.contenido = contenido;
        this.id = id;
    }
    // Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(Date fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }
}
