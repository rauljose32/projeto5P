/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsalunos20191.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericDAO <T extends Serializable>{
    
    private Class<T> aClass;
    
    @Inject
    private EntityManager em;

    public GenericDAO(Class<T> aClass) {
        this.aClass = aClass;
    }
            
    /**
     * Sempre quando precisar retorna um EntityManager chama-se a o mesmo na classe JPAUtil.
     * @return 
     */
//    protected EntityManager getEntityManager(){
//        return JPAUtil.getInstance().getEntityManager();
//    }
    
    /**
     * Método para retornar quantide de pessoas.
     * @return 
     */
    public long count(){
        //EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select count(c) from: "+aClass.getSimpleName()+" c");
        
        Long count = (Long) query.getSingleResult();
        
        em.getTransaction().commit();
        em.close();
        
        return count;        
    }
    
    
    /**
     * Retorna uma lista baseada em uma lista de parâmentros
     * @param jpql Query
     * @param params
     * @return 
     */
    public T findOne(String jpql, Object... params){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery(jpql); //exemplo:from Person p where p.nome like ? and p.age like ?
        for(int i=0;i<params.length;i++)
            query.setParameter(i+1, params[i]);
        
        T entity = (T) query.getSingleResult(); //necessário fazer quest ao utilizar singleResult
        em.getTransaction().commit();
        em.close();
        
        return entity;
    }
    
    
    /**
     * Retorna uma lista baseada em uma lista de parâmentros
     * @param jpql Query
     * @param params
     * @return 
     */
    public List<T> find(String jpql, Object... params){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery(jpql); //exemplo:from Person p where p.nome like ? and p.age = ?
        for(int i=0;i<params.length;i++)
            query.setParameter(i+1, params[i]);
        
        List<T> entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return entities;
    }
    
    public List<T> findAll(){
        //EntityManager em = getEntityManager(); //recebe um EntityManagerFactory
        em.getTransaction().begin(); //inicia a transação
        
        //consulta JPA para retornar uma lista
        Query query = em.createQuery("select e from "+aClass.getSimpleName()+" e");
        List<T> entities = query.getResultList();
        
        em.getTransaction().commit();
        em.close();
        
        return entities;
    }    
    
    public T findById(Long id){
        //EntityManager em = getEntityManager(); //recebe um EntityManagerFactory
        em.getTransaction().begin(); //inicia a transação
        T entity = (T) em.find(aClass, id);
        em.getTransaction().commit();
        em.close();
        return entity;
    }
 
    public void save(T entity){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }
    
    public void update(T entity){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
    
    public void remove(Long id){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.getReference(aClass, id)); //ou em.find(aClass, id), getReference é mais rápido 
        em.getTransaction().commit();
        em.close();
    }
   
     public void removeGenerico(T entity){
        //EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity)); //faz update em cascata 
        em.getTransaction().commit();
        em.close();
    }
    
}
