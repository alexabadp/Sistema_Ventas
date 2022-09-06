package Controladores;

import Entidades.Cliente;
import Entidades.Producto;
import Formatos.ClienteControl;
import Formatos.VentaControl;
import Vista.FrmCliente;
import Vista.FrmVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControlFrmVenta implements ActionListener {

    FrmVenta vista;
    DefaultTableModel modeloTabla;

    private VentaControl CONTROL;
    private String accion;
    private DefaultTableModel modeloDetalles;

    public ControlFrmVenta(FrmVenta FVenta) {
        this.vista = FVenta;

        this.vista.btnAnular.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnDetalles.addActionListener(this);
        this.vista.btnQuitarProducto.addActionListener(this);
        this.vista.btnAgregarProducto.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        this.CONTROL = new VentaControl();
        accion = "guardar";
        vista.tabGeneral.setEnabledAt(1, false);
        Listar(vista);
        cargarClientes();
        cargarProductos();
        vista.txtFecha.setText(fechaSistema());
        crearDetalles();
        vista.txtDescuento.setText("0.00");
        vista.txtTotal.setText("0.00");
    }

    private void Listar(FrmVenta FVenta) {
        vista.tabla.setModel(CONTROL.listar());
        TableRowSorter orden = new TableRowSorter(vista.tabla.getModel());

        FVenta.setVisible(true);
        FVenta.setTitle("Lista de Clientes");
        FVenta.setLocationRelativeTo(null);
    }

    private void cargarClientes() {
        DefaultComboBoxModel items = CONTROL.seleccionarCliente();
        vista.cboCliente.setModel(items);
    }

    private void cargarProductos() {
        DefaultComboBoxModel items = CONTROL.seleccionarProducto();
        vista.cboProducto.setModel(items);
    }

    private void Limpiar() {
        vista.txtIdVenta.setText("");
        vista.txtDescuento.setText("0.00");
        vista.txtTotal.setText("0.00");
        vista.txtFecha.setText(fechaSistema());
        crearDetalles();
        accion = "guardar";
    }

    private String fechaSistema() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    private void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    private void crearDetalles() {
        modeloDetalles = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {

                if (columna == 3) {
                    return columna == 3;
                }
                if (columna == 4) {
                    return columna == 4;
                }
                return columna == 3;
            }

            @Override
            public Object getValueAt(int row, int col) {

                if (col == 5) {
                    Double cantD;
                    try {
                        cantD = Double.parseDouble((String) getValueAt(row, 3));
                    } catch (NumberFormatException e) {
                        cantD = 1.0;
                    }
                    Double precioD = Double.parseDouble((String) getValueAt(row, 4));
                    if (cantD != null && precioD != null) {
                        return String.format("%.2f", cantD * precioD);
                    } else {
                        return 0;
                    }
                }
                return super.getValueAt(row, col);
            }

            @Override
            public void setValueAt(Object aValue, int row, int col) {
                super.setValueAt(aValue, row, col);
                try {
                    int cantD = Integer.parseInt((String) getValueAt(row, 3));
                    int stockD = Integer.parseInt((String) getValueAt(row, 2));
                    if (cantD > stockD) {
                        super.setValueAt(stockD, row, 4);
                        mensajeError("La cantidad a vender no puede superar el stock. Usted puede vender como"
                                + "maximo: " + stockD);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                calcularTotales();
                fireTableDataChanged();
            }

        };
        modeloDetalles.setColumnIdentifiers(new Object[]{"Id Producto", "Producto", "Stock", "Cantidad", "Precio", "Sub Total"});
        vista.tablaDetalle.setModel(modeloDetalles);
    }

    private void calcularTotales() {
        double total = 0.00;
        int items = modeloDetalles.getRowCount();
        if (items == 0) {
            total = 0.00;
        } else {
            for (int i = 0; i < items; i++) {
                total = total + Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 5)));
            }
        }
        vista.txtTotal.setText(String.format("%.2f", total));
    }

    public void agregarDetalles(String id, String nombre, String stock, String precio) {
        String idT;
        boolean existe = false;
        for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
            idT = String.valueOf(modeloDetalles.getValueAt(i, 0));
            if (idT.equals(id)) {
                existe = true;
            }
        }
        if (existe) {
            mensajeError("El producto ya se ha agregado");
        } else {
            modeloDetalles.addRow(new Object[]{id, nombre, stock, "1", precio, precio});
            calcularTotales();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAnular) {
            if (vista.tabla.getSelectedRowCount() == 1) {
                String id = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 0));
                String fecha = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 1));
                String descuento = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 2));
                String idCliente = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 3));
                String nombreCliente = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 4));
                String total = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 5));
                String estado = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 6));

                int resultado = JOptionPane.showConfirmDialog(null, "Estas seguro de anular esta venta", "Sitema", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                switch (resultado) {
                    case 0 -> {
                        String msg = CONTROL.anular(Integer.parseInt(id), fecha, Double.parseDouble(descuento),
                                Double.parseDouble(total), Integer.parseInt(idCliente));
                        if (msg.equals("OK")) {
                            mensajeOK("Se anuló la venta correctamente");
                            Listar(vista);
                        } else {
                            mensajeError(msg);
                        }
                    }
                    case 1 -> {
                    }
                }
            } else {
                this.mensajeError("Seleccione un registro a Editar");
            }

        }

        if (e.getSource() == vista.btnNuevo) {
            vista.tabGeneral.setEnabledAt(0, false);
            vista.tabGeneral.setEnabledAt(1, true);
            vista.tabGeneral.setSelectedIndex(1);
            this.accion = "guardar";

            vista.btnGuardar.setText("Guardar");
        }

        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtIdVenta.getText().trim().length() == 0 || vista.txtIdVenta.getText().trim().length() > 11) {
                this.mensajeError("Debes ingresar un ID y no debe ser mayor a 11 caracteres, es obligatorio");
                vista.txtIdVenta.requestFocus();
                return;
            }
            if (vista.txtDescuento.getText().trim().length() == 0 || vista.txtDescuento.getText().trim().length() > 10) {
                this.mensajeError("Debes ingresar un nombre y no debe ser mayor a 10 caracteres, es obligatorio");
                vista.txtDescuento.requestFocus();
                return;
            }
            if (vista.cboCliente.getItemCount() == 0) {
                this.mensajeError("Por favor, seleccione un Cliente, es Obligatorio");
            }
            if (modeloDetalles.getRowCount() == 0) {
                this.mensajeError("Por favor agrega productos, es Obligatorio");
            }

            String resp;
            Cliente cliente = (Cliente) vista.cboCliente.getSelectedItem();

            resp = CONTROL.insertar(Integer.parseInt(vista.txtIdVenta.getText().trim()), vista.txtFecha.getText(), Double.parseDouble(vista.txtDescuento.getText()),
                    Double.parseDouble(vista.txtTotal.getText()), cliente.getRuc(), modeloDetalles);
            if (resp.equals("OK")) {
                this.mensajeOK("Venta Registrada correctamente");
                this.Limpiar();
                this.CONTROL = new VentaControl();
                this.Listar(vista);

                vista.tabGeneral.setEnabledAt(0, true);
                vista.tabGeneral.setEnabledAt(1, false);
                vista.tabGeneral.setSelectedIndex(0);
            } else {
                this.mensajeError(resp);
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            this.Limpiar();
            vista.tabGeneral.setEnabledAt(0, true);
            vista.tabGeneral.setEnabledAt(1, false);
            vista.tabGeneral.setSelectedIndex(0);
            accion = "Guardar";
            vista.btnGuardar.setVisible(true);
            vista.btnQuitarProducto.setVisible(true);
            vista.btnAgregarProducto.setVisible(true);

            vista.txtIdVenta.setEditable(true);
            vista.txtDescuento.setEditable(true);
            vista.txtFecha.setEditable(true);
            vista.cboCliente.setEnabled(true);
            vista.cboProducto.setEnabled(true);

            vista.btnCancelar.setText("Cancelar");
            this.CONTROL = new VentaControl();
            this.Listar(vista);
        }

        if (e.getSource() == vista.btnDetalles) {
            if (vista.tabla.getSelectedRowCount() == 1) {
                String id = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 0));
                String fecha = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 1));
                String descuento = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 2));
                String idCliente = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 3));
                String nombreCliente = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 4));
                String total = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 5));
                String estado = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 6));

                vista.txtIdVenta.setText(id);
                vista.txtDescuento.setText(descuento);
                vista.txtFecha.setText(fecha);
                vista.cboCliente.setSelectedItem(new Cliente(Integer.parseInt(idCliente), nombreCliente));
                vista.txtTotal.setText(total);

                vista.txtIdVenta.setEditable(false);
                vista.txtDescuento.setEditable(false);
                vista.txtFecha.setEditable(false);
                vista.cboCliente.setEnabled(false);
                vista.cboProducto.setEnabled(false);

                modeloDetalles = CONTROL.listarDetalles(Integer.parseInt(id));

                vista.tablaDetalle.setModel(modeloDetalles);
                calcularTotales();

                vista.tabGeneral.setEnabledAt(1, true);
                vista.tabGeneral.setEnabledAt(0, false);
                vista.tabGeneral.setSelectedIndex(1);
                vista.btnGuardar.setVisible(false);
                vista.btnQuitarProducto.setVisible(false);
                vista.btnAgregarProducto.setVisible(false);
                vista.btnCancelar.setText("Regresar");

            } else {
                this.mensajeError("Seleccione un registro para ver sus detalles");
            }
        }
        if (e.getSource() == vista.btnQuitarProducto) {
            if (vista.tablaDetalle.getSelectedRowCount() == 1) {
                modeloDetalles.removeRow(vista.tablaDetalle.getSelectedRow());
                calcularTotales();

            } else {
                this.mensajeError("Seleccione un registro para Quitar");
            }
        }

        if (e.getSource() == vista.btnAgregarProducto) {
            Producto producto = (Producto) vista.cboProducto.getSelectedItem();
            agregarDetalles(String.valueOf(producto.getId()), producto.getNombre(), String.valueOf(producto.getStock()), String.valueOf(producto.getPrecio()));

        }

    }

}
