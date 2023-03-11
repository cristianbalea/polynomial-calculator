import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;
        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubstractListener());
        view.addDerivateListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDivideListener(new DivideListener());
        view.setVisible();
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getP1();
            String s2 = view.getP2();
            if (Validation.isValid(s1) == 0 || Validation.isValid(s2) == 0)
                view.showMessage();
            else {
                view.clearMessage();
                Polynomial p1 = new Polynomial(s1);
                Polynomial p2 = new Polynomial(s2);
                model.add(p1, p2);
                view.setR1(model.getResult());
            }

        }
    }

    class SubstractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getP1();
            String s2 = view.getP2();
            if (Validation.isValid(s1) == 0 || Validation.isValid(s2) == 0) {
                view.showMessage();
            } else {
                view.clearMessage();
                Polynomial p1 = new Polynomial(s1);
                Polynomial p2 = new Polynomial(s2);
                model.sub(p1, p2);
                view.setR1(model.getResult());
            }
        }
    }

    class DerivateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = view.getP1();
            if (Validation.isValid(s) == 0) {
                view.showMessage();
            } else {
                view.clearMessage();
                Polynomial p = new Polynomial(s);
                model.derivate(p);
                view.setR1(model.getResult());
            }
        }
    }

    class IntegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = view.getP1();
            if (Validation.isValid(s) == 0) {
                view.showMessage();
            } else {
                view.clearMessage();
                Polynomial p = new Polynomial(s);
                model.integrate(p);
                view.setR1(model.getResult() + "+C");
            }

        }
    }

    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s1 = view.getP1();
            String s2 = view.getP2();
            if (Validation.isValid(s1) == 0 || Validation.isValid(s2) == 0) {
                view.showMessage();
            } else {
                view.clearMessage();
                Polynomial p1 = new Polynomial(s1);
                Polynomial p2 = new Polynomial(s2);
                model.multiply(p1, p2);
                view.setR1(model.getResult());
            }
        }
    }

    class DivideListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
