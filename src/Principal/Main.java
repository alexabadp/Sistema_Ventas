package Principal;

import Controladores.ControlFrmCategoria;
import Controladores.ControlFrmCliente;
import Controladores.ControlFrmMenu;
import Controladores.ControlFrmProducto;
import Controladores.ControlFrmProveedor;
import Controladores.ControlFrmVenta;
import Vista.*;

public class Main {

    public static FrmCategoria FCategoria;
    public static ControlFrmCategoria ControlFCategoria;
    
    public static FrmCliente FCliente;
    public static ControlFrmCliente ControlFCliente;
    
    public static FrmProducto FProducto;
    public static ControlFrmProducto ControlFProducto;
    
    public static FrmProveedor FProveedor;
    public static ControlFrmProveedor ControlFProveedor;
    
    public static FrmVenta FVenta;
    public static ControlFrmVenta ControlFVenta;
    
    public static Menu FMenu;
    public static ControlFrmMenu ControlFMenu;
    
    
    public static void main(String[] args) {

//        Menu menu = new Menu();
//        menu.setVisible(true);
//        menu.setTitle("Ventas de Vinos");
//        menu.setLocationRelativeTo(null);
        FMenu = new Menu();
        ControlFMenu = new ControlFrmMenu(FMenu);
        

    }

}
