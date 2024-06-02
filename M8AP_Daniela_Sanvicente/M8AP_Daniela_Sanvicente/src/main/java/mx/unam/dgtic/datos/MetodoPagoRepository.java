package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.MetodoPago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MetodoPagoRepository extends CrudRepository<MetodoPago, Integer> {

    //------Consultas Derivadas-----------
    List<MetodoPago> findByMetodo(String metodo);
    List<MetodoPago> findByMetodoNot(String metodo);

    List<MetodoPago> findByMetodoStartingWith(String prefijo);

    List<MetodoPago> findByMetodoEndingWith(String sufijo);

    List<MetodoPago> findByMetodoContains(String palabraClave);

    List<MetodoPago> findByMetodoIgnoreCase(String metodo);

    //-----Consultas Nombradas------------
    @Query(value = "SELECT * FROM metodo_pago"
            + " WHERE metodo = null",
            nativeQuery = true
    )
    List<MetodoPago> buscarPorMetodoNulo(String metodo);

    @Query(value = "SELECT * FROM metodo_pago"
            + " WHERE metodo LIKE '?%'", //el signo de interrogacion es sustituido por la cadena enviada y el % 0 hasta n caracteres de cualquier tipo
            nativeQuery = true
    )
    List<MetodoPago> buscarAlInicio(String metodo);

    @Query(value = "SELECT * FROM metodo_pago"
            + " WHERE metodo LIKE '%?%'",
            nativeQuery = true
    )
    List<MetodoPago> buscarEnMedio(String metodo);

    @Query(value = "SELECT * FROM metodo_pago"
            + " WHERE metodo LIKE '%?'",
            nativeQuery = true
    )
    List<MetodoPago> buscarAlFinal(String metodo);

    @Query(value = "SELECT * FROM metodo_pago"
            + " ORDER BY metodo ASC",
            nativeQuery = true
    )
    List<MetodoPago> buscarPorMetodoAsc(String metodo);
}
