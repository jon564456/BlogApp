package com.jbrigido.blog.dto.post;

/**
 * DTO Utilizado para la creacion y actualizacion de un post
 * @param descripcion Descripcion o cuerpo del post
 * @param categoria id de la categoria que pertenece el post
 * @param usuario id del usuario que publica el post
 */
public record PostRequestDTO(String descripcion, Long categoria, Long usuario) {

   
}
