import java.util.ArrayList;
import java.util.Collections;

public class Model {

    private Polynomial result;

    public String getResult() {
        return result.toString();
    }

    public void add(Polynomial p1, Polynomial p2) {
        p1.compress();
        p2.compress();
        ArrayList<Monomial> l1 = p1.getMonomialList();
        ArrayList<Monomial> l2 = p2.getMonomialList();
        ArrayList<Monomial> toRemove = new ArrayList<>();
        for (Monomial i : l1) {
            for (Monomial j : l2) {
                if (i.getGrad() == j.getGrad()) {
                    i.setCoef(i.getCoef() + j.getCoef());
                    if (i.getCoef() == 0) {
                        toRemove.add(i);
                    }
                    l2.remove(j);
                    break;
                }
            }
        }
        l1.addAll(l2);
        l1.removeAll(toRemove);
        Collections.sort(l1);
        this.result = new Polynomial(l1);
    }

    public void sub(Polynomial p1, Polynomial p2) {
        p1.compress();
        p2.compress();
        ArrayList<Monomial> l1 = p1.getMonomialList();
        ArrayList<Monomial> l2 = p2.getMonomialList();
        ArrayList<Monomial> toRemove = new ArrayList<>();
        for (Monomial i : l1) {
            for (Monomial j : l2) {
                if (i.getGrad() == j.getGrad()) {
                    i.setCoef(i.getCoef() - j.getCoef());
                    if (i.getCoef() == 0) {
                        toRemove.add(i);
                    }
                    l2.remove(j);
                    break;
                }
            }
        }
        for (Monomial m : l2) {
            Monomial mSub = new Monomial();
            mSub.setCoef(-m.getCoef());
            mSub.setGrad(m.getGrad());
            l1.add(mSub);
        }
        l1.removeAll(toRemove);
        Collections.sort(l1);
        this.result = new Polynomial(l1);
    }

    public void derivate(Polynomial p) {
        p.compress();
        ArrayList<Monomial> l = p.getMonomialList();
        ArrayList<Monomial> toRemove = new ArrayList<>();
        for (Monomial m : l) {
            if (m.getGrad() == 0) {
                toRemove.add(m);
            } else if (m.getGrad() == 1) {
                m.setGrad(0);
            } else {
                m.setCoef(m.getCoef() * m.getGrad());
                m.setGrad(m.getGrad() - 1);
            }
        }
        l.removeAll(toRemove);
        Collections.sort(l);
        this.result = new Polynomial(l);
    }

    public void integrate(Polynomial p) {
        p.compress();
        ArrayList<Monomial> l = p.getMonomialList();
        for (Monomial m : l) {
            if (m.getGrad() == 0) {
                m.setGrad(1);
            } else {
                m.setGrad(m.getGrad() + 1);
                m.setCoef(m.getCoef() / m.getGrad());
            }
        }
        this.result = new Polynomial(l);
    }

    public void multiply(Polynomial p1, Polynomial p2) {
        p1.compress();
        p2.compress();
        ArrayList<Monomial> l1 = p1.getMonomialList();
        ArrayList<Monomial> l2 = p2.getMonomialList();
        ArrayList<Monomial> l = new ArrayList<>();
        ArrayList<Monomial> toRemove = new ArrayList<>();
        for (Monomial m : l1) {
            for (Monomial n : l2) {
                Monomial q = new Monomial();
                q.setCoef(m.getCoef() * n.getCoef());
                q.setGrad(m.getGrad() + n.getGrad());
                l.add(q);
            }
        }
        Polynomial result = new Polynomial(l);
        result.compress();
        l = result.getMonomialList();
        for (Monomial m : l) {
            if (m.getCoef() == 0)
                toRemove.add(m);
        }
        l.removeAll(toRemove);
        this.result = result;
    }
}


