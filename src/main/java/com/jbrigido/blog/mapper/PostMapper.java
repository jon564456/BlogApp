package com.jbrigido.blog.mapper;

import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.dto.categoria.CategoriaResponseDTO;
import com.jbrigido.blog.dto.comentario.ComentarioResponseDTO;
import com.jbrigido.blog.dto.post.PostRequestDTO;
import com.jbrigido.blog.dto.post.PostResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Provee metodos para mapear entiendades DTO Y objetos Post
 */
@Component
public class PostMapper {

    /**
     * Contruye una entidad Post mediante una entidad DTO
     *
     * @param request contiene la informacion a convertie en un objeto Post
     * @return un objeto Post
     */
    public Post mapearPost(PostRequestDTO request) {
        Post post = new Post();
        post.setDescripcion(request.descripcion());
        return post;
    }

    /**
     * Convierte un objeto Post a un PostResponseDTO
     *
     * @param post Objeto a mapear a dto
     * @return PostResponseDTO
     */

    public PostResponseDTO mapearDto(Post post) {
        return new PostResponseDTO(
                post.getDescripcion(),
                new CategoriaResponseDTO(post.getCategoria().getDescripcion()),
                post.getComentarios().stream().map(c -> new ComentarioResponseDTO(c.getDescripcion(), c.getFecha())).toList());
    }


}
