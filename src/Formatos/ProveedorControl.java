package Formatos;

import Dao.ProveedorDao;
import Entidades.Proveedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProveedorControl {

    private final ProveedorDao DATOS;
    private final Proveedor obj;
    DefaultTableModel modeloTabla;

    public ProveedorControl() {
        this.DATOS = new ProveedorDao();
        this.obj = new Proveedor();
    }

    public DefaultTableModel listar() {
        String[] titulos = {"Ruc", "Nombre", "Telefono", "Direccion", "Pagina Web"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[5];
        List<Proveedor> lista = DATOS.listar();
        for (Proveedor item : lista) {
            registro[0] = Integer.toString(item.getRuc());
            registro[1] = item.getNombre();
            registro[2] = Integer.toString(item.getTelefono());
            registro[3] = item.getDireccion();
            registro[4] = item.getPaginaWeb();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Integer ruc, String nombre, Integer telefono, String direccion, String paginaWeb) {
        if (DATOS.buscarCodigo(ruc) != -1) {
            return "El ruc ingresado ya existe";
        } else if (DATOS.buscarNombre(nombre) != -1) {
            return "El nombre ingresado ya existe";
        } else {
            obj.setRuc(ruc);
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);
            obj.setPaginaWeb(paginaWeb);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(Integer ruc, String nombre, Integer telefono, String direccion, String paginaWeb, String nombreAnterior) {
        if (nombre.equals(nombreAnterior)) {
            obj.setRuc(ruc);
            obj.setNombre(nombre);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);
            obj.setPaginaWeb(paginaWeb);
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
                obj.setPaginaWeb(paginaWeb);
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
}
