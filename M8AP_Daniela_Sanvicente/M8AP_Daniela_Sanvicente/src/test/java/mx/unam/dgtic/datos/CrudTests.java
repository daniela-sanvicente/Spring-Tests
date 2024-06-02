package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Sql(scripts = {"/schema.sql","/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class CrudTests {
    final Integer idCliente = 1;
    final Integer idArreglo = 1;
    final Integer idDulce = 8;

    @Autowired
    ClienteRepository repositorioCliente;

    @Autowired
    PagoRepository repositorioPago;

    @Autowired
    MetodoPagoRepository repositorioMetodoPago;

    @Autowired
    ArregloRepository repositorioArreglo;

    @Autowired
    DulceRepository repositorioDulce;

    @Autowired
    OrdenRepository repositorioOrden;


    // prepara estado de la tabla
    // es inserción de orden con arreglo y cliente
    @Test
    @Transactional
    @Rollback
    void insertarOrdenPagoCliente(){
        try {
            System.out.println("Insertar una Orden");

            Cliente cliente = repositorioCliente.findById(2).get();
            MetodoPago metodoPago = repositorioMetodoPago.findById(1).get();
            Pago pago = new Pago(cliente, metodoPago,"MASTERCARD",  "9876543210987654", "06/27", "456");
            repositorioPago.save(pago);
            Orden orden = new Orden(cliente, pago,"mayoreo",  "realizado", "Calle de la Amistad 789", 50.00 , new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-02"), 10.00, 90.00);

            repositorioOrden.save(orden);

            Optional<Orden> optional = repositorioOrden.findById(6);

            if (optional.isPresent()) {
                System.out.println("Orden añadida: " + optional.get().toString());
            } else {
                System.out.println("Orden NO localizada");
            }
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    // prepara estado de la tabla
    // crea nuevo arreglo
    @Test
    @Transactional
    @Rollback
    void insertarArreglo(){
        System.out.println("Insertar un Arreglo");

        Dulce dulce = repositorioDulce.findById(2).get();

         List<Dulce> dulces = Arrays.asList(
                 repositorioDulce.findById(2).get(),
                 repositorioDulce.findById(2).get(),
                 repositorioDulce.findById(2).get()
             );

         Arreglo arreglo=new Arreglo(
                 "Arreglo de Paletas de Amaranto",
                 60.50,
                 "N/A",
                 "Chocolate",
                 50,
                 "arreglo_paletas.jpg",
                 "3 horas",
                 "Arreglo de paletas surtidas de amaranto",
                 dulces
         );


        repositorioArreglo.save(arreglo);

        Optional<Arreglo> optional = repositorioArreglo.findById(5);

        if (optional.isPresent()){
            System.out.println(optional.get().toString());
        } else {
            System.out.println("Arreglo NO localizado");
        }
    }

    // prepara estado de la tabla
    // crea nuevo cliente
    @Test
    @Transactional
    @Rollback
    void insertarCliente(){
        try {
            System.out.println("Insertar un Cliente");

            Cliente cliente = new Cliente("Angelino", "Lionel Petrocleo","petro@example.com", "0987654321", "0987654321", "Avenida Central 456", "revendedor", "contrasena436");

            repositorioCliente.save(cliente);

            Optional<Cliente> optional = repositorioCliente.findById(6);

            if (optional.isPresent()) {
                System.out.println("Añadido: " + optional.get().toString());
            } else {
                System.out.println("Cliente NO localizado");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // read
    @Test
    @Transactional
    @Rollback
    void buscarCliente() {
        System.out.println(repositorioCliente.findById(idCliente));
    }

    // read
    @Test
    @Transactional
    @Rollback
    void buscarArreglo() {
        System.out.println(repositorioArreglo.findById(idArreglo));
    }

    // update
    @Test
    @Transactional
    @Rollback
    void editarCliente(){
        System.out.println("Editar un Cliente");

        Optional<Cliente> optional = repositorioCliente.findById(idCliente);

        if (optional.isPresent()){
            Cliente cliente = optional.get();

            System.out.println("Cliente antes del cambio");
            System.out.println(cliente);

            cliente.setNombre("Angelino");
            cliente.setApellidos("Lionel Petrocleo");
            cliente.setCorreo("petro@example.com");

            repositorioCliente.save(cliente);

            optional = repositorioCliente.findById(idCliente);

            System.out.println("Cliente despues del cambio");
            System.out.println(optional.get().toString());
        } else {
            System.out.println("Cliente de Id " + idCliente + " NO localizado");
        }
    }

    // update
    @Test
    @Transactional
    @Rollback
    void editarDulce(){
        System.out.println("Editar un Dulce");

        Optional<Dulce> optional = repositorioDulce.findById(idDulce);

        if (optional.isPresent()){
            Dulce dulce = optional.get();

            System.out.println("Dulce antes del cambio");
            System.out.println(dulce);

            dulce.setNombreDulce("Paleta de Amaranto Día de las Madres");
            dulce.setPrecio(8.50);
            dulce.setTema("Día de las Madres");
            dulce.setStock(5);


            repositorioDulce.save(dulce);

            optional = repositorioDulce.findById(idDulce);

            System.out.println("Dulce despues del cambio");
            System.out.println(optional.get().toString());
        } else {
            System.out.println("Dulce de Id " + idDulce + " NO localizado");
        }
    }



    // delete
    @Test
    @Transactional
    @Rollback
    void eliminarCliente() {

        System.out.println("Eliminar un cliente por id (clave): " + idCliente);

        Optional<Cliente> optional = repositorioCliente.findById(idCliente);

        if (optional.isPresent()) {
            Cliente cliente = optional.get();

            System.out.println("El cliente a eliminar es: " + cliente);

            repositorioCliente.delete(cliente);

            System.out.println("Clientes despues de la eliminacion " + repositorioCliente.count());
        } else {
            System.out.println("Cliente de Id " + idCliente + " NO localizado");
        }
    }

    // delete
    @Test
    @Transactional
    @Rollback
    void eliminarArreglo() {
        System.out.println("Eliminar un arreglo por id: " + idArreglo);

        Optional<Arreglo> optional = repositorioArreglo.findById(idArreglo);

        if (optional.isPresent()) {
            Arreglo arreglo = optional.get();

            System.out.println("El arreglo a eliminar es: " + arreglo);

            repositorioArreglo.delete(arreglo);

            System.out.println("Arreglos despues de la eliminacion " + repositorioArreglo.count());
        } else {
            System.out.println("Arreglo de Id " + idArreglo + " NO localizado");
        }
    }
}
