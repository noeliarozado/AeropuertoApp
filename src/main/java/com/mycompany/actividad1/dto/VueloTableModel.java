package com.mycompany.actividad1.dto;

import java.time.format.DateTimeFormatter;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author Noelia Rozado
 */
public final class VueloTableModel extends AbstractTableModel {

    List<VueloDiario> vuelosDiarios;
    List<Vuelo> listaVuelo;

    String[] titulos = {"Codigo vuelo", "Fecha", "Hora de salida", "Hora de llegada", "Aeropuerto origen",
        "Aeropuerto destino"};

    public VueloTableModel(List<VueloDiario> vuelosDiarios, List<Vuelo> listaVuelo) {
        super();
        this.vuelosDiarios = vuelosDiarios;
        this.listaVuelo = listaVuelo;
    }

    @Override
    public int getRowCount() {
        return vuelosDiarios.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch (columna) {
            case 0 -> {
                return vuelosDiarios.get(fila).getCodigoVuelo();
            }
            case 1 -> {
                return vuelosDiarios.get(fila).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
            case 2 -> {
                return vuelosDiarios.get(fila).getHoraSalidaReal();
            }
            case 3 -> {
                return vuelosDiarios.get(fila).getHoraLlegadaReal();
            }
            case 4 -> {
                String codigoVuelo = vuelosDiarios.get(fila).getCodigoVuelo();
                for (Vuelo vuelo : listaVuelo) {
                    if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                        return vuelo.getAeropuertoOrigen().getNombreCiudad();
                    }
                }
                return null;
            }
            case 5 -> {
                String codigoVuelo = vuelosDiarios.get(fila).getCodigoVuelo();
                for (Vuelo vuelo : listaVuelo) {
                    if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                        return vuelo.getAeropuertoDestino().getNombreCiudad();
                    }
                }
                return null;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public Class getColumnClass(int columna) {
        return getValueAt(0, columna).getClass();
    }

    @Override
    public String getColumnName(int columna) {
        return titulos[columna];
    }

    public int getCodigoDestinoEn(int fila) {
        String codigoVuelo = vuelosDiarios.get(fila).getCodigoVuelo();
        for (Vuelo vuelo : listaVuelo) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo.getAeropuertoOrigen().getCodigoMunicipio();
            }
        }
        return 0;
    }

    public int getCodigoOrigenEn(int fila) {
        String codigoVuelo = vuelosDiarios.get(fila).getCodigoVuelo();
        for (Vuelo vuelo : listaVuelo) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo.getAeropuertoDestino().getCodigoMunicipio();
            }
        }
        return 0;
    }
}
