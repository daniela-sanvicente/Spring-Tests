package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Arreglo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ArregloRepository extends CrudRepository<Arreglo, Integer> {
    //------Consultas Derivadas-----------
    List<Arreglo> findByDescripcion(String descripcion);
    List<Arreglo> findByDescripcionNot(String descripcion);

    List<Arreglo> streamByDescripcionIsNull();

    Long countByDescripcion(String descripcion);
    Long countByDescripcionNot(String descripcion);
    Long countByDescripcionIsNull();

    List<Arreglo> findByNombreArreglo(String nombreArreglo);
    List<Arreglo> findByTema(String tema);
    List<Arreglo> findByTipo(String tipo);

    List<Arreglo> streamByImagenIsNull();

    Long countByStock(Integer stock);
    Long countByImagenIsNull();

    boolean existsByTema(String tema);

    //-----Consultas Nombradas------------
    @Query(value = "SELECT nombre_arreglo, stock FROM arreglos ORDER BY stock DESC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarArregloPorStockDesc();

    @Query(value = "SELECT * FROM arreglos ORDER BY precio DESC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarArregloPorPrecioDesc();

    @Query(value = "SELECT * FROM arreglos ORDER BY precio ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarArregloPorPrecioAsc();

    @Query(value = "SELECT nombre_arreglo, tiempo_elaboracion FROM arreglos"
            + " ORDER BY nombre_arreglo ASC", //cuando es una cadena se ordena en orden alfabetico si es DESC  de la z a la a
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarPorTiempoElaboracion();

    @Query(value = "SELECT tema, nombre_arreglo, SUM(stock) AS stock_arreglo FROM arreglos "
            + "GROUP BY tema, nombre_arreglo "
            + "ORDER BY tema ASC, stock_arreglo DESC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> agruparArregloPorTemaYStock();

    @Query(value = "SELECT tipo, SUM(stock) AS total_stock FROM arreglos "
            + "GROUP BY tipo "
            + "ORDER BY tipo ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> contarPorTipo();
}
