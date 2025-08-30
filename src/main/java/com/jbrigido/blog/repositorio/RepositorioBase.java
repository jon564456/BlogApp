package com.jbrigido.blog.repositorio;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio base para entidades  JPA
 * <p>
 * <p>
 * Marcada con {@link NoRepositoryBean} indicando a spring data que esta interfaz no debe ser marcada como un repositorio
 * directamente, si no solamente extendida
 *
 * @param <T>  Tipo de la entidad gestionada
 * @param <ID> Tipo de la clave primaria de la entidad
 */
@NoRepositoryBean
public interface RepositorioBase<T, ID> extends Repository<T, ID> {
    /**
     * Busca una entidad por su identificador.
     *
     * @param id identificador de la entidad
     * @return un {@link Optional} con la entidad encontrada o vacío si no existe
     */
    Optional<T> findById(ID id);

    /**
     * Guarda una entidad (inserta o actualiza).
     *
     * @param Entity entidad a guardar
     * @param <S>    tipo de la entidad (subtipo de T)
     * @return la entidad persistida
     */
    <S extends T> S save(S Entity);

    /**
     * Obtiene todas las entidades.
     *
     * @return lista de todas las entidades
     */
    List<T> findAll();
}
