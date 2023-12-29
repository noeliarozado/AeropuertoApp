package com.mycompany.actividad1.logica;

import com.mycompany.actividad1.dto.Aeropuerto;
import com.mycompany.actividad1.dto.Vuelo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Noelia Rozado
 *
 * Clase que almacena la lógica relacionada con la gestión de un vuelo
 */
public class LogicaVuelo {

    private static final String RUTA_FICHERO_CSV = "vuelos.csv";
    private static final String RUTA_FICHERO_SERIALIZADO = "vuelos.ser";

    /**
     * Lista de vuelos
     */
    private List<Vuelo> listaVuelos;

    private String nombreAeropuertoActual;

    public LogicaVuelo() {
        listaVuelos = cargarCSV();
        //listaVuelos = cargarDatosSerializados();
        if (listaVuelos == null) {
            listaVuelos = new ArrayList<>();
        }
    }

    /**
     * Carga los datos desde el archivo CSV que contiene la información sobre
     * los vuelos
     *
     * @return lista de vuelos
     */
    private List<Vuelo> cargarCSV() {
        List<Vuelo> cargarVuelos = new ArrayList<>();

        List<Aeropuerto> listaAeropuerto = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("aeropuertos.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigoIATA = datos[0];
                String nombreAeropuerto = datos[1];
                int codigoMunicipio = Integer.parseInt(datos[2]);

                Aeropuerto aeropuerto = new Aeropuerto(codigoIATA, nombreAeropuerto, codigoMunicipio);
                listaAeropuerto.add(aeropuerto);
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el fichero: " + ioe.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_FICHERO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigoVuelo = datos[0];
                String codigoAeropuertoOrigen = datos[1];
                String codigoAeropuertoDestino = datos[2];
                int numeroPlazas = Integer.parseInt(datos[3]);
                String horaOficialSalida = datos[4];
                String horaOficialLlegada = datos[5];
                String dias = datos[6];

                Aeropuerto aeropuertoOrigen = null;
                Aeropuerto aeropuertoDestino = null;

                for (Aeropuerto aeropuerto : listaAeropuerto) {
                    if (aeropuerto.getCodigoIATA().equals(codigoAeropuertoOrigen)) {
                        aeropuertoOrigen = aeropuerto;
                    }
                    if (aeropuerto.getCodigoIATA().equals(codigoAeropuertoDestino)) {
                        aeropuertoDestino = aeropuerto;
                    }
                }
                Vuelo vuelo = new Vuelo(codigoVuelo, aeropuertoOrigen, aeropuertoDestino, numeroPlazas, horaOficialSalida,
                        horaOficialLlegada, dias);
                cargarVuelos.add(vuelo);
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura del fichero: " + ioe.getMessage());
        }
        return cargarVuelos;
    }

    /**
     * Guarda los datos en el archivo CSV
     */
    private void guardarCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_FICHERO_CSV))) {
            for (Vuelo vuelo : listaVuelos) {
                writer.println(formatearCSV(vuelo));
            }
        } catch (IOException ioe) {
            System.out.println("Error de escritura en el fichero: " + ioe.getMessage());
        }
    }

    /**
     * Formatea los datos de un vuelo para incluir en un archivo CSV
     *
     * @param vuelo datos del vuelo a formatear
     * @return cadena con los datos del vuelo según el formato de los archivos
     * CSV
     */
    private static String formatearCSV(Vuelo vuelo) {
        return vuelo.getCodigoVuelo() + ","
                + vuelo.getAeropuertoOrigen().getCodigoIATA() + ","
                + vuelo.getAeropuertoDestino().getCodigoIATA() + ","
                + vuelo.getNumeroPlazas() + ","
                + vuelo.getHoraOficialSalida() + ","
                + vuelo.getHoraOficialLlegada() + ","
                + vuelo.getDias();
    }

    /**
     * Carga los datos desde un archivo serializado
     *
     * @return lista de vuelos
     */
    private List<Vuelo> cargarArchivoSerializado() {
        List<Vuelo> datosCargados = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RUTA_FICHERO_SERIALIZADO))) {
            datosCargados = (List<Vuelo>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error de lectura en el archivo: " + ioe.getMessage());
        }
        if (datosCargados == null) {
            datosCargados = new ArrayList<>();
        }
        return datosCargados;
    }

    /**
     * Guarda los datos en un archivo serializado
     */
    private void guardarArchivoSerializado() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO_SERIALIZADO))) {
            outputStream.writeObject(listaVuelos);
        } catch (IOException ioe) {
            System.out.println("Error de escritura en el fichero: " + ioe.getMessage());
        }
    }

    /**
     * Obtiene la lista de vuelos
     *
     * @return lista de vuelos
     */
    public List<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    /**
     * Añade un nuevo vuelo a la lista y guarda los datos en el archivo CSV
     *
     * @param vuelo vuelo a añadir
     */
    public void anadirVuelo(Vuelo vuelo) {
        listaVuelos.add(vuelo);
        guardarCSV();
        //guardarArchivoSerializado();
    }

    /**
     * Borra un vuelo de la lista y guarda los cambios en el archivo CSV
     *
     * @param codigoVuelo código del vuelo a borrar
     */
    public void borrarVuelo(String codigoVuelo) {
        Vuelo vueloABorrar = null;
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                vueloABorrar = vuelo;
                break;
            }
        }
        if (vueloABorrar != null) {
            listaVuelos.remove(vueloABorrar);
            guardarCSV();
            // guardarArchivoSerializado();
        }
    }

    /**
     * Actualiza la información de un vuelo en el archivo CSV
     *
     * @param vueloActualizado vuelo con la información actualizada
     */
    public void actualizarVuelo(Vuelo vueloActualizado) {
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getCodigoVuelo().equals(vueloActualizado.getCodigoVuelo())) {
                vuelo.setAeropuertoOrigen(vueloActualizado.getAeropuertoOrigen());
                vuelo.setAeropuertoDestino(vueloActualizado.getAeropuertoDestino());
                vuelo.setNumeroPlazas(vueloActualizado.getNumeroPlazas());
                vuelo.setHoraOficialSalida(vueloActualizado.getHoraOficialSalida());
                vuelo.setHoraOficialLlegada(vueloActualizado.getHoraOficialLlegada());
                vuelo.setDias(vueloActualizado.getDias());
                guardarCSV();
                //guardarArchivoSerializado();
                break;
            }
        }
    }

    /**
     * Obtiene una lista de vuelos para una compañía específica
     *
     * @param codigoVuelo código de la compañía aérea
     * @return lista de vuelos para la compañía especificada
     */
    public List<Vuelo> vuelosPorCompania(String codigoVuelo) {
        List<Vuelo> vuelosCompania = new ArrayList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                vuelosCompania.add(vuelo);
            }
        }
        return vuelosCompania;
    }
}
