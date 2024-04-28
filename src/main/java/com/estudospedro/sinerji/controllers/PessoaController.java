/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.controllers;

import com.estudospedro.sinerji.entities.Pessoa;
import com.estudospedro.sinerji.model.implement.PessoaModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import lombok.Data;

/**
 *
 * @author felly
 */
@ManagedBean
@ApplicationScoped
@Data
public class PessoaController {
    
    public PessoaController(){
        this.listarPessoas();
    }
    
    private Pessoa p = new Pessoa();
    
    private List<Pessoa> listaPessoas = new ArrayList<>();

    private PessoaModel pm = new PessoaModel();
    
    public String salvar() {
        try {
            if (pm.save(p)) {
		listaPessoas = (pm.findAll());
            }
            p = new Pessoa();
        } catch (Exception e) {
            e.printStackTrace(); // Tratar o erro de forma adequada conforme necessário
        }
        return "index.xhtml";
    }
    
    public List<Pessoa> listarPessoas(){
        p = new Pessoa();
        return listaPessoas = (pm.findAll());
    }
    
    public String redirecionarCadastroPessoa() {
        p = new Pessoa();
        return "cadastrarPessoa.xhtml?faces-redirect=true";
    }
    
    public String editarPessoa(Pessoa pessoa) {
        p = pessoa;
        return "cadastrarPessoa.xhtml?faces-redirect=true";
    }

    public String excluirPessoa(Pessoa pessoa) {
        boolean result = pm.delete(pessoa.getId());
        listaPessoas = (pm.findAll());
        return "index.xhtml?faces-redirect=true";
    }
}
