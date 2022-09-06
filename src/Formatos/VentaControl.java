package Formatos;

import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import Dao.ClienteDao;
import Dao.DetalleVentaDao;
import Dao.ProductoDao;
import Dao.VentaDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class VentaControl {

    private final VentaDao DATOS;
    private final ClienteDao DATOSCLI;
    private final ProductoDao DATOSPROD;
    private final DetalleVentaDao DATOS_DET;
    private final Venta obj;
    private final DetalleVenta objDetalle;
    private DefaultTableModel modeloTabla;

    public VentaControl() {
        this.DATOS = new VentaDao();
        DATOSCLI = new ClienteDao();
        DATOSPROD = new ProductoDao();
        DATOS_DET = new DetalleVentaDao();
        this.obj = new Venta();
        this.objDetalle = new DetalleVenta();
    }

    public DefaultTableModel listar() {
        String[] titulos = {"ID", "FECHA", "DESCUENTO", "ID CLIENTE", "CLIENTE", "TOTAL", "ESTADO"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[7];
        List<Venta> lista = DATOS.listar();
        for (Venta item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getFecha();
            registro[2] = Double.toString(item.getDescuento());
            registro[3] = Integer.toString(item.getRucCliente().getRuc());
            registro[4] = item.getRucCliente().getNombre();
            registro[5] = Double.toString(item.getTotal());

            if (item.getEstado().equals("true")) {
                registro[6] = "Activo";
            } else {
                registro[6] = "Anulado";
            }

            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listarDetalles(int idVenta) {
        String[] titulos = {"ID PRODUCTO", "PRODUCTO", "STOCK", "CANTIDAD", "PRECIO", "SUBTOTAL"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[6];
        List<DetalleVenta> lista = DATOS_DET.listarDetalles(idVenta);
        for (DetalleVenta item : lista) {

            registro[0] = Integer.toString(item.getIdProducto().getId());
            registro[1] = item.getIdProducto().getNombre();
            registro[2] = Integer.toString(item.getIdProducto().getStock());
            registro[3] = Integer.toString(item.getCantidad());
            registro[4] = Double.toString(item.getPrecio());
            registro[5] = Double.toString(item.getCantidad() * item.getPrecio());

            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Integer idVenta, String fecha, double descuento, double total, int rucCliente, DefaultTableModel modeloDetalles) {
         String respuesta;
        if (DATOS.buscarCodigo(idVenta) != -1) {
            return "El ID ingresado ya existe";
        } else {
            obj.setId(idVenta);
            obj.setFecha(fecha);
            obj.setDescuento(descuento);
            obj.setTotal(total - descuento);
            obj.setEstado("true");
            obj.setRucCliente(new Cliente(rucCliente));

            List<DetalleVenta> listaDetalles = new ArrayList<>();
            int idProducto;
            int cantidad;
            double precio;

            Boolean resp = true;
            if (DATOS.insertar(obj) == resp) {
                respuesta="OK";
            } else {
               respuesta="Error en el registro";
            }
            for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
                idProducto = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));
                cantidad = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 3)));
                precio = Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 4)));

                objDetalle.setId(2);
                objDetalle.setPrecio(precio);
                objDetalle.setCantidad(cantidad);
                objDetalle.setIdVenta(idVenta);
                objDetalle.setIdProducto(new Producto(idProducto));

                resp = DATOS_DET.insertar(objDetalle);

            }

            obj.setDetalles(listaDetalles);
           
            
        }
        return respuesta;
    }

//    public String insertarDetalle(Integer idVenta, DefaultTableModel modeloDetalles) {
//        List<DetalleVenta> listaDetalles = new ArrayList<>();
//        int idProducto;
//        int cantidad;
//        double precio;
//
//        Boolean resp = false;
//
//        for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
//
//            idProducto = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));
//            cantidad = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 3)));
//            precio = Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 4)));
//
//            objDetalle.setId(2);
//            objDetalle.setPrecio(precio);
//            objDetalle.setCantidad(cantidad);
//            objDetalle.setIdVenta(idVenta);
//            objDetalle.setIdProducto(new Producto(idProducto));
//
//            resp = DATOS_DET.insertar(objDetalle);
//
//        }
//        if (resp) {
//            return "OK";
//        } else {
//            return "Error en el registro";
//        }
//
//    }
    public int claveGenerar() {
        int min = 1000;
        int max = 9999;
        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        return value;
    }

    public String anular(Integer id, String fecha, double descuento, double total, int rucCliente) {
        obj.setId(id);
        obj.setFecha(fecha);
        obj.setDescuento(descuento);
        obj.setRucCliente(new Cliente(rucCliente));
        obj.setTotal(total - descuento);
        obj.setEstado("false");

        if (DATOS.anular(obj)) {
            return "OK";
        } else {
            return "Error al anular Venta";
        }
    }

    public DefaultComboBoxModel seleccionarCliente() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Cliente> lista = new ArrayList<>();
        lista = DATOSCLI.listar();
        for (Cliente item : lista) {
            items.addElement(new Cliente(item.getRuc(), item.getNombre()));
        }
        return items;
    }

    public DefaultComboBoxModel seleccionarProducto() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Producto> lista = new ArrayList<>();
        lista = DATOSPROD.listar();
        for (Producto item : lista) {
            items.addElement(new Producto(item.getId(), item.getNombre(), item.getPrecio(), item.getStock()));
        }
        return items;
    }
}
