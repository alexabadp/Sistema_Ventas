package Formatos;

import Dao.ClienteDao;
import Entidades.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteControl implements ActionListener{
 
    private final ClienteDao DATOS;
    private final Cliente obj;
    DefaultTableModel modeloTabla;
    
    public ClienteControl() {
  
        this.DATOS = new ClienteDao();
        this.obj = new Cliente();
    }

    public DefaultTableModel listar() {
        String[] titulos = {"ruc", "nombre", "telefono", "direccion"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[4];
        List<Cliente> lista = DATOS.listar();
        for (Cliente item : lista) {
            registro[0] = Integer.toString(item.getRuc());
            registro[1] = item.getNombre();
            registro[2] = Integer.toString(item.getTelefono());
            registro[3] = item.getDireccion();

            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Integer ruc, String nombre, Integer telefono, String direccion) {
        if (DATOS.buscarCodigo(ruc) != -1) {
            return "El ruc ingresado ya existe";
        } else if (DATOS.buscarNombre(nombre) != -1) {
            return "El nombre ingresado ya existe";
        } else {
            obj.setRuc(ruc);
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(Integer ruc, String nombre, Integer telefono, String direccion, String nombreAnterior) {
        if (nombre.equals(nombreAnterior)) {
            obj.setRuc(ruc);
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en el Registro";
            }
        } else {
            if (DATOS.buscarNombre(nombre) != -1) {
                return "El nombre ingresado ya existe";
            } else {
                obj.setRuc(ruc);
                obj.setNombre(nombre);
                obj.setTelefono(telefono);
                obj.setDireccion(direccion);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en el registro";
                }
            }
        }
    }

    public String eliminar(Integer ruc) {

        if (DATOS.eliminar(ruc)) {
            return "OK";
        } else {
            return "Error en eliminar el registro";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
