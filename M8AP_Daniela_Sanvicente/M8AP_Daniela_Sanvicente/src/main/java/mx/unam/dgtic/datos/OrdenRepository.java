package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Orden;
import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends CrudRepository<Orden, Integer> {
  
}
