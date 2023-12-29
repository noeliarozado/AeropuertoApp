package com.mycompany.actividad1.dto;

import java.util.Objects;

/**
 *
 * @author Noelia Rozado
 *
 * Clase que almacena los datos básicos de un aeropuerto
 */
public class Aeropuerto {

    /**
     * Código IATA del aeropuerto
     */
    private String codigoIATA;

    /**
     * Nombre de la localidad donde está ubicado el aeropuerto
     */
    private String nombreCiudad;

    /**
     * Código del municipio donde está ubicado el aeropuerto
     */
    private int codigoMunicipio;

    public Aeropuerto(String codigoIATA, String nombreCiudad, int codigoMunicipio) {
        this.codigoIATA = codigoIATA;
        this.nombreCiudad = nombreCiudad;
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     * Obtiene el código IATA del aeropuerto
     *
     * @return código IATA del aeropuerto
     */
    public String getCodigoIATA() {
        return codigoIATA;
    }

    /**
     * Establece el código IATA del aeropuerto
     *
     * @param codigoIATA código IATA del aeropuerto
     */
    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    /**
     * Obtiene el nombre de la ciudad donde está el aeropuerto
     *
     * @return nombre de la ciudad
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Establece el nombre de la ciudad donde está el aeropuerto
     *
     * @param nombreCiudad nombre de la ciudad
     */
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    /**
     * Obtiene el código del municipio donde está el aeropuerto
     *
     * @return código del municipio
     */
    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * Establece el código del municipio donde está el aeropuerto.
     *
     * @param codigoMunicipio código del municipio
     */
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
