package org.company.belili.springbootjpa.models.service;

import org.company.belili.springbootjpa.models.dao.IClienteDao;
import org.company.belili.springbootjpa.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clienteDaoJPA")
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteDao iClienteDao;

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return (List) iClienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        iClienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return iClienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        iClienteDao.deleteById(id);
    }
}
