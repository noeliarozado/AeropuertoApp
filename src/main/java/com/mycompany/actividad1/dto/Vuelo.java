package com.mycompany.actividad1.dto;

import java.io.Serializable;

/**
 *
 * @author noeli
 */
public class Vuelo implements Serializable {
    private String codigoVuelo;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private int numeroPlazas;
    private String horaOficialSalida;
    private String horaOficialLlegada;
    private String dias;

    public Vuelo(String codigoVuelo, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, int numeroPlazas, 
            String horaOficialSalida, String horaOficialLlegada, String dias) {
        this.codigoVuelo = codigoVuelo;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.numeroPlazas = numeroPlazas;
        this.horaOficialSalida = horaOficialSalida;
        this.horaOficialLlegada = horaOficialLlegada;
        this.dias = dias;
    }
    
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getHoraOficialSalida() {
        return horaOficialSalida;
    }

    public void setHoraOficialSalida(String horaOficialSalida) {
        this.horaOficialSalida = horaOficialSalida;
    }

    public String getHoraOficialLlegada() {
        return horaOficialLlegada;
    }

    public void setHoraOficialLlegada(String horaOficialLlegada) {
        this.horaOficialLlegada = horaOficialLlegada;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return codigoVuelo;
    }
      
}