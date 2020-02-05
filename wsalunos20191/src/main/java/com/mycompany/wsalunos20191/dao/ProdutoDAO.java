/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsalunos20191.dao;

import com.mycompany.wsalunos20191.model.Produto;
import javax.enterprise.context.Dependent;

/**
 *
 * @author aluno
 */

@Dependent
public class ProdutoDAO extends GenericDAO<Produto>{
    
    public ProdutoDAO() {
        super(Produto.class);
    }
    
}
