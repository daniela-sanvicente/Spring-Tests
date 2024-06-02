package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.buscarPorNombre",
        query = "SELECT c FROM Cliente c WHERE c.nombre = ?1"
)

@NamedQuery(name = "Cliente.buscarPorNombreYPaterno",
        query = "SELECT c FROM Cliente c WHERE c.nombre = ?1 AND c.paterno = ?2"
)
@NamedQuery(name = "Cliente.contarPorPaternoUnico",
        query = "SELECT c.paterno AS campo, COUNT(c) as conteo"
                + " FROM Cliente c "
                + " GROUP BY c.paterno"
)
@NamedQuery(name = "Cliente.buscarNombreDistinto",
        query = "SELECT DISTINCT c.nombre FROM Cliente c"
)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave_cliente")
    private Integer claveCliente;
    
    private String nombre;
    private String paterno;
    private Date fnac;
    private String curp;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Cliente() {
    }

    public Cliente(Integer claveCliente) {
        this.claveCliente = claveCliente;
    }

    public Cliente(Integer claveCliente, String nombre, String paterno, Date fnac, String curp, Pais pais) {
        this.claveCliente = claveCliente;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.curp = curp;
        this.pais = pais;
    }

    public Integer getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(Integer claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "claveCliente=" + claveCliente +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", curp='" + curp + '\'' +
                ", pais=" + pais +
                '}';
    }
}
