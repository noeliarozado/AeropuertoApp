package com.mycompany.actividad1.logica;

import com.mycompany.actividad1.dto.Aeropuerto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noeli
 */
public class LogicaAeropuerto {
    private static final String RUTA_ARCHIVO_CSV = "aeropuertos.csv";
    private static final String RUTA_ARCHIVO_AEROPUERTO = "codigoAeropuerto.csv";

    private List<Aeropuerto> listaAeropuerto;

    private String codigoIATAAeropuerto;

    public LogicaAeropuerto() {
        listaAeropuerto = cargarCSV();
        cargarCodigoAeropuerto();
        if (listaAeropuerto == null) {
            listaAeropuerto = new ArrayList<>();
        }
    }

    private List<Aeropuerto> cargarCSV() {
        List<Aeropuerto> companiasCargadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigoIATA = datos[0];
                String nombreCiudad = datos[1];
                int codigoMunicipio = Integer.parseInt(datos[2]);

                Aeropuerto aeropuerto = new Aeropuerto(codigoIATA, nombreCiudad, codigoMunicipio);
                companiasCargadas.add(aeropuerto);
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el fichero: " + ioe.getMessage());
        }
        return companiasCargadas;
    }

    public void cargarCodigoAeropuerto() {
        try {
            codigoIATAAeropuerto = Files.readString(Path.of(RUTA_ARCHIVO_AEROPUERTO));
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el archivo: " + ioe.getMessage());
        }
    }

    public Aeropuerto getAeropuertoPorCodigoIATA(String codigoIATA) {
        for (Aeropuerto aeropuerto : listaAeropuerto) {
            if (aeropuerto.getCodigoIATA().equals(codigoIATA)) {
                return aeropuerto;
            }
        }
        return null;
    }

    public Aeropuerto getAeropuertoPorCodigoMunicipio(int codigoMunicipio) {
        for (Aeropuerto aeropuerto : listaAeropuerto) {
            if (aeropuerto.getCodigoMunicipio() == codigoMunicipio) {
                return aeropuerto;
            }
        }
        return null;
    }

    public List<Aeropuerto> getListaAeropuerto() {
        return listaAeropuerto;
    }

    public Aeropuerto getAeropuertoActual() {
        Aeropuerto aeropuertoActual = getAeropuertoPorCodigoIATA(codigoIATAAeropuerto);
        return aeropuertoActual;
    }

}
