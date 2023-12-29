package com.mycompany.actividad1.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Noelia Rozado
 *
 * Clase que almacena los datos básicos de un vuelo diario
 */
public class VueloDiario implements Serializable {

    /**
     * Código de vuelo
     */
    private String codigoVuelo;

    /**
     * Fecha del vuelo
     */
    private LocalDate fecha;

    /**
     * Hora de salida real
     */
    private LocalTime horaSalidaReal;

    /**
     * Hora de llegada real
     */
    private LocalTime horaLlegadaReal;

    /**
     * Número de plazas ocupadas
     */
    private int plazasOcupadas;

    /**
     * Precio del vuelo
     */
    private double precio;

    public VueloDiario(String codigoVuelo, LocalDate fecha, LocalTime horaSalidaReal, LocalTime horaLlegadaReal,
            int plazasOcupadas, double precio) {
        this.codigoVuelo = codigoVuelo;
        this.fecha = fecha;
        this.horaSalidaReal = horaSalidaReal;
        this.horaLlegadaReal = horaLlegadaReal;
        this.plazasOcupadas = plazasOcupadas;
        this.precio = precio;
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
     * Establece el código del vuelo
     *
     * @param codigoVuelo código del vuelo
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     * Obtiene la fecha del vuelo
     *
     * @return fecha del vuelo
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del vuelo
     *
     * @param fecha fecha del vuelo
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de salida real
     *
     * @return hora de salida real
     */
    public LocalTime getHoraSalidaReal() {
        return horaSalidaReal;
    }

    /**
     * Establece la hora de salida real
     *
     * @param horaSalidaReal hora de salida real
     */
    public void setHoraSalidaReal(LocalTime horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    /**
     * Obtiene la hora de llegada real
     *
     * @return hora de llegada real
     */
    public LocalTime getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    /**
     * Establece la hora de llegada real
     *
     * @param horaLlegadaReal hora de llegada real
     */
    public void setHoraLlegadaReal(LocalTime horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    /**
     * Obtiene el número de plazas ocupadas
     *
     * @return número de plazas ocupadas
     */
    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    /**
     * Establece el número de plazas ocupadas
     *
     * @param plazasOcupadas número de plazas ocupadas
     */
    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    /**
     * Obtiene el precio del vuelo
     *
     * @return precio del vuelo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del vuelo
     *
     * @param precio precio del vuelo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigoVuelo;
    }

}
