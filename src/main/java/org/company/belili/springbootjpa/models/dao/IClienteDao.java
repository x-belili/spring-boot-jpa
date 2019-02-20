package org.company.belili.springbootjpa.models.dao;

import org.company.belili.springbootjpa.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
