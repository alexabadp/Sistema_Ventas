package Controladores;

import Entidades.Categoria;
import Entidades.Proveedor;
import Formatos.ProductoControl;
import Vista.FrmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControlFrmProducto implements ActionListener {

    FrmProducto vista;
    DefaultTableModel modeloTabla;

    private final ProductoControl CONTROL;
    private String accion;
    String nombreAnterior;

    public ControlFrmProducto(FrmProducto FProducto) {
        this.vista = FProducto;

        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        this.CONTROL = new ProductoControl();
        accion = "guardar";
        vista.tabGeneral.setEnabledAt(1, false);
        Listar(vista);
        cargarCategoria();
        cargarProveedor();
    }

    private void cargarCategoria() {
        DefaultComboBoxModel item = CONTROL.seleccionarCategoria();
        vista.cboCategoria.setModel(item);
    }

    private void cargarProveedor() {
        DefaultComboBoxModel item = CONTROL.seleccionarProveedor();
        vista.cboProveedor.setModel(item);
    }

    private void Listar(FrmProducto FProducto) {
        vista.tabla.setModel(CONTROL.listar());
        TableRowSorter orden = new TableRowSorter(vista.tabla.getModel());

        FProducto.setVisible(true);
        FProducto.setTitle("Lista de Productos");
        FProducto.setLocationRelativeTo(null);
    }

    private void Limpiar() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
        accion = "guardar";
    }

    private void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnEditar) {
            if (vista.tabla.getSelectedRowCount() == 1) {
                String ruc = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 0));
                String nombre = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 1));
                String precio = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 2));
                String stock = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 3));
                String idCategoria = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 4));
                String nombreCategoria = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 5));
                String idProveedor = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 6));
                String nombreProveedor = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 7));
                nombreAnterior = nombre;

                vista.txtId.setText(ruc);
                vista.txtNombre.setText(nombre);
                vista.txtPrecio.setText(precio);
                vista.txtStock.setText(stock);

                vista.txtId.setEditable(false);

                vista.cboCategoria.setSelectedItem(new Categoria(Integer.parseInt(idCategoria), nombreCategoria));
                vista.cboProveedor.setSelectedItem(new Proveedor(Integer.parseInt(idProveedor), nombreProveedor));

                vista.tabGeneral.setEnabledAt(0, false);
                vista.tabGeneral.setEnabledAt(1, true);
                vista.tabGeneral.setSelectedIndex(1);
                this.accion = "editar";
                vista.btnGuardar.setText("Editar");
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
            vista.txtId.setEditable(true);
        }

        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtId.getText().trim().length() == 0 || vista.txtId.getText().trim().length() > 11) {
                this.mensajeError("Debes ingresar un ID y no debe ser mayor a 11 caracteres, es obligatorio");
                vista.txtId.requestFocus();
                return;
            }
            if (vista.txtNombre.getText().trim().length() == 0 || vista.txtNombre.getText().trim().length() > 45) {
                this.mensajeError("Debes ingresar un nombre y no debe ser mayor a 45 caracteres, es obligatorio");
                vista.txtNombre.requestFocus();
                return;
            }

            if (vista.txtPrecio.getText().trim().length() == 0 || vista.txtPrecio.getText().trim().length() > 10) {
                this.mensajeError("Debes ingresar un precio y no debe ser mayor a 10 caracteres, es obligatorio");
                vista.txtPrecio.requestFocus();
                return;
            }
            if (vista.txtStock.getText().trim().length() == 0 || vista.txtStock.getText().trim().length() > 11) {
                this.mensajeError("Debes ingresar un stock y no debe ser mayor a 11 caracteres, es obligatorio");
                vista.txtStock.requestFocus();
                return;
            }
            if (vista.cboCategoria.getItemCount() == 0) {
                this.mensajeError("Debe seleccionar una categoria");
                vista.cboCategoria.requestFocus();
                return;
            }
            if (vista.cboProveedor.getItemCount() == 0) {
                this.mensajeError("Debe seleccionar un Proveedor");
                vista.cboProveedor.requestFocus();
                return;
            }

            Categoria cat = (Categoria) vista.cboCategoria.getSelectedItem();
            Proveedor prov = (Proveedor) vista.cboProveedor.getSelectedItem();

            String resp;
            if (accion.equals("editar")) {
                resp = CONTROL.actualizar(Integer.parseInt(vista.txtId.getText().trim()), vista.txtNombre.getText().trim(),
                        Double.parseDouble(vista.txtPrecio.getText()), Integer.parseInt(vista.txtStock.getText()), cat.getId(), prov.getRuc(), nombreAnterior);

                if (resp.equals("OK")) {
                    this.mensajeOK("Actualizado correctamente");
                    this.Limpiar();
                    this.Listar(vista);

                    vista.tabGeneral.setEnabledAt(0, true);
                    vista.tabGeneral.setEnabledAt(1, false);
                    vista.tabGeneral.setSelectedIndex(0);
                } else {
                    this.mensajeError(resp);
                }
            } else {
                resp = CONTROL.insertar(Integer.parseInt(vista.txtId.getText().trim()), vista.txtNombre.getText().trim(), Double.parseDouble(vista.txtPrecio.getText()),
                        Integer.parseInt(vista.txtStock.getText()), cat.getId(), prov.getRuc());

                if (resp.equals("OK")) {
                    this.mensajeOK("Registrado correctamente");
                    this.Limpiar();
                    this.Listar(vista);

                    vista.tabGeneral.setEnabledAt(0, true);
                    vista.tabGeneral.setEnabledAt(1, false);
                    vista.tabGeneral.setSelectedIndex(0);
                } else {
                    this.mensajeError(resp);
                }
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            this.Limpiar();
            vista.tabGeneral.setEnabledAt(0, true);
            vista.tabGeneral.setEnabledAt(1, false);
            vista.tabGeneral.setSelectedIndex(0);
            accion = "Guardar";
        }

        if (e.getSource() == vista.btnEliminar) {
            String resp;
            int fila = vista.tabla.getSelectedRow();

            if (fila >= 0) {
                //try {

                resp = CONTROL.eliminar(Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString()));
                if (resp.equals("OK")) {
                    this.mensajeOK("Eliminado correctamente");
                    this.Listar(vista);
                }

                //} catch (NumberFormatException e) {
                //    JOptionPane.showMessageDialog(this, "Error al eliminar el registro 1", "Error", JOptionPane.ERROR_MESSAGE);
                //}
            } else {
                JOptionPane.showMessageDialog(null, "La fila que intenta eliminar esta vacia", "Error", JOptionPane.QUESTION_MESSAGE);
            }
        }
    }

}
