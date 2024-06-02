package mx.unam.dgtic.datos.entidades;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.*;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String metodo;

    @OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL)
    private List<Pago> pagos;

    public MetodoPago() {
    }

    public MetodoPago(String metodo, List<Pago> pagos) {
        this.metodo = metodo;
        this.pagos = pagos;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getMetodo() {
      return metodo;
    }

    public void setMetodo(String metodo) {
      this.metodo = metodo;
    }

    public List<Pago> getPagos() {
      return pagos;
    }

    public void setPagos(List<Pago> pagos) {
      this.pagos = pagos;
    }

    @Override
    public String toString() {
        var pgos = pagos.stream()
                .map(Pago::getNumeroCuenta)
                .collect(Collectors.joining(", "));

        return "MetodoPago [id=" + id + ", metodo=" + metodo + ", pagos=" + pgos + "]";
    }
}
