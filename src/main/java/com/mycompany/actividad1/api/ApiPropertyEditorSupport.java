package com.mycompany.actividad1.api;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 * @author Noelia Rozado
 *
 * Implementa el editor de propiedades
 */
public class ApiPropertyEditorSupport extends PropertyEditorSupport {

    private ApiPanelPropiedades apiPanel = new ApiPanelPropiedades();

    /**
     * Indica si el editor de propiedades admite un editor personalizado.
     *
     * @return true si admite un editor personalizado y false si no lo admite
     */
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    /**
     * Obtiene el componente que se utilizará como editor personalizado
     *
     * @return componente que actuará como editor personalizado.
     */
    @Override
    public Component getCustomEditor() {
        return apiPanel;
    }

    /**
     * Obtiene una cadena de inicialización que representa el valor actual de la
     * propiedad
     *
     * @return cadena de inicialización para el valor de la propiedad
     */
    @Override
    public String getJavaInitializationString() {
        int codigoCiudad = apiPanel.getCodigoCiudad();
        String apiKey = apiPanel.getAPIKey();
        return "new com.mycompany.actividad1.api.ApiInformacion(" + codigoCiudad + ", \"" + apiKey + "\")";
    }

    /**
     * Obtiene el valor actual de la propiedad
     *
     * @return valor actual de la propiedad
     */
    @Override
    public Object getValue() {
        int codigoCiudad = apiPanel.getCodigoCiudad();
        String apiKey = apiPanel.getAPIKey();
        return new ApiInformacion(codigoCiudad, apiKey);
    }

}
