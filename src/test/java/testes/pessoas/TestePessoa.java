/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.pessoas;

import com.estudospedro.sinerji.entities.Pessoa;
import com.estudospedro.sinerji.model.implement.PessoaModel;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author felly
 */
public class TestePessoa {
    private static PessoaModel pm;
    
    @BeforeClass
    public static void setUp() {
        // Inicializar o PessoaDAO ou injetá-lo com Spring, CDI, etc.
        pm = new PessoaModel();
    }
    
    @Test
    public void testCriarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João da Silva");
        pessoa.setIdade(34);
        pm.save(pessoa);
        assertNotNull("Pessoa não foi criada", pessoa.getId());
    }

    @Test
    public void testListarPessoas() {
        List<Pessoa> pessoas = pm.findAll();
        assertNotNull("A lista de pessoas não deve ser nula", pessoas);
        assertTrue("A lista de pessoas deve conter pelo menos uma pessoa", pessoas.size() > 0);
    }
    
    @Test
    public void testExcluirPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João da Silva");
        pessoa.setIdade(34);
        pm.save(pessoa);

        assertNotNull("Pessoa não foi criada", pessoa.getId());

        // Excluímos a pessoa
        pm.delete(pessoa.getId());

        // Verificamos se a pessoa foi excluída corretamente
        Pessoa pessoaExcluida = pm.findById(pessoa.getId());
        assertNull("A pessoa não deve existir mais após a exclusão", pessoaExcluida);
    }
}
