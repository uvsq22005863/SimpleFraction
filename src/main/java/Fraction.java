public class Fraction {
    private int num;
    private int den;

    public Fraction (int num, int den){
        this.num = num;
        this.den = den;
    }

    @Override
    public String toString() {
        return num + "/" + den ;
    }
}
