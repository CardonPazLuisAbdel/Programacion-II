package practica_4.ejercicio1;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        
        System.out.println("=== INGRESO DE EMPLEADOS ===");
        
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEmpleado Tiempo Completo #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Salario Anual: ");
            double salarioAnual = leer.nextDouble();
            leer.nextLine();
            
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }
        
        for (int i = 3; i < 5; i++) {
            System.out.println("\nEmpleado Tiempo Horario #" + (i - 2));
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Horas Trabajadas: ");
            double horas = leer.nextDouble();
            System.out.print("Tarifa por Hora: ");
            double tarifa = leer.nextDouble();
            leer.nextLine();
            
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }
        
        System.out.println("\n=== INFORMACIÓN DE EMPLEADOS ===");
        for (Empleado emp : empleados) {
            System.out.println("Nombre: " + emp.getNombre() + 
                            ", Salario Mensual: " + emp.CalcularSalarioMensual());
        }
        
        leer.close();
    }
}
