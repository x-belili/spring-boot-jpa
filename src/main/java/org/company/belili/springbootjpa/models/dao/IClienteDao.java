package org.company.belili.springbootjpa.models.dao;

import org.company.belili.springbootjpa.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {

    List findAll();

    void save(Cliente cliente);

    Cliente findOne(Long id);

    void delete(Long id);

}
