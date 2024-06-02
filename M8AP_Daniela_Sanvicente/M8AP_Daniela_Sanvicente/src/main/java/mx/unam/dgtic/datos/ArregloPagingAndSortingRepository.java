package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Arreglo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface ArregloPagingAndSortingRepository extends PagingAndSortingRepository<Arreglo, Integer> {
    //---------PagingAndSorting------
    Page<Arreglo> findByDescripcion(String descripcion, Pageable pagina);
    Page<Arreglo> findByDescripcionNot(String descripcion, Pageable pagina);

    Page<Arreglo> streamByDescripcionIsNull(Pageable pagina);

    Page<Long> countByDescripcion(String descripcion, Pageable pagina);
    Page<Long> countByDescripcionNot(String descripcion, Pageable pagina);
    Page<Long> countByDescripcionIsNull(Pageable pagina);

    Page<Arreglo> findByNombreArreglo(String nombreArreglo, Pageable pagina);
    Page<Arreglo> findByTema(String tema, Pageable pagina);
    Page<Arreglo> findByTipo(String tipo, Pageable pagina);

    Page<Arreglo> streamByImagenIsNull(Pageable pagina);

    Page<Long> countByStock(Integer stock, Pageable pagina);
    Page<Long> countByImagenIsNull(Pageable pagina);
}
