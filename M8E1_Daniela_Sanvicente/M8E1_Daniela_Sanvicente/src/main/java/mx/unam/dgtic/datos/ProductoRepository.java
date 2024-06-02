package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    //------Consultas Derivadas-----------
    List<Producto> findByDescripcion(String descripcion);
    List<Producto> findByDescripcionNot(String descripcion);

    List<Producto> streamByDescripcionIsNull();

    long countByDescripcion(String descripcion);
    long countByDescripcionNot(String descripcion);
    long countByDescripcionIsNull();

    boolean existsByDescripcion(String descripcion);

    //-----Consultas Nombradas------------
    List<Producto> buscarPorStock();
    List<Producto> buscarPorStockYPrecio();
    List<String> buscarPrecioDistinto();
    List<ConteoPorCampo> contarPorStockUnico();
    @Query(value = "SELECT * FROM producto"
            + " WHERE id_categoria = ?",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Producto> buscarPorCategoria(Integer id);
}
