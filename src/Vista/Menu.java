package Vista;

//import Controladores.ControlFrmCategoria;
//import Controladores.ControlFrmCliente;
//import Controladores.ControlFrmProducto;
//import Controladores.ControlFrmProveedor;
//import Controladores.ControlFrmVenta;

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
//    public static ControlFrmCliente controlFCliente;
//    public static ControlFrmProveedor controlFProveedor;
//    public static ControlFrmCategoria controlFCategoria;
//    public static ControlFrmProducto controlFProducto;
//    public static ControlFrmVenta controlFVenta;
    public Menu() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemCategoria = new javax.swing.JMenuItem();
        MenuItemProducto = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        MenuItemCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuItemProveedor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuItemVenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Viña Tintos.png"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(730, 360, 500, 320);

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel2.setText("Menú de opciones");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(830, 310, 340, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.jpg"))); // NOI18N
        desktopPane.add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 270);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.jpg"))); // NOI18N
        desktopPane.add(jLabel4);
        jLabel4.setBounds(400, 0, 400, 270);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.jpg"))); // NOI18N
        desktopPane.add(jLabel5);
        jLabel5.setBounds(800, 0, 360, 270);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.jpg"))); // NOI18N
        desktopPane.add(jLabel6);
        jLabel6.setBounds(1160, 0, 400, 270);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/5.png"))); // NOI18N
        desktopPane.add(jLabel7);
        jLabel7.setBounds(1560, 0, 370, 270);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.jpg"))); // NOI18N
        desktopPane.add(jLabel8);
        jLabel8.setBounds(0, 750, 400, 240);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.jpg"))); // NOI18N
        desktopPane.add(jLabel9);
        jLabel9.setBounds(400, 750, 240, 240);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/8.jpg"))); // NOI18N
        desktopPane.add(jLabel10);
        jLabel10.setBounds(640, 750, 390, 240);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/9.jpg"))); // NOI18N
        desktopPane.add(jLabel11);
        jLabel11.setBounds(1030, 750, 400, 240);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/10.png"))); // NOI18N
        desktopPane.add(jLabel12);
        jLabel12.setBounds(1430, 750, 390, 240);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/11.jpg"))); // NOI18N
        desktopPane.add(jLabel13);
        jLabel13.setBounds(1720, 750, 380, 240);

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setText("Almacen");

        MenuItemCategoria.setBackground(new java.awt.Color(204, 204, 255));
        MenuItemCategoria.setText("Categoria");
        MenuItemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemCategoria);

        MenuItemProducto.setBackground(new java.awt.Color(204, 204, 255));
        MenuItemProducto.setText("Producto");
        MenuItemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemProductoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemProducto);

        menuBar.add(jMenu1);

        fileMenu.setBackground(new java.awt.Color(204, 204, 255));
        fileMenu.setMnemonic('f');
        fileMenu.setText("Clientes");

        MenuItemCliente.setBackground(new java.awt.Color(204, 204, 255));
        MenuItemCliente.setMnemonic('o');
        MenuItemCliente.setText("Clientes");
        MenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemClienteActionPerformed(evt);
            }
        });
        fileMenu.add(MenuItemCliente);

        menuBar.add(fileMenu);

        jMenu2.setText("Proveedores");

        MenuItemProveedor.setBackground(new java.awt.Color(204, 204, 255));
        MenuItemProveedor.setText("Proveedores");
        MenuItemProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemProveedorActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemProveedor);

        menuBar.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3.setText("Ventas");

        MenuItemVenta.setBackground(new java.awt.Color(204, 204, 255));
        MenuItemVenta.setText("Ventas");
        MenuItemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemVentaActionPerformed(evt);
            }
        });
        jMenu3.add(MenuItemVenta);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemClienteActionPerformed
        
//        FrmCliente FCliente = new FrmCliente();
//        controlFCliente = new ControlFrmCliente(FCliente);
//        FCliente.setVisible(true);
        //new FrmCliente().setVisible(true);
        
        
    }//GEN-LAST:event_MenuItemClienteActionPerformed

    private void MenuItemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCategoriaActionPerformed
        
//        FrmCategoria FCategoria = new FrmCategoria();
//        controlFCategoria = new ControlFrmCategoria(FCategoria);
//        FCategoria.setVisible(true);
        
        //new FrmCategoria().setVisible(true);
    }//GEN-LAST:event_MenuItemCategoriaActionPerformed

    private void MenuItemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemProductoActionPerformed
        
//        FrmProducto FProducto = new FrmProducto();
//        controlFProducto = new ControlFrmProducto(FProducto);
//        FProducto.setVisible(true);
        
        //new FrmProducto().setVisible(true);
    }//GEN-LAST:event_MenuItemProductoActionPerformed

    private void MenuItemProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemProveedorActionPerformed
        
//        FrmProveedor FProveedor = new FrmProveedor();
//        controlFProveedor = new ControlFrmProveedor(FProveedor);
//        FProveedor.setVisible(true);
        
        //new FrmProveedor().setVisible(true);
    }//GEN-LAST:event_MenuItemProveedorActionPerformed

    private void MenuItemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemVentaActionPerformed
        
//        FrmVenta FVenta = new FrmVenta();
//        controlFVenta = new ControlFrmVenta(FVenta);
//        FVenta.setVisible(true);
        
        //new FrmVenta().setVisible(true);
    }//GEN-LAST:event_MenuItemVentaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuItemCategoria;
    public javax.swing.JMenuItem MenuItemCliente;
    public javax.swing.JMenuItem MenuItemProducto;
    public javax.swing.JMenuItem MenuItemProveedor;
    public javax.swing.JMenuItem MenuItemVenta;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
