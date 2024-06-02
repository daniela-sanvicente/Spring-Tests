package mx.unam.dgtic.datos.dto;

public class DulceDto {
    private String nombreDulce;
    private String tiempoElaboracion;


    public DulceDto(String nombreDulce, String tiempoElaboracion) {
        this.nombreDulce = nombreDulce;
        this.tiempoElaboracion = tiempoElaboracion;
    }

    public String getNombreDulce() {
        return nombreDulce;
    }

    public void setNombreDulce(String nombreDulce) {
        this.nombreDulce = nombreDulce;
    }

    public String getTiempoElaboracion() {
        return tiempoElaboracion;
    }

    public void setTiempoElaboracion(String tiempoElaboracion) {
        this.tiempoElaboracion = tiempoElaboracion;
    }

    @Override
    public String toString() {
        return "{" +
                "nombreDulce='" + nombreDulce + '\'' +
                ", tiempoElaboracion='" + tiempoElaboracion + '\'' +
                '}';
    }
}
