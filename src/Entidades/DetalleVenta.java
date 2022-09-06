package Entidades;

import java.util.List;

public class DetalleVenta {

    private int id;
    private double precio;
    private int cantidad;
    private int idVenta;
    private Producto idProducto;
    //private List<DetalleVenta> detalles;

    public DetalleVenta() {
    }

    public DetalleVenta(int id) {
        this.id = id;
    }

    public DetalleVenta(int id, double precio, int cantidad, int idVenta, Producto idProducto) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }

    public DetalleVenta(double precio, int cantidad, int idVenta, Producto idProducto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }

    public DetalleVenta(int id, double precio, int cantidad, int idVenta, Producto idProducto, List<DetalleVenta> detalles) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        //this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    //public List<DetalleVenta> getDetalles() {
    //    return detalles;
    //}
    //public void setDetalles(List<DetalleVenta> detalles) {
    //    this.detalles = detalles;
    //}
}
