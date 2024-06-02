package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.dto.DulceDto;
import mx.unam.dgtic.datos.entidades.Dulce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DulceRepository extends CrudRepository<Dulce, Integer> {
    //------Consultas Derivadas-----------
    List<Dulce> findByNombreDulce(String nombreDulce);
    List<Dulce> findByTema(String tema);
    List<Dulce> findByTipo(String tipo);

    List<Dulce> streamByImagenIsNull();

    Long countByStock(Integer stock);
    Long countByImagenIsNull();

    boolean existsByTema(String tema);

    //-----Consultas Nombradas------------
    @Query(value = "SELECT * FROM dulces ORDER BY stock DESC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Dulce> buscarDulcePorStockDesc();

//    @Query(value = "SELECT * FROM dulces ORDER BY stock ASC",
//            nativeQuery = true    //SQL lo que no lo tenga es JPQL
//    )
//    List<Dulce> buscarDulcePorStockAsc();

    @Query(value = "SELECT * FROM dulces ORDER BY precio DESC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Dulce> buscarDulcePorPrecioDesc();

    @Query(value = "SELECT * FROM dulces ORDER BY precio ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Dulce> buscarDulcePorPrecioAsc();

    @Query(value = "SELECT d FROM Dulce d"
            + " ORDER BY d.stock ASC" //cuando es una cadena se ordena en orden alfabetico si es DESC  de la z a la a
    )
    List<Dulce> buscarDulcePorStockAsc();

    @Query(value = "SELECT * FROM dulces "
            + "GROUP BY tema, nombre_dulce "
            + "ORDER BY tema ASC, SUM(stock) DESC", nativeQuery = true)
    List<Dulce> agruparDulcePorTemaYStock();

    @Query(value = "SELECT * FROM dulces "
            + "ORDER BY tipo ASC, stock DESC", nativeQuery = true)
    List<Dulce> contarPorTipo();


    @Query(value = "select new mx.unam.dgtic.datos.dto.DulceDto(d.nombreDulce, d.tiempoElaboracion) from Dulce d")
    List<DulceDto> buscarPorTiempoElaboracion();

}
