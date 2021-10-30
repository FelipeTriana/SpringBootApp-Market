package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//We must specify to the interface the entity and the data type of the primary key: Producto and Integer
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //The next line is only for Query Methods!!!!!!!!!!!!
    //We obtain list of products of a category order alphabeticlly by name
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Specifically products that are running out(Se estan agotando) and that are active
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
