package com.mycompany.actividad1.dto;

import java.io.Serializable;

/**
 *
 * @author noeli
 */
public class Compania implements Serializable {
    private int prefijo;
    private String codigo;
    private String nombreCompania;
    private String direccion;
    private String municipio;
    private String telefonoPasajero;
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

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }

    public String getTelefonoAeropuerto() {
        return telefonoAeropuerto;
    }

    public void setTelefonoAeropuerto(String telefonoAeropuerto) {
        this.telefonoAeropuerto = telefonoAeropuerto;
    }

}
