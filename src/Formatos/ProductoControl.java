package Formatos;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Proveedor;
import Dao.CategoriaDao;
import Dao.ProductoDao;
import Dao.ProveedorDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ProductoControl {

    private final ProductoDao DATOS;
    private final CategoriaDao DATOS_CAT;
    private final ProveedorDao DATOS_PROV;
    private final Producto obj;
    private DefaultTableModel modeloTabla;

    public ProductoControl() {

        this.DATOS = new ProductoDao();
        DATOS_CAT = new CategoriaDao();
        DATOS_PROV = new ProveedorDao();
        this.obj = new Producto();
    }

    public DefaultTableModel listar() {
        String[] titulos = {"Id", "Nombre", "Precio", "Stock", "Categoria ID", "Categoria", "Proveedor ID", "Proveedor"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[8];
        List<Producto> lista = DATOS.listar();
        for (Producto item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = Double.toString(item.getPrecio());
            registro[3] = Integer.toString(item.getStock());
            registro[4] = Integer.toString(item.getIdCategoria().getId());
            registro[5] = item.getIdCategoria().getNombre();
            registro[6] = Integer.toString(item.getRucProveedor().getRuc());
            registro[7] = item.getRucProveedor().getNombre();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Integer id, String nombre, double precio, int stock, int idCat, int idProv) {
        if (DATOS.buscarCodigo(id) != -1) {
            return "El ID ingresado ya existe";
        } else if (DATOS.buscarNombre(nombre) != -1) {
            return "El nombre ingresado ya existe";
        } else {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setPrecio(precio);
            obj.setStock(stock);
            obj.setIdCategoria(new Categoria(idCat));
            obj.setRucProveedor(new Proveedor(idProv));

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(Integer id, String nombre, double precio, int stock, int idCat, int idProv, String nombreAnterior) {

        if (nombre.equals(nombreAnterior)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setPrecio(precio);
            obj.setStock(stock);
            obj.setIdCategoria(new Categoria(idCat));
            obj.setRucProveedor(new Proveedor(idProv));

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
                obj.setPrecio(precio);
                obj.setStock(stock);
                obj.setIdCategoria(new Categoria(idCat));
                obj.setRucProveedor(new Proveedor(idProv));

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
            return "Error al eliminar el registro";
        }
    }

    public DefaultComboBoxModel seleccionarCategoria() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categoria> lista = new ArrayList<>();
        lista = DATOS_CAT.listar();
        for (Categoria item : lista) {
            items.addElement(new Categoria(item.getId(), item.getNombre()));
        }
        return items;
    }

    public DefaultComboBoxModel seleccionarProveedor() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Proveedor> lista = new ArrayList<>();
        lista = DATOS_PROV.listar();
        for (Proveedor item : lista) {
            items.addElement(new Proveedor(item.getRuc(), item.getNombre()));
        }
        return items;
    }
}
