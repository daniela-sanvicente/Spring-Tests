package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Dulce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"/schema.sql","/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class ConsultasDerivadasTests {
    final String tema= "Navidad";
    final String tipo = "Chocolate";
    final int stock = 80;
    final String nombreDulce = "Paleta de Navidad";


    @Autowired
    DulceRepository repositorioDulce;

    @Test
    @Transactional
    void buscarPorNombreDulce(){
        System.out.println("Buscar por nombre del dulce:\n");

        repositorioDulce.findByNombreDulce(nombreDulce).forEach(System.out::println);
    }

    @Test
    @Transactional
    void buscarPorTema(){
        System.out.println("Buscar por tema del dulce " );

        repositorioDulce.findByTema(tema).forEach(System.out::println);
    }

    @Test
    @Transactional
    void buscarPorTipo(){
        System.out.println("Buscar por tema de dulce " );

        repositorioDulce.findByTipo(tipo).forEach(System.out::println);
    }

    @Test
    void buscarPorImagenNulo(){
        System.out.println("Buscar todas los dulces que tengan la imagen nula:\n");

        repositorioDulce.streamByImagenIsNull().forEach(System.out::println);
    }

    @Test
    void cuentaPorStock(){
        System.out.println("Numero de dulces con el stock " + stock +
                ": " + repositorioDulce.countByStock(stock));
    }


    @Test
    void cuentaPorImagenNulo(){
        System.out.println("Numero de dulces con imagen nulo "+
                " "+ repositorioDulce.countByImagenIsNull()
        );
    }


}

//    List<Dulce> findByNombreDulce(String nombreDulce);
//    List<Dulce> findByTema(String tema);
//    List<Dulce> findByTipo(String tipo);
//
//    List<Dulce> streamByImagenIsNull();
//
//    Long countByStock(Integer stock);
//    Long countByImagenIsNull();
//
//    boolean existsByTema(String tema);
