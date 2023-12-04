package com.mycompany.actividad1.api;

import java.io.Serializable;

/**
 *
 * @author noeli
 */
public class ApiInformacion implements Serializable {
    private int codigo;
    private String apiKey;

    public ApiInformacion(int codigo, String apiKey) {
        this.codigo = codigo;
        this.apiKey = apiKey;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}