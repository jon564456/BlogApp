package com.jbrigido.blog.repositorio;

import com.jbrigido.blog.domain.Comentario;
import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.proyeciones.ComentarioProyeccion;

import java.util.List;

public interface RepositorioComentario extends RepositorioBase<Comentario, Long> {


    /**
     * Recupera una lista de comentarios
     *
     * @param post que se deasea recuperar informacion
     * @return una lista de los comentarios de un post
     */
    List<ComentarioProyeccion> getByPost(Post post);

}
