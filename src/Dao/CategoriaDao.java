package Dao;

import java.sql.*;
import Acceso.ConexionMySQL;
import Entidades.Categoria;
import Entidades.Interfaces.metodosDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDao implements metodosDao<Categoria> {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    boolean resp;
    Categoria categoria;

    Categoria catTemp;                                // PARA OBTENER LOS OBJETOS
    List<Categoria> registrosTemp = new ArrayList<>();// PARA OBTENER LOS OBJETOS

    public CategoriaDao() {
        cn = ConexionMySQL.MyConexion();
        cargarLista();
    }

    private void cargarLista() {

        try {

            pt = cn.prepareStatement("SELECT * FROM categoria");
            rs = pt.executeQuery();

            while (rs.next()) {
                catTemp = new Categoria();
                catTemp.setId(rs.getInt("idCategoria"));
                catTemp.setNombre(rs.getString("nombre"));
                catTemp.setDescripcion(rs.getString("descripcion"));
                registrosTemp.add(catTemp);
            }

            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Categorias: " + e.getMessage());
        }

    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> registros = new ArrayList<>();
        try {

            pt = cn.prepareStatement("SELECT * FROM categoria");
            rs = pt.executeQuery();

            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                registros.add(categoria);
            }

            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Categorias: " + e.getMessage());
        }
        return registros;
    }

    @Override
    public boolean insertar(Categoria obj) {
        resp = false;

        try {
            pt = cn.prepareStatement("INSERT INTO categoria values(?,?,?)");

            pt.setInt(1, obj.getId());
            pt.setString(2, obj.getNombre());
            pt.setString(3, obj.getDescripcion());

            pt.executeUpdate();

            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Categoria ...");
        }
        return resp;
    }

    @Override
    public boolean actualizar(Categoria obj) {
        resp = false;

        try {

            pt = cn.prepareStatement("UPDATE categoria SET nombre = ?, descripcion =? WHERE idCategoria = ?");
            pt.setString(1, obj.getNombre());
            pt.setString(2, obj.getDescripcion());
            pt.setInt(3, obj.getId());

            pt.execute();
            rs.close();
            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoria");
        }
        return resp;
    }

    @Override
    public boolean eliminar(int ruc) {
        resp = false;
        try {
            pt = cn.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
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
    public int buscarCodigo(int idCategoria) {
        try {
            pt = cn.prepareStatement("SELECT * FROM categoria WHERE idCategoria = ?");
            pt.setInt(1, idCategoria);
            rs = pt.executeQuery();

            while (rs.next()) {
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));

                if (categoria.getId() == idCategoria) {
                    return categoria.getId();
                }
            }
            pt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar codigo");
        }
        return -1;
    }

    @Override
    public int buscarNombre(String nombre) {
        try {
            pt = cn.prepareStatement("SELECT * FROM categoria WHERE nombre = ?");
            pt.setString(1, nombre);
            rs = pt.executeQuery();

            while (rs.next()) {
                categoria.setId(rs.getInt("idCliente"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));

                if (categoria.getNombre().equals(nombre)) {
                    return categoria.getId();
                }
            }
            pt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar nombre");
        }
        return -1;
    }

    @Override
    public Categoria getObjeto(int idCategoria) {

        for (Categoria cat : registrosTemp) {

            if (cat.getId() == idCategoria) {
                return cat;
            }
        }

        return null;
    }

}
