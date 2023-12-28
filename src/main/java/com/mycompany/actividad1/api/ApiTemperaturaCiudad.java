package com.mycompany.actividad1.api;

/**
 * @author Noelia Rozado
 *
 * Representa las temperaturas de una ciudad
 */
public class ApiTemperaturaCiudad {

    /**
     * Nombre de la ciduad
     */
    private String nombreCiudad;

    /**
     * Temperatura máxima prevista en la ciudad
     */
    private double temperaturaMaxima;

    /**
     * Temperatura mínima prevista en la ciudad
     */
    private double temperaturaMinima;

    public ApiTemperaturaCiudad(String nombreCiudad, double temperaturaMaxima, double temperaturaMinima) {
        this.nombreCiudad = nombreCiudad;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    }

    /**
     * Obtiene el nombre de la ciudad
     *
     * @return nombre de la ciudad
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Establece el nombre de la ciudad
     *
     * @param nombreCiudad nombre de la ciudad
     */
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    /**
     * Obtiene la temperatura máxima prevista en la ciudad
     *
     * @return temperatura máxima prevista
     */
    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    /**
     * Establece la temperatura máxima prevista en la ciudad
     *
     * @param temperaturaMaxima temperatura máxima prevista
     */
    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    /**
     * Obtiene la temperatura mínima prevista en la ciudad
     *
     * @return temperatura mínima prevista
     */
    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    /**
     * Establece la temperatura mínima prevista en la ciudad
     *
     * @param temperaturaMinima temperatura mínima prevista
     */
    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

}
