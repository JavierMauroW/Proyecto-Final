package com.example.stream.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true)
    private String email;
    private String contraseña;
    private String preferencias;
    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ListaDeReproduccion> listas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<HistorialVisualizacion> historial;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String email, String contraseña, String preferencias, Date fechaRegistro, List<ListaDeReproduccion> listas, List<HistorialVisualizacion> historial) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.preferencias = preferencias;
        this.fechaRegistro = fechaRegistro;
        this.listas = listas;
        this.historial = historial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<ListaDeReproduccion> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeReproduccion> listas) {
        this.listas = listas;
    }

    public List<HistorialVisualizacion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialVisualizacion> historial) {
        this.historial = historial;
    }
}
