package Controladores;

import Principal.Main;
import Vista.FrmCategoria;
import Vista.FrmCliente;
import Vista.FrmProducto;
import Vista.FrmProveedor;
import Vista.FrmVenta;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControlFrmMenu implements ActionListener {

    Menu vista;

    public ControlFrmMenu(Menu FMenu) {

        vista = FMenu;

        vista.MenuItemCategoria.addActionListener(this);
        vista.MenuItemCliente.addActionListener(this);
        vista.MenuItemProducto.addActionListener(this);
        vista.MenuItemProveedor.addActionListener(this);
        vista.MenuItemVenta.addActionListener(this);

        FMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        FMenu.setDefaultCloseOperation(FMenu.EXIT_ON_CLOSE);
        FMenu.setVisible(true);
        FMenu.setTitle("Aplicacion de Pedidos de Productos");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.MenuItemCategoria) {
            Main.FCategoria = new FrmCategoria();
            Main.ControlFCategoria = new ControlFrmCategoria(Main.FCategoria);
        }
        if (e.getSource() == vista.MenuItemCliente) {
            Main.FCliente = new FrmCliente();
            Main.ControlFCliente = new ControlFrmCliente(Main.FCliente);
        }
        if (e.getSource() == vista.MenuItemProducto) {
            Main.FProducto = new FrmProducto();
            Main.ControlFProducto = new ControlFrmProducto(Main.FProducto);
        }
        if (e.getSource() == vista.MenuItemProveedor) {
            Main.FProveedor = new FrmProveedor();
            Main.ControlFProveedor = new ControlFrmProveedor(Main.FProveedor);
        }
        if (e.getSource() == vista.MenuItemVenta) {
            Main.FVenta = new FrmVenta();
            Main.ControlFVenta = new ControlFrmVenta(Main.FVenta);
        }
    }

}
