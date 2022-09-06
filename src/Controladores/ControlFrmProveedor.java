package Controladores;

import Formatos.ProveedorControl;
import Vista.FrmProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControlFrmProveedor implements ActionListener {

    FrmProveedor vista;
    DefaultTableModel modeloTabla;

    private final ProveedorControl CONTROL;
    private String accion;
    String nombreAnterior;

    public ControlFrmProveedor(FrmProveedor FProveedor) {
        this.vista = FProveedor;

        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        this.CONTROL = new ProveedorControl();
        accion = "guardar";
        vista.tabGeneral.setEnabledAt(1, false);
        Listar(vista);
    }

    private void Listar(FrmProveedor FProveedor) {
        vista.tabla.setModel(CONTROL.listar());
        TableRowSorter orden = new TableRowSorter(vista.tabla.getModel());

        FProveedor.setVisible(true);
        FProveedor.setTitle("Lista de Clientes");
        FProveedor.setLocationRelativeTo(null);
    }

    private void Limpiar() {
        vista.txtRuc.setText("");
        vista.txtNombre.setText("");
        vista.txtTelefono.setText("");
        vista.txtDireccion.setText("");
        vista.txtPaginaWeb.setText("");
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
            String telefono = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 2));
            String direccion = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 3));
            String paginaWeb = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 4));
            nombreAnterior = nombre;

            vista.txtRuc.setText(ruc);
            vista.txtNombre.setText(nombre);
            vista.txtTelefono.setText(telefono);
            vista.txtDireccion.setText(direccion);
            vista.txtPaginaWeb.setText(paginaWeb);

            vista.tabGeneral.setEnabledAt(0, false);
            vista.tabGeneral.setEnabledAt(1, true);
            vista.tabGeneral.setSelectedIndex(1);
            this.accion = "editar";
            vista.btnGuardar.setText("Editar");
            vista.txtRuc.setEditable(false);
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
            vista.txtRuc.setEditable(true);
        }

        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtRuc.getText().trim().length() == 0 || vista.txtRuc.getText().trim().length() > 11) {
                this.mensajeError("Debes ingresar un RUC y no debe ser mayor a 11 caracteres, es obligatorio");
                vista.txtRuc.requestFocus();
                return;
            }
            if (vista.txtNombre.getText().trim().length() == 0 || vista.txtNombre.getText().trim().length() > 45) {
                this.mensajeError("Debes ingresar un nombre y no debe ser mayor a 45 caracteres, es obligatorio");
                vista.txtNombre.requestFocus();
                return;
            }
            if (vista.txtTelefono.getText().trim().length() == 0) {
                this.mensajeError("Debes ingresar un telefono, es obligatorio");
                vista.txtNombre.requestFocus();
                return;
            }
            if (vista.txtDireccion.getText().trim().length() == 0) {
                this.mensajeError("Debes ingresar una direccion, es obligatorio");
                vista.txtNombre.requestFocus();
                return;
            }
            if (vista.txtPaginaWeb.getText().trim().length() == 0) {
                this.mensajeError("Debes ingresar una paginaWeb, es obligatorio");
                vista.txtNombre.requestFocus();
                return;
            }

            String resp;
            if (accion.equals("editar")) {
                resp = CONTROL.actualizar(Integer.parseInt(vista.txtRuc.getText().trim()), vista.txtNombre.getText().trim(), Integer.parseInt(vista.txtTelefono.getText().trim()), vista.txtDireccion.getText().trim(), vista.txtPaginaWeb.getText().trim(), nombreAnterior);
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
                resp = CONTROL.insertar(Integer.parseInt(vista.txtRuc.getText().trim()), vista.txtNombre.getText().trim(), Integer.parseInt(vista.txtTelefono.getText().trim()), vista.txtDireccion.getText().trim(), vista.txtPaginaWeb.getText());
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
