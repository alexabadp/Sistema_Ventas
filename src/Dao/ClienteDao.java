package Dao;

import Entidades.Interfaces.metodosDao;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Acceso.ConexionMySQL;
import javax.swing.JOptionPane;

public class ClienteDao implements metodosDao<Cliente> {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;


    private boolean resp;
    private Cliente cliente;
    
    Cliente cliTemp;
    List<Cliente> registrosTemp = new ArrayList<>();

    public ClienteDao() {

        cn = ConexionMySQL.MyConexion();
        cargarLista();
    }
    
    private void cargarLista(){
        try {
            pt = cn.prepareStatement("SELECT * FROM cliente");
            rs = pt.executeQuery();
            
            while(rs.next()){
                cliTemp = new Cliente();
                cliTemp.setRuc(rs.getInt("rucCliente"));
                cliTemp.setNombre(rs.getString("nombre"));
                cliTemp.setTelefono(rs.getInt("telefono"));
                cliTemp.setDireccion(rs.getString("direccion"));
                registrosTemp.add(cliTemp);               
            }
            
            rs.close();
            pt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Cliente: " + e.getMessage());
        }
    }

    @Override
    public List listar() {
        List<Cliente> registros = new ArrayList<>();
        try {

            pt = cn.prepareStatement("SELECT * FROM cliente");
            rs = pt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setRuc(rs.getInt("rucCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                registros.add(cliente);

            }
            rs.close();
            pt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Clientes");
        }
        return registros;
    }

    @Override
    public boolean insertar(Cliente obj) {
        resp = false;
        try {
            pt = cn.prepareStatement("INSERT INTO cliente values(?,?,?,?)");
            pt.setInt(1, obj.getRuc());
            pt.setString(2, obj.getNombre());
            pt.setInt(3, obj.getTelefono());
            pt.setString(4, obj.getDireccion());

            pt.executeUpdate();

            resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Cliente");
        }
        return resp;

    }

    @Override
    public boolean actualizar(Cliente obj) {
        resp = false;

        try {

            pt = cn.prepareStatement("UPDATE cliente SET nombre=?, telefono=?, direccion=? WHERE rucCliente=?");

            pt.setString(1, obj.getNombre());
            pt.setInt(2, obj.getTelefono());
            pt.setString(3, obj.getDireccion());
            pt.setInt(4, obj.getRuc());

            pt.execute();
            rs.close();
            resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Cliente");
        }
        return resp;
    }

    @Override
    public boolean eliminar(int ruc) {
        resp = false;
        try {
            pt = cn.prepareStatement("DELETE FROM cliente WHERE rucCliente=(?)");
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
            pt = cn.prepareStatement("SELECT * FROM cliente WHERE rucCliente = (?)");
            pt.setInt(1, ruc);
            rs = pt.executeQuery();

            while (rs.next()) {
                cliente.setRuc(rs.getInt("rucCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));

                if (cliente.getRuc() == ruc) {
                    return cliente.getRuc();
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
            pt = cn.prepareStatement("SELECT * FROM cliente WHERE nombre = (?)");
            pt.setString(1, nombre);
            rs = pt.executeQuery();

            while (rs.next()) {
                cliente.setRuc(rs.getInt("rucCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setDireccion(rs.getString("direccion"));

                if (cliente.getNombre().equals(nombre)) {
                    return cliente.getRuc();
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
    public Cliente getObjeto(int rucCliente) {
        for (Cliente cli : registrosTemp) {
            if (cli.getRuc() == rucCliente) {
                return cli;
            }
        }
        return null;
    }

}
