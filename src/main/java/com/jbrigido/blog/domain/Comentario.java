package com.jbrigido.blog.domain;

import jakarta.persistence.*;

import java.util.Date;


/**
 * Representa una entidad comentario en la base de datos
 * la cual contiene sus respectivos metodos setter y getters
 * Nombre de la tabla en la base de datos es comentarios
 * Primary key es comentarioid
 */

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @Column(name = "comentarioid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "comentario_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "comentario_post")
    private Post post;
    private String descripcion;
    private Date fecha;

    public Comentario() {
    }

    public Comentario(Long id, Usuario usuario, Post post, String descripcion, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.post = post;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
