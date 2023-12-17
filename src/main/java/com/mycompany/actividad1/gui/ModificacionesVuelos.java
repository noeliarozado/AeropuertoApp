package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.Aeropuerto;
import com.mycompany.actividad1.dto.Vuelo;
import com.mycompany.actividad1.logica.LogicaAeropuerto;
import com.mycompany.actividad1.logica.LogicaVuelo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author noeli
 */
public class ModificacionesVuelos extends javax.swing.JFrame {

    private LogicaVuelo logicaVuelo = new LogicaVuelo();
    private LogicaAeropuerto logicaAeropuerto = new LogicaAeropuerto();
    private JFXPanel fxPanel;
    private JFrame frame;
    private Map<JComponent, String> contextualHelpMap;

    /**
     * Creates new form ModificacionesVuelos
     */
    public ModificacionesVuelos() {
        initComponents();

        comboVueloModificar.setBackground(Color.WHITE);
        comboAeropuertoOrigen.setBackground(Color.WHITE);
        comboAeropuertoDestino.setBackground(Color.WHITE);
        btnModificar.setBackground(new Color(186, 213, 255));

        List<Vuelo> vuelos = logicaVuelo.getListaVuelos();

        String[] codigosVuelo = new String[vuelos.size()];
        int i = 0;
        for (Vuelo vuelo : vuelos) {
            codigosVuelo[i] = vuelo.getCodigoVuelo();
            i++;
        }
        comboVueloModificar.setModel(new DefaultComboBoxModel(codigosVuelo));

        List<Aeropuerto> aeropuertos = logicaAeropuerto.getListaAeropuerto();
        Aeropuerto[] codigosAeropuerto = new Aeropuerto[aeropuertos.size()];
        for (int j = 0; j < aeropuertos.size(); j++) {
            codigosAeropuerto[j] = aeropuertos.get(j);
        }
        comboAeropuertoOrigen.setModel(new DefaultComboBoxModel(codigosAeropuerto));
        comboAeropuertoDestino.setModel(new DefaultComboBoxModel(codigosAeropuerto));

        inputPrecargado();

        setHelp();
    }

    private void setHelp() {
        fxPanel = new JFXPanel();
        frame = new JFrame("Ayuda");
        frame.setSize(new Dimension(500, 600));
        frame.add(fxPanel);

        contextualHelpMap = new HashMap<>();
        contextualHelpMap.put(comboVueloModificar, "https://noelia-2.gitbook.io/ayuda5/ayuda5/combo-codigo-de-vuelo");

        setContextualHelp(contextualHelpMap);
    }

    private void setContextualHelp(Map<JComponent, String> map) {
        for (JComponent comp : map.keySet()) {
            KeyStroke f1KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
            InputMap inputMap = comp.getInputMap(JComponent.WHEN_FOCUSED);
            ActionMap actionMap = comp.getActionMap();
            inputMap.put(f1KeyStroke, "showContextualHelp");
            actionMap.put("showContextualHelp", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String helpURL = map.get(comp);
                    openWebView(helpURL);
                }
            });
        }
    }

    private void openWebView(String url) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webEngine.load(url);
            fxPanel.setScene(new Scene(webView));
            frame.setVisible(true);
        });
    }

    private void inputPrecargado() {
        List<Vuelo> vuelos = logicaVuelo.getListaVuelos();

        String codigoSeleccionado = (String) comboVueloModificar.getSelectedItem();

        if (codigoSeleccionado != null) {
            for (Vuelo vuelo : vuelos) {
                if (vuelo.getCodigoVuelo().equals(codigoSeleccionado)) {
                    comboAeropuertoOrigen.setSelectedItem(vuelo.getAeropuertoOrigen());
                    comboAeropuertoDestino.setSelectedItem(vuelo.getAeropuertoDestino());
                    spinnerPlazas.setValue(vuelo.getNumeroPlazas());
                    inputHoraSalida.setText(vuelo.getHoraOficialSalida());
                    inputHoraLlegada.setText(String.valueOf(vuelo.getHoraOficialLlegada()));
                    inputDias.setText(vuelo.getDias());
                    break;
                }
            }
        }
    }

    private boolean validarComponente() {
        String dias = inputDias.getText();
        if (dias == null || "".equals(dias)) {
            JOptionPane.showMessageDialog(this, "Lo días que opera no puede estar vacíos.", "Error en los días que opera",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!dias.matches("[LMXJVSD]{1,7}")) {
            JOptionPane.showMessageDialog(this, "Los días que opera no cumplen los requisitos.", "Error en los días que opera.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputDias = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        comboVueloModificar = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labeldepar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboAeropuertoOrigen = new javax.swing.JComboBox<>();
        comboAeropuertoDestino = new javax.swing.JComboBox<>();
        spinnerPlazas = new javax.swing.JSpinner();
        inputHoraSalida = new javax.swing.JFormattedTextField();
        inputHoraLlegada = new javax.swing.JFormattedTextField();
        btnMenu = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuAyuda = new javax.swing.JMenu();
        menuAyudaPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 240, 248));

        jLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel.setText("Vuelo a modificar:");

        comboVueloModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVueloModificarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Datos del nuevo vuelo:");

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Días que opera:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Hora oficial de llegada:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Hora oficial de salida:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Número de plazas:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Aeropuerto destino:");
        jLabel5.setToolTipText("");

        labeldepar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labeldepar.setText("Aeropuerto origen:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("MODIFICACIÓN DE VUELOS");

        spinnerPlazas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 583, 1));

        try {
            inputHoraSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            inputHoraLlegada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homepage.png"))); // NOI18N
        btnMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel6)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel)
                            .addComponent(labeldepar)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboVueloModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputDias)
                            .addComponent(comboAeropuertoOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboAeropuertoDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerPlazas)
                            .addComponent(inputHoraSalida)
                            .addComponent(inputHoraLlegada))))
                .addGap(84, 84, 84)
                .addComponent(btnMenu)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(comboVueloModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labeldepar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboAeropuertoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spinnerPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(inputDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnMenu))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboAeropuertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        menuAyuda.setText("Ayuda");
        menuAyuda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        menuAyudaPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuAyudaPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuAyudaPrincipal.setText("Ayuda principal");
        menuAyudaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaPrincipalActionPerformed(evt);
            }
        });
        menuAyuda.add(menuAyudaPrincipal);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarComponente()) {
            String codigoVuelo = (String) comboVueloModificar.getSelectedItem();
            Aeropuerto aeropuertoOrigen = (Aeropuerto) comboAeropuertoOrigen.getSelectedItem();
            Aeropuerto aeropuertoDestino = (Aeropuerto) comboAeropuertoDestino.getSelectedItem();
            int plazas = (int) spinnerPlazas.getValue();
            String horaSalida = inputHoraSalida.getText();
            String horaLlegada = inputHoraLlegada.getText();
            String dias = inputDias.getText();
            logicaVuelo.actualizarVuelo(new Vuelo(codigoVuelo, aeropuertoOrigen, aeropuertoDestino, plazas,
                    horaSalida, horaLlegada, dias));
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void comboVueloModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVueloModificarActionPerformed
        inputPrecargado();
    }//GEN-LAST:event_comboVueloModificarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void menuAyudaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaPrincipalActionPerformed
        openWebView("https://noelia-2.gitbook.io/ayuda4/");
    }//GEN-LAST:event_menuAyudaPrincipalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionesVuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboAeropuertoDestino;
    private javax.swing.JComboBox<String> comboAeropuertoOrigen;
    private javax.swing.JComboBox<String> comboVueloModificar;
    private javax.swing.JTextField inputDias;
    private javax.swing.JFormattedTextField inputHoraLlegada;
    private javax.swing.JFormattedTextField inputHoraSalida;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labeldepar;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuItem menuAyudaPrincipal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSpinner spinnerPlazas;
    // End of variables declaration//GEN-END:variables
}
