package mx.unam.dgtic.datos;



import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "categoria")
//NamedQuery literalmente consulta nombrada
//Dentro de name definimos el metodo dentro de una entidad
//La firma de este metodo se vera dentro del repositorio equivalente a esta entidad
//dentro de query definimos la lógica de la consulta a través de JPQL
@NamedQuery(name = "Categoria.buscarGrandes",
        query = "SELECT c FROM Categoria c WHERE LENGTH(c.descripcion) >= 10"
)
@NamedQuery(name = "Categoria.buscarCortas",
        query = "SELECT c FROM Categoria c WHERE LENGTH(c.descripcion) < 10"
)
@NamedQuery(name = "Categoria.contarPorDescripcionUnico",
        query = "SELECT c.descripcion AS campo, COUNT(c) as conteo"
                + " FROM Categoria c "
                + " GROUP BY c.descripcion"
)
@NamedQuery(name = "Categoria.buscarDescripcionDistinta",
        query = "SELECT DISTINCT c.descripcion FROM Categoria c"
)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String descripcion, List<Producto> productos) {
        this.id = id;
        this.descripcion = descripcion;
        this.productos = productos;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        //Sacamos los valores de los productos para que no se genera un ciclo infinito en el toString debido a la relacion bidireccional de las entidades
        //(Porque Categoría tienesus productos asociados y cada producto tiene una categoría asociada, así que para imprimir uno hay que llamar el toString que tiene la otra entidad generando un cliclo infinito)
        var prods = productos.stream()
                .map(Producto::getDescripcion)
                .collect(Collectors.joining(", "));
        return "Categoria{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", productos=" + prods +
                '}';
    }
}
