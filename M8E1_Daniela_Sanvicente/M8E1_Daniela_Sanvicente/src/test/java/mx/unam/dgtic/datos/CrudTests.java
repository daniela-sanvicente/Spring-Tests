package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
// prepara esquema de las tablas
@Sql({"/schema.sql", "/data.sql"})
public class CrudTests {
    final Integer idCliente = 1;
    final Integer idProducto = 1;

    @Autowired
    ClienteRepository repositorioCliente;

    @Autowired
    ProductoRepository repositorioProducto;

    @Autowired
    VentaRepository repositorioVenta;

    @Autowired
    CategoriaRepository repositorioCategoria;

    @Autowired
    PaisRepository repositorioPais;

    // prepara estado de la tabla
    // es inserción de venta con producto y cliente
    @Test
    @Transactional
    void insertarVentaProductoCliente(){
        try {
            System.out.println("Insertar una Venta");

            Cliente cliente = repositorioCliente.findById(7).get();
            List<Producto> productos = (List<Producto>) repositorioProducto.findAll();

            Venta venta = new Venta(20, cliente, new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"), 31030, productos);

            repositorioVenta.save(venta);

            Optional<Venta> optional = repositorioVenta.findById(20);

            if (optional.isPresent()) {
                System.out.println(optional.get().toString());
            } else {
                System.out.println("Venta NO localizada");
            }
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    // prepara estado de la tabla
    // crea nuevo producto
    @Test
    @Transactional
    void insertarProducto(){
        System.out.println("Insertar un Producto");

        Categoria categoria = repositorioCategoria.findById(2).get();

        Producto producto = new Producto(11, "Chamarra", 800, 10, categoria);

        repositorioProducto.save(producto);
        
        Optional<Producto> optional = repositorioProducto.findById(11);
        
        if (optional.isPresent()){
            System.out.println(optional.get().toString());
        } else {
            System.out.println("Producto NO localizado");
        }
    }

    // prepara estado de la tabla
    // crea nuevo cliente
    @Test
    @Transactional
    void insertarCliente(){
        try {
            System.out.println("Insertar un Cliente");

            Pais pais = repositorioPais.findById(1).get();

            Cliente cliente = new Cliente(14, "Angelino", "Lionel", new SimpleDateFormat("yyyy-MM-dd").parse("2009-06-29"), "SOTP950629ZCFSTN08", pais);

            repositorioCliente.save(cliente);

            Optional<Cliente> optional = repositorioCliente.findById(14);

            if (optional.isPresent()) {
                System.out.println(optional.get().toString());
            } else {
                System.out.println("Cliente NO localizado");
            }
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    // read
    @Test
    @Transactional
    void buscarCliente() {
        System.out.println(repositorioCliente.findById(idCliente));
    }

    // read
    @Test
    @Transactional
    void buscarProducto() {
        System.out.println(repositorioProducto.findById(idProducto));
    }

    // update
    @Test
    @Transactional
    void editarCliente(){
        System.out.println("Editar un Cliente");

        Optional<Cliente> optional = repositorioCliente.findById(idCliente);
        
        if (optional.isPresent()){
            Cliente cliente = optional.get();

            System.out.println("Cliente antes del cambio");
            System.out.println(cliente);

            cliente.setNombre("Daniela");
            cliente.setPaterno("Sanvicente");
            
            try {
                cliente.setFnac(new SimpleDateFormat("yyyy-MM-dd").parse("1993-10-22"));
            } catch (ParseException e){
               throw new RuntimeException(e);
            }

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
    void editarProducto(){
        System.out.println("Editar un Producto");

        Optional<Producto> optional = repositorioProducto.findById(idProducto);
        
        if (optional.isPresent()){
            Producto producto = optional.get();

            System.out.println("Producto antes del cambio");
            System.out.println(producto);

            producto.setDescripcion("Desktop");
            producto.setPrecio(35000);
            producto.setStock(5);

            repositorioProducto.save(producto);

            optional = repositorioProducto.findById(idProducto);

            System.out.println("Producto despues del cambio");
            System.out.println(optional.get().toString());
        } else {
            System.out.println("Producto de Id " + idProducto + " NO localizado");
        }
    }

    // delete
    @Test
    @Transactional
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
    void eliminarProducto() {
        System.out.println("Eliminar un producto por id: " + idProducto);

        Optional<Producto> optional = repositorioProducto.findById(idProducto);

        if (optional.isPresent()) {
            Producto producto = optional.get();

            System.out.println("El producto a eliminar es: " + producto);

            repositorioProducto.delete(producto);

            System.out.println("Productos despues de la eliminacion " + repositorioProducto.count());
        } else {
            System.out.println("Producto de Id " + idProducto + " NO localizado");
        }
    }
}
