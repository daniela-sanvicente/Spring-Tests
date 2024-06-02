package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Dulce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface DulcePagingAndSortingRepository extends PagingAndSortingRepository<Dulce,Integer> {

    //---------PagingAndSorting------
    Page<Dulce> findByNombreDulce(String nombreDulce, Pageable pagina);
    Page<Dulce> findByTema(String tema, Pageable pagina);
    Page<Dulce> findByTipo(String tipo, Pageable pagina);

    Page<Dulce> streamByImagenIsNull(Pageable pagina);

    Page<Long> countByStock(Integer stock, Pageable pagina);
    Page<Long> countByImagenIsNull(Pageable pagina);
}
