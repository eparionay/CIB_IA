package configuracion;

import data.Datos;

public class Probar {

	public static void main(String[] args) {
	
		
		double []  arr_menor = new double[5];
		arr_menor[0] = Datos.precio0;
		arr_menor[1] = Datos.precio1;
		arr_menor[2] = Datos.precio2;
		arr_menor[3] = Datos.precio3;
		arr_menor[4] = Datos.precio4;
		double menor= arr_menor[0];
		for(int i=0; i<arr_menor.length;i++) {
			System.out.println(menor + "-" + arr_menor[i]);
			if(menor>arr_menor[i]) {
				menor= arr_menor[i];
			}
		}
		// TODO Auto-generated method stub
		System.out.println(menor);

	}
	

}
