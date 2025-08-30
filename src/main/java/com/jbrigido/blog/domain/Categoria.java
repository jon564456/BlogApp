package com.jbrigido.blog.domain;

import jakarta.persistence.*;

/**
 * Representa una entidad categoria en la base de datos
 * la cual contiene sus respectivos metodos setter y getters
 * Nombre de la tabla en la base de datos es Categorias
 * Primary key es idCategorias
 */
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorias")
    private Long id;
    private String descripcion;

    public Categoria() {

    }

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
