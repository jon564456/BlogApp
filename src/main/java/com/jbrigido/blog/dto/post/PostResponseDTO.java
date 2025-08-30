package com.jbrigido.blog.dto.post;

import com.jbrigido.blog.dto.categoria.CategoriaResponseDTO;
import com.jbrigido.blog.dto.comentario.ComentarioResponseDTO;

import java.util.List;

/**
 * DTO utilizado para la visualizacion de informacion de post
 *
 * @param descripcion Despripcion del post
 * @param categoria   informacion de la categoria al que pertenece el post
 * @param comentarios Lista de comentarios que contiene el posts
 */
public record PostResponseDTO(String descripcion, CategoriaResponseDTO categoria,
                              List<ComentarioResponseDTO> comentarios) {


}
