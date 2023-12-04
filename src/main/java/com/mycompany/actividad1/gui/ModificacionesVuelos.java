package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.Aeropuerto;
import com.mycompany.actividad1.dto.Vuelo;
import com.mycompany.actividad1.logica.LogicaAeropuerto;
import com.mycompany.actividad1.logica.LogicaVuelo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author noeli
 */
public class ModificacionesVuelos extends javax.swing.JFrame {

    private LogicaVuelo logicaVuelo = new LogicaVuelo();
    private LogicaAeropuerto logicaAeropuerto = new LogicaAeropuerto();

    /**
     * Creates new form ModificacionesVuelos
     */
    public ModificacionesVuelos() {
        initComponents();

        List<Vuelo> vuelos = logicaVuelo.getListaVuelos();

        String[] codigosVuelo = new String[vuelos.size()];
        int i = 0;
        for (Vuelo vuelo : vuelos) {
            codigosVuelo[i] = vuelo.getCodigoVuelo();
            i++;
        }
        comboVueloModificar.setModel(new DefaultComboBoxModel(codigosVuelo));

        inputPrecargado();
    }

    private void inputPrecargado() {
        List<Vuelo> vuelos = logicaVuelo.getListaVuelos();

        String codigoSeleccionado = (String) comboVueloModificar.getSelectedItem();

        if (codigoSeleccionado != null) {
            for (Vuelo vuelo : vuelos) {
                if (vuelo.getCodigoVuelo().equals(codigoSeleccionado)) {
                    inputAeropuertoOrigen.setText(vuelo.getAeropuertoOrigen().getCodigoIATA());
                    inputAeropuertoDestino.setText(vuelo.getAeropuertoDestino().getCodigoIATA());
                    inputPlazas.setText(String.valueOf(vuelo.getNumeroPlazas()));
                    inputHoraSalida.setText(vuelo.getHoraOficialSalida());
                    inputHoraLlegada.setText(String.valueOf(vuelo.getHoraOficialLlegada()));
                    inputDias.setText(vuelo.getDias());
                    break;
                }
            }
        }
    }

    private boolean validarComponente() {
        String aeropuertoOrigen = inputAeropuertoOrigen.getText();
        if (aeropuertoOrigen == null || "".equals(aeropuertoOrigen)) {
            JOptionPane.showMessageDialog(this, "El aeropuerto origen no puede estar vacío.", "Error en el aeropuerto "
                    + "origen.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!aeropuertoOrigen.matches("[A-Z]{3}")) {
            JOptionPane.showMessageDialog(this, "El aeropuerto origen no cumple los requisitos.", "Error en el aeropuerto "
                    + "origen.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String aeropuertoDestino = inputAeropuertoDestino.getText();
        if (aeropuertoDestino == null || "".equals(aeropuertoDestino)) {
            JOptionPane.showMessageDialog(this, "El aeropuerto destino no puede estar vacío.", "Error en el aeropuerto "
                    + "destino.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!aeropuertoDestino.matches("[A-Z]{3}")) {
            JOptionPane.showMessageDialog(this, "El aeropuerto destino no cumple los requisitos.", "Error en el aeropuerto "
                    + "destino.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int plazas = Integer.parseInt(inputPlazas.getText());
        if (plazas == 0 || "".equals(plazas)) {
            JOptionPane.showMessageDialog(this, "El número de plazas no puede estar vacías.", "Error en el número de "
                    + "plazas.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (plazas <= 0 || plazas > 853) {
            JOptionPane.showMessageDialog(this, "El número de plazas no cumple con los requisitos.", "Error en el número "
                    + "de plazas.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaSalida = inputHoraSalida.getText();
        if (horaSalida == null || "".equals(horaSalida)) {
            JOptionPane.showMessageDialog(this, "La hora de salida no puede estar vacía.", "Error en la hora de salida.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!horaSalida.matches("[0-9]{2}:[0-9]{2}")) {
            JOptionPane.showMessageDialog(this, "La hora de salida no cumple con los requisitos.", "Error en la hora de "
                    + "salida.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaLlegada = inputHoraLlegada.getText();
        if (horaLlegada == null || "".equals(horaLlegada)) {
            JOptionPane.showMessageDialog(this, "La hora de llegada no puede estar vacía.", "Error en la hora de llegada.",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!horaLlegada.matches("[0-9]{2}:[0-9]{2}")) {
            JOptionPane.showMessageDialog(this, "La hora de llegada no cumple los requisitos.", "Error en la hora de "
                    + "llegada.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labeldepar = new javax.swing.JLabel();
        inputAeropuertoOrigen = new javax.swing.JTextField();
        inputAeropuertoDestino = new javax.swing.JTextField();
        inputPlazas = new javax.swing.JTextField();
        inputHoraSalida = new javax.swing.JTextField();
        inputHoraLlegada = new javax.swing.JTextField();
        inputDias = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        comboVueloModificar = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Días que opera:");

        jLabel2.setText("Hora oficial de llegada:");

        jLabel3.setText("Hora oficial de salida:");

        jLabel4.setText("Número de plazas:");

        jLabel5.setText("Aeropuerto destino:");
        jLabel5.setToolTipText("");

        labeldepar.setText("Aeropuerto origen:");

        jLabel.setText("Vuelo a modificar:");

        comboVueloModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVueloModificarActionPerformed(evt);
            }
        });

        jLabel8.setText("Datos del nuevo vuelo:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDias, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel)
                            .addComponent(labeldepar)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputAeropuertoOrigen)
                                    .addComponent(inputAeropuertoDestino)
                                    .addComponent(inputPlazas)
                                    .addComponent(comboVueloModificar, 0, 191, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(inputHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel)
                    .addComponent(comboVueloModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeldepar)
                    .addComponent(inputAeropuertoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputAeropuertoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(btnModificar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarComponente()) {
            String codigoVuelo = (String) comboVueloModificar.getSelectedItem();
            Aeropuerto aeropuertoOrigen = logicaAeropuerto.getAeropuertoPorCodigoIATA(inputAeropuertoOrigen.getText());
            Aeropuerto aeropuertoDestino = logicaAeropuerto.getAeropuertoPorCodigoIATA(inputAeropuertoDestino.getText());
            int plazas = Integer.parseInt(inputPlazas.getText());
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
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboVueloModificar;
    private javax.swing.JTextField inputAeropuertoDestino;
    private javax.swing.JTextField inputAeropuertoOrigen;
    private javax.swing.JTextField inputDias;
    private javax.swing.JTextField inputHoraLlegada;
    private javax.swing.JTextField inputHoraSalida;
    private javax.swing.JTextField inputPlazas;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labeldepar;
    // End of variables declaration//GEN-END:variables
}
