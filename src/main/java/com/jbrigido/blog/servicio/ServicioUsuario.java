package com.jbrigido.blog.servicio;

import com.jbrigido.blog.domain.Usuario;
import com.jbrigido.blog.dto.usuario.UsuarioRequestDTO;
import com.jbrigido.blog.dto.usuario.UsuarioResponseDTO;
import com.jbrigido.blog.mapper.UsuarioMapper;
import com.jbrigido.blog.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de negocio para el manejo de {@link  Usuario}
 */
@Service
public class ServicioUsuario {
    /**
     * Ineyccion de dependencias
     */
    @Autowired
    private RepositorioUsuario repositorio;
    @Autowired
    private UsuarioMapper mapper;

    /**
     * Crea un nuevo usuario
     *
     * @param request en formato {@link  UsuarioRequestDTO}
     * @return el usuario creado en formato{@link  UsuarioResponseDTO}
     */
    public UsuarioResponseDTO saveUsuario(UsuarioRequestDTO request) {
        Usuario map = mapper.mapearEntidad(request);
        Usuario usuario = repositorio.save(map);
        return mapper.mapearDto(usuario);
    }

    /**
     * Recupera una lista de todos los usuarios disponibles
     *
     * @return una lista de usuario
     */
    public List<Usuario> getUsuarios() {
        return repositorio.findAll();
    }

    /**
     * Recupera un usuario apartir de un username
     *
     * @param username del usuario
     * @return el usuario encontrado
     * @throws RuntimeException sí el usuario no es encontrado
     */
    public UsuarioResponseDTO obtenerPorUsername(String username) {
        Usuario encontrado = repositorio.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.mapearDto(encontrado);
    }

}
