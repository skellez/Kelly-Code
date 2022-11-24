package testthingy;
/* La administracion de una compañia quiere conocer el ausentismo registrado en cada uno de los 3 departamentos que tiene la empresa para los doce meses del a�o.  Para ello se requiere registrar las ausencias para cada departamento.
Usted debe construir un programa que contenga un men� y que utilice arreglos bidimensionales para guardar la informaci�n de las ausencias por departamentos y mes.  Adem�s, el programa debe proporcionar las siguientes consultas:
�	El promedio de ausencias para el a�o.
�	El departamento que present� mayor n�mero de ausencias en el a�o.
�	Porcentaje de ausencias obtenidas en los dos semestres del a�o.
*/


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Ausencias {

	   private String [] array_meses= new String [12];
	   private String [] array_departamento = new String [3];
	   private int [][] array_ausencia = new int [3][12];
	   private static final DecimalFormat df = new DecimalFormat("0.00");
	   

	   
	   
	public void setArray_meses(String[] array_meses) {
		this.array_meses = array_meses;
	}
	public String[] getArray_departamento() {
		return array_departamento;
	}
	public void setArray_departamento(String[] array_departamento) {
		this.array_departamento = array_departamento;
	}
	public void setArray_ausencia(int[][] array_ausencia) {
		this.array_ausencia = array_ausencia;
	}
	
	// SE CALCULA EL PROMEDIO DE AUSENCIAS ANUAL POR DEPARTAMENTO
	public float calcularPromedio(){
	    float promedio=0;
		int i,j;
		int [] array_aux = new int [3];
		
		array_aux = totalDepto();
		
		for(i=0;i<array_aux.length;i++)
	    {
			promedio = promedio + array_aux[i];
				
	   }
		  promedio = promedio/this.array_departamento.length;
		  
		  return promedio;
		}
	
	//SE CALCULA EL PORCENTAJE POR SEMESTRE
	public float [] calcularPorcentaje(){
	    float semestre1 = 0, semestre2 = 0;
		int i,j, total = 0;
		int [] array_aux = new int [12];
		float [] array_aux1 = new float [2];
		
		
		array_aux = totalMes();
		
		//Se obtiene la sumatoria del arreglo
		
		total = Arrays.stream(array_aux).sum();
		
				
		for(i=0;i<6;i++)
	    {
			semestre1 = semestre1 + array_aux[i];		
	    }	
			   
	
		for(;i<12;i++)
	    {
			semestre2 = semestre2 + array_aux[i];			
			
	    }	
		
		    semestre1 = (semestre1/total) * 100;
		    semestre2 = (semestre2/total) * 100;
		    array_aux1[0]= semestre1;
			array_aux1[1]= semestre2;
	   
			
		  
		  return array_aux1;
		}
	
	//GENERA EL ARREGLO CON LOS TOTALES POR DEPARTAMENTO
	public int [] totalDepto(){
	   int  suma=0;
	   int i,j;
	   int [] array_aux = new int [3];
		   
		for(i=0;i<array_departamento.length;i++)
	    {
			for(j=0;j<array_meses.length;j++) {
				
			   suma = suma + array_ausencia[i][j];	     
		   }
			
		    array_aux[i]= suma;
		    suma = 0;
			
	    }
	      System.out.println(Arrays.toString(array_aux));
		  
		  return array_aux;
		}
	
	//GENERA EL ARREGLO CON TOTALES POR MES
	 public int [] totalMes(){
		   int  suma=0;
		   int i,j;
		   int [] array_aux = new int[12];
			   
			for(i=0;i<array_meses.length;i++)
		    {
				for(j=0;j<array_departamento.length;j++) {
					
				   suma = suma + array_ausencia[j][i];	     
			   }
				
			    array_aux[i]= suma;
			    suma = 0;
				
		    }
		      System.out.println(Arrays.toString(array_aux));
			  
			  return array_aux;
			}
	
    //SE BUSCA EL DEPARTAMENTO CON MAYOR NUMERO DE AUSENCIAS
	public String[]  masAusencias(){
	 
		int i,j=0,mayor=0, suma=0;
		   
		int [] array_aux = new int [3];
		String [] array_aux2 = new String [3];
		
		  array_aux=totalDepto();
		  
		  //mayor = array_aux[0];
		  for(i=0;i<array_aux.length;i++)
		    {
			  if (array_aux[i] >= mayor){
				  mayor = array_aux[i];
				  
				  array_aux2[j]= array_departamento[i];
				    j = j + 1;
			  }
		    }
		  return array_aux2;
		}
	
	
	public int menu()
	   {
	   	 int opcion; 
	   	 Scanner sc = new Scanner (System.in);
	   	 System.out.println("***************EMPRESA XYZ***************");
	   	 System.out.println("1.  Ingresar Datos");
	   	 System.out.println("2.  Promedio de Ausencias Anual");
	   	 System.out.println("3.  Departamento con mayor numero de ausencias");
	   	 System.out.println("4.  Porcentaje de ausencias obtenidas en los dos semestres del a�o");
	   	 System.out.println("5.  Salir");
	   	 System.out.println("\n\nSeleccione una opcion:");
	   	 opcion = sc.nextInt();
	   	 return opcion;
	   }	
	public void ingresarDatos()
	   {
	   	String nombre;
	   	int i, j;
		int ausencia;
	   	String [] array_depto = new String [3];
	   	String [] array_meses = new String [12];
	    int  [][] array_ausencias = new int[3][12];
	   	
	       Scanner sc = new Scanner (System.in);
	       for (i=0; i<3; i=i+1)
	       {
	       	 System.out.println("Ingrese el nombre del departamento:");   
	            nombre = sc.next();
	            array_depto[i]= nombre;
	                  
	        }
	       
	       for (i=0; i<12; i=i+1)
	       {
	       	 System.out.printf("Ingrese el nombre del mes %d:\n",i+1);   
	            nombre = sc.next();
	            array_meses[i]= nombre;
	                  
	        }
	   //Se carga la matriz de Ausencias
	       
	   for (i=0; i<3; i=i+1)
	   {     
		  for (j=0; j<12; j=j+1)
	      {
	    	   
	       	   System.out.println("Ingrese la cantidad de ausencias de " + array_depto[i] + " en el mes de " + array_meses[j]);   
	       	   array_ausencias[i][j]= sc.nextInt();
	           
	                  
	        }
	   }
	       setArray_departamento(array_depto);
	       setArray_meses(array_meses);
	       setArray_ausencia(array_ausencias);
	       
	       //VERIFICAR SI SE CARGAN LOS ARREGLOS
	       System.out.println(Arrays.toString(array_meses));
	       System.out.println(Arrays.toString(array_depto));
	       System.out.println(Arrays.deepToString(array_ausencias));
	       
	      
	   }
	   
  
	    
	public static void main(String[] args) {
		
		String [] deptos = new String [3];
		float [] porcentajes = new float [2];
		int opcion = 0, i;
		
		Ausencias au = new Ausencias();
		
		while (opcion < 5)
		{ 		
			opcion = au.menu();
			switch(opcion) 
		   {
			case 1:
				au.ingresarDatos();		
				break;
			case 2:
				System.out.println("El promedio de las ausencias anual es:"+ df.format(au.calcularPromedio()));
			    break;
			case 3:
				au.totalDepto();
				deptos= au.masAusencias();
				System.out.println("Departamentos con mas Ausencias");
				
				for (i=0; i< deptos.length; i++) {
					if (deptos[i] != null) {

    				System.out.println(deptos[i]);
				}
				}
				
				System.out.println(Arrays.toString(deptos));
				break;
			case 4:			
				  porcentajes = au.calcularPorcentaje();
				  System.out.println("Porcentaje de Ausencias");
				  for (i=0; i< porcentajes.length; i++) {
    				            System.out.println(df.format(porcentajes[i]) + '%');
				   }					
				break;
			case 5:
				System.exit(0);
				
			}
		}
	
	}

}
