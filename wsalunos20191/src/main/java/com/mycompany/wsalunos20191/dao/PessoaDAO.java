/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wsalunos20191.dao;

import com.mycompany.wsalunos20191.model.Pessoa;
import javax.enterprise.context.Dependent;

@Dependent
public class PessoaDAO extends GenericDAO<Pessoa>{

    public PessoaDAO(){
        super(Pessoa.class);
    }
       
    
    
}
