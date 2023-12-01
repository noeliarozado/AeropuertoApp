package com.mycompany.actividad1.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author noeli
 */
public class VueloDiario implements Serializable {
    private String codigoVuelo;
    private LocalDate fecha;
    private LocalTime horaSalidaReal;
    private LocalTime horaLlegadaReal;
    private int plazasOcupadas;
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

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(LocalTime horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public LocalTime getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(LocalTime horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigoVuelo;
    }
        
}
