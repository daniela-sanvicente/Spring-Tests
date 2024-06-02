package mx.unam.dgtic.datos.entidades;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.Set;

@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_mesa", nullable = false, unique = true, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String nombreMesa;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.00")
    private double precio;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tema;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String tipo;

    @Column(columnDefinition = "VARCHAR(200) DEFAULT NULL")
    private String imagen;

    @Column(nullable = false, columnDefinition = "VARCHAR(250) DEFAULT 'N/A'")
    private String cotizacion;

    @Column(name = "tiempo_elaboracion", nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tiempoElaboracion;

    @Column(nullable = false, columnDefinition = "VARCHAR(300) DEFAULT 'N/A'")
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "mesa_dulces",
            joinColumns = @JoinColumn(name = "id_mesa"),
            inverseJoinColumns = @JoinColumn(name = "id_dulce")
    )
    private List<Dulce> dulces;

    @ManyToMany
    @JoinTable(
            name = "mesa_arreglos",
            joinColumns = @JoinColumn(name = "id_mesa"),
            inverseJoinColumns = @JoinColumn(name = "id_arreglo")
    )
    private Set<Arreglo> arreglos;

    public Mesa() {
    }

    public Mesa(String nombreMesa, double precio, String tema, String tipo, String imagen, String cotizacion, String tiempoElaboracion, String descripcion, List<Dulce> dulces, Set<Arreglo> arreglos) {
        this.nombreMesa = nombreMesa;
        this.precio = precio;
        this.tema = tema;
        this.tipo = tipo;
        this.imagen = imagen;
        this.cotizacion = cotizacion;
        this.tiempoElaboracion = tiempoElaboracion;
        this.descripcion = descripcion;
        this.dulces = dulces;
        this.arreglos = arreglos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMesa() {
        return nombreMesa;
    }

    public void setNombreMesa(String nombreMesa) {
        this.nombreMesa = nombreMesa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(String cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(String tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Dulce> getDulces() {
        return dulces;
    }

    public void setDulces(List<Dulce> dulces) {
        this.dulces = dulces;
    }

    public Set<Arreglo> getArreglos() {
        return arreglos;
    }

    public void setArreglos(Set<Arreglo> arreglos) {
        this.arreglos = arreglos;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", nombreMesa='" + nombreMesa + '\'' +
                ", precio=" + precio +
                ", tema='" + tema + '\'' +
                ", tipo='" + tipo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cotizacion='" + cotizacion + '\'' +
                ", tiempoElaboracion='" + tiempoElaboracion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", dulces=" + dulces +
                ", arreglos=" + arreglos +
                '}';
    }
}
