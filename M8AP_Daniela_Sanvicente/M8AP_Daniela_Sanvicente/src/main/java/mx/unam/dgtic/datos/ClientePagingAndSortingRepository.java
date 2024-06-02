package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientePagingAndSortingRepository extends PagingAndSortingRepository<Cliente,Integer> {

    //---------PagingAndSorting------
    Page<Cliente> findByNombre(String nombre, Pageable pagina);

    Page<Long> countByNombre(String nombre,Pageable pagina);
    Page<Long> countByNombreNot(String nombre,Pageable pagina);

    Page<Cliente> findByApellidosStartingWith(String prefijo,Pageable pagina);

    Page<Cliente> findByApellidosContains(String palabraClave,Pageable pagina);

    Page<Cliente> findByApellidosIgnoreCase(String apellidos,Pageable pagina);

}
