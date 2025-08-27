package practica_1.java;

public class EcuacionLineal__dos_por_dos {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public EcuacionLineal__dos_por_dos(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean tieneSolucion() {
        double solu= (this.a * this.d) - (this.b * this.c);
        if (solu != 0){
            return true;
        }else{
            return false;
        }
    }
    public double getX() {
        if(tieneSolucion()){
            return ((this.e * this.d) - (this.b * this.f)) / ((this.a * this.d) - (this.b * this.c));
        }else{
            return 0;
        }
        
    }

        public double getY() {
        if(tieneSolucion()){
            return ((this.a * this.f) - (this.e * this.c)) / ((this.a * this.d) - (this.b * this.c));
        }else{
            return 0;
        }
        
    }
    
}
