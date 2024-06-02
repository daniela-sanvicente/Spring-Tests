package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface VentaRepository extends CrudRepository<Venta, Integer> {
    //------Consultas Derivadas-----------
    List<Venta> findByTotalVenta(Long totalVenta);

    List<Venta> findByTotalVentaNot(Long totalVenta);

    List<Venta> streamByTotalVentaIsNull();

    Long countByTotalVenta(Long totalVenta);

    Long countByTotalVentaNot(Long totalVenta);

    Long countByTotalVentaIsNull();

    boolean existsByTotalVenta(Long totalVenta);

    //-----Consultas Nombradas------------
    List<Venta> buscarPorIdVenta();
    List<Venta> buscarPorIdVentaYFechaVenta();
    List<Long> buscarTotalVentaDistinto();
    List<ConteoPorCampo> contarPorTotalVentaUnico();

    @Query(value = "SELECT * FROM venta"
            + " WHERE clave_cliente = ?",
            nativeQuery = true
    )
    List<Venta> buscarPorClaveCliente(Integer clave);
}
