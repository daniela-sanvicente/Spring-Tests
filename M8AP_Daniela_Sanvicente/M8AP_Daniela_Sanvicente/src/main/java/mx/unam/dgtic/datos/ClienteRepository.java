package mx.unam.dgtic.datos;

import mx.unam.dgtic.datos.entidades.Arreglo;
import mx.unam.dgtic.datos.entidades.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    //------Consultas Derivadas-----------
    List<Cliente> findByNombre(String nombre);

    Long countByNombre(String nombre);
    Long countByNombreNot(String nombre);

    boolean existsByNombre(String nombre);

    List<Cliente> findByApellidosStartingWith(String prefijo);

    List<Cliente> findByApellidosContains(String palabraClave);

    List<Cliente> findByApellidosIgnoreCase(String apellidos);


    //-----Consultas Nombradas------------
    @Query(value = "SELECT nombre, apellidos FROM cliente "
            +"ORDER BY apellidos ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarClientesPorApellidoAsc();

    @Query(value = "SELECT correo FROM cliente "
            +"ORDER BY correo ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarClientesPorCorreoAsc();

    @Query(value = "SELECT nombre, apellidos, whatsapp FROM cliente "
            +"ORDER BY nombre ASC",
            nativeQuery = true    //SQL lo que no lo tenga es JPQL
    )
    List<Arreglo> buscarClientesPorWhatsapp();

    @Query(value = "SELECT * FROM cliente"
            + " WHERE correo = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorCorreo(String correo);

    @Query(value = "SELECT * FROM cliente"
            + " WHERE whatsapp = ?",
            nativeQuery = true //SQL
    )
    List<Cliente> buscarPorWhatsapp(String whatsapp);
}
