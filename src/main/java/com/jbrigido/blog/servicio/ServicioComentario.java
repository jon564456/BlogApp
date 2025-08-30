package com.jbrigido.blog.servicio;

import com.jbrigido.blog.domain.Comentario;
import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.dto.comentario.ComentarioRequestDTO;
import com.jbrigido.blog.dto.comentario.ComentarioResponseDTO;
import com.jbrigido.blog.mapper.ComentarioMapper;
import com.jbrigido.blog.proyeciones.ComentarioProyeccion;
import com.jbrigido.blog.repositorio.RepositorioComentario;
import com.jbrigido.blog.repositorio.RepositorioPost;
import com.jbrigido.blog.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de negocio para la gestion de {@link Comentario}
 */
@Service
public class ServicioComentario {
    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private RepositorioComentario repositorioComentario;
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ComentarioMapper mapper;

    /**
     * Recupera todos los comentario asociados a un post
     *
     * @param id del post
     * @return una lista de comentarios
     * @throws RuntimeException sí el post no es encontrado
     */
    public List<ComentarioProyeccion> getComentariosByIdPost(Long id) {
        Post post = repositorioPost.findById(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        return repositorioComentario.getByPost(post);
    }

    /**
     * Crea un nuevo comentario
     *
     * @param request en formato {@link  ComentarioRequestDTO}
     * @return comentario en formato {@link  ComentarioResponseDTO}
     * @throws RuntimeException sí el usuario o post no es encontrado
     */
    public ComentarioResponseDTO saveComentario(ComentarioRequestDTO request) {
        Usuario usuario = repositorioUsuario.findById(request.usuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Post post = repositorioPost.findById(request.post()).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        Comentario comentario = mapper.mapearComentario(request);
        comentario.setPost(post);
        comentario.setUsuario(usuario);
        Comentario save = repositorioComentario.save(comentario);
        return mapper.mapearDto(save);
    }


}
