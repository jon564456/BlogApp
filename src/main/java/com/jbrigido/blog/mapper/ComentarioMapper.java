package com.jbrigido.blog.mapper;

import com.jbrigido.blog.domain.Comentario;
import com.jbrigido.blog.dto.comentario.ComentarioRequestDTO;
import com.jbrigido.blog.dto.comentario.ComentarioResponseDTO;
import org.springframework.stereotype.Component;


/**
 * Provee metodos para mapear entiendades DTO Y objetos Comentario
 */
@Component
public class ComentarioMapper {
    /**
     * Contruye una entidad Comentario mediante una entidad DTO
     *
     * @param request contiene la informacion a convertie en un objeto Comentario
     * @return un objeto comentario
     */

    public Comentario mapearComentario(ComentarioRequestDTO request) {
        Comentario comentario = new Comentario();
        comentario.setDescripcion(request.descripcion());
        return comentario;
    }

    /**
     * Convierte un objeto Comentario a un ComentarioResponseDTO
     *
     * @param comentario Objeto a mapear a dto
     * @return ComentarioResponseDTO
     */
    public ComentarioResponseDTO mapearDto(Comentario comentario) {
        return new ComentarioResponseDTO(comentario.getDescripcion(), comentario.getFecha());
    }


}
