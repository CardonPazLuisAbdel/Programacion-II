package Hospital;

import com.google.gson.Gson;

public class Consulta {
	private int ci;
	private String nombrePaciente;
	private String apellidoPaciente;
	private int idMed;
	private int dia;
	private int mes;
	private int anio;
	
	
	public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMed, int dia, int mes, int anio) {
		super();
		this.ci = ci;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.idMed = idMed;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	//a) Alta
	public String altaConsulta() {
		try {
			Gson gson = new Gson();
			String consultaJson = gson.toJson(this);
			System.out.println("Consulta dada de alta con exito");
			return consultaJson;
		} catch (Exception e) {
			System.out.println("Error al dar de alta a la consulta " + e);	
			return null;
		}

	}
	
	// C) cambiar
	public String cambiarFechaConsulta(int nuevoDia, int nuevoMes, int nuevoAnio) {
		try {
			this.dia = nuevoDia;
			this.mes = nuevoMes;
			this.anio = nuevoAnio;
			Gson gson = new Gson();
			String consultaJson = gson.toJson(this);
			System.out.println("Fecha de la consulta cambiada con exito");
			return consultaJson;
		} catch (Exception e) {
			System.out.println("Error al cambiar la fecha de la consulta " + e);	
			return null;
		}

	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
