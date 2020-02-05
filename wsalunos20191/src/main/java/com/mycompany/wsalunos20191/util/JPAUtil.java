/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsalunos20191.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Dependent
public class JPAUtil {

    @ApplicationScoped
    @Produces
    public EntityManagerFactory factory(){
        return Persistence.createEntityManagerFactory("wsalunos20192");
    }

    @Produces
    public EntityManager manager(EntityManagerFactory factory){
        return factory.createEntityManager();
    }
    
    public void fechar(@Disposes EntityManager manager){
        manager.close();
    }
    
    public void fechar(@Disposes EntityManagerFactory factory){
        factory.close();
    }
    
 
//    
//    /*
//     * DEFINE O GERENCIAMENTO DO ACESSO AO BANCO DE DADOS E TRADUÇÃO DE CLASSE PARA TABELA   
//     */ 
//    private EntityManagerFactory factory; 
//    private static JPAUtil instance;
//    
//    public JPAUtil(){
//        this.factory = Persistence.createEntityManagerFactory("wsalunos20192");
//    }
//    
//    /*
//     * synchronized a partir da thread da aplicação
//     * Ao marcarmos um método como synchronized, o sistema de execução Java garantirá que apenas uma thread de 
//     * cada vez acesse tal método. Se outras threads tentarem fazer o mesmo, elas serão colocadas em espera até
//     * que a thread atual finalize seu trabalho e libere o método.
//     * 
//     * Um exemplo de aplicação do modificador synchronized pode ser visto em uma classe Pilha. Como sabemos, 
//     * esta estrutura de dados possui métodos para inserir um novo item no topo da pilha e para removê-lo do 
//     * topo (lembra? LIFO: Last In First Out). Ora, para evitar que uma thread remova o elemento do topo ao
//     * mesmo tempo em que outra está tentando inserir, tais métodos devem ser marcados como synchronized. Isso 
//     * evitará que os dados sejam corrompidos.
//     * @return 
//     */
//    public static synchronized JPAUtil getInstance(){
//        if(instance == null){
//            instance = new JPAUtil();
//        }
//        return instance;
//    }
//    
//    public EntityManager getEntityManager(){
//        return factory.createEntityManager();
//    }
    
    
    
}
