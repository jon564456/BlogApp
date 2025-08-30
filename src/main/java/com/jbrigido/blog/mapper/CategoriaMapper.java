package com.jbrigido.blog.mapper;

import com.jbrigido.blog.domain.Categoria;
import com.jbrigido.blog.dto.categoria.CategoriaRequestDTO;
import com.jbrigido.blog.dto.categoria.CategoriaResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Provee metodos para mapear entiendades DTO Y objetos Categoria
 */
@Component
public class CategoriaMapper {

    /**
     * Contruye una entidad Categoria mediante una entidad DTO
     *
     * @param request contiene la informacion a convertie en un objeto Categoria
     * @return un objeto Categoria
     */
    public Categoria mapearCategoria(CategoriaRequestDTO request) {
        return new Categoria(request.descripcion());
    }

    /**
     * Convierte un objeto Categoria a un CategoriaResponseDTO
     *
     * @param categoria Objeto a mapear a dto
     * @return CategoriaResponseDTO
     */
    public CategoriaResponseDTO mapearDto(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getDescripcion());
    }

}
