package com.jbrigido.blog.dto.comentario;

/**
 *
 * DTO utilizada para la creacion o actualizacion de un comentario
 *
 * @param descripcion Descripcion del comentario
 * @param usuario id del usuario que realiza el comentario
 * @param post id del post al que se realiza el comentario
 */
public record ComentarioRequestDTO(String descripcion, Long usuario, Long post) {


}
