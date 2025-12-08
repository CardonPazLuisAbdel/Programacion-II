package Hospital;

import com.google.gson.Gson;

public class Medico {
	private int idMed;
	private String nombreMed;
	private String apellidoMed;
	private String aniosExperiencia;
	
	
	public Medico(int idMed, String nombreMed, String apellidoMed, String especialidad) {
		super();
		this.idMed = idMed;
		this.nombreMed = nombreMed;
		this.apellidoMed = apellidoMed;
		this.aniosExperiencia = especialidad;
	}
	
	//Alta
	public String altaMedico() {
		try {
			Gson gson = new Gson();
			String medicoJson = gson.toJson(this);
			System.out.println("Medico dado de alta con exito");
			return medicoJson;
		} catch (Exception e) {
			System.out.println("Error al dar de alte al medico " + e);	
			return null;
		}

	}
	
	// BAJA
	public String bajaMedico() {
		try {
			Gson gson = new Gson();
			String medicoJson = gson.toJson(this);
			System.out.println("Medico dado de baja con exito");
			return medicoJson;
		} catch (Exception e) {
			System.out.println("Error al dar de baja al medico " + e);	
			return null;
		}

	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public String getNombreMed() {
		return nombreMed;
	}

	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}

	public String getApellidoMed() {
		return apellidoMed;
	}

	public void setApellidoMed(String apellidoMed) {
		this.apellidoMed = apellidoMed;
	}

	public String getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	
	
}
