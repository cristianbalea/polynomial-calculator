public class Monomial implements Comparable<Monomial> {
    private int grad;
    private float coef;

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public String toString() {
        if (this.grad == 0) {
            if (this.coef == this.coef - this.coef % 1) return String.valueOf((int) this.coef);
            else return String.valueOf(this.coef);
        } else if (this.grad == 1) {
            if (this.coef == 1f) return "x";
            else if (this.coef == -1f) return "-x";
            else if (this.coef == this.coef - this.coef % 1)
                return (int) this.coef + "*x";
            else return String.format("%.2f", this.coef) + "*x";
        } else {
            if (this.coef == 1f) return "x^" + this.grad;
            else if (this.coef == -1f) return "-x^" + this.grad;
            else if (this.coef == this.coef - this.coef % 1) return (int) this.coef + "*x^" + this.grad;
            else return String.format("%.2f", this.coef) + "*x^" + this.grad;
        }
    }

    @Override
    public int compareTo(Monomial o) {
        if (this.grad > o.grad) return -1;
        else if (this.grad < o.grad) return 1;
        return 0;
    }
}
