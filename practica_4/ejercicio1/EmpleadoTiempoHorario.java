package practica_4.ejercicio1;

class EmpleadoTiempoHorario extends Empleado {
    private double horas_trabajadas;
    private double tarifa_por_hora;
    
    public EmpleadoTiempoHorario(String nombre, double horas_trabajadas, double tarifa_por_hora) {
        super(nombre);
        this.horas_trabajadas = horas_trabajadas;
        this.tarifa_por_hora = tarifa_por_hora;
    }
    
    @Override
    public double CalcularSalarioMensual() {
        return horas_trabajadas * tarifa_por_hora;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Horas Trabajadas: " + horas_trabajadas + 
            ", Tarifa por Hora: " + tarifa_por_hora + 
            ", Salario Mensual: " + CalcularSalarioMensual();
    }
    
    public double getHorasTrabajadas() {
        return horas_trabajadas;
    }
    
    public void setHorasTrabajadas(double horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }
    
    public double getTarifaPorHora() {
        return tarifa_por_hora;
    }
    
    public void setTarifaPorHora(double tarifa_por_hora) {
        this.tarifa_por_hora = tarifa_por_hora;
    }
}
