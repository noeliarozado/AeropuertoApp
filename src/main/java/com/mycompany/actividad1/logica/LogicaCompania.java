package com.mycompany.actividad1.logica;

import com.mycompany.actividad1.dto.Compania;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Noelia Rozado
 *
 * Clase que almacena la lógica relacionada con la gestión de una compañía aérea
 */
public class LogicaCompania {

    private static final String RUTA_ARCHIVO_CSV = "companias.csv";
    private static final String RUTA_ARCHIVO_SERIALIZADO = "companias.ser";

    /**
     * Lista de compañías aereas
     */
    private List<Compania> listaCompanias;

    public LogicaCompania() {
        //listaCompanias = cargarArchivoSerializado();
        listaCompanias = cargarCSV();
        if (listaCompanias == null) {
            listaCompanias = new ArrayList<>();
        }
    }

    /**
     * Carga los datos desde el archivo CSV que contiene la información sobre
     * las compañías aéreas
     *
     * @return lista de compañías aéreas
     */
    private List<Compania> cargarCSV() {
        List<Compania> companiasCargadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int prefijo = Integer.parseInt(datos[0]);
                String codigo = datos[1];
                String nombreCompania = datos[2];
                String direccion = datos[3];
                String municipio = datos[4];
                String telefonoPasajero = datos[5];
                String telefonoAeropuerto = datos[6];

                Compania compania = new Compania(prefijo, codigo, nombreCompania, direccion, municipio, telefonoPasajero,
                        telefonoAeropuerto);
                companiasCargadas.add(compania);
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el fichero: " + ioe.getMessage());
        }
        return companiasCargadas;
    }

    /**
     * Guarda los datos en el archivo CSV
     */
    private void guardarCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO_CSV))) {
            for (Compania compania : listaCompanias) {
                writer.println(formatearCSV(compania));
            }
        } catch (IOException ioe) {
            System.out.println("Error de escritura en el fichero: " + ioe.getMessage());
        }
    }

    /**
     * Formatea los datos de una compañía aérea para incluir en un archivo CSV
     *
     * @param compania datos de la compañía a formatear
     * @return cadena con los datos de la compañía según el formato de los
     * archivos CSV
     */
    private String formatearCSV(Compania compania) {
        return compania.getPrefijo() + ","
                + compania.getCodigo() + ","
                + compania.getNombreCompania() + ","
                + compania.getDireccion() + ","
                + compania.getMunicipio() + ","
                + compania.getTelefonoPasajero() + ","
                + compania.getTelefonoAeropuerto();
    }

    /**
     * Carga los datos desde un archivo serializado
     *
     * @return lista de compañías aéreas
     */
    private List<Compania> cargarArchivoSerializado() {
        List<Compania> datosCargados = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO_SERIALIZADO))) {
            datosCargados = (List<Compania>) inputStream.readObject();
        } catch (IOException ioe) {
            System.out.println("Error al leer el fichero: " + ioe.getMessage());
        } catch (ClassNotFoundException ioe) {
            System.out.println("Clase no encontrada: " + ioe.getMessage());
        }
        return datosCargados;
    }

    /**
     * Guarda los datos en un archivo serializado
     */
    private void guardarArchivoSerializado() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_SERIALIZADO))) {
            outputStream.writeObject(listaCompanias);
        } catch (IOException ioe) {
            System.out.println("Error al escribir en el fichero " + ioe.getMessage());
        }
    }

    /**
     * Obtiene la lista de compañías aéreas
     *
     * @return lista de compañías
     */
    public List<Compania> getListaCompanias() {
        return listaCompanias;
    }

    /**
     * Añade una nueva compañía aérea a la lista y guarda los datos en el
     * archivo CSV
     *
     * @param compania compañía a añadir
     */
    public void anadirCompania(Compania compania) {
        listaCompanias.add(compania);
        guardarCSV();
        //guardarArchivoSerializado();
    }

    /**
     * Borra una compañía aérea de la lista y guarda los cambios en el archivo
     * CSV
     *
     * @param prefijo prefijo de la compañía a borrar
     */
    public void borrarCompania(int prefijo) {
        Compania companiaBorrar = null;
        for (Compania compania : listaCompanias) {
            if (compania.getPrefijo() == prefijo) {
                companiaBorrar = compania;
                break;
            }
        }
        if (companiaBorrar != null) {
            listaCompanias.remove(companiaBorrar);
            guardarCSV();
            //guardarArchivoSerializado();
        }
    }

    /**
     * Actualiza la información de una compañía aérea en el archivo CSV
     *
     * @param companiaActualizada compañía con la información actualizada
     */
    public void actualizarCompania(Compania companiaActualizada) {
        for (Compania compania : listaCompanias) {
            if (compania.getPrefijo() == companiaActualizada.getPrefijo()) {
                compania.setCodigo(companiaActualizada.getCodigo());
                compania.setNombreCompania(companiaActualizada.getNombreCompania());
                compania.setDireccion(companiaActualizada.getDireccion());
                compania.setMunicipio(companiaActualizada.getMunicipio());
                compania.setTelefonoPasajero(companiaActualizada.getTelefonoPasajero());
                compania.setTelefonoAeropuerto(companiaActualizada.getTelefonoAeropuerto());
                guardarCSV();
                //guardarArchivoSerializado();
                break;
            }
        }
    }

}
