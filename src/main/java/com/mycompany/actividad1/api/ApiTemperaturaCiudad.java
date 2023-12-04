package com.mycompany.actividad1.api;

/**
 *
 * @author noeli
 */
public class ApiTemperaturaCiudad {
    private String nombreCiudad;
    private double temperaturaMaxima;
    private double temperaturaMinima;

    public ApiTemperaturaCiudad(String nombreCiudad, double temperaturaMaxima, double temperaturaMinima) {
        this.nombreCiudad = nombreCiudad;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    } 

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

}
