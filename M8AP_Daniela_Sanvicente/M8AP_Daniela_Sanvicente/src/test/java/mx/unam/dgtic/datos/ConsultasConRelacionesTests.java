package mx.unam.dgtic.datos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import mx.unam.dgtic.datos.entidades.Arreglo;
import mx.unam.dgtic.datos.entidades.Dulce;
import mx.unam.dgtic.datos.entidades.MetodoPago;
import mx.unam.dgtic.datos.entidades.Orden;
import mx.unam.dgtic.datos.entidades.Pago;

@SpringBootTest
@Transactional
@Rollback(false)
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class ConsultasConRelacionesTests {
	final Integer idCliente = 1;
	final Integer idProducto = 1;

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

	@Test
	@Transactional
	void buscarMetodosDePagosDePago(){
		System.out.println("\nBuscar metodos de pago de un pago:\n");

		Iterable<Pago> pagos = repositorioPago.findAll();

		pagos.forEach(pgo -> {
			System.out.println(
				"Método de pago de Pago '" + pgo.getId() + 
        "': " + pgo.getMetodoPago().getMetodo()
			);
		});
	}

	@Test
	@Transactional
	void buscarPagosDeUnMetodoDePago(){
		System.out.println("\nBuscar pagos de un metodo de pago:\n");

		Iterable<MetodoPago> metodos = repositorioMetodoPago.findAll();

		metodos.forEach(mtd -> {
			System.out.println(
				"Método: " + mtd.getMetodo() + "- pagos: " + mtd.getPagos()
			);
		});
	}

	@Test
	@Transactional
	void buscarClienteYPagoPorOrden(){
		System.out.println("\nBuscar cliente y pago de orden:\n");

		Iterable<Orden> ordenes = repositorioOrden.findAll();

		ordenes.forEach(c -> {
			System.out.println(
				"Cliente de orden número " + c.getId() + 
        ": " + c.getCliente().getNombre() + 
        " " + c.getCliente().getApellidos() + 
        "- pago: " + c.getPago().getId()
			);
		});
	}

	@Test
	@Transactional
	void buscarDulcesDeUnArreglo(){
		System.out.println("\nBuscar dulces de un arreglo:\n");

		Iterable<Arreglo> arreglos = repositorioArreglo.findAll();

		arreglos.forEach(arr -> {
			System.out.println(
				"Dulces del arreglo " + arr.getId() + ": " + arr.getDulces()
			);
		});
	}

	@Test
	@Transactional
	void buscarArreglosDeUnDulce(){
		System.out.println("\nBuscar arreglos a los cuales pertenecen un dulce:\n");

		Iterable<Dulce> dulces = repositorioDulce.findAll();

		dulces.forEach(dlc -> {
			System.out.println(
				"Arreglos a los cuales pertenecen " + dlc.getNombreDulce() + 
				": " + dlc.getArreglos()
			);
		});
	}
}
