package com.jbrigido.blog.dto.usuario;

/**
 * DTO utilizado para visualizar informacion recuperada de un usuario
 * @param nombre Nombre del usuario
 * @param username Username del usuario
 */
public record UsuarioResponseDTO(String nombre, String username) {
}
