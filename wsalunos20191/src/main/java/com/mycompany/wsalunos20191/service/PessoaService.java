package com.mycompany.wsalunos20191.service;

import com.mycompany.wsalunos20191.dao.PessoaDAO;
import com.mycompany.wsalunos20191.model.Pessoa;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Dependent
@Path("/pessoa")
public class PessoaService {

    @Inject
    private PessoaDAO dao;

    @GET
    @Path("/lista")
    @Produces("application/json")
    public List<Pessoa> pessoas() {
        return dao.findAll();
    }

//    public static void main(String[] args) {
//        EntityManagerFactory f = Persistence.createEntityManagerFactory("wsalunos20192");
//        EntityManager em = f.createEntityManager();
//        em.getTransaction().begin(); //inicia a transação
//
//        Pessoa p = em.find(Pessoa.class, 1L);
//        em.getTransaction().commit();
//        System.out.println(p.getNome());
//    }

}
