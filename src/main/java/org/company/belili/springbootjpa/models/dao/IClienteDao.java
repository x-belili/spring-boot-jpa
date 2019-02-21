package org.company.belili.springbootjpa.models.dao;

import org.company.belili.springbootjpa.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
