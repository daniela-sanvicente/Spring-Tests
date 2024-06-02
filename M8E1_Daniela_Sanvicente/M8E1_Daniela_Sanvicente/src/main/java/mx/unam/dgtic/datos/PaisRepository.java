package mx.unam.dgtic.datos;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface PaisRepository extends CrudRepository<Pais, Integer> {
    //------Consultas Derivadas-----------
    List<Pais> findByCodigoIso(String codigoIso);
    List<Pais> findByCodigoIsoNot(String codigoIso);

    List<Pais> streamByCodigoIsoIsNull();

    Long countByCodigoIso(String codigoIso);
    Long countByCodigoIsoNot(String codigoIso);
    Long countByCodigoIsoIsNull();

    boolean existsByCodigoIso(String codigoIso);

    //-----Consultas Nombradas------------
    List<Pais> buscarPorPais();
    List<Pais> buscarPorPaisYCodigoIso();
    List<String> buscarCodigoIsoDistinto();
    List<ConteoPorCampo> contarPorCodigoIsoUnico();

    @Query(value = "SELECT * FROM pais"
            + " WHERE codigo_iso = ?",
            nativeQuery = true
    )
    List<Pais> buscarPorCodigoIso(String codigoIso);
}
