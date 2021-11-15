package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Client;
import com.platzi.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PurchaseMapper.class})
public interface ClientMapper {
    @Mappings({
            //@Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "lastname"),
            @Mapping(source = "celular", target = "nroCellphone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "compra", target = "purchases"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);

}
