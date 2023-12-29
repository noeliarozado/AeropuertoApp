package com.mycompany.actividad1.gui;

import com.mycompany.actividad1.dto.Aeropuerto;
import com.mycompany.actividad1.dto.VueloTableModel;
import com.mycompany.actividad1.dto.VueloDiario;
import com.mycompany.actividad1.dto.Vuelo;
import com.mycompany.actividad1.logica.LogicaAeropuerto;
import com.mycompany.actividad1.logica.LogicaVueloDiario;
import com.mycompany.actividad1.logica.LogicaVuelo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author Noelia Rozado
 */
public class ConsultasVuelosSieteDias extends javax.swing.JFrame {

    private LogicaVuelo logicaVuelos = new LogicaVuelo();
    private LogicaVueloDiario logicaVuelosDiarios = new LogicaVueloDiario();
    private LogicaAeropuerto logicaAeropuerto = new LogicaAeropuerto();

    /**
     * Creates new form ConsultasVuelosSieteDias
     */
    public ConsultasVuelosSieteDias() {
        initComponents();

        comboDestinos.setBackground(new Color(186, 213, 255));

        actualizarTabla(LocalDate.now());

        Aeropuerto miAeropuerto = logicaAeropuerto.getAeropuertoActual();
        apiTemperaturasMiAeropuerto.cambiarCiudad(miAeropuerto.getCodigoMunicipio());

        List<Vuelo> vuelos = logicaVuelos.getListaVuelos();
        List<String> destinos = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            if (!destinos.contains(vuelo.getAeropuertoDestino().getCodigoIATA())) {
                destinos.add(vuelo.getAeropuertoDestino().getCodigoIATA());
            }
            comboDestinos.setModel(new DefaultComboBoxModel(destinos.toArray()));
        }

        formatearEncabezadoTabla();

        formatearTabla();
    }

        /**
     * Actualiza la tabla con los vuelos para los próximos siete días
     *
     * @param date fecha actual
     */
    private void actualizarTabla(LocalDate fecha) {

        List<VueloDiario> vuelosDiarios = logicaVuelosDiarios.ordenarDestinos((String) comboDestinos.getSelectedItem());

        List<Vuelo> listaVuelos = logicaVuelos.getListaVuelos();

        VueloTableModel dataModel = new VueloTableModel(vuelosDiarios, listaVuelos);

        tblDestinos.setModel(dataModel);
    }

        /**
     * Formatea el encabezado de la tabla
     */
    private void formatearEncabezadoTabla() {
        JTableHeader encabezado = tblDestinos.getTableHeader();

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                c.setBackground(new Color(210, 230, 255));
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("Segoe UI", Font.BOLD, 13));
                return c;
            }
        };

        encabezado.setDefaultRenderer(headerRenderer);
    }

        /**
     * Formatea la apariencia de la tabla
     */
    private void formatearTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int[] columnasCentradas = {0, 1, 2, 3, 4, 5};

        for (int columnIndex : columnasCentradas) {
            tblDestinos.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        TableColumnModel columnModel = tblDestinos.getColumnModel();

        int indiceColumnaCodigo = 0;
        TableColumn columnaCodigo = columnModel.getColumn(indiceColumnaCodigo);
        columnaCodigo.setPreferredWidth(80);

        int indiceColumnaFecha = 1;
        TableColumn columnaFecha = columnModel.getColumn(indiceColumnaFecha);
        columnaFecha.setPreferredWidth(60);

        int indiceColumnaHoraSalida = 2;
        TableColumn columnaHoraSalida = columnModel.getColumn(indiceColumnaHoraSalida);
        columnaHoraSalida.setPreferredWidth(90);

        int indiceColumnaHoraLlegada = 3;
        TableColumn columnaHoraLlegada = columnModel.getColumn(indiceColumnaHoraLlegada);
        columnaHoraLlegada.setPreferredWidth(90);

        int indiceColumnaAeropuertoOrigen = 4;
        TableColumn columnaAeropuertoOrigen = columnModel.getColumn(indiceColumnaAeropuertoOrigen);
        columnaAeropuertoOrigen.setPreferredWidth(120);

        int indiceColumnaAeropuertoDestino = 5;
        TableColumn columnaAeropuertoDestino = columnModel.getColumn(indiceColumnaAeropuertoDestino);
        columnaAeropuertoDestino.setPreferredWidth(120);
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
        jLabel1 = new javax.swing.JLabel();
        comboDestinos = new javax.swing.JComboBox<>();
        apiTemperaturasMiAeropuerto = new com.mycompany.actividad1.api.ApiTemperaturas();
        apiTemperaturasOtroAeropuerto = new com.mycompany.actividad1.api.ApiTemperaturas();
        jscroll = new javax.swing.JScrollPane();
        tblDestinos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(214, 240, 248));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Escoja un destino:");

        comboDestinos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDestinosActionPerformed(evt);
            }
        });

        apiTemperaturasMiAeropuerto.setApiInformacion(new com.mycompany.actividad1.api.ApiInformacion(33044, "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvY2Vhbm95dGllcnJhQGdtYWlsLmNvbSIsImp0aSI6IjAwNzI2NzZkLTU4ZDctNDgzMC1iOTA5LWM2OGYxNDkxNTQyZCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjk5MjgxNjg4LCJ1c2VySWQiOiIwMDcyNjc2ZC01OGQ3LTQ4MzAtYjkwOS1jNjhmMTQ5MTU0MmQiLCJyb2xlIjoiIn0.rFtCYDSZY8jRcXPtaQPXaBFhDEubJ3tNP3sKxZEsSX0"));

        apiTemperaturasOtroAeropuerto.setApiInformacion(new com.mycompany.actividad1.api.ApiInformacion(33044, "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvY2Vhbm95dGllcnJhQGdtYWlsLmNvbSIsImp0aSI6IjAwNzI2NzZkLTU4ZDctNDgzMC1iOTA5LWM2OGYxNDkxNTQyZCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjk5MjgxNjg4LCJ1c2VySWQiOiIwMDcyNjc2ZC01OGQ3LTQ4MzAtYjkwOS1jNjhmMTQ5MTU0MmQiLCJyb2xlIjoiIn0.rFtCYDSZY8jRcXPtaQPXaBFhDEubJ3tNP3sKxZEsSX0"));

        tblDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDestinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDestinosMousePressed(evt);
            }
        });
        jscroll.setViewportView(tblDestinos);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("VUELOS POR DESTINO");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(apiTemperaturasMiAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(126, 126, 126)
                                            .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(104, 104, 104)
                                            .addComponent(comboDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(apiTemperaturasOtroAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(apiTemperaturasMiAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(comboDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(apiTemperaturasOtroAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMenu)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDestinosActionPerformed
        actualizarTabla(LocalDate.now());

        formatearTabla();
    }//GEN-LAST:event_comboDestinosActionPerformed

    private void tblDestinosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDestinosMousePressed
        if (tblDestinos.getSelectedRow() != -1) {
            VueloTableModel llegadasTableModel = (VueloTableModel) tblDestinos.getModel();
            try {
                apiTemperaturasMiAeropuerto.cambiarCiudad(llegadasTableModel.getCodigoDestinoEn(tblDestinos.getSelectedRow()));
                apiTemperaturasOtroAeropuerto.cambiarCiudad(llegadasTableModel.getCodigoOrigenEn(tblDestinos.getSelectedRow()));
            } catch (NullPointerException np) {
                JOptionPane.showMessageDialog(null, "Sin información.");
            }
        }
    }//GEN-LAST:event_tblDestinosMousePressed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultasVuelosSieteDias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasVuelosSieteDias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasVuelosSieteDias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasVuelosSieteDias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultasVuelosSieteDias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.actividad1.api.ApiTemperaturas apiTemperaturasMiAeropuerto;
    private com.mycompany.actividad1.api.ApiTemperaturas apiTemperaturasOtroAeropuerto;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboDestinos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jscroll;
    private javax.swing.JTable tblDestinos;
    // End of variables declaration//GEN-END:variables
}
