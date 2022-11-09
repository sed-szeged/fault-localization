package hu.szte.inf.sed.fl.formula.sbfl;

public class Ochiai extends SBFLFormula {

    public String getName() {
        return "Ochiai";
    }

    @Override
    public double compute(double ef, double ep, double nf, double np) {
        try {
            return ef / Math.sqrt((ef + nf) * (ef + ep));
        } catch (ArithmeticException e) {
            return Double.NaN;
        }
    }

}
