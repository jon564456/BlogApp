package com.jbrigido.blog.mapper;

import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.dto.usuario.UsuarioRequestDTO;
import com.jbrigido.blog.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Component;


/**
 * Provee metodos para mapear entiendades DTO Y objetos Usuario
 */
@Component
public class UsuarioMapper {


    /**
     * Contruye una entidad Usuario mediante una entidad DTO
     *
     * @param request contiene la informacion a convertie en un objeto Usuario
     * @return un objeto Usuario
     */

    public UsuarioResponseDTO mapearDto(Usuario request) {
        return new UsuarioResponseDTO(request.getNombre(), request.getUsername());
    }


    /**
     * Convierte un objeto Usuario a un UsuarioResponseDTO
     *
     * @param request Objeto a mapear a dto
     * @return UsuarioResponseDTO
     */

    public Usuario mapearEntidad(UsuarioRequestDTO request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setUsername(request.username());
        return usuario;
    }

}
