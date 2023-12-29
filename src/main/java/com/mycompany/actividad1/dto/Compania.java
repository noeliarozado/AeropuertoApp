package com.mycompany.actividad1.dto;

import java.io.Serializable;

/**
 * @author Noelia Rozado
 *
 * Clase que almacena los datos básicos de una compañía
 */
public class Compania implements Serializable {

    /**
     * Prefijo
     */
    private int prefijo;

    /**
     * Código
     */
    private String codigo;

    /**
     * Nombre de la compañía
     */
    private String nombreCompania;

    /**
     * Dirección de la sede central
     */
    private String direccion;

    /**
     * Municipio de la sede central
     */
    private String municipio;

    /**
     * Teléfono de información al pasajero
     */
    private String telefonoPasajero;

    /**
     * Teléfono de información a aeropuertos
     */
    private String telefonoAeropuerto;

    public Compania(int prefijo, String codigo, String nombreCompania, String direccion, String municipio,
            String telefonoPasajero, String telefonoAeropuerto) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombreCompania = nombreCompania;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefonoPasajero = telefonoPasajero;
        this.telefonoAeropuerto = telefonoAeropuerto;
    }

    /**
     * Obtiene el prefijo de la compañía
     *
     * @return código numérico que representa el prefijo de la compañía
     */
    public int getPrefijo() {
        return prefijo;
    }

    /**
     * Establece el prefijo de la compañía
     *
     * @param prefijo prefijo de la compañía
     */
    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    /**
     * Obtiene el código de identificación de la compañía
     *
     * @return cadena de dos caracteres que representa el código de la compañía
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código de identificación de la compañía
     *
     * @param codigo código de identificación de la compañía
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre de la compañía
     *
     * @return nombre de la compañía
     */
    public String getNombreCompania() {
        return nombreCompania;
    }

    /**
     * Establece el nombre de la compañía aérea
     *
     * @param nombreCompania nombre de la compañía
     */
    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    /**
     * Obtiene la dirección de la compañía
     *
     * @return dirección de la compañía
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la compañía
     *
     * @param direccion dirección de la compañía
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el municipio donde está la compañía
     *
     * @return municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio donde se encuentra la compañía
     *
     * @param municipio municipio de la sede central
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el número de teléfono de información para pasajeros
     *
     * @return número de teléfono para pasajeros
     */
    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    /**
     * Establece el número de teléfono de información para pasajeros
     *
     * @param telefonoPasajero número de teléfono para pasajeros
     */
    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }

    /**
     * Obtiene el número de teléfono que tiene el aeropuerto para realizar
     * gestiones
     *
     * @return número de teléfono de información del aeropuerto
     */
    public String getTelefonoAeropuerto() {
        return telefonoAeropuerto;
    }

    /**
     * Establece el número de teléfono que tiene el aeropuerto para realizar
     * gestiones
     *
     * @param telefonoAeropuerto número de teléfono de información del
     * aeropuerto
     */
    public void setTelefonoAeropuerto(String telefonoAeropuerto) {
        this.telefonoAeropuerto = telefonoAeropuerto;
    }

    @Override
    public String toString() {
        return nombreCompania;
    }

}
