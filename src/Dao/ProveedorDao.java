package Dao;

import Entidades.Proveedor;
import Entidades.Interfaces.metodosDao;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Acceso.ConexionMySQL;
import javax.swing.JOptionPane;

public class ProveedorDao implements metodosDao<Proveedor> {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    private boolean resp;
    private Proveedor proveedor;

    Proveedor catTemp;                                // PARA OBTENER LOS OBJETOS
    List<Proveedor> registrosTemp = new ArrayList<>();// PARA OBTENER LOS OBJETOS

    public ProveedorDao() {

        cn = ConexionMySQL.MyConexion();
        cargarLista();

    }

    private void cargarLista() {

        try {

            pt = cn.prepareStatement("SELECT * FROM Proveedor");
            rs = pt.executeQuery();

            while (rs.next()) {
                catTemp = new Proveedor();
                catTemp.setRuc(rs.getInt("rucProveedor"));
                catTemp.setNombre(rs.getString("nombre"));
                catTemp.setTelefono(rs.getInt("telefono"));
                catTemp.setDireccion(rs.getString("direccion"));
                catTemp.setPaginaWeb(rs.getString("paginaWeb"));
                registrosTemp.add(catTemp);
            }

            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Proveedores: " + e.getMessage());
        }

    }

    @Override
    public List<Proveedor> listar() {
        List<Proveedor> registros = new ArrayList<>();
        try {
            pt = cn.prepareStatement("SELECT * FROM proveedor");
            rs = pt.executeQuery();

            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setRuc(rs.getInt("rucProveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setPaginaWeb(rs.getString("paginaWeb"));
                registros.add(proveedor);
            }
            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Clientes");
        }
        return registros;
    }

    @Override
    public boolean insertar(Proveedor obj) {
        resp = false;
        //int idCliente = 0;
        try {
            pt = cn.prepareStatement("INSERT INTO Proveedor values(?,?,?,?,?)");
            pt.setInt(1, obj.getRuc());
            pt.setString(2, obj.getNombre());
            pt.setInt(3, obj.getTelefono());
            pt.setString(4, obj.getDireccion());
            pt.setString(5, obj.getPaginaWeb());
            pt.executeUpdate();

            resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Proveedor");
        }
        return resp;
    }

    @Override
    public boolean actualizar(Proveedor obj) {
        resp = false;

        try {

            pt = cn.prepareStatement("UPDATE proveedor SET nombre=?, telefono=?, direccion=?, paginaWeb=? WHERE rucProveedor=?");
            pt.setString(1, obj.getNombre());
            pt.setInt(2, obj.getTelefono());
            pt.setString(3, obj.getDireccion());
            pt.setString(4, obj.getPaginaWeb());
            pt.setInt(5, obj.getRuc());
            pt.execute();
            rs.close();
            resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Proveedor");
        }
        return resp;
    }

    @Override
    public boolean eliminar(int ruc) {
        resp = false;
        try {
            pt = cn.prepareStatement("DELETE FROM proveedor WHERE rucProveedor=(?)");
            pt.setInt(1, ruc);

            pt.execute();
            pt.close();
            resp = true;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar registro");
        }
        return resp;
    }

    @Override
    public int buscarCodigo(int ruc) {
        try {
            pt = cn.prepareStatement("SELECT * FROM proveedor WHERE rucProveedor = (?)");
            pt.setInt(1, ruc);
            rs = pt.executeQuery();

            while (rs.next()) {
                proveedor.setRuc(rs.getInt("rucProveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setPaginaWeb(rs.getString("paginaWeb"));
                if (proveedor.getRuc() == ruc) {
                    return proveedor.getRuc();
                }
            }

            pt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar el código");
        }
        return -1;
    }

    @Override
    public int buscarNombre(String nombre) {
        try {
            pt = cn.prepareStatement("SELECT * FROM proveedor WHERE nombre = (?)");
            pt.setString(1, nombre);
            rs = pt.executeQuery();
            while (rs.next()) {
                proveedor.setRuc(rs.getInt("rucProveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setPaginaWeb(rs.getString("paginaWeb"));
                if (proveedor.getNombre().equals(nombre)) {
                    return proveedor.getRuc();
                }
            }
            pt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error al consultar el nombre");
        }
        return -1;
    }

    @Override
    public Proveedor getObjeto(int rucProveedor) {
        for (Proveedor cat : registrosTemp) {

            if (cat.getRuc() == rucProveedor) {
                return cat;
            }
        }

        return null;
    }

}
