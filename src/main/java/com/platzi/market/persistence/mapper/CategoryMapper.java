package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")  //Indicates to the project that it is a mapper
public interface CategoryMapper {
    @Mappings({
            //Important: We have not productos attribute, then won't be mapped, is a desing decision!!!!!!!!!!!
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration     //Is necesary the inverse mapping, this is a way to abreviate this
    @Mapping(target = "productos", ignore = true) //We warn that the products attribute will not be mapped from the domain
    Categoria toCategoria(Category category);
}
