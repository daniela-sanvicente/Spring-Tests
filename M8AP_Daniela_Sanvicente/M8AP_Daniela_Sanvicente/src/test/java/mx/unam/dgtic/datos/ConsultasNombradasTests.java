package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS) //execution, para solo correr una vez los documentos sql
public class ConsultasNombradasTests {

    @Autowired
    DulceRepository repositorioDulce;

    @Test
    void buscarPorStockDesc() {
        System.out.println("Buscar dulces por su stock, descendente " );
        repositorioDulce.buscarDulcePorStockDesc().forEach(System.out::println);
    }

    @Test
    void buscarPorPrecioDesc() {
        System.out.println("Buscar dulces por su precio, descendente " );
        repositorioDulce.buscarDulcePorPrecioDesc().forEach(System.out::println);
    }

    @Test
    void buscarPorPrecioAsc() {
        System.out.println("Buscar dulces por su precio, ascendente " );
        repositorioDulce.buscarDulcePorPrecioAsc().forEach(System.out::println);
    }

    @Test
    void buscarDulcePorStockAsc() {
        System.out.println("Buscar dulces por su tiempo de elaboración " );
        System.out.println(repositorioDulce.findAll());
        repositorioDulce.buscarDulcePorStockAsc().forEach(System.out::println);
    }

    @Test
    void buscarPorTemaYStock() {
        System.out.println("Ordenar dulces por su tema y stock " );
        repositorioDulce.agruparDulcePorTemaYStock().forEach(System.out::println);
    }

    @Test
    void contarPorTipoDulce() {
        System.out.println("Ordenar dulces por su tipo y stock " );
        repositorioDulce.contarPorTipo().forEach(System.out::println);
    }

    @Test
    void contarPorTiempoElaboracion() {
        System.out.println("Ordenar dulces por su tiempo Elaboracion  " );
        repositorioDulce.buscarPorTiempoElaboracion().forEach(System.out::println);
    }


}
