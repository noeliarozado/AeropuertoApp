package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.VueloDiario;
import com.mycompany.actividad1.logica.LogicaVueloDiario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author noeli
 */
public class ModificacionesVuelosDiarios extends javax.swing.JFrame {

        private LogicaVueloDiario logicaVueloDiario = new LogicaVueloDiario();
        
    /**
     * Creates new form ModificacionesVuelosDiarios
     */
    public ModificacionesVuelosDiarios() {
        initComponents();
        
           List<VueloDiario> vuelosDiarios = logicaVueloDiario.getListaVueloDiario();

        String[] codigosVuelo = new String[vuelosDiarios.size()];
        int i = 0;
        for (VueloDiario vueloDiario : vuelosDiarios) {
            codigosVuelo[i] = vueloDiario.getCodigoVuelo();
            i++;
        }
        comboCodigo.setModel(new DefaultComboBoxModel(codigosVuelo));

        inputPrecargado();
    }

    
      private void inputPrecargado() {
        List<VueloDiario> vuelosDiarios = logicaVueloDiario.getListaVueloDiario();

        String codigoSeleccionado = (String) comboCodigo.getSelectedItem();

        if (codigoSeleccionado != null) {
            for (VueloDiario vueloDiario : vuelosDiarios) {
                if (vueloDiario.getCodigoVuelo().equals(codigoSeleccionado)) {
                    inputFecha.setText(vueloDiario.getFecha().toString());
                    inputHoraSalida.setText(vueloDiario.getHoraSalidaReal().toString());
                    inputHoraLlegada.setText(vueloDiario.getHoraLlegadaReal().toString());
                    inputPlazasOcupadas.setText(String.valueOf(vueloDiario.getPlazasOcupadas()));
                    inputPrecioAsiento.setText(String.valueOf(vueloDiario.getPrecio()));
                    break;
                }
            }
        }
    }

    private boolean validarComponente() {
        String fecha = inputFecha.getText();
        if (fecha == null || "".equals(fecha)) {
            JOptionPane.showMessageDialog(this, "La fecha del vuelo no puede estar vacía.", 
                    "Error en la fecha.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!fecha.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            JOptionPane.showMessageDialog(this, "La fecha no cumple los requisitos.", "Error en la fecha.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaSalida = inputHoraSalida.getText();
        if (horaSalida == null || "".equals(horaSalida)) {
            JOptionPane.showMessageDialog(this, "La hora de salida no puede estar vacía.", "Error en la hora de salida.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!horaSalida.matches("[0-9]{2}:[0-9]{2}")) {
            JOptionPane.showMessageDialog(this, "La hora de salida no cumple los requisitos.", "Error en la hora de salida.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String horaLlegada = inputHoraLlegada.getText();
        if (horaLlegada == null || "".equals(horaLlegada)) {
            JOptionPane.showMessageDialog(this, "La hora de llegada no puede estar vacía.", "Error en la hora de llegada.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!horaLlegada.matches("[0-9]{2}:[0-9]{2}")) {
            JOptionPane.showMessageDialog(this, "La hora de llegada no cumple los requisitos.", "Error en la hora de llegada.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int plazasOcupadas = Integer.parseInt(inputPlazasOcupadas.getText());
        if ("".equals(plazasOcupadas)) {
            JOptionPane.showMessageDialog(this, "El número de plazas ocupadas no puede estar vacío.", "Error en el número "
                    + "de plazas ocupadas.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (plazasOcupadas <= 0 || plazasOcupadas > 853) {
            JOptionPane.showMessageDialog(this, "El número de plazas ocupadas no cumple los requisitos.", "Error en "
                    + "el número de plazas ocupadas.", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        double precioVuelo = Double.parseDouble(inputPrecioAsiento.getText());
        if ("".equals(precioVuelo)) {
            JOptionPane.showMessageDialog(this, "El precio del vuelo no puede estar vacío.", "Error en el precio del vuelo.", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (precioVuelo <= 0) {
            JOptionPane.showMessageDialog(this, "El precio del vuelo no cumple los requisitos.", "Error en el precio del "
                    + "vuelo.", JOptionPane.ERROR_MESSAGE);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputFecha = new javax.swing.JTextField();
        inputHoraSalida = new javax.swing.JTextField();
        inputHoraLlegada = new javax.swing.JTextField();
        inputPrecioAsiento = new javax.swing.JTextField();
        inputPlazasOcupadas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboCodigo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nuevos datos:");

        jLabel2.setText("Código de vuelo:");

        jLabel5.setText("Hora de llegada real:");

        jLabel7.setText("Precio del vuelo:");

        jLabel6.setText("Número de plazas ocupadas:");

        jLabel4.setText("Hora de salida real:");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel9.setText("Seleccione un vuelo:");

        jLabel10.setText("Fecha:");

        comboCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputPlazasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputHoraSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputHoraLlegada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(inputPrecioAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModificar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputPlazasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputPrecioAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarComponente()) {
            String codigoVuelo = (String) comboCodigo.getSelectedItem();
            LocalDate fecha = LocalDate.parse(inputFecha.getText());
            LocalTime horaSalida = LocalTime.parse(inputHoraSalida.getText());
            LocalTime horaLlegada = LocalTime.parse(inputHoraLlegada.getText());
            int plazasOcupadas = Integer.parseInt(inputPlazasOcupadas.getText());
            double precioVuelo = Double.parseDouble(inputPrecioAsiento.getText());

            logicaVueloDiario.actualizarVueloDiario(new VueloDiario(codigoVuelo, fecha, horaSalida, horaLlegada,
                plazasOcupadas, precioVuelo));
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void comboCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCodigoActionPerformed
        inputPrecargado();
    }//GEN-LAST:event_comboCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(ModificacionesVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificacionesVuelosDiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificacionesVuelosDiarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboCodigo;
    private javax.swing.JTextField inputFecha;
    private javax.swing.JTextField inputHoraLlegada;
    private javax.swing.JTextField inputHoraSalida;
    private javax.swing.JTextField inputPlazasOcupadas;
    private javax.swing.JTextField inputPrecioAsiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
