package com.mycompany.actividad1.dto;

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

}
