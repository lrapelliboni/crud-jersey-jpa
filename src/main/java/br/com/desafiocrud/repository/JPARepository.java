package br.com.desafiocrud.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JPARepository<T> implements GenericRepository<T> {

    private static final String PERSISTENCE_UNIT = "desafiocrud";
    private EntityManager entityManager;
    private Class<T> type;

    private EntityManager getEntityManager(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public JPARepository(){
        entityManager = getEntityManager();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(T o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return o;
    }

    @Override
    public void delete(T o) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(o));
        entityManager.getTransaction().commit();
    }

    @Override
    public T find(Long id) {
        entityManager.getTransaction().begin();
        T obj = (T) entityManager.find(type, id);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public T update(T o) {
        entityManager.getTransaction().begin();
        T obj =  entityManager.merge(o);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
