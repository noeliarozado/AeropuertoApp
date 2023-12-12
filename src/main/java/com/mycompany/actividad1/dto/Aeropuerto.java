package com.mycompany.actividad1.dto;

import java.util.Objects;

/**
 *
 * @author noeli
 */
public class Aeropuerto {
    private String codigoIATA;
    private String nombreCiudad;
    private int codigoMunicipio;

    public Aeropuerto(String codigoIATA, String nombreCiudad, int codigoMunicipio) {
        this.codigoIATA = codigoIATA;
        this.nombreCiudad = nombreCiudad;
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    @Override
    public String toString() {
        return codigoIATA;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigoIATA);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeropuerto other = (Aeropuerto) obj;
        return Objects.equals(this.codigoIATA, other.codigoIATA);
    }
    
}
