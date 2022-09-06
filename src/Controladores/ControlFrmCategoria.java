package Controladores;

import Formatos.CategoriaControl;
import Vista.FrmCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ControlFrmCategoria implements ActionListener {

    FrmCategoria vista;
    DefaultTableModel modeloTabla;

    private final CategoriaControl CONTROL;
    private String accion;
    String nombreAnterior;

    public ControlFrmCategoria(FrmCategoria FCategoria) {
        this.vista = FCategoria;

        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        this.CONTROL = new CategoriaControl();
        accion = "guardar";
        vista.tabGeneral.setEnabledAt(1, false);
        Listar(vista);
    }

    private void Listar(FrmCategoria FCategoria) {
        vista.tabla.setModel(CONTROL.listar());
        TableRowSorter orden = new TableRowSorter(vista.tabla.getModel());

        FCategoria.setVisible(true);
        FCategoria.setTitle("Lista de Categorias");
        FCategoria.setLocationRelativeTo(null);
    }

    private void Limpiar() {
        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
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
                String id = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 0));
                String nombre = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 1));
                nombreAnterior = nombre;
                String descripcion = String.valueOf(vista.tabla.getValueAt(vista.tabla.getSelectedRow(), 2));

                vista.txtId.setText(id);
                vista.txtNombre.setText(nombre);
                vista.txtDescripcion.setText(descripcion);

                vista.tabGeneral.setEnabledAt(0, false);
                vista.tabGeneral.setEnabledAt(1, true);
                vista.tabGeneral.setSelectedIndex(1);
                this.accion = "editar";
                vista.btnGuardar.setText("Editar");
                vista.txtId.setEditable(false);
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

        String descripcion = vista.txtDescripcion.getText();
        if (descripcion.trim().length() == 0) {
            descripcion = "-";
        }

        String resp;
        if (accion.equals("editar")) {
            resp = CONTROL.actualizar(Integer.parseInt(vista.txtId.getText().trim()), vista.txtNombre.getText().trim(), nombreAnterior, descripcion);
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
            resp = CONTROL.insertar(Integer.parseInt(vista.txtId.getText().trim()), vista.txtNombre.getText().trim(), descripcion);
            //resp = CONTROL.insertar(txtNombre.getText().trim(), descripcion);
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
