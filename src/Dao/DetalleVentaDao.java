package Dao;

//import Acceso.Acceso;
import Acceso.ConexionMySQL;
import Entidades.DetalleVenta;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;

public class DetalleVentaDao {

    private Connection cn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    private boolean resp;
    private DetalleVenta detallesVenta;
    private final ProductoDao DATOS_PROD;

    public DetalleVentaDao() {

        cn = ConexionMySQL.MyConexion();

        DATOS_PROD = new ProductoDao();
        detallesVenta = new DetalleVenta();
    }

    public List listarDetalles(int idVenta) {
        List<DetalleVenta> registros = new ArrayList<>();

        try {
            pt = cn.prepareStatement("SELECT * FROM detalleventa WHERE idVenta = ?");
            pt.setInt(1, idVenta);
            rs = pt.executeQuery();

            while (rs.next()) {
                detallesVenta = new DetalleVenta();

                int idProducto = rs.getInt("idProducto");
                Producto prod = DATOS_PROD.getObjeto(idProducto);
                detallesVenta.setIdProducto(prod);
                detallesVenta.setPrecio(rs.getDouble("precio"));
                detallesVenta.setCantidad(rs.getInt("cantidad"));

                registros.add(detallesVenta);

            }
            rs.close();
            pt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Detalle de Venta: " + e.getMessage());
        }
        return registros;
    }

    public boolean insertar(DetalleVenta obj) {
        resp = true;

        try {
            JOptionPane.showMessageDialog(null, "iDVENTA "+obj.getIdVenta());
            pt = cn.prepareStatement("INSERT INTO detalleventa values(?,?,?,?)");
            pt.setInt(1, obj.getIdVenta());
            pt.setInt(2, obj.getIdProducto().getId());
            pt.setDouble(3, obj.getPrecio());
            pt.setInt(4, obj.getCantidad());
            pt.executeUpdate();

            resp = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Venta"+e);
        }

        return resp;
    }

}
