package com.bootcamp.jpa.repositories;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.*;

/**
 * Created by darextossa on 9/22/17.
 *
 * @param <T>
 */
public abstract class BaseRepository<T> {

    private EntityManager em;
    private String unitPersistence;
    private EntityManagerFactory emf;
    private Class entityClass;

    public BaseRepository(String unitPersistence, Class entityClass) {
        this.unitPersistence = unitPersistence;
        emf = Persistence.createEntityManagerFactory(this.unitPersistence);
        em = emf.createEntityManager();
        this.entityClass = entityClass;

    }

    /**
     * Méthode de création
     *
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    public boolean create(T obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        return true;
    }

    /**
     * Méthode pour effacer
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean delete(T obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        return true;
    }

    /**
     * Méthode de mise é jour
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean update(T obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        return true;
    }

    /**
     * Méthode de recherche des informations
     *
     * @param propertyName
     * @param value
     * @return T
     * @throws java.sql.SQLException
     */
    public T findById(String propertyName, Object value) throws SQLException {
        try {
            String className = getEntityClass().getSimpleName();
            String request = "select t from " + className + " t where t." + propertyName + "=:param";
            Query query = getEm().createQuery(request);
            query.setParameter("param", value);
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
    
    /**
     * Méthode de recherche des informations
     *
     * @param propertyName
     * @param value
     * @return T
     * @throws java.sql.SQLException
     */
    public T findByProperty(String propertyName, Object value) throws SQLException {
        try {
            String className = getEntityClass().getSimpleName();
            String request = "select t from " + className + " t where t." + propertyName + "=:param";
            Query query = getEm().createQuery(request);
            query.setParameter("param", value);
            return (T) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }

    }

    /**
     * Méthode de recherche de toutes les information
     *
     * @return T
     * @throws java.sql.SQLException
     */
    public List<T> findAll() throws SQLException {
        return getEm().createQuery("select t from " + getEntityClass().getSimpleName() + " t").getResultList();
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the unitPersistence
     */
    public String getUnitPersistence() {
        return unitPersistence;
    }

    /**
     * @param UnitPersistence the unitPersistence to set
     */
    public void setUnitPersistence(String UnitPersistence) {
        this.unitPersistence = UnitPersistence;
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the entityClass
     */
    public Class getEntityClass() {
        return entityClass;
    }

    /**
     * @param entityClass the entityClass to set
     */
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }
}
