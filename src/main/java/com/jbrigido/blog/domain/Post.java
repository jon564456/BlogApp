package com.jbrigido.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Representa una entidad Post en la base de datos
 * la cual contiene sus respectivos metodos setter y getters
 * Nombre de la tabla en la base de datos es Posts
 * Primary key es idPosts
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idposts")
    private Long id;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "post_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "post_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comentario> comentarios;

    public Post() {

    }

    public Post(Long id, String descripcion, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public Post(Long id, String descripcion, Categoria categoria, Usuario usuario, List<Comentario> comentarios) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.usuario = usuario;
        this.comentarios = comentarios;
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

    public void setDescripcion(String description) {
        this.descripcion = description;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
