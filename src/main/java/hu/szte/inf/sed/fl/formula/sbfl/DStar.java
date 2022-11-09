package hu.szte.inf.sed.fl.formula.sbfl;

public class DStar extends SBFLFormula {

    public String getName() {
        return "DStar";
    }

    @Override
    public double compute(double ef, double ep, double nf, double np) {
        try {
            return Math.pow(ef, 2) / (ep + ((ef + nf) - ef));
        } catch (ArithmeticException e) {
            return Double.NaN;
        }
    }

}
