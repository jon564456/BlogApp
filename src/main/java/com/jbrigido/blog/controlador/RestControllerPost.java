package com.jbrigido.blog.controlador;

import com.jbrigido.blog.domain.Post;
import com.jbrigido.blog.dto.post.PostRequestDTO;
import com.jbrigido.blog.dto.post.PostResponseDTO;
import com.jbrigido.blog.proyeciones.PostProyeccion;
import com.jbrigido.blog.servicio.ServicioPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Restcontroller que provee endpoints
 */
@RestController
@RequestMapping("/post")
public class RestControllerPost {
    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private ServicioPost servicio;

    /**
     * Recupera una lista de post
     *
     * @return Http code 200
     */
    @GetMapping
    public ResponseEntity<List<Post>> obtenerListaPost() {
        List<Post> lista = servicio.obtenerLista();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Recupera de la base de datos a traves de un id
     * @param id de post solicitado a recuperar informacion
     * @return Http code 200
     */

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> obtenerPost(@PathVariable Long id) {
        PostResponseDTO response = servicio.obtenerPostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Recuperar de la base de datos relacionados a un usuario especifico
     * @param id del usuario que se desea recuperar sus post
     * @return ResponseEntity HTTP code 200
     */
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<PostProyeccion>> obtenerListaPostsByUsuario(@PathVariable Long id) {
        List<PostProyeccion> response = servicio.obtenerListaPostsByUsuario(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Crea un nuevo post en la base de datos
     * @param request representa un PostRequestDTO
     * @return ResponseEntity con HTTP code 200
     */
    @PostMapping
    public ResponseEntity<PostResponseDTO> guardarPost(@RequestBody PostRequestDTO request) {
        Post creado = servicio.guardarPost(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(creado.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
