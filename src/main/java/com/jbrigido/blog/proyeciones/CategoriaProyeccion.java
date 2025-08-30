package com.jbrigido.blog.proyeciones;

/**
 * Proyeccion para la entidad {@code Categoria}
 */
public interface CategoriaProyeccion {
    /**
     * Identificador de la categoria
     *
     * @return id de la categoria
     */
    Long getId();

    /**
     * Descripcion la categoria
     *
     * @return la descripcion relacionada
     */
    String getDescripcion();

}
