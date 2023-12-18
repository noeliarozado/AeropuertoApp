package com.mycompany.actividad1.logica;

import com.mycompany.actividad1.dto.Vuelo;
import com.mycompany.actividad1.dto.VueloDiario;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author noeli
 */
public class LogicaVueloDiario {

    private static final String RUTA_ARCHIVO_CSV = "vuelosDiarios.csv";
    private static final String RUTA_ARCHIVO_SERIALIZADO = "vuelosDiarios.ser";
    private static final String RUTA_ARCHIVO_AEROPUERTO = "codigoAeropuerto.csv";

    private String nombreAeropuerto;

    private List<VueloDiario> listaVuelosDiarios;

    LogicaVuelo logicaVuelos = new LogicaVuelo();

    LogicaAeropuerto logicaAeropuerto = new LogicaAeropuerto();

    public LogicaVueloDiario() {
        listaVuelosDiarios = cargarCSV();
        //listaVuelosDiarios = cargarArchivoSerializado();
        if (listaVuelosDiarios == null) {
            listaVuelosDiarios = new ArrayList<>();
        }
    }

    private List<VueloDiario> cargarCSV() {
        List<VueloDiario> datosCargados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_CSV))) {
            String linea;

            DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("H:m");

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigoVuelo = datos[0];
                LocalDate fecha = LocalDate.parse(datos[1], fechaFormateada);
                LocalTime horaSalida = LocalTime.parse(datos[2], horaFormateada);
                LocalTime horaLlegada = LocalTime.parse(datos[3], horaFormateada);
                int plazasOcupadas = Integer.parseInt(datos[4]);
                double preciovuelo = Double.parseDouble(datos[5]);

                VueloDiario vueloDiario = new VueloDiario(codigoVuelo, fecha, horaSalida, horaLlegada, plazasOcupadas,
                        preciovuelo);
                datosCargados.add(vueloDiario);
            }
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el archivo: " + ioe.getMessage());
        }
        try {
            nombreAeropuerto = Files.readString(Path.of(RUTA_ARCHIVO_AEROPUERTO));
        } catch (IOException ioe) {
            System.out.println("Error de lectura en el fichero: " + ioe.getMessage());
        }
        return datosCargados;
    }

    private void guardarCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO_CSV))) {
            for (VueloDiario vueloDiario : listaVuelosDiarios) {
                writer.println(formatearCSV(vueloDiario));
            }
        } catch (IOException e) {
            System.out.println("Error de escritura en el fichero " + e.getMessage());
        }
    }

    private String formatearCSV(VueloDiario vueloDiario) {
        String fechaFormateada = vueloDiario.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return vueloDiario.getCodigoVuelo() + ","
                + fechaFormateada + ","
                + vueloDiario.getHoraSalidaReal() + ","
                + vueloDiario.getHoraLlegadaReal() + ","
                + vueloDiario.getPlazasOcupadas() + ","
                + vueloDiario.getPrecio();
    }

    private List<VueloDiario> cargarArchivoSerializado() {
        List<VueloDiario> datosCargados = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO_SERIALIZADO))) {
            datosCargados = (List<VueloDiario>) inputStream.readObject();
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        }
        return datosCargados;
    }

    private void guardarArchivoSerializado() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO_SERIALIZADO))) {
            outputStream.writeObject(listaVuelosDiarios);
        } catch (IOException e) {
            System.out.println("Error de escritura en el archivo: " + e.getMessage());
        }
    }

    public List<VueloDiario> getListaVueloDiario() {
        return listaVuelosDiarios;
    }

    public void anadirVueloDiario(VueloDiario vuelosDiarios) {
        listaVuelosDiarios.add(vuelosDiarios);
        guardarCSV();
        // guardarArchivoSerializado();
    }

    public void borrarVueloDiario(String codigoVuelo) {
        listaVuelosDiarios.removeIf(vuelosDiarios
                -> vuelosDiarios.getCodigoVuelo().equals(codigoVuelo));
        guardarCSV();
        //guardarArchivoSerializado();
    }

    public void actualizarVueloDiario(VueloDiario vueloDiarioActualizado) {
        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            if (vueloDiario.getCodigoVuelo().equals(vueloDiarioActualizado.getCodigoVuelo())) {
                vueloDiario.setFecha(vueloDiarioActualizado.getFecha());
                vueloDiario.setHoraSalidaReal(vueloDiarioActualizado.getHoraSalidaReal());
                vueloDiario.setHoraLlegadaReal(vueloDiarioActualizado.getHoraLlegadaReal());
                vueloDiario.setPlazasOcupadas(vueloDiarioActualizado.getPlazasOcupadas());
                vueloDiario.setPrecio(vueloDiarioActualizado.getPrecio());
                guardarCSV();
                // guardarArchivoSerializado();
                return;
            }
        }
        System.out.println("Vuelo no encontrado para el código: " + vueloDiarioActualizado.getCodigoVuelo());
    }

    public List ordenarVuelosSalida(LocalDate fecha) {
        List<VueloDiario> vuelosCompania = new ArrayList<>();

        List<Vuelo> vuelos = logicaVuelos.getListaVuelos();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            for (Vuelo vuelo : vuelos) {
                if (vueloDiario.getCodigoVuelo().equals(vuelo.getCodigoVuelo()) && vueloDiario.getFecha().equals(fecha)
                        && vuelo.getAeropuertoOrigen().getCodigoIATA().equals(nombreAeropuerto)) {
                    vuelosCompania.add(vueloDiario);
                }
            }
        }
        Collections.sort(vuelosCompania, Comparator.comparing(VueloDiario::getHoraSalidaReal));

        return vuelosCompania;
    }

    public List ordenarVuelosLlegada(LocalDate fecha) {
        List<VueloDiario> vuelosCompania = new ArrayList<>();

        List<Vuelo> vuelos = logicaVuelos.getListaVuelos();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            for (Vuelo vuelo : vuelos) {
                if (vueloDiario.getCodigoVuelo().equals(vuelo.getCodigoVuelo()) && vueloDiario.getFecha().equals(fecha)
                        && vuelo.getAeropuertoDestino().getCodigoIATA().equals(nombreAeropuerto)) {
                    vuelosCompania.add(vueloDiario);
                }
            }
        }
        Collections.sort(vuelosCompania, Comparator.comparing(VueloDiario::getHoraSalidaReal));

        return vuelosCompania;
    }

    public List<VueloDiario> mostrarSalidasEnFecha(LocalDate fecha) {
        List<VueloDiario> salidas = new ArrayList<>();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            if (vueloDiario.getFecha().equals(fecha)) {
                salidas.add(vueloDiario);
            }
        }
        Collections.sort(salidas, Comparator.comparing(VueloDiario::getHoraSalidaReal));

        return salidas;
    }

    public List<VueloDiario> mostrarLlegasEnFecha(Date fecha) {
        List<VueloDiario> llegadas = new ArrayList<>();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            if (vueloDiario.getFecha().equals(fecha)) {
                llegadas.add(vueloDiario);
            }
        }
        Collections.sort(llegadas, Comparator.comparing(VueloDiario::getHoraLlegadaReal));

        return llegadas;
    }

    public List<VueloDiario> vuelosPorCompaniaEnFecha(String codigoVuelo, LocalDate fecha) {
        List<VueloDiario> vuelosCompanias = new ArrayList<>();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            if (vueloDiario.getCodigoVuelo().equals(codigoVuelo) && vueloDiario.getFecha().equals(fecha)) {
                vuelosCompanias.add(vueloDiario);
            }
        }
        return vuelosCompanias;
    }

    public List<VueloDiario> mostrarDiasCompania(String inicialesCodigo, LocalDate fecha) {
        List<VueloDiario> vuelosCompania = new ArrayList<>();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            if (vueloDiario.getCodigoVuelo().startsWith(inicialesCodigo) && vueloDiario.getFecha().equals(fecha)) {
                vuelosCompania.add(vueloDiario);
            }
        }
        return vuelosCompania;
    }

    public List ordenarDestinos(String codigoAeropuertoDestino) {
        List<VueloDiario> vuelosCompania = new ArrayList<>();

        List<Vuelo> vuelos = logicaVuelos.getListaVuelos();

        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            for (Vuelo vuelo : vuelos) {
                if (vueloDiario.getCodigoVuelo().equals(vuelo.getCodigoVuelo())
                        && vueloDiario.getFecha().isBefore(LocalDate.now().plusDays(8))
                        && vueloDiario.getFecha().isAfter(LocalDate.now())
                        && vuelo.getAeropuertoDestino().getCodigoIATA().equals(codigoAeropuertoDestino)) {
                    vuelosCompania.add(vueloDiario);
                }
            }
        }
        Collections.sort(vuelosCompania, Comparator
                .comparing(VueloDiario::getFecha)
                .thenComparing(VueloDiario::getHoraSalidaReal));

        return vuelosCompania;
    }

    public double recaudacionesDiarias(LocalDate fecha) {
        double recaudaciones = 0;
        for (VueloDiario vueloDiario : listaVuelosDiarios) {
            boolean fechaBusqueda = vueloDiario.getFecha().equals(fecha);
            boolean esHoy = vueloDiario.getFecha().equals(LocalDate.now());
            boolean haSalido = vueloDiario.getHoraSalidaReal().isBefore(LocalTime.now());
            /*if ((vueloDiario.getFecha().equals(fecha) && vueloDiario.getFecha().equals(LocalDate.now())
                    && vueloDiario.getHoraSalidaReal().isBefore(LocalTime.now()))
                    || (vueloDiario.getFecha().equals(fecha) && !vueloDiario.getFecha().equals(LocalDate.now()))) {
                recaudaciones += vueloDiario.getPrecio() * vueloDiario.getPlazasOcupadas();
            }*/
            if (fechaBusqueda && (haSalido || !esHoy)) {
                recaudaciones += vueloDiario.getPrecio() * vueloDiario.getPlazasOcupadas();
            }
        }
        return recaudaciones;
    }

}
