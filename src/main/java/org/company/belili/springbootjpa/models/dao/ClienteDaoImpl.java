package org.company.belili.springbootjpa.models.dao;

import org.company.belili.springbootjpa.models.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository("clienteDaoJPA")
@Repository
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("FROM Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            entityManager.merge(cliente);
        } else {
            entityManager.persist(cliente);
        }
    }

    @Override
    public Cliente findOne(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }
}