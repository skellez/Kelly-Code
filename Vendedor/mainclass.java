package Vendedor;


public class mainclass {

    public static void main(String[]args){

        Vendedor vendedor1 = new Vendedor();
        Vendedor vendedor2 = new Vendedor();
        System.out.print("\n Ventas Para el Vendedor 1 \n");
        vendedor1.PedirVenta();
        System.out.print("\n Ventas Para el Vendedor 2 \n");
        vendedor2.PedirVenta();
        vendedor1.Promedio();
        vendedor2.Promedio();
        System.out.print("\n Mostrando Ventas Para el Vendedor 1 \n");
        vendedor1.MostrarVentas();
        System.out.print("\n Mostrando Ventas Para el Vendedor 2 \n");
        vendedor2.MostrarVentas();
        }  
}


