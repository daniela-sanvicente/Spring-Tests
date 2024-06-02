package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "venta")
@NamedQuery(name = "Venta.buscarPorIdVenta",
        query = "SELECT v FROM Venta v WHERE v.id = ?1"
)

@NamedQuery(name = "Venta.buscarPorIdVentaYFechaVenta",
        query = "SELECT v FROM Venta v WHERE v.id = ?1 AND v.fechaVenta = ?2"
)
@NamedQuery(name = "Venta.contarPorTotalVentaUnico",
        query = "SELECT v.totalVenta AS campo, COUNT(v) as conteo"
                + " FROM Venta v "
                + " GROUP BY v.totalVenta"
)
@NamedQuery(name = "Venta.buscarTotalVentaDistinto",
        query = "SELECT DISTINCT v.totalVenta FROM Venta v"
)
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;

    @ManyToOne // unidireccional
    @JoinColumn(name = "clave_cliente", referencedColumnName = "clave_cliente")//@JoinColumn es para llaves foraneas
    private Cliente cliente;

    @Column(name = "fecha_venta")
    private Date fechaVenta;
    
    @Column(name = "total_venta")
    private Long totalVenta;

    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;


    public Venta() {
    }

    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, Cliente cliente, Date fechaVenta, long totalVenta, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.productos = productos;
    }   public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }


    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public long getTotalVenta() {
        return totalVenta;
    }


    public void setTotalVenta(long totalVenta) {
        this.totalVenta = totalVenta;
    }


    public List<Producto> getProductos() {
        return productos;
    }


    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        var prods = getProductos().stream()
                .map(Producto::getDescripcion)
                .collect(Collectors.joining(", "));
        return "Venta{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fechaVenta=" + fechaVenta +
                ", totalVenta=" + totalVenta +
                ", productos=" + prods +
                '}';
    }
}
