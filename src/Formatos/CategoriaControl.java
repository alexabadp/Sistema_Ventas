package Formatos;

import Entidades.Categoria;
import Dao.CategoriaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl{

    private final CategoriaDao DATOS;
    private final Categoria obj;
    private DefaultTableModel modeloTabla;

    public CategoriaControl() {
        this.DATOS = new CategoriaDao();
        this.obj = new Categoria();
    }

    public DefaultTableModel listar() {
        String[] titulos = {"IdCategoria", "Nombre", "Descripcion"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[3];
        List<Categoria> lista = DATOS.listar();
        for (Categoria item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(int id, String nombre, String descripcion) {
        if (DATOS.buscarCodigo(id) != -1) {
            return "El ID ingresado ya existe";
        } else if (DATOS.buscarNombre(nombre) != -1) {
            return "El nombre ingresado ya existe";
        } else {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(Integer id, String nombre, String nombreAnterior, String descripcion) {

        if (nombre.equals(nombreAnterior)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en el Registro";
            }
        } else {
            if (DATOS.buscarNombre(nombre) != -1) {
                return "El nombre ingresado ya existe";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setDescripcion(descripcion);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en el Registro";
                }
            }
        }
    }

    public String eliminar(Integer id) {

        if (DATOS.eliminar(id)) {
            return "OK";
        } else {
            return "Error en eliminar el registro";
        }
    }


}
