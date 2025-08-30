package com.jbrigido.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


/**
 * Representa una entidad Usuario en la base de datos la cual contiene sus respectivos metodos setter y getters
 * Nombre de la tabla en la base de datos es Usuarios
 * Primary key es idusuario
 */

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long id;
    private String username;
    private String nombre;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comentario> comentarios;


    public Usuario() {
    }


    public Usuario(Long id, String username, String nombre) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
    }

    public Usuario(List<Comentario> comentarios, List<Post> posts, String nombre, String username, Long id) {
        this.comentarios = comentarios;
        this.posts = posts;
        this.nombre = nombre;
        this.username = username;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
