package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.Vuelo;
import com.mycompany.actividad1.dto.VueloDiario;
import com.mycompany.actividad1.logica.LogicaVuelo;
import com.mycompany.actividad1.logica.LogicaVueloDiario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
 * @author Noelia Rozado
 */
public class AltasVuelosDiarios extends javax.swing.JFrame {

    private LogicaVueloDiario logicaVueloDiario = new LogicaVueloDiario();
    private LogicaVuelo logicaVuelo = new LogicaVuelo();

    private JFXPanel fxPanel;
    private JFrame frame;
    private Map<JComponent, String> contextualHelpMap;

    /**
     * Creates new form AltaVuelosDiarios
     */
    public AltasVuelosDiarios() {
        initComponents();

        comboVueloDiario.setBackground(Color.WHITE);
        btnRegistrar.setBackground(new Color(186, 213, 255));

        List<Vuelo> vuelos = logicaVuelo.getListaVuelos();
        comboVueloDiario.setModel(new DefaultComboBoxModel(vuelos.toArray()));

        setHelp();
    }

    /**
     * Muestra la ayuda principal
     */
    private void setHelp() {
        fxPanel = new JFXPanel();
        frame = new JFrame("Ayuda");
        frame.setSize(new Dimension(500, 600));
        frame.add(fxPanel);

        contextualHelpMap = new HashMap<>();
        contextualHelpMap.put(comboVueloDiario, "https://noelia-2.gitbook.io/ayuda6/ayuda6/combo-codigo-de-vuelo");
        contextualHelpMap.put(spinnerPlazas, "https://noelia-2.gitbook.io/ayuda6/ayuda6/spinner-numero-de-plazas-ocupadas");
        contextualHelpMap.put(btnRegistrar, "https://noelia-2.gitbook.io/ayuda6/ayuda6/control-registrar");

        setContextualHelp(contextualHelpMap);
    }

    /**
     * Asigna la ayuda contextual
     */
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

    /**
     * Abre una ventana que muestra la ayuda
     *
     * @param url URL de la página de ayuda
     */
    private void openWebView(String url) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webEngine.load(url);
            fxPanel.setScene(new Scene(webView));
            frame.setVisible(true);
        });
    }

    /**
     * Valida los componentes antes de registrar un vuelo diario
     *
     * @return true si los datos son válidos y false si no lo son
     */
    private boolean validarComponente() {
        String fecha = inputFecha.getText();
        if (fecha == null || "".equals(fecha)) {
            JOptionPane.showMessageDialog(this, "La fecha del vuelo no puede estar vacía.", "Error en la fecha del vuelo.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaSalida = inputHoraSalida.getText();
        if (horaSalida == null || "".equals(horaSalida)) {
            JOptionPane.showMessageDialog(this, "La hora de salida no puede estar vacía.", "Error en la hora de salida.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaLlegada = inputHoraLlegada.getText();
        if (horaLlegada == null || "".equals(horaLlegada)) {
            JOptionPane.showMessageDialog(this, "La hora de llegada no puede estar vacía.", "Error en la hora de llegada.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        double preciovuelo = Double.parseDouble(inputPrecioVuelo.getText());
        if ("".equals(preciovuelo)) {
            JOptionPane.showMessageDialog(this, "El precio del vuelo no puede estar vacío.", "Error en el precio del vuelo",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (preciovuelo <= 0) {
            JOptionPane.showMessageDialog(this, "El precio del vuelo no cumple los requisitos.", "Error en el precio del vuelo.",
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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputFecha = new javax.swing.JFormattedTextField();
        inputPrecioVuelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputHoraSalida = new javax.swing.JFormattedTextField();
        inputHoraLlegada = new javax.swing.JFormattedTextField();
        spinnerPlazas = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        comboVueloDiario = new javax.swing.JComboBox<>();
        btnVolver = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuAyuda = new javax.swing.JMenu();
        menuAyudaPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(214, 240, 248));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Precio del vuelo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código de vuelo:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Fecha del vuelo:");
        jLabel10.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Hora de salida real:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Hora de llegada real:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Número de plazas ocupadas:");

        try {
            inputFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("ALTA DE VUELOS DIARIOS");

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

        spinnerPlazas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 583, 1));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homepage.png"))); // NOI18N
        btnMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flechaatras.png"))); // NOI18N
        btnVolver.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputHoraLlegada))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerPlazas)
                                    .addComponent(inputPrecioVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboVueloDiario, 0, 227, Short.MAX_VALUE)
                                    .addComponent(inputFecha)
                                    .addComponent(inputHoraSalida)))))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboVueloDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(inputHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spinnerPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(inputPrecioVuelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu))
                        .addGap(32, 32, 32))))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarComponente()) {
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/M/yyyy");
            Vuelo selectedVuelo = (Vuelo) comboVueloDiario.getSelectedItem();
            String codigoVuelo = selectedVuelo.getCodigoVuelo();
            LocalDate fecha = LocalDate.parse(inputFecha.getText(), formatterDate);
            LocalTime horaSalida = LocalTime.parse(inputHoraSalida.getText());
            LocalTime horaLlegada = LocalTime.parse(inputHoraLlegada.getText());
            int plazasOcupadas = (int) spinnerPlazas.getValue();
            double preciovuelo = Double.parseDouble(inputPrecioVuelo.getText());

            logicaVueloDiario.anadirVueloDiario(new VueloDiario(codigoVuelo, fecha, horaSalida, horaLlegada,
                    plazasOcupadas, preciovuelo));
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void menuAyudaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaPrincipalActionPerformed
        openWebView("https://noelia-2.gitbook.io/ayuda6/");
    }//GEN-LAST:event_menuAyudaPrincipalActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        VuelosDiariosPanelCRUD vuelosDiariosPanelCRUD = new VuelosDiariosPanelCRUD();
        vuelosDiariosPanelCRUD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(AltasVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltasVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltasVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltasVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltasVuelosDiarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboVueloDiario;
    private javax.swing.JFormattedTextField inputFecha;
    private javax.swing.JFormattedTextField inputHoraLlegada;
    private javax.swing.JFormattedTextField inputHoraSalida;
    private javax.swing.JTextField inputPrecioVuelo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuItem menuAyudaPrincipal;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSpinner spinnerPlazas;
    // End of variables declaration//GEN-END:variables
}
