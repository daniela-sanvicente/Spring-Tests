package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = {M8E1Application.class})
@Sql({"/schema.sql", "/data.sql"})
public class ConsultasConRelacionesTests {
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

	@Test
	@Transactional
	void buscarPaisPorCliente(){
		System.out.println("Buscar paises por clientes:\n");

		Iterable<Cliente> clientes = repositorioCliente.findAll();

		clientes.forEach(c -> {
			System.out.println(
				"Pais de " + c.getNombre() + ": " + c.getPais().getPais()
			);
		});
	}

	@Test
	@Transactional
	void buscarCategoriaPorProducto(){
		System.out.println("Buscar categoria por producto:\n");

		Iterable<Producto> productos = repositorioProducto.findAll();

		productos.forEach(p -> {
			System.out.println(
				"Categoria de " + p.getDescripcion() + ": " + p.getCategoria().getDescripcion()
			);
		});
	}

	@Test
	@Transactional
	void buscarProductosPorVenta(){
		System.out.println("Buscar productos por venta:\n");

		Iterable<Venta> ventas = repositorioVenta.findAll();

		ventas.forEach(v -> {
			System.out.println(
				"Productos de la venta " + v.getId() + ": " + v.getProductos()
			);
		});
	}

	@Test
	@Transactional
	void buscarClientesPorVenta(){
		System.out.println("Buscar clientes por venta:\n");

		Iterable<Venta> ventas = repositorioVenta.findAll();

		ventas.forEach(v -> {
			System.out.println(
				"Cliente de la venta " + v.getId() + ": " + 
				v.getCliente().getNombre() + " " + v.getCliente().getPaterno()
			);
		});
	}

	@Test
	@Transactional
	void buscarMontoProductosPorVenta(){
		System.out.println("Buscar monto total de productos por venta:\n");

		Iterable<Venta> ventas = repositorioVenta.findAll();

		ventas.forEach(v -> {
			System.out.println(
				"Monto total de los productos de la venta " + v.getId() + ":" + 
				v.getTotalVenta() + "\nProductos: " + v.getProductos()
			);
		});
	}

	@Test
	@Transactional
	void buscarProductosPorCategoria(){
		System.out.println("Buscar productos por categoria:\n");

		Iterable<Categoria> categorias = repositorioCategoria.findAll();

		categorias.forEach(c -> {
			System.out.println(
				"Productos de la categoria " + c.getDescripcion() + ":" +
				c.getProductos()
			);
		});
	}

	@Test
	@Transactional
	void buscarClientesPorPais(){
		System.out.println("Buscar clientes por pais:\n");

		Iterable<Pais> pais = repositorioPais.findAll();

		pais.forEach(p -> {
			System.out.println(
				"Clientes de " + p.getPais() + ": " + p.getClientes()
			);
		});
	}
}
