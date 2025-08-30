package com.jbrigido.blog.controlador;

import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.dto.usuario.UsuarioRequestDTO;
import com.jbrigido.blog.dto.usuario.UsuarioResponseDTO;
import com.jbrigido.blog.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Restcontroller que provee endpoint para mannejar informacion acerca de usuarios
 * Soporta metodos para recuperar, crear informacion de usuarios
 */
@RestController
@RequestMapping("/usuario")
public class RestControllerUsuario {
    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private ServicioUsuario servicioUsuario;

    /**
     * Recupera de la base de datos una lista de informacion acerca de usuarios
     *
     * @return ResponseEntity con lista de usuarios y un Http code 200
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> list = servicioUsuario.getUsuarios();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Crear un nuevo usuario en la base de datos
     *
     * @param request representa una solicitud con informacion para crear un usuario
     * @return ResponseEntity con el Http code 200
     */

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequestDTO request) {
        UsuarioResponseDTO creado = servicioUsuario.saveUsuario(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{username}").buildAndExpand(creado.username()).toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Recupera un usuario a mediante de su username
     *
     * @param username del usuario a recuperar informacion
     * @return ResponseEntity con la informacion del usuario con un codigo Http code 200
     */
    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponseDTO> obtenerPorUsername(@PathVariable String username) {
        UsuarioResponseDTO encontrado = servicioUsuario.obtenerPorUsername(username);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }


}
