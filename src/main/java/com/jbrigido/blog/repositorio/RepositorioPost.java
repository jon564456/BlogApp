package com.jbrigido.blog.repositorio;

import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.proyeciones.PostProyeccion;

import java.util.List;

public interface RepositorioPost extends RepositorioBase<Post, Long> {
    /**
     * Busca los post realizado por un usuario
     *
     * @param usuario que se desea recuperar post
     * @return una lista de los post realizados  por un usuario
     */
    List<PostProyeccion> findByUsuario(Usuario usuario);

}
