package Entidades;

import java.util.List;

public class Venta {

    private int id;
    private String fecha;
    private double descuento;
    private double total;
    private String estado;
    private Cliente rucCliente;
    private List<DetalleVenta> detalles;

    public Venta() {
    }

    public Venta(int id) {
        this.id = id;
    }

    public Venta(int id, String fecha, double descuento, double total, String estado, Cliente rucCliente) {
        this.id = id;
        this.fecha = fecha;
        this.descuento = descuento;
        this.rucCliente = rucCliente;
        this.total = total;
        this.estado = estado;
    }

    public Venta(int id, String fecha, double descuento, double total, String estado, Cliente rucCliente, List<DetalleVenta> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.descuento = descuento;
        this.rucCliente = rucCliente;
        this.total = total;
        this.estado = estado;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(Cliente rucCliente) {
        this.rucCliente = rucCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

}
