package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Cliente;
import mx.unam.dgtic.datos.entidades.Pago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagoRepository extends CrudRepository<Pago, Integer> {
    //------Consultas Derivadas-----------
    List<Pago> findByEmisor(String emisor);

    List<Pago> findByNumeroCuentaStartingWith(String prefijo);

    List<Pago> findByNumeroCuentaEndingWith(String sufijo);

    List<Pago> findByNumeroCuentaContains(String numeroCuenta);

    List<Pago> findByEmisorIgnoreCase(String emisor);

    //-----Consultas Nombradas------------
    @Query(value = "SELECT * FROM pago"
            + " WHERE numero_cuenta = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorNumeroCuenta(String numeroCuenta);

    @Query(value = "SELECT * FROM pago"
            + " WHERE fecha_expiracion = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorFechaExpiracion(String fechaExpiracion);


    @Query(value = "SELECT * FROM pago"
            + " WHERE cvv = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorCvv(String cvv);

    @Query(value = "SELECT * FROM pago "
            + "WHERE fecha_expiracion = ?1 AND cvv = ?2",
            nativeQuery = true // SQL
    )
    List<Pago> buscarPorFechaExpiracionYCvv(String fechaExpiracion, String cvv);

    @Query(value = "SELECT * FROM pago "
            + "WHERE numero_cuenta = ?1 AND emisor = ?2",
            nativeQuery = true // SQL
    )
    List<Pago> buscarPorNumeroCuentaYEmisor(String numeroCuenta, String emisor);


}
