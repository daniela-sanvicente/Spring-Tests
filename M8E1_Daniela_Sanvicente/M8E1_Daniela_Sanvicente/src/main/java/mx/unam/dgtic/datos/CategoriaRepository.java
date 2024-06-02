package mx.unam.dgtic.datos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    //------Consultas Derivadas-----------
    List<Categoria> findByDescripcion(String descripcion);
    List<Categoria> findByDescripcionNot(String descripcion);

    List<Categoria> streamByDescripcionIsNull();

    Long countByDescripcion(String descripcion);
    Long countByDescripcionNot(String descripcion);
    Long countByDescripcionIsNull();

    boolean existsByDescripcion(String descripcion);

    //-----Consultas Nombradas------------
    List<Categoria> buscarGrandes();
    List<Categoria> buscarCortas();
    List<String> buscarDescripcionDistinta();
    List<ConteoPorCampo> contarPorDescripcionUnico();
    
    @Query(value = "SELECT * FROM categoria"
            + " WHERE descripcion = ?",
            nativeQuery = true //SQL
    )
    List<Categoria> buscarPorDescripcion(String descripcion);
}
