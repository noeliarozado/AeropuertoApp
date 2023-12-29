package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.Compania;
import com.mycompany.actividad1.logica.LogicaCompania;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * @author Noelia Rozado
 */
public class AltasCompanias extends javax.swing.JFrame {

    private LogicaCompania logicaCompanias = new LogicaCompania();

    private JFXPanel fxPanel;
    private JFrame frame;
    private Map<JComponent, String> contextualHelpMap;

    /**
     * Creates new form AltasCompanias
     */
    public AltasCompanias() {
        initComponents();

        btnRegistrar.setBackground(new Color(186, 213, 255));

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
        contextualHelpMap.put(inputPrefijo, "https://noelia-2.gitbook.io/ayuda2/pagina-principal/campo-prefijo");
        contextualHelpMap.put(btnRegistrar, "https://noelia-2.gitbook.io/ayuda2/pagina-principal/control-registrar");

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
     * Valida los componentes antes de registrar una compañía aérea
     *
     * @return true si los datos son válidos y false si no lo son
     */
    private boolean validarComponente() {
        String prefijo = inputPrefijo.getText();
        if (prefijo == null || "".equals(prefijo)) {
            JOptionPane.showMessageDialog(this, "El prefijo no puede estar vacío.", "Error en el prefijo.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(prefijo) <= 0 || Integer.parseInt(prefijo) > 999) {
            JOptionPane.showMessageDialog(this, "El prefijo tiene que ser un número entre 1 y 999", "Error en el prefijo.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String codigo = inputCodigo.getText();
        if (codigo == null || "".equals(codigo)) {
            JOptionPane.showMessageDialog(this, "El código no puede estar vacío.", "Error en el código.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!codigo.matches("[A-Z]{2}|[A-Z][0-9]")) {
            JOptionPane.showMessageDialog(this, "El código no cumple los requisitos.", "Error en el código.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String direccion = inputDireccion.getText();
        if (direccion == null || "".equals(direccion)) {
            JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía.", "Error en la dirección",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String municipio = inputMunicipio.getText();
        if (municipio == null || "".equals(municipio)) {
            JOptionPane.showMessageDialog(this, "El municipio no puede estar vacío.", "Error en el municipio.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String telefonoPasajero = inputTelefonoPasajero.getText();
        if (telefonoPasajero == null || "".equals(telefonoPasajero)) {
            JOptionPane.showMessageDialog(this, "El teléfono de información al pasajero no puede estar vacío.", "Error "
                    + "en el teléfono de información al pasajero.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!telefonoPasajero.matches("\\d{3}\\d{1,12}")) {
            JOptionPane.showMessageDialog(this, "El teléfono de atención al pasajero no cumple los requisitos.",
                    "Error en el teléfono de atención al pasajero.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String telefonoAeropuerto = inputTelefonoAeropuerto.getText();
        if (telefonoAeropuerto == null || "".equals(telefonoAeropuerto)) {
            JOptionPane.showMessageDialog(this, "El teléfono de atención a aeropuertos no puede estar vacío.",
                    "Error en el teléfono de atención a aeropuertos.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!telefonoAeropuerto.matches("\\d{3}\\d{1,12}")) {
            JOptionPane.showMessageDialog(this, "El teléfono de atención a aeropuertos no puede estar vacío.",
                    "Error en el teléfono de atención a aeropuertos.", JOptionPane.ERROR_MESSAGE);
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
        btnMenu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inputNombreCompania = new javax.swing.JTextField();
        inputDireccion = new javax.swing.JTextField();
        inputMunicipio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputTelefonoPasajero = new javax.swing.JTextField();
        inputTelefonoAeropuerto = new javax.swing.JTextField();
        inputCodigo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        inputPrefijo = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuAyuda = new javax.swing.JMenu();
        menuAyudaPrincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(214, 240, 248));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homepage.png"))); // NOI18N
        btnMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Teléfono de información al pasajero:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Teléfono de información a aeropuertos:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("ALTA DE COMPAÑÍAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre de la compañía:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Municipio:");

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Prefijo:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputTelefonoAeropuerto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(37, 37, 37)
                                .addComponent(inputTelefonoPasajero))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(inputMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(inputNombreCompania))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputCodigo)
                                    .addComponent(inputPrefijo, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(10, 10, 10)))
                .addGap(46, 46, 46)
                .addComponent(btnMenu)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(inputPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(inputNombreCompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(inputMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTelefonoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(inputTelefonoAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar)
                            .addComponent(btnMenu))))
                .addGap(35, 35, 35))
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

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarComponente()) {
            int prefijo = Integer.parseInt(inputPrefijo.getText());
            String codigo = inputCodigo.getText();
            String nombreCompania = inputNombreCompania.getText();
            String direccion = inputDireccion.getText();
            String municipio = inputMunicipio.getText();
            String telefonoPasajero = inputTelefonoPasajero.getText();
            String telefonoAeropuerto = inputTelefonoAeropuerto.getText();

            logicaCompanias.anadirCompania(new Compania(prefijo, codigo, nombreCompania, direccion, municipio, telefonoPasajero,
                    telefonoAeropuerto));
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void menuAyudaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaPrincipalActionPerformed
        openWebView("https://noelia-2.gitbook.io/ayuda2/");
    }//GEN-LAST:event_menuAyudaPrincipalActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        CompaniasPanelCRUD companiasPanelCRUD = new CompaniasPanelCRUD();
        companiasPanelCRUD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting codigo (optional) ">
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
            java.util.logging.Logger.getLogger(AltasCompanias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltasCompanias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltasCompanias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltasCompanias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltasCompanias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField inputCodigo;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputMunicipio;
    private javax.swing.JTextField inputNombreCompania;
    private javax.swing.JTextField inputPrefijo;
    private javax.swing.JTextField inputTelefonoAeropuerto;
    private javax.swing.JTextField inputTelefonoPasajero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuItem menuAyudaPrincipal;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
