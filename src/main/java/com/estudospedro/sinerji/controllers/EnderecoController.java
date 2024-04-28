/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.controllers;

import com.estudospedro.sinerji.entities.Endereco;
import com.estudospedro.sinerji.entities.Pessoa;
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
public class EnderecoController {
    
    private Pessoa p = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Endereco> enderecos = new ArrayList<>();
    
//    public List<Endereco> listarEendercosDaPessoa(){
//    
//    }
    
    public String redirecionarCadastroEndereco(Pessoa pessoa) {
        p = pessoa;
        return "listaEndereco.xhtml?faces-redirect=true";
    }
}
