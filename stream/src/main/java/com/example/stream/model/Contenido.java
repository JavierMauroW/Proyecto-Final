package com.example.stream.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String genero;
    private String clasificacion;
    private int duracion;
    private Date fechaEstreno;
    private String urlContenido;

    @OneToMany(mappedBy = "contenido", cascade = CascadeType.ALL)
    private List<HistorialVisualizacion> historial;

    @ManyToMany
    @JoinTable(
            name = "ListaContenido",
            joinColumns = @JoinColumn(name = "contenidoId"),
            inverseJoinColumns = @JoinColumn(name = "listaId")
    )
    private List<ListaDeReproduccion> listas;

    @ManyToMany
    @JoinTable(
            name = "ContenidoCategoria",
            joinColumns = @JoinColumn(name = "contenidoId"),
            inverseJoinColumns = @JoinColumn(name = "categoriaId")
    )
    private List<Categoria> categorias;

    public Contenido() {
    }

    public Contenido(String descripcion, String titulo, String genero, Long id, String clasificacion, int duracion, Date fechaEstreno, String urlContenido, List<HistorialVisualizacion> historial, List<ListaDeReproduccion> listas, List<Categoria> categorias) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.genero = genero;
        this.id = id;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.fechaEstreno = fechaEstreno;
        this.urlContenido = urlContenido;
        this.historial = historial;
        this.listas = listas;
        this.categorias = categorias;
    }
    // Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<ListaDeReproduccion> getListas() {
        return listas;
    }

    public void setListas(List<ListaDeReproduccion> listas) {
        this.listas = listas;
    }

    public String getUrlContenido() {
        return urlContenido;
    }

    public void setUrlContenido(String urlContenido) {
        this.urlContenido = urlContenido;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<HistorialVisualizacion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialVisualizacion> historial) {
        this.historial = historial;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
