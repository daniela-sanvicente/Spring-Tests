package mx.unam.dgtic.datos;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
//JPQL (SQL de java)
@NamedQuery(name = "Producto.buscarPorStock",
        query = "SELECT p FROM Producto p WHERE p.stock = ?1"
)

@NamedQuery(name = "Producto.buscarPorStockYPrecio",
        query = "SELECT p FROM Producto p WHERE p.stock = ?1 AND p.precio = ?2"
)
@NamedQuery(name = "Producto.buscarPrecioDistinto",
        query = "SELECT DISTINCT p.precio FROM Producto p"
)
@NamedQuery(name = "Producto.contarPorStockUnico",
        query = "SELECT p.stock AS campo, COUNT(p) as conteo"
                + " FROM Producto p "
                + " GROUP BY p.stock"
)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Integer precio;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    /*@ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;*/

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String descripcion, Integer precio, Integer stock, Categoria categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria=" + categoria +
                '}';
    }
}
