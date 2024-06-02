package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Dulce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;


@SpringBootTest
@Transactional
public class PagingAndSortingTests {
    final String tema= "Navidad";
    final String tipo = "Chocolate";
    final int stock = 80;
    final String nombreDulce = "Paleta de Navidad";
    private static int PAGE_SIZE = 3;

    @Autowired
    DulcePagingAndSortingRepository repositorioDulce;


    @Test
    void buscarPorNombreDulceTest() {
        System.out.println("Buscar los dulces por nombre paginados ");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombreDulce").ascending());

        Page<Dulce> dulcePage = repositorioDulce.findAll(pagina);
        System.out.println("Pagina 1 de "+ dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(1, PAGE_SIZE, Sort.by( "nombreDulce").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 2 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(2, PAGE_SIZE, Sort.by( "nombreDulce").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 3 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(3, PAGE_SIZE, Sort.by( "nombreDulce").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 4 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);
    }


    @Test
    void buscarPorTipoTest() {
        System.out.println("Buscar los dulces por tipo paginados ");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("tipo").ascending());

        Page<Dulce> dulcePage = repositorioDulce.findAll(pagina);
        System.out.println("Pagina 1 de "+ dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(1, PAGE_SIZE, Sort.by( "tipo").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 2 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(2, PAGE_SIZE, Sort.by( "tipo").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 3 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(3, PAGE_SIZE, Sort.by( "tipo").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 4 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);
    }


    @Test
    void buscarPorTemaTest() {
        System.out.println("Buscar los dulces por tema paginados ");

        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("tema").ascending());

        Page<Dulce> dulcePage = repositorioDulce.findAll(pagina);
        System.out.println("Pagina 1 de "+ dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(1, PAGE_SIZE, Sort.by( "tema").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 2 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(2, PAGE_SIZE, Sort.by( "tema").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 3 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);

        pagina = PageRequest.of(3, PAGE_SIZE, Sort.by( "tema").ascending());
        dulcePage= repositorioDulce.findAll(pagina);
        System.out.println("Pagina 4 de " + dulcePage.getTotalPages());
        dulcePage.forEach(System.out::println);
    }


    @Test
    void buscarTodosPaginasTest(){
        System.out.println("Buscar todos los Dulces Paginado ");
        Pageable pagina = PageRequest.of(0, PAGE_SIZE, Sort.by("nombreDulce").ascending());
        Page<Dulce> dulcePage;
        do{
            dulcePage = repositorioDulce.findAll(pagina);

            System. out.println("Pagina "+(pagina.getPageNumber() + 1) + " de "+ dulcePage.getTotalPages());
            dulcePage.forEach(System.out::println);
            pagina = dulcePage.nextPageable();
            //pagina = dulcePage.previousPageable();


        } while (dulcePage.hasNext());

    }

}

