package clases;

import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private int id;
	ArrayList<Desarrollador> listaDesarrolladores;
	
	public Proyecto( ){
	}
	
	public Proyecto(String nombre){
		this.setNombre(nombre);
		this.setListaDesarrolladores(new ArrayList<Desarrollador>());
	}
	
	public void setListaDesarrolladores(ArrayList<Desarrollador> empleados){

		this.listaDesarrolladores = empleados;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public Integer calcularCostoProyecto(){
		Double total = 0.0;
		Desarrollador empleado;
		
		for(int i = 0; i< listaDesarrolladores.size(); i++){
			empleado = this.listaDesarrolladores.get(i);
			total += ((empleado.getDedicacionMensual()/100) * empleado.calcularCostoSemanal());
		}
		
		return (int) (Math.round(total)) ;
	}
	
	public void agregarDesarrollador(Desarrollador desarrollador){
		listaDesarrolladores.add(desarrollador);
		
	}

	public String toString(){
		return this.getNombre();
	}
	
	public boolean esCapacitacion(){
		
	return false;
	}
}
