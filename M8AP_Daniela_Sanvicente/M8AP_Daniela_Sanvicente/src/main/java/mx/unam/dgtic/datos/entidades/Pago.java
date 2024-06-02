package mx.unam.dgtic.datos.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", referencedColumnName = "id", nullable = false)
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private String emisor;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @Column(name = "fecha_expiracion", nullable = false)
    private String fechaExpiracion;

    @Column(nullable = false)
    private String cvv;

    public Pago() {
    }

    public Pago(Cliente cliente, MetodoPago metodoPago, String emisor, String numeroCuenta, String fechaExpiracion, String cvv) {
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.emisor = emisor;
        this.numeroCuenta = numeroCuenta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    public Integer getId() {
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

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Pago [id=" + id + ", cliente=" + cliente + ", metodoPago=" + metodoPago + ", emisor=" + emisor
                + ", numeroCuenta=" + numeroCuenta + ", fechaExpiracion=" + fechaExpiracion + ", cvv=" + cvv + "]";
    }
}
