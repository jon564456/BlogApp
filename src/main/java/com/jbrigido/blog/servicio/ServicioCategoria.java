package com.jbrigido.blog.servicio;

import com.jbrigido.blog.domain.Categoria;
import com.jbrigido.blog.dto.categoria.CategoriaRequestDTO;
import com.jbrigido.blog.dto.categoria.CategoriaResponseDTO;
import com.jbrigido.blog.mapper.CategoriaMapper;
import com.jbrigido.blog.repositorio.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de negocio para la gestion de {@link  Categoria}
 */
@Service
public class ServicioCategoria {
    /**
     * Inyeccion de dependencias
     */
    @Autowired
    private RepositorioCategoria repositorioCategoria;
    @Autowired
    private CategoriaMapper mapper;

    /**
     * Recupera todas las categorias disponibles
     *
     * @return una lista de categorias en formato{@link  CategoriaResponseDTO}
     */
    public List<CategoriaResponseDTO> obtenerCategorias() {
        return repositorioCategoria.findAll().stream().map(c ->
                new CategoriaResponseDTO(c.getDescripcion()
                )).toList();
    }

    /**
     * Recupera una categoria por id
     *
     * @param id de la categoria
     * @return un objeto de categoria en formato {@link  CategoriaResponseDTO}
     * @throws RuntimeException sí la categoria no es encontrada
     */
    public CategoriaResponseDTO obtenerCategoriaById(Long id) {
        Categoria categoria = repositorioCategoria.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return mapper.mapearDto(categoria);
    }

    /**
     * Crea una nueva categoria
     *
     * @param request en formato {@link  CategoriaRequestDTO}
     * @return la categoria creada en formato {@link CategoriaResponseDTO}
     */
    public CategoriaResponseDTO crearCategoria(CategoriaRequestDTO request) {
        Categoria mapeado = mapper.mapearCategoria(request);
        Categoria creado = repositorioCategoria.save(mapeado);
        return mapper.mapearDto(creado);
    }
}
