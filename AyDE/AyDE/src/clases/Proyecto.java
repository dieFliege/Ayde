package clases;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String nombre;
	private Desarrolladores empleado;
	List<Desarrolladores> listaDesarrolladores = new ArrayList<Desarrolladores>();
	
	public Proyecto(String nombre){
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int calcularCostoSemanal(int salario) {
		return (int) ((salario*13/12)*1.3)/4;
	}
	
	public int calcularCostoProyecto(){
		int total = 0;
		for(int i = 0; i< listaDesarrolladores.size(); i++){
			total += empleado.getDedicacionMensual() * this.calcularCostoSemanal(empleado.getSalario());
		}
		
		return total;
	}
	
	public void agregarDesarrollador(Desarrolladores desarrollador){
		listaDesarrolladores.add(desarrollador);
		
	}


}
