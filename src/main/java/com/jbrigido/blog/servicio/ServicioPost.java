package com.jbrigido.blog.servicio;

import com.jbrigido.blog.domain.Categoria;
import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.dto.post.PostRequestDTO;
import com.jbrigido.blog.dto.post.PostResponseDTO;
import com.jbrigido.blog.mapper.PostMapper;
import com.jbrigido.blog.proyeciones.PostProyeccion;
import com.jbrigido.blog.repositorio.RepositorioCategoria;
import com.jbrigido.blog.repositorio.RepositorioPost;
import com.jbrigido.blog.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de negocio para la gestio de {@link  Post}
 */
@Service
public class ServicioPost {
    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioCategoria repositorioCategoria;
    @Autowired
    private PostMapper postMapper;

    /**
     * Recupera todos los post realizados
     *
     * @return una lista con todo los post existentes
     */
    public List<Post> obtenerLista() {
        return repositorioPost.findAll();
    }

    /**
     * Recupera una lista de los post realizado por un usuario
     *
     * @param id del usuario
     * @return una lista de los post realizado por un usuario en formato {@link  PostProyeccion}
     * @throws RuntimeException sí el usuario no es encontrado
     */
    public List<PostProyeccion> obtenerListaPostsByUsuario(Long id) {
        Usuario usuario = repositorioUsuario.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return repositorioPost.findByUsuario(usuario);
    }

    /**
     * Crea un nuevo post en la base de datos
     *
     * @param request
     * @return el post insertado en la base de datos
     * @throws RuntimeException sí la categoria o usuario no es encontrador
     */
    public Post guardarPost(PostRequestDTO request) {
        Categoria categoria = repositorioCategoria.findById(request.categoria()).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        Usuario usuario = repositorioUsuario.findById(request.categoria()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Post post = postMapper.mapearPost(request);
        post.setUsuario(usuario);
        post.setCategoria(categoria);
        return repositorioPost.save(post);
    }

    /**
     * Recupera un post por su id
     *
     * @param id del post
     * @return post encontrado
     * @throws RuntimeException si el post no es encontrado
     */
    public PostResponseDTO obtenerPostById(Long id) {
        Post post = repositorioPost.findById(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        return postMapper.mapearDto(post);
    }


}
