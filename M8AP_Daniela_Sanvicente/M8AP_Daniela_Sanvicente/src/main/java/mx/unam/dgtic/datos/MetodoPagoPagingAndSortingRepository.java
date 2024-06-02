package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.MetodoPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MetodoPagoPagingAndSortingRepository extends PagingAndSortingRepository<MetodoPago, Integer> {
      //---------PagingAndSorting------

    Page<MetodoPago> findByMetodo(String metodo, Pageable pagina);

    Page<MetodoPago> findByMetodoNot(String metodo, Pageable pagina);

    Page<MetodoPago> findByMetodoStartingWith(String prefijo, Pageable pagina);

    Page<MetodoPago> findByMetodoEndingWith(String sufijo, Pageable pagina);

    Page<MetodoPago> findByMetodoContains(String palabraClave, Pageable pagina);

    Page<MetodoPago> findByMetodoIgnoreCase(String metodo, Pageable pagina);

}
