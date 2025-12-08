package Hospital;

public class Main {
	public static void main(String[] args) {
		Medico medico1 = new Medico(1, "Juan", "Perez", "Cardiologia");
		Medico medico2 = new Medico(2, "Ana", "Gomez", "Pediatria");
		Medico medico3 = new Medico(3, "Luis", "Lopez", "Dermatologia");
		Medico medico4 = new Medico(4, "Marta", "Santos", "Neurologia");
		medico1.altaMedico();
		medico2.altaMedico();
		medico3.altaMedico();
		
		Consulta consulta1 = new Consulta(12345678, "Carlos", "Ramirez", 1, 25, 12, 2023);
		Consulta consulta2 = new Consulta(87654321, "Maria", "Fernandez", 2, 1, 1, 2024);
		Consulta consulta3 = new Consulta(11223344, "Jose", "Martinez", 3, 15, 11, 2023);
		Consulta consulta4 = new Consulta(44332211, "Laura", "Gonzalez", 1, 20, 12, 2023);
		Consulta consulta5 = new Consulta(55667788, "Ana", "Lopez", 2, 5, 1, 2024);
		Consulta consulta6 = new Consulta(99887766, "Pedro", "Sanchez", 3, 10, 10, 2023);
		Consulta consulta7 = new Consulta(66778899, "Sofia", "Diaz", 1, 30, 12, 2023);
		Consulta consulta8 = new Consulta(33445566, "Diego", "Torres", 2, 2, 1, 2024);
		Consulta consulta9 = new Consulta(77889900, "Elena", "Ruiz", 3, 25, 9, 2023);
		consulta1.altaConsulta();
		consulta2.altaConsulta();
		consulta3.altaConsulta();
		consulta4.altaConsulta();
		consulta5.altaConsulta();
		consulta6.altaConsulta();
		consulta7.altaConsulta();
		consulta8.altaConsulta();
		consulta9.altaConsulta();
		
		consulta1.cambiarFechaConsulta(27, 12, 2023);
		consulta2.cambiarFechaConsulta(3, 1, 2024);
		medico4.bajaMedico();
		
		
		
		
    }
}
