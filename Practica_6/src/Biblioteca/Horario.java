package Biblioteca;

public class Horario {
    private String diaApertura;
    private String horaApertura;
    private String horaCierre;
    
    public Horario() {}
    
    public Horario(String diaApertura, String horaApertura, String horaCierre) {
        this.diaApertura = diaApertura;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    public String getDiaApertura() { return diaApertura; }
    public void setDiaApertura(String diaApertura) { this.diaApertura = diaApertura; }
    
    public String getHoraApertura() { return horaApertura; }
    public void setHoraApertura(String horaApertura) { this.horaApertura = horaApertura; }
    
    public String getHoraCierre() { return horaCierre; }
    public void setHoraCierre(String horaCierre) { this.horaCierre = horaCierre; }
    
    @Override
    public String toString() {
        return diaApertura + " de " + horaApertura + " a " + horaCierre;
    }
}
