package com.jbrigido.blog.repositorio;

import com.jbrigido.blog.domain.Usuario;

import java.util.Optional;

public interface RepositorioUsuario extends RepositorioBase<Usuario, Long> {

    /**
     * Busca a un usuario por un nombre de usuario
     * @param username del usuario 
     * @return el usuarioencontrado o en caso contrario retorna un objeto optional.
     */
    Optional<Usuario> findByUsername(String username);

}
