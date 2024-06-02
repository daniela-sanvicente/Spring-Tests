package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    //------Consultas Derivadas-----------
    List<Cliente> findByNombre(String nombre);
    List<Cliente> findByNombreNot(String nombre);

    List<Cliente> streamByNombreIsNull();

    Long countByNombre(String nombre);
    Long countByNombreNot(String nombre);
    Long countByNombreIsNull();

    boolean existsByNombre(String nombre);

    //-----Consultas Nombradas------------
    List<Cliente> buscarPorNombre();
    List<Cliente> buscarPorNombreYPaterno();
    List<String> buscarNombreDistinto();
    List<ConteoPorCampo> contarPorPaternoUnico();
    
    @Query(value = "SELECT * FROM cliente"
            + " WHERE curp = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorCurp(String curp);
}
