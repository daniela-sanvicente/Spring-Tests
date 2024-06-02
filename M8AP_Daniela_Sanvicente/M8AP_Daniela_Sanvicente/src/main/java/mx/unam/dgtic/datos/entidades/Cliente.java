package mx.unam.dgtic.datos.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, columnDefinition = "VARCHAR(30) DEFAULT 'N/A'")
    private String nombre;

    @Column(nullable = false, columnDefinition = "VARCHAR(80) DEFAULT 'N/A'")
    private String apellidos;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(80) DEFAULT 'N/A'")
    private String correo;

    @Column(name = "telefono_casa", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'N/A'")
    private String telefonoCasa;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'N/A'")
    private String whatsapp;

    @Column(nullable = false, columnDefinition = "VARCHAR(200) DEFAULT 'N/A'")
    private String direccion;

    @Column(nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'N/A'")
    private String tipo;

    @Column(nullable = false, columnDefinition = "VARCHAR(30) DEFAULT 'N/A'")
    private String contrasena;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefonoCasa, String whatsapp, String direccion, String tipo, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefonoCasa = telefonoCasa;
        this.whatsapp = whatsapp;
        this.direccion = direccion;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
                + ", telefonoCasa=" + telefonoCasa + ", whatsapp=" + whatsapp + ", direccion=" + direccion + ", tipo="
                + tipo + ", contrasena=" + contrasena + "]";
    }
}
