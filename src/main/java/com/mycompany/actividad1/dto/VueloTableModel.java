package com.mycompany.actividad1.dto;

import java.time.format.DateTimeFormatter;
import javax.swing.table.*;
import java.util.*;

/**
 * @author Noelia Rozado
 *
 * Clase que representa un modelo de tabla para mostrar los vuelos diarios
 */
public final class VueloTableModel extends AbstractTableModel {

    /**
     * Lista de vuelos diarios
     */
    List<VueloDiario> vuelosDiarios;

    /**
     * Lista de vuelos
     */
    List<Vuelo> listaVuelo;

    String[] titulos = {"Codigo vuelo", "Fecha", "Hora de salida", "Hora de llegada", "Aeropuerto origen",
        "Aeropuerto destino"};

    public VueloTableModel(List<VueloDiario> vuelosDiarios, List<Vuelo> listaVuelo) {
        super();
        this.vuelosDiarios = vuelosDiarios;
        this.listaVuelo = listaVuelo;
    }

    /**
     * Devuelve el número de filas de la tabla
     *
     * @return número de filas
     */
    @Override
    public int getRowCount() {
        return vuelosDiarios.size();
    }

    /**
     * Devuelve el número de columnas de la tabla
     *
     * @return número de columnas
     */
    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    /**
     * Devuelve el valor en la posición especificada en la tabla.
     *
     * @param fila índice de la fila
     * @param columna índice de la columna
     * @return valor en la posición especificada
     */
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

    /**
     * Devuelve la clase de la columna especificada
     *
     * @param columna índice de la columna
     * @return clase de la columna
     */
    @Override
    public Class getColumnClass(int columna) {
        return getValueAt(0, columna).getClass();
    }

    /**
     * Devuelve el nombre de la columna especificada
     *
     * @param columna índice de la columna
     * @return nombre de la columna
     */
    @Override
    public String getColumnName(int columna) {
        return titulos[columna];
    }

    /**
     * Obtiene el código de municipio del destino en la fila especificada
     *
     * @param fila índice de la fila
     * @return código de municipio del destino
     */
    public int getCodigoDestinoEn(int fila) {
        String codigoVuelo = vuelosDiarios.get(fila).getCodigoVuelo();
        for (Vuelo vuelo : listaVuelo) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo.getAeropuertoOrigen().getCodigoMunicipio();
            }
        }
        return 0;
    }

    /**
     * Obtiene el código de municipio del destino en la fila especificada
     *
     * @param fila índice de la fila
     * @return código de municipio del destino
     */
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
