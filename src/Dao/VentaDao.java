package Dao;

import Acceso.ConexionMySQL;
import Entidades.Cliente;
import Entidades.Venta;
import Entidades.Interfaces.metodosDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;

public class VentaDao implements metodosDao<Venta> {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    private boolean resp;
    private Venta venta;
    private final ClienteDao DATOS;

    public VentaDao() {

        cn = ConexionMySQL.MyConexion();
        DATOS = new ClienteDao();

    }

    public boolean anular(Venta obj) {
        resp = false;

        try {
            pt = cn.prepareStatement("UPDATE venta SET estado = ? WHERE idVenta = ?");
            pt.setString(1, obj.getEstado());
            pt.setInt(2, obj.getId());

            pt.execute();

            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al anular Ventas" + e.getMessage());
        }
        return resp;
    }

    @Override
    public List listar() {

        List<Venta> registros = new ArrayList<>();
        try {
            pt = cn.prepareStatement("SELECT * FROM venta");
            rs = pt.executeQuery();

            while (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("idVenta"));
                venta.setFecha(rs.getString("fecha"));
                venta.setDescuento(rs.getDouble("descuento"));
                venta.setTotal(rs.getDouble("total"));
                venta.setEstado(rs.getString("estado"));

                int rucCliente = rs.getInt("rucCliente");

                Cliente cli = DATOS.getObjeto(rucCliente);

                venta.setRucCliente(cli);

                registros.add(venta);
            }
        } catch (SQLException e) {
        }

        return registros;
    }

    @Override
    public boolean insertar(Venta obj) {

        resp = true;
        try {
            pt = cn.prepareStatement("INSERT INTO venta VALUES(?,?,?,?,?,?) ");
            pt.setInt(1, obj.getId());
            pt.setString(2, obj.getFecha());
            pt.setDouble(3, obj.getDescuento());
            pt.setDouble(4, obj.getTotal());
            pt.setString(5, obj.getEstado());
            pt.setInt(6, obj.getRucCliente().getRuc());

            pt.executeUpdate();

            resp = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar Venta");
        }
        return resp;
    }

    @Override
    public boolean actualizar(Venta obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int ruc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int buscarCodigo(int idVenta) {
        try {
            pt = cn.prepareStatement("SELECT * FROM venta WHERE idVenta = ?");
            pt.setInt(1, idVenta);
            rs = pt.executeQuery();
            
            while (rs.next()) {                
                venta.setId(rs.getInt("idVenta"));
                
                if (venta.getId() == idVenta) {
                    return venta.getId();
                }
            }
            pt.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Error al consultar el codigo");
        }
        return -1;
    }

    @Override
    public int buscarNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta getObjeto(int codigo) {

        Venta vent = null;

        return vent;
    }

}
