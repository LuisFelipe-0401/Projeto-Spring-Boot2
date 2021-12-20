package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.LuisFelipe.domain.Estado;
import com.LuisFelipe.domain.repositories.EstadoRepository;



@SpringBootTest
public class EstadoTest {

    @Autowired
    EstadoRepository estadoRepo;

    @Test
    void Estado() {
        Estado es = new Estado();
        es.setId(null);
        es.setNome("Minas Gerais");
        estadoRepo.save(es);
    }

    @Test
    public void listaEstado() {
        List<Estado> list = estadoRepo.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    public void idEstado() {
        Estado es = estadoRepo.findById(1).get();
        assertEquals("Minas Gerais", es.getNome());
    }

    @Test
    public void updateEstado() {
        Estado es = estadoRepo.findById(1).get();
        es.setNome("Minas Gerais");
        estadoRepo.save(es);
        assertNotEquals("Bibor", es.getNome());
    }

    /*
    @Test
    public void deleteEstado() {
        estadoRepo.deleteById(2);
        assertThat(estadoRepo.existsById(2));
    }*/

}
