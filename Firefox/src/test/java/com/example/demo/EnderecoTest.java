package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {

    @Autowired
    EnderecoRepository enderecoRepo;

    @Test
    void Endereco() {
        Endereco en = new Endereco();
        en.setId(1);
        en.setLogradouro("Rua Itadaki Masu");
        en.setNumero("96");
        en.setComplemento("");
        en.setBairro("martins");
        en.setCep("12041620");
        enderecoRepo.save(en);
    }

    @Test
    public void listaEndereco() {
        List<Endereco> list = enderecoRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void idEndereco() {
        Endereco en = enderecoRepo.findById(1).get();
        assertEquals(1, en.getId());
    }

    @Test
    public void updateEndereco() {
        Endereco en = enderecoRepo.findById(1).get();
        en.setBairro("Brabo de Ku");
        enderecoRepo.save(en);
        assertNotEquals("Brabo", en.getBairro());
    }

    @Test
    public void deleteEndereco() {
        enderecoRepo.deleteById(2);
        assertThat(enderecoRepo.existsById(2));
    }
}
