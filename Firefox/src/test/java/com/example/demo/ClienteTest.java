package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {

    @Autowired
    ClienteRepository clienteRepo;

    @Test
    void cliente() {
        Cliente cli = new Cliente();
        cli.setIdCliente(null);
        cli.setNome("Teste 1");
        cli.setCpfOuCnpj("000000001");
        cli.setEmail("teste1@gmail.com");
        clienteRepo.save(cli);
    }

    @Test
    public void listaCliente() {
        List<Cliente> list = clienteRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void idCliente() {
        Cliente cliente = clienteRepo.findById(2).get();
        assertEquals("pessoa2", cliente.getNome());
    }

    @Test
    public void updateCliente() {
        Cliente cliente = clienteRepo.findById(1).get();
        cliente.setNome("Thiago Leal");
        clienteRepo.save(cliente);
        assertNotEquals("Thiago", cliente.getNome());
    }
    @Test
    public void deleteCliente() {
        clienteRepo.deleteById(2);
        assertThat(clienteRepo.existsById(2));
    }

    @Test
    public void somar() {
        double num1 = 10.0;
        double num2 = 15.0;
        Cliente cliente = new Cliente();
        double soma = cliente.somar(num1, num2);
        assertEquals(25, soma);
    }

    @Test
    public void subtrair() {
        double num1 = 20.0;
        double num2 = 1.0;
        Cliente cliente = new Cliente();
        double subtração = cliente.subtrair(num1, num2);
        assertEquals(19, subtração);
    }

    @Test
    public void multiplicar() {
        double num1 = 10.0;
        double num2 = 20.0;
        Cliente cliente = new Cliente();
        double multiplicação = cliente.multiplicar(num1, num2);
        assertEquals(200, multiplicação);
    }

    @Test
    public void dividir() {
        double num1 = 20.0;
        double num2 = 5.0;
        Cliente cliente = new Cliente();
        double divisão = cliente.dividir(num1, num2);
        assertEquals(4, divisão);
    }

}
