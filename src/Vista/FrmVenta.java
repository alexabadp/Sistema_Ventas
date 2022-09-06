package Vista;

//import Formatos.VentaControl;
//import Entidades.Cliente;
//import Entidades.Producto;
//import java.time.LocalDate;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;

public class FrmVenta extends javax.swing.JFrame {

//    private final VentaControl CONTROL;
//    private String accion;
//    private DefaultTableModel modeloDetalles;

    public FrmVenta() {

        initComponents();

//        this.CONTROL = new VentaControl();
//        accion = "guardar";
//        tabGeneral.setEnabledAt(1, false);
//        listar();
//        cargarClientes();
//        cargarProductos();
//        txtFecha.setText(fechaSistema());
//        crearDetalles();
//        txtDescuento.setText("0.00");
//        txtTotal.setText("0.00");
    }
//
//    private void listar() {
//        tabla.setModel(CONTROL.listar());
//        TableRowSorter orden = new TableRowSorter(tabla.getModel());
//        tabla.setRowSorter(orden);
//    }
//
//    private void cargarClientes() {
//        DefaultComboBoxModel items = CONTROL.seleccionarCliente();
//        cboCliente.setModel(items);
//    }
//
//    private void cargarProductos() {
//        DefaultComboBoxModel items = CONTROL.seleccionarProducto();
//        cboProducto.setModel(items);
//    }
//
//    private void limpiar() {
//        txtIdVenta.setText("");
//        txtDescuento.setText("0.00");
//        txtTotal.setText("0.00");
//        txtFecha.setText(fechaSistema());
//        crearDetalles();
//        accion = "guardar";
//    }
//
//    private String fechaSistema() {
//        LocalDate date = LocalDate.now();
//        return date.toString();
//    }
//
//    private void mensajeError(String mensaje) {
//        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
//    }
//
//    private void mensajeOK(String mensaje) {
//        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private void crearDetalles() {
//        modeloDetalles = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int fila, int columna) {
//
//                if (columna == 3) {
//                    return columna == 3;
//                }
//                if (columna == 4) {
//                    return columna == 4;
//                }
//                return columna == 3;
//            }
//
//            @Override
//            public Object getValueAt(int row, int col) {
//
//                if (col == 5) {
//                    Double cantD;
//                    try {
//                        cantD = Double.parseDouble((String) getValueAt(row, 3));
//                    } catch (NumberFormatException e) {
//                        cantD = 1.0;
//                    }
//                    Double precioD = Double.parseDouble((String) getValueAt(row, 4));
//                    if (cantD != null && precioD != null) {
//                        return String.format("%.2f", cantD * precioD);
//                    } else {
//                        return 0;
//                    }
//                }
//                return super.getValueAt(row, col);
//            }
//
//            @Override
//            public void setValueAt(Object aValue, int row, int col) {
//                super.setValueAt(aValue, row, col);
//                try {
//                    int cantD = Integer.parseInt((String) getValueAt(row, 3));
//                    int stockD = Integer.parseInt((String) getValueAt(row, 2));
//                    if (cantD > stockD) {
//                        super.setValueAt(stockD, row, 4);
//                        mensajeError("La cantidad a vender no puede superar el stock. Usted puede vender como"
//                                + "maximo: " + stockD);
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println(e.getMessage());
//                }
//                calcularTotales();
//                fireTableDataChanged();
//            }
//
//        };
//        modeloDetalles.setColumnIdentifiers(new Object[]{"Id Producto", "Producto", "Stock", "Cantidad", "Precio", "Sub Total"});
//        tablaDetalle.setModel(modeloDetalles);
//    }

//    private void calcularTotales() {
//        double total = 0.00;
//        int items = modeloDetalles.getRowCount();
//        if (items == 0) {
//            total = 0.00;
//        } else {
//            for (int i = 0; i < items; i++) {
//                total = total + Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 5)));
//            }
//        }
//        txtTotal.setText(String.format("%.2f", total));
//    }
//
//    public void agregarDetalles(String id, String nombre, String stock, String precio) {
//        String idT;
//        boolean existe = false;
//        for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
//            idT = String.valueOf(modeloDetalles.getValueAt(i, 0));
//            if (idT.equals(id)) {
//                existe = true;
//            }
//        }
//        if (existe) {
//            mensajeError("El producto ya se ha agregado");
//        } else {
//            modeloDetalles.addRow(new Object[]{id, nombre, stock, "1", precio, precio});
//            calcularTotales();
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        cboCliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnQuitarProducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(205, 177, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, 700, 300));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 30));

        btnAnular.setBackground(new java.awt.Color(255, 51, 51));
        btnAnular.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 120, 30));

        btnDetalles.setBackground(new java.awt.Color(204, 255, 255));
        btnDetalles.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel7.setText("Listado de Ventas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 250, 30));

        tabGeneral.addTab("Listado", jPanel1);

        jPanel2.setBackground(new java.awt.Color(205, 177, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 200, 30));

        jLabel1.setText("ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel2.setText("Cliente:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel3.setText("Fecha:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setText("Total:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, 30));

        txtDescuento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 190, 30));

        btnGuardar.setBackground(new java.awt.Color(153, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 140, 30));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 140, 30));

        jLabel5.setText("Descuento:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 190, 30));

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 30));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDetalle);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 700, 150));

        btnQuitarProducto.setBackground(new java.awt.Color(255, 51, 51));
        btnQuitarProducto.setText("Quitar");
        btnQuitarProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnQuitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 120, 30));

        jLabel6.setText("Producto:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(153, 153, 153));
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 120, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(153, 153, 255));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel8.setText("Registro de ventas");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 250, 30));

        tabGeneral.addTab("Mantenimiento", jPanel2);

        getContentPane().add(tabGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 470));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
//        if (tabla.getSelectedRowCount() == 1) {
//            String id = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0));
//            String fecha = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 1));
//            String descuento = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 2));
//            String idCliente = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 3));
//            String nombreCliente = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 4));
//            String total = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 5));
//            String estado = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 6));
//
//            int resultado = JOptionPane.showConfirmDialog(null, "Estas seguro de anular esta venta", "Sitema", JOptionPane.YES_NO_OPTION,
//                    JOptionPane.WARNING_MESSAGE);
//            switch (resultado) {
//                case 0 -> {
//                    String msg = CONTROL.anular(Integer.parseInt(id), fecha, Double.parseDouble(descuento),
//                            Double.parseDouble(total), Integer.parseInt(idCliente));
//                    if (msg.equals("OK")) {
//                        mensajeOK("Se anuló la venta correctamente");
//                        listar();
//                    } else {
//                        mensajeError(msg);
//                    }
//                }
//                case 1 -> {
//                }
//            }
//        } else {
//            this.mensajeError("Seleccione un registro a Editar");
//        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
//        tabGeneral.setEnabledAt(0, false);
//        tabGeneral.setEnabledAt(1, true);
//        tabGeneral.setSelectedIndex(1);
//        this.accion = "guardar";
//
//        btnGuardar.setText("Guardar");

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
//        if (txtIdVenta.getText().trim().length() == 0 || txtIdVenta.getText().trim().length() > 11) {
//            this.mensajeError("Debes ingresar un ID y no debe ser mayor a 11 caracteres, es obligatorio");
//            txtIdVenta.requestFocus();
//            return;
//        }
//        if (txtDescuento.getText().trim().length() == 0 || txtDescuento.getText().trim().length() > 10) {
//            this.mensajeError("Debes ingresar un nombre y no debe ser mayor a 10 caracteres, es obligatorio");
//            txtDescuento.requestFocus();
//            return;
//        }
//        if (cboCliente.getItemCount() == 0) {
//            this.mensajeError("Por favor, seleccione un Cliente, es Obligatorio");
//        }
//        if (modeloDetalles.getRowCount() == 0) {
//            this.mensajeError("Por favor agrega productos, es Obligatorio");
//        }
//
//        String resp;
//        Cliente cliente = (Cliente) cboCliente.getSelectedItem();
//
//        resp = CONTROL.insertar(Integer.parseInt(txtIdVenta.getText().trim()), txtFecha.getText(), Double.parseDouble(txtDescuento.getText()),
//                Double.parseDouble(txtTotal.getText()), cliente.getRuc(), modeloDetalles);
//        if (resp.equals("OK")) {
//            this.mensajeOK("Venta Registrada correctamente");
//            this.limpiar();
//            this.listar();
//
//            tabGeneral.setEnabledAt(0, true);
//            tabGeneral.setEnabledAt(1, false);
//            tabGeneral.setSelectedIndex(0);
//        } else {
//            this.mensajeError(resp);
//        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
//        this.limpiar();
//        tabGeneral.setEnabledAt(0, true);
//        tabGeneral.setEnabledAt(1, false);
//        tabGeneral.setSelectedIndex(0);
//        accion = "Guardar";
//        btnGuardar.setVisible(true);
//        btnQuitarProducto.setVisible(true);
//        btnAgregarProducto.setVisible(true);
//
//        txtIdVenta.setEditable(true);
//        txtDescuento.setEditable(true);
//        txtFecha.setEditable(true);
//        cboCliente.setEnabled(true);
//        cboProducto.setEnabled(true);
//
//        btnCancelar.setText("Cancelar");

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
//        if (tabla.getSelectedRowCount() == 1) {
//            String id = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0));
//            String fecha = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 1));
//            String descuento = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 2));
//            String idCliente = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 3));
//            String nombreCliente = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 4));
//            String total = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 5));
//            String estado = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 6));
//
//            txtIdVenta.setText(id);
//            txtDescuento.setText(descuento);
//            txtFecha.setText(fecha);
//            cboCliente.setSelectedItem(new Cliente(Integer.parseInt(idCliente), nombreCliente));
//            txtTotal.setText(total);
//
//            txtIdVenta.setEditable(false);
//            txtDescuento.setEditable(false);
//            txtFecha.setEditable(false);
//            cboCliente.setEnabled(false);
//            cboProducto.setEnabled(false);
//
//            modeloDetalles = CONTROL.listarDetalles(Integer.parseInt(id));
//
//            tablaDetalle.setModel(modeloDetalles);
//            calcularTotales();
//
//            tabGeneral.setEnabledAt(1, true);
//            tabGeneral.setEnabledAt(0, false);
//            tabGeneral.setSelectedIndex(1);
//            btnGuardar.setVisible(false);
//            btnQuitarProducto.setVisible(false);
//            btnAgregarProducto.setVisible(false);
//            btnCancelar.setText("Regresar");
//
//        } else {
//            this.mensajeError("Seleccione un registro para ver sus detalles");
//        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        // TODO add your handling code here:
//        if (tablaDetalle.getSelectedRowCount() == 1) {
//            modeloDetalles.removeRow(tablaDetalle.getSelectedRow());
//            calcularTotales();
//
//        } else {
//            this.mensajeError("Seleccione un registro para Quitar");
//        }
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
//        Producto producto = (Producto) cboProducto.getSelectedItem();
//        agregarDetalles(String.valueOf(producto.getId()), producto.getNombre(), String.valueOf(producto.getStock()), String.valueOf(producto.getPrecio()));

    }//GEN-LAST:event_btnAgregarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarProducto;
    public javax.swing.JButton btnAnular;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnDetalles;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnQuitarProducto;
    public javax.swing.JComboBox<String> cboCliente;
    public javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTabbedPane tabGeneral;
    public javax.swing.JTable tabla;
    public javax.swing.JTable tablaDetalle;
    public javax.swing.JTextField txtDescuento;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtIdVenta;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
