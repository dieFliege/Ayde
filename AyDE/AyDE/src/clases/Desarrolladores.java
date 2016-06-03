package clases;

public class Desarrolladores extends Usuarios {
	private int legajo;
	private int salario;
	private int dedicacion;

	public Desarrolladores(String nombre, String apellido) {
		super(nombre, apellido);
		
	}
	public Desarrolladores(String nombre, String apellido, int legajo){
		super(nombre, apellido);
		this.setLegajo(legajo);	
	}

	public int getLegajo() {
		return legajo;
	}

	private void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public int getSalario() {
		return salario;
	}

	public void ingresarSalario(int salario) {
		this.salario = salario;
	}
	
	public int getDedicacionMensual() {
		return dedicacion;
	}
	public void setDedicacion(int dedicacion) {
		this.dedicacion = dedicacion;
	}
	
	
	
}
