package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Retrieve the list of products thanks to the SpringData repositories(interface ProductoCrudRepository in crud folder)
    private List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //Here we're using Query Methods, specifically the query method declared in the interface ProductoCrudRepository in crud folder
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    //The other query method in interface ProductoCrudRepository in crud folder
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

}
