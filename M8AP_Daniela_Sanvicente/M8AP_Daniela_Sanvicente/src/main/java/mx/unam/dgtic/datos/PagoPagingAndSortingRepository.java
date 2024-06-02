package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Pago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagoPagingAndSortingRepository extends PagingAndSortingRepository<Pago, Integer> {
     //---------PagingAndSorting------

    Page<Pago> findByEmisor(String emisor, Pageable pagina);

    Page<Pago> findByNumeroCuentaStartingWith(String prefijo, Pageable pagina);

    Page<Pago> findByNumeroCuentaEndingWith(String sufijo, Pageable pagina);

    Page<Pago> findByNumeroCuentaContains(String numeroCuenta, Pageable pagina);

    Page<Pago> findByEmisorIgnoreCase(String emisor, Pageable pagina);


}
