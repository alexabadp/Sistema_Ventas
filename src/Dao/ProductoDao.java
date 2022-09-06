package Dao;

import Entidades.Interfaces.metodosDao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Acceso.ConexionMySQL;
import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Proveedor;
import javax.swing.JOptionPane;

public class ProductoDao implements metodosDao<Producto> {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    private boolean resp;
    private Producto producto;
    private final CategoriaDao DATOS;
    private final ProveedorDao DATOS_PROV;

    Producto prodTemp;
    List<Producto> registrosTemp = new ArrayList<>();

    public ProductoDao() {

        cn = ConexionMySQL.MyConexion();
        DATOS = new CategoriaDao();
        DATOS_PROV = new ProveedorDao();
        cargarLista();
    }

    private void cargarLista() {
        try {
            pt = cn.prepareStatement("SELECT * FROM producto");
            rs = pt.executeQuery();

            while (rs.next()) {
                prodTemp = new Producto();
                prodTemp.setId(rs.getInt("idProducto"));
                prodTemp.setNombre(rs.getString("nombre"));
                prodTemp.setPrecio(rs.getDouble("precio"));
                prodTemp.setStock(rs.getInt("stock"));

                //producto.setCategoriaId(rs.getInt("idCategoria"));
                int idCategoria = rs.getInt("idCategoria");
                int rucProveedor = rs.getInt("rucProveedor");

                Categoria cat = DATOS.getObjeto(idCategoria);
                Proveedor prov = DATOS_PROV.getObjeto(rucProveedor);

                prodTemp.setIdCategoria(cat);
                prodTemp.setRucProveedor(prov);
                registrosTemp.add(prodTemp);
            }
            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar productos: " + e.getMessage());
        }
    }

    @Override
    public List listar() {

        List<Producto> registros = new ArrayList<>();
        try {
            pt = cn.prepareStatement("SELECT * FROM producto");
            rs = pt.executeQuery();

            while (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));

                //producto.setCategoriaId(rs.getInt("idCategoria"));
                int idCategoria = rs.getInt("idCategoria");
                int rucProveedor = rs.getInt("rucProveedor");

                Categoria cat = DATOS.getObjeto(idCategoria);
                Proveedor prov = DATOS_PROV.getObjeto(rucProveedor);

                producto.setIdCategoria(cat);
                producto.setRucProveedor(prov);
                registros.add(producto);

            }
            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Productos");
        }
        return registros;

    }

    @Override
    public boolean insertar(Producto obj) {

        resp = false;

        try {
            pt = cn.prepareStatement("INSERT INTO producto values(?,?,?,?,?,?)");
            pt.setInt(1, obj.getId());
            pt.setString(2, obj.getNombre());
            pt.setDouble(3, obj.getPrecio());
            pt.setInt(4, obj.getStock());
            pt.setInt(5, obj.getIdCategoria().getId());
            pt.setInt(6, obj.getRucProveedor().getRuc());

            pt.executeUpdate();

            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Producto");
        }
        return resp;

    }

    @Override
    public boolean actualizar(Producto obj) {

        resp = false;

        try {
            pt = cn.prepareStatement("UPDATE producto SET nombre=?, precio=?,stock=?, idCategoria=?, rucProveedor=? WHERE idProducto = ?");

            pt.setString(1, obj.getNombre());
            pt.setDouble(2, obj.getPrecio());
            pt.setInt(3, obj.getStock());
            pt.setInt(4, obj.getIdCategoria().getId());
            pt.setInt(5, obj.getRucProveedor().getRuc());
            pt.setInt(6, obj.getId());

            pt.execute();
            rs.close();
            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Producto ");
        }
        return resp;

    }

    @Override
    public boolean eliminar(int idProducto) {
        resp = false;
        try {
            pt = cn.prepareStatement("DELETE FROM producto WHERE idProducto=(?)");
            pt.setInt(1, idProducto);

            pt.execute();
            pt.close();
            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro");
        }
        return resp;
    }

    @Override
    public int buscarCodigo(int idProducto) {

        try {
            pt = cn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            pt.setInt(1, idProducto);
            rs = pt.executeQuery();

            while (rs.next()) {
                producto.setId(rs.getInt("idProducto"));

                if (producto.getId() == idProducto) {
                    return producto.getId();
                }
            }

            pt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error al consultar el Id del producto");
        }
        return -1;

    }

    @Override
    public int buscarNombre(String nombre) {
        try {
            pt = cn.prepareStatement("SELECT * FROM producto WHERE nombre = ?");
            pt.setString(1, nombre);
            rs = pt.executeQuery();

            while (rs.next()) {
                producto.setId(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));

                if (producto.getNombre().equals(nombre)) {
                    return producto.getId();
                }
            }
            pt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar el nombre del producto");
        }
        return -1;
    }

    @Override
    public Producto getObjeto(int idProducto) {

        for (Producto prod : registrosTemp) {
            if (prod.getId() == idProducto) {
                return prod;
            }
        }
        return null;
    }

}
