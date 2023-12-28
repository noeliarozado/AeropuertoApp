package com.mycompany.actividad1.api;

import java.io.Serializable;

/**
 * @author Noelia Rozado
 *
 * Contiene la información que se utiliza en el editor de propiedades
 */
public class ApiInformacion implements Serializable {

    private int codigo;
    private String apiKey;

    public ApiInformacion(int codigo, String apiKey) {
        this.codigo = codigo;
        this.apiKey = apiKey;
    }

    /**
     * Obtiene el código IATA del municipio
     *
     * @return código de municipio
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Establece el código IATA del municipio
     *
     * @param codigo número entero que representa el códígo del municipio
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene la API key
     *
     * @return API key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Establece la API key
     *
     * @param apiKey string con la API key
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
