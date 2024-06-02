package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "pais")
@NamedQuery(name = "Pais.buscarPorPais",
        query = "SELECT p FROM Pais p WHERE p.pais = ?1"
)

@NamedQuery(name = "Pais.buscarPorPaisYCodigoIso",
        query = "SELECT p FROM Pais p WHERE p.pais = ?1 AND p.codigoIso = ?2"
)

@NamedQuery(
        name = "Pais.contarPorCodigoIsoUnico",
        query = "SELECT p.codigoIso AS campo, COUNT(p) as conteo"
                + " FROM Pais p "
                + " GROUP BY p.codigoIso"
)

@NamedQuery(name = "Pais.buscarCodigoIsoDistinto",
        query = "SELECT DISTINCT p.codigoIso FROM Pais p"
)
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer id;

    @Column(unique = true)
    private String pais;

    @Column(name = "codigo_iso", unique = true)
    private String codigoIso;

    @OneToMany(mappedBy = "pais")
    private List<Cliente> clientes;

    public Pais() {
    }

    public Pais(Integer id) {
        this.id = id;
    }

    public Pais(Integer id, String pais, String codigoIso, List<Cliente> clientes) {
        this.id = id;
        this.pais = pais;
        this.codigoIso = codigoIso;
        this.clientes = clientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        var clts = clientes.stream()
                .map(Cliente::getNombre)
                .collect(Collectors.joining(", "));
        return "Pais{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", codigoIso='" + codigoIso + '\'' +
                ", clientes=" + clts +
                '}';
    }
}
