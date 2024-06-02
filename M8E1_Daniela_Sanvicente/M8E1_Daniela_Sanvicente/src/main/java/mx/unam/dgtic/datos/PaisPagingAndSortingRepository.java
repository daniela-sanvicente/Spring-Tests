package mx.unam.dgtic.datos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaisPagingAndSortingRepository extends PagingAndSortingRepository<Pais,Integer> {

//    //---------PagingAndSorting------
//    Page<Pais> findByCurpLike(String patron, Pageable pagina);
//
//    //DISTINCT
//    @Query(value = "SELECT DISTINCT a.nombre FROM Pais a")
//    Page<String> findDistinctNombre(Pageable pagina);
//
//    @Query(value = "SELECT DISTINCT a.paterno FROM Pais a")
//    Page<String> findDistinctPaterno(Pageable pagina);
//
//    @Query(value = "SELECT a.nombre AS campo, COUNT(a) as conteo "
//            + "FROM Pais a "
//            + "GROUP BY a.nombre")
//    Page<ConteoPorCampo> contarPorNombreUnico(Pageable pagina);
//
//    @Query(value = "SELECT a.paterno AS campo, COUNT(a) as conteo "
//            + "FROM Pais a "
//            + "GROUP BY a.paterno")
//    Page<ConteoPorCampo> contarPorPaternoUnico(Pageable pagina);
//
//    @Query(value = "SELECT EXTRACT(YEAR FROM a.fnac) AS campo, COUNT(a) as conteo "
//            +"FROM Pais a "
//            +"GROUP BY EXTRACT(YEAR FROM a.fnac)")
//    Page<ConteoPorCampo> contarPorAnioUnico(Pageable pagina);

}
