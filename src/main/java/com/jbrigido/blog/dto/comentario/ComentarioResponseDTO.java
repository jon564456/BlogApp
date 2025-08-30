package com.jbrigido.blog.dto.comentario;

import java.util.Date;

/**
 * DTO utilizada para visualizar informacion de un comentario
 *
 * @param descripcion Descripcion del comentario
 * @param fecha Fecha de publicacion del comentario
 */

public record ComentarioResponseDTO(String descripcion, Date fecha) {


}
