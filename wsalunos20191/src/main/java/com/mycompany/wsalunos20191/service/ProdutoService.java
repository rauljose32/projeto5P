
package com.mycompany.wsalunos20191.service;

import com.mycompany.wsalunos20191.dao.ProdutoDAO;
import com.mycompany.wsalunos20191.model.Produto;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Dependent
@Path("/produto")
public class ProdutoService {
    
    @Inject
    private ProdutoDAO dao;
    
    @GET
    @Path("/lista")
    @Produces("application/json")
    public List<Produto> produtos(){
        return dao.findAll();
    }
}
