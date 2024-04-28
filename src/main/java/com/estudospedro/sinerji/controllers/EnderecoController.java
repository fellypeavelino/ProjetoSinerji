/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estudospedro.sinerji.controllers;

import com.estudospedro.sinerji.entities.Endereco;
import com.estudospedro.sinerji.entities.Pessoa;
import com.estudospedro.sinerji.model.implement.EnderecoModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
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
    private EnderecoModel enm = new EnderecoModel();
    private List<SelectItem> estados;
        
    public String listarCadastroEndereco(Pessoa pessoa) {
        p = pessoa;
        endereco = new Endereco();
        enderecos = enm.findByPessoa(p.getId());
        return "listaEndereco.xhtml?faces-redirect=true";
    }
    
  
    public String redirecionarCadastroEndereco(){
        return "cadastrarEndereco.xhtml?faces-redirect=true";
    }
    
    public String salvarEndereco(){
        endereco.setPessoa(p);
        enm.save(endereco);
        return listarCadastroEndereco(p);
    }
    
    public String editarEndereco(Endereco endereco){
        this.endereco = endereco;
        enderecos = enm.findByPessoa(p.getId());
        return "listaEndereco.xhtml?faces-redirect=true";
    }
    
    public String excluirEndereco(Endereco endereco){
        enm.delete(endereco.getId());
        enderecos = enm.findByPessoa(p.getId());
        return "listaEndereco.xhtml?faces-redirect=true";
    }
    
    public EnderecoController() {
        estados = new ArrayList<>();
        estados.add(new SelectItem("AC", "Acre"));
        estados.add(new SelectItem("AL", "Alagoas"));
        estados.add(new SelectItem("AP", "Amapá"));
        estados.add(new SelectItem("AM", "Amazonas"));
        estados.add(new SelectItem("BA", "Bahia"));
        estados.add(new SelectItem("CE", "Ceará"));
        estados.add(new SelectItem("DF", "Distrito Federal"));
        estados.add(new SelectItem("ES", "Espírito Santo"));
        estados.add(new SelectItem("GO", "Goiás"));
        estados.add(new SelectItem("MA", "Maranhão"));
        estados.add(new SelectItem("MT", "Mato Grosso"));
        estados.add(new SelectItem("MS", "Mato Grosso do Sul"));
        estados.add(new SelectItem("MG", "Minas Gerais"));
        estados.add(new SelectItem("PA", "Pará"));
        estados.add(new SelectItem("PB", "Paraíba"));
        estados.add(new SelectItem("PR", "Paraná"));
        estados.add(new SelectItem("PE", "Pernambuco"));
        estados.add(new SelectItem("PI", "Piauí"));
        estados.add(new SelectItem("RJ", "Rio de Janeiro"));
        estados.add(new SelectItem("RN", "Rio Grande do Norte"));
        estados.add(new SelectItem("RS", "Rio Grande do Sul"));
        estados.add(new SelectItem("RO", "Rondônia"));
        estados.add(new SelectItem("RR", "Roraima"));
        estados.add(new SelectItem("SC", "Santa Catarina"));
        estados.add(new SelectItem("SP", "São Paulo"));
        estados.add(new SelectItem("SE", "Sergipe"));
        estados.add(new SelectItem("TO", "Tocantins"));
    }
}
