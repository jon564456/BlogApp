package com.jbrigido.blog.controlador;

import com.jbrigido.blog.dto.categoria.CategoriaRequestDTO;
import com.jbrigido.blog.dto.categoria.CategoriaResponseDTO;
import com.jbrigido.blog.servicio.ServicioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * RestController que provee endpoints para manejar informacion acerca las categorias
 * Soporta métodos para recuperar y crear una nueva categoria.
 */
@RestController
@RequestMapping("/categoria")
public class RestControllerCategoria {


    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private ServicioCategoria servicio;

    /**
     * Recupera una lista con las categorias almacenada en la base de datos
     * @return ResponseEntity con HTTP code 200
     */
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obtenerCategoria() {
        List<CategoriaResponseDTO> response = servicio.obtenerCategorias();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *
     * Crea una nueva categoria en la base de datos
     *
     * @param request que es un objeto DTO de la entidad Categoria
     * @return ResponseEntity con un objeto CategoriaResponseDTO y HTTP code 204
     */
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> crearCategoria(@RequestBody CategoriaRequestDTO request) {
        CategoriaResponseDTO categoria = servicio.crearCategoria(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{descripcion}")
                .buildAndExpand(categoria.descripcion())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
