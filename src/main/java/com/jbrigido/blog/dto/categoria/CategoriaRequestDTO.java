package com.jbrigido.blog.dto.categoria;

/**
 * DTO utilizada para la creacion o actualizacion de una categoria
 *
 * @param descripcion Descripcion de la categoria, no debe ser nula
 */
public record CategoriaRequestDTO(String descripcion) {
}
