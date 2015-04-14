/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilitarios.Validacion;

/**
 *
 * @author Karlo
 */
public class Buscar extends javax.swing.JDialog {
    private boolean validez;
    int xa,ya;
    /**
     * Creates new form Buscar
     */
    public Buscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        initComponents();
        error.setVisible(false);
        error1.setVisible(false);
        validez=false;
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
        origen = new javax.swing.JTextField();
        destinos = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        error1 = new javax.swing.JLabel();
        graficar = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        tipo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Origen:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Destinos:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        origen.setToolTipText("Ingresar el nombre de un nodo. Ejm: A");
        origen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                origenKeyTyped(evt);
            }
        });
        getContentPane().add(origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 112, -1));

        destinos.setToolTipText("Ingresar los nodos destinos separados por \",\". Ejm: A,B,C...");
        destinos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                destinosKeyTyped(evt);
            }
        });
        getContentPane().add(destinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 111, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 81, -1));

        error.setFont(new java.awt.Font("TINspireKeysCX", 0, 13)); // NOI18N
        error.setForeground(new java.awt.Color(255, 51, 51));
        error.setText("X");
        error.setToolTipText("Error de nombre");
        getContentPane().add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 15, -1));

        error1.setFont(new java.awt.Font("TINspireKeysCX", 0, 13)); // NOI18N
        error1.setForeground(new java.awt.Color(255, 51, 51));
        error1.setText("X");
        error1.setToolTipText("Error de nombre");
        getContentPane().add(error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 15, -1));

        graficar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
        graficar.setForeground(new java.awt.Color(255, 255, 255));
        graficar.setSelected(true);
        graficar.setText("Retardo");
        graficar.setToolTipText("Deseleccionar para medir el tiempo de procesamiento");
        graficar.setOpaque(false);
        graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarActionPerformed(evt);
            }
        });
        getContentPane().add(graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 90, 10));

        titulo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Busqueda");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 3, -1, -1));

        tiempo.setText("1000");
        tiempo.setToolTipText("Ingrese el tiempo de retardo en mseg");
        tiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tiempoKeyTyped(evt);
            }
        });
        getContentPane().add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, -1));

        tipo.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
        tipo.setForeground(new java.awt.Color(255, 255, 255));
        tipo.setSelected(true);
        tipo.setText("Minimo");
        tipo.setOpaque(false);
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void destinosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destinosKeyTyped
        int nc=evt.getKeyChar();
        if((nc<"a".charAt(0) || nc >"z".charAt(0)) && (nc<"A".charAt(0) || nc >"Z".charAt(0)) && nc!=",".charAt(0)){
            evt.consume();
        }
    }//GEN-LAST:event_destinosKeyTyped

    private void origenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_origenKeyTyped
        int nc=evt.getKeyChar();
        if((nc<"a".charAt(0) || nc >"z".charAt(0)) && (nc<"A".charAt(0) || nc >"Z".charAt(0))){
            evt.consume();
        }else{if(origen.getText().length()>0){evt.consume();}}
    }//GEN-LAST:event_origenKeyTyped

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(Validacion.validarNombre(origen.getText())){
            if(Validacion.validarDestinos(destinos.getText())){
                validez=true;
                this.dispose();
            }error1.setVisible(true);
        }error.setVisible(true);
    }//GEN-LAST:event_aceptarActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(ya<42){
            int xp, yp;
            xp = evt.getXOnScreen();
            yp = evt.getYOnScreen();
            move(xp - xa, yp - ya);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xa = evt.getX();
        ya = evt.getY();
    }//GEN-LAST:event_formMouseMoved

    private void graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarActionPerformed
        tiempo.setEnabled(graficar.isSelected());
    }//GEN-LAST:event_graficarActionPerformed

    private void tiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempoKeyTyped
        int nc=evt.getKeyChar();
        if((nc<"0".charAt(0) || nc >"9".charAt(0))){
            evt.consume();
        }       
    }//GEN-LAST:event_tiempoKeyTyped

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        if(tipo.isSelected()){tipo.setText("Minimo");}else{tipo.setText("Maximo");}
    }//GEN-LAST:event_tipoActionPerformed
    public boolean esValido(){return validez;}
    public String getOrigen(){
        return origen.getText();
    }
    public long getTiempo(){
        return Long.valueOf(tiempo.getText());
    }
    public String getDestinos(){
        return destinos.getText();
    }
    public boolean graficar(){
        return graficar.isSelected();
    }
    public boolean esMinimo(){
        return tipo.isSelected();
    }
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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Buscar dialog = new Buscar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField destinos;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error1;
    private javax.swing.JCheckBox graficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField origen;
    private javax.swing.JTextField tiempo;
    private javax.swing.JCheckBox tipo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
