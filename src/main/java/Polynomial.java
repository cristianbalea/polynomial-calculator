import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomialList = new ArrayList<>();

    public Polynomial(String poly) {
        Pattern pattern = Pattern.compile("[+-]?[^+-]+");
        Matcher matcher = pattern.matcher(poly);
        while (matcher.find()) {
            Monomial monomial = new Monomial();
            if (matcher.group().contains("x")) {
                monomial.setGrad(1);
                monomial.setCoef(1);
                String[] parts = matcher.group().split("x", 0);
                for (String s : parts) {
                    if (!s.equals("")) {
                        if (s.contains("^")) monomial.setGrad(Integer.parseInt(s.substring(1)));
                        else {
                            if (s.equals("+")) monomial.setCoef(1);
                            else if (s.equals("-")) monomial.setCoef(-1);
                            else monomial.setCoef(Integer.parseInt(s.substring(0, s.length() - 1)));
                        }
                    }
                }
            } else {
                monomial.setCoef(Integer.parseInt(matcher.group()));
                monomial.setGrad(0);
            }
            monomialList.add(monomial);
        }
    }

    public Polynomial(ArrayList<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    public void compress() {
        ArrayList<Monomial> l = this.getMonomialList();
        ArrayList<Monomial> toRemove = new ArrayList<>();
        Collections.sort(l);
        int i = 0, j = 1;
        while (i < l.size() - 1 && j < l.size()) {
            while (j < l.size() && l.get(i).getGrad() == l.get(j).getGrad()) {
                l.get(i).setCoef(l.get(i).getCoef() + l.get(j).getCoef());
                toRemove.add(l.get(j));
                j++;
            }
            i = j;
            j++;
        }
        l.removeAll(toRemove);
    }

    public ArrayList<Monomial> getMonomialList() {
        return monomialList;
    }

    @Override
    public String toString() {
        String result = "";
        ArrayList<Monomial> list = this.getMonomialList();
        for (Monomial m : list) {
            if (m.getCoef() >= 0) {
                result += "+" + m.toString();
            } else result += m.toString();
        }
        if (result.equals("")) return "0";
        if (result.charAt(0) == '+')
            result = result.substring(1);
        return result;
    }
}
