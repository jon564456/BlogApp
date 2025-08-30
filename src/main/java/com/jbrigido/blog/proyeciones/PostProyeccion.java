package com.jbrigido.blog.proyeciones;

import java.util.List;

/**
 * Proyeccion para la entidad {@code Post}
 */
public interface PostProyeccion {
    /**
     * Descripcion del post
     *
     * @return la descripcion relacionada
     */
    String getDescripcion();

    /**
     * Categoria del post
     *
     * @return la informacion de la categoria relacionada con el post
     */
    CategoriaProyeccion getCategoria();

    /**
     * Lista de comentario
     *
     * @return una lista de comentarios relacionados con el post
     */
    List<ComentarioProyeccion> getComentarios();

}
