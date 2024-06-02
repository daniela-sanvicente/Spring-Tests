package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
public class CategoriaConsultasNombradasTests {
    final String descripcion = "teste";

    @Autowired
    CategoriaRepository repositorioCategoria;

    @Test
    void buscarPorDescripcion() {
        System.out.println("Buscar por las categorias de descripcion " + descripcion);
        repositorioCategoria.buscarPorDescripcion(descripcion);
    }

    @Test
    @Transactional
    void buscarDescripcionGrande(){
        System.out.println("Buscar las descripciones grandes:\n");
        
        System.out.println(repositorioCategoria.buscarGrandes());
    }

    @Test
    @Transactional
    void buscarDescripcionCorta(){
        System.out.println("Buscar las descripciones cortas:\n");
        
        System.out.println(repositorioCategoria.buscarCortas());
    }
    @Test
    void buscarPorDescripcionUnica() {
        System.out.println("Buscar todas las categorias de descripcion única:\n");
        System.out.println(repositorioCategoria.buscarDescripcionDistinta());
    }

    @Test
    void cuentaPorDescripcionUnica() {
        System.out.println("Contar por descripcion única:\n");
        
        repositorioCategoria.contarPorDescripcionUnico() //forEach, es como un ciclo for que aplica la función lambda providenciada para cada elemento en una lista
                .forEach(c -> {
                    System.out.println(c.getCampo() + " " + c.getConteo());
                });
    }
}
