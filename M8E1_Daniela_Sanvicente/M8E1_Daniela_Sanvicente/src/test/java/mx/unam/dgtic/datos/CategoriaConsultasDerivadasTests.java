package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest //@SQL corre los scripts
@Sql({"/schema.sql", "/data.sql"})
//Crea el esquema para nuestro banco de datos modulo8 y añade datos a sus tablas
public class CategoriaConsultasDerivadasTests {
    final String descripcion = "Ropa";

    @Autowired
    CategoriaRepository repositorioCategoria;

    @Test
    @Transactional
    void buscarPorDescripcion(){
        System.out.println("Buscar todas las categorias por descripcion:\n");

        repositorioCategoria.findByDescripcion(descripcion).forEach(System.out::println);
    }

    @Test
    @Transactional
    void buscarPorDescripcionNot(){
        System.out.println("Buscar todas las categorias que no tengan la descripcion " + descripcion);

        repositorioCategoria.findByDescripcionNot(descripcion).forEach(System.out::println);
    }

    @Test
    void buscarPorDescripcionNulo(){
        System.out.println("Buscar todas las categorías que tengan la descripción nula:\n");

        repositorioCategoria.streamByDescripcionIsNull().forEach(System.out::println);
    }

    @Test
    void buscarExistenciaPorDescripcion(){
        System.out.println("Buscar existencia de categoria por descripcion:\n");

        System.out.println(repositorioCategoria.existsByDescripcion(descripcion));
    }
    
    @Test
    void cuentaPorDescripcion(){
        System.out.println("Numero de categorias con la descripcion " + descripcion +
                ": " + repositorioCategoria.countByDescripcion(descripcion));
    }
    
    @Test
    void cuentaPorDescripcionNot(){
        System.out.println("Numero de alumnos diferentes a nombre "+ descripcion +
                " "+ repositorioCategoria.countByDescripcionNot(descripcion));
    }
    
    @Test
    void cuentaPorDescripcionNulo(){
        System.out.println("Numero de alumnos con paterno nulo "+
                " "+ repositorioCategoria.countByDescripcionIsNull()
        );
    }
}
