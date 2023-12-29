package com.mycompany.actividad1.dto;

import java.io.Serializable;

/**
 * @author Noelia Rozado
 *
 * Clase que almacena los datos básicos de un vuelo
 */
public class Vuelo implements Serializable {

    /**
     * Código de vuelo
     */
    private String codigoVuelo;

    /**
     * Aeropuerto origen
     */
    private Aeropuerto aeropuertoOrigen;

    /**
     * Aeropuerto destino
     */
    private Aeropuerto aeropuertoDestino;

    /**
     * Número de plazas
     */
    private int numeroPlazas;

    /**
     * Hora oficial de salida
     */
    private String horaOficialSalida;

    /**
     * Hora oficial de llegada
     */
    private String horaOficialLlegada;

    /**
     * Días que opera
     */
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

    /**
     * Obtiene el código de vuelo
     *
     * @return una cadena formada por el código de la compañía y un número
     * entero positivo
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     * Establece el código de vuelo
     *
     * @param codigoVuelo código de vuelo
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     * Obtiene el aeropuerto de origen del vuelo
     *
     * @return aeropuerto origen
     */
    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    /**
     * Establece el aeropuerto de origen del vuelo
     *
     * @param aeropuertoOrigen aeropuerto origen
     */
    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    /**
     * Obtiene el aeropuerto de destino del vuelo
     *
     * @return aeropuerto destino
     */
    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    /**
     * Establece el aeropuerto de destino del vuelo
     *
     * @param aeropuertoDestino aeropuerto destino
     */
    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    /**
     * Obtiene el número total de plazas disponibles en el vuelo
     *
     * @return número de plazas disponibles
     */
    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    /**
     * Establece el número de plazas disponibles en el vuelo
     *
     * @param numeroPlazas número de plazas disponibles
     */
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    /**
     * Obtiene la hora oficial de salida
     *
     * @return hora oficial de salida
     */
    public String getHoraOficialSalida() {
        return horaOficialSalida;
    }

    /**
     * Establece la hora oficial de salida
     *
     * @param horaOficialSalida hora oficial de salida
     */
    public void setHoraOficialSalida(String horaOficialSalida) {
        this.horaOficialSalida = horaOficialSalida;
    }

    /**
     * Obtiene la hora oficial de llegada
     *
     * @return hora oficial de llegada
     */
    public String getHoraOficialLlegada() {
        return horaOficialLlegada;
    }

    /**
     * Establece la hora oficial de llegada
     *
     * @param horaOficialLlegada hora oficial de llegada
     */
    public void setHoraOficialLlegada(String horaOficialLlegada) {
        this.horaOficialLlegada = horaOficialLlegada;
    }

    /**
     * Obtiene los días en los que opera
     *
     * @return días en los que opera
     */
    public String getDias() {
        return dias;
    }

    /**
     * Establece los días en los que opera
     *
     * @param dias días en los que opera
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return codigoVuelo;
    }

}
