package org.company.belili.springbootjpa.models.service;

import org.company.belili.springbootjpa.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List findAll();

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);

}
