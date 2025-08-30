package com.jbrigido.blog.controlador;

import com.jbrigido.blog.domain.Comentario;
import com.jbrigido.blog.dto.comentario.ComentarioRequestDTO;
import com.jbrigido.blog.dto.comentario.ComentarioResponseDTO;
import com.jbrigido.blog.proyeciones.ComentarioProyeccion;
import com.jbrigido.blog.servicio.ServicioComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restcontroller que provee endpoints para manejar informacion acerca de la entidad comentarios
 * Soporta metodos para recuperar y crear un comentario
 */
@RestController
@RequestMapping("/post/comentarios")
public class RestControllerComentario {

    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private ServicioComentario servicioComentario;

    /**
     * Recupera de la base datos todos los comentarios de un post
     *
     * @param id representa el id del post
     * @return Http code 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ComentarioProyeccion>> obtenerComentarios(@PathVariable Long id) {
        List<ComentarioProyeccion> comentarios = servicioComentario.getComentariosByIdPost(id);
        return new ResponseEntity<>(comentarios, HttpStatus.OK);

    }

    /**
     * Crea un nuevo comentario en un post
     *
     * @param comentario comentarioRequestDTO que representa una solicitud al servidor para crear un comentario
     * @return HTTP code 204
     */
    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> guardarComentario(@RequestBody ComentarioRequestDTO comentario) {
        ComentarioResponseDTO responseDTO = servicioComentario.saveComentario(comentario);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
