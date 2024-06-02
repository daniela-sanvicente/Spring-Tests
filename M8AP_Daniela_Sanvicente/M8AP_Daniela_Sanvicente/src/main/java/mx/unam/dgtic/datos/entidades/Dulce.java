package mx.unam.dgtic.datos.entidades;

import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "dulces")
public class Dulce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_dulce", nullable = false, unique = true, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String nombreDulce;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.00")
    private double precio;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tema;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String tipo;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int stock;

    @Column(columnDefinition = "VARCHAR(200) DEFAULT NULL")
    private String imagen;

    @Column(name = "tiempo_elaboracion", nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tiempoElaboracion;

    @ManyToMany(mappedBy = "dulces")
    private Set<Arreglo> arreglos;

    @ManyToMany(mappedBy = "dulces")
    private Set<Mesa> mesas;

    public Dulce() {
    }

    public Dulce(String nombreDulce, double precio, String tema, String tipo, int stock, String imagen, String tiempoElaboracion, Set<Arreglo> arreglos, Set<Mesa> mesas) {
        this.nombreDulce = nombreDulce;
        this.precio = precio;
        this.tema = tema;
        this.tipo = tipo;
        this.stock = stock;
        this.imagen = imagen;
        this.tiempoElaboracion = tiempoElaboracion;
        this.arreglos = arreglos;
        this.mesas = mesas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDulce() {
        return nombreDulce;
    }

    public void setNombreDulce(String nombreDulce) {
        this.nombreDulce = nombreDulce;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(String tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public Set<Arreglo> getArreglos() {
        return arreglos;
    }

    public void setArreglos(Set<Arreglo> arreglos) {
        this.arreglos = arreglos;
    }

    public Set<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(Set<Mesa> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        var arrs = arreglos.stream()
                .map(Arreglo::getNombreArreglo)
                .collect(Collectors.joining(", "));

        return "Dulce{" +
                "id=" + id +
                ", nombreDulce='" + nombreDulce + '\'' +
                ", precio=" + precio +
                ", tema='" + tema + '\'' +
                ", tipo='" + tipo + '\'' +
                ", stock=" + stock +
                ", imagen='" + imagen + '\'' +
                ", tiempoElaboracion='" + tiempoElaboracion + '\'' +
                ", arreglos='" + arrs + 
                '}';
    }
}
