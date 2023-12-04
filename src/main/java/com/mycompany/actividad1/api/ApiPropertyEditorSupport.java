package com.mycompany.actividad1.api;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author noeli
 */
public class ApiPropertyEditorSupport extends PropertyEditorSupport {

    private ApiPanelPropiedades apiPanel = new ApiPanelPropiedades();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return apiPanel;
    }

    @Override
    public String getJavaInitializationString() {
        int codigoCiudad = apiPanel.getCodigoCiudad();
        String apiKey = apiPanel.getAPIKey();
        return "new com.mycompany.actividad1.api.ApiInformacion(" + codigoCiudad + ", \"" + apiKey + "\")";
    }

    @Override
    public Object getValue() {
        int codigoCiudad = apiPanel.getCodigoCiudad();
        String apiKey = apiPanel.getAPIKey();
        return new ApiInformacion(codigoCiudad, apiKey);
    }

}
