package Vendedor;
import java.util.Scanner;
public class Vendedor {
    

    Scanner sc = new Scanner(System.in);

    int Venta;
    int i=1;
    int promedio;
    int total;
    int ventaS;
    int VentaM;
    
    public void PedirVenta() {
    while(i<=5){
    System.out.print("\n Ingrese la Venta "+i+"\n");
    Venta = sc.nextInt();
    total=total+Venta;
    if (Venta>=350) {
    ventaS=ventaS+Venta;
    }
    else
    VentaM=VentaM+Venta;
    i=i+1;
    }
    }
    
    public void Promedio() {
    promedio=total/i;
    }
    public void MostrarVentas() {
    System.out.print("Promedio Toltal de Ventas :"+" "+promedio+"$\n");
    System.out.print("Toltal de Ventas :"+" "+total+"$\n");
    System.out.print("Toltal de Ventas Menor a 350 :"+" "+VentaM+"$\n");
    System.out.print("Toltal de Ventas Mayor a 350 :"+" "+ventaS+"$\n");
    }
    }

