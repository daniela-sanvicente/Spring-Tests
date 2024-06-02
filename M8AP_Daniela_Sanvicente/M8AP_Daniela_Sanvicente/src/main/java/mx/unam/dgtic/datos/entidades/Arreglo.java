package mx.unam.dgtic.datos.entidades;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "arreglos")
public class Arreglo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //name, nombre de la columna en la tabla de la base de datos
    //nullable si una columna puede tener un valor vacío o no
    //unique para expresar que este valor no se puede repetir , todos los valores deben ser unicos para la columna
    @Column(name = "nombre_arreglo", nullable = false, unique = true, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String nombreArreglo;

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.00")
    private Double precio;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tema;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String tipo;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer stock;

    @Column(columnDefinition = "VARCHAR(200) DEFAULT NULL")
    private String imagen;

    @Column(name = "tiempo_elaboracion", nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String tiempoElaboracion;

    @Column(nullable = false, columnDefinition = "VARCHAR(300) DEFAULT 'N/A'")
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "arreglo_dulces",
            joinColumns = @JoinColumn(name = "id_arreglo"),
            inverseJoinColumns = @JoinColumn(name = "id_dulce")
    )
    private List<Dulce> dulces;

    @ManyToMany(mappedBy = "arreglos")
    private Set<Mesa> mesas;

    public Arreglo() {
    }


    public Arreglo(String nombreArreglo, Double precio, String tema, String tipo, Integer stock, String imagen, String tiempoElaboracion, String descripcion, List<Dulce> dulces) {
        this.nombreArreglo = nombreArreglo;
        this.precio = precio;
        this.tema = tema;
        this.tipo = tipo;
        this.stock = stock;
        this.imagen = imagen;
        this.tiempoElaboracion = tiempoElaboracion;
        this.descripcion = descripcion;
        this.dulces = dulces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreArreglo() {
        return nombreArreglo;
    }

    public void setNombreArreglo(String nombreArreglo) {
        this.nombreArreglo = nombreArreglo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
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

    public Set<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(Set<Mesa> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        var dlcs = dulces.stream()
                .map(Dulce::getNombreDulce)
                .collect(Collectors.joining(", "));
        
        return "Arreglo [id=" + id + ", nombreArreglo=" + nombreArreglo + ", precio=" + precio + ", tema=" + tema
                + ", tipo=" + tipo + ", stock=" + stock + ", imagen=" + imagen + ", tiempoElaboracion="
                + tiempoElaboracion + ", descripcion=" + descripcion + ", dulces=" + dlcs + "]";
    }
}
