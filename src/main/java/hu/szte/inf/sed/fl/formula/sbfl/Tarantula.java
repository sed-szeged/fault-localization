package hu.szte.inf.sed.fl.formula.sbfl;

public class Tarantula extends SBFLFormula {

    public String getName() {
        return "Tarantula";
    }

    @Override
    public double compute(double ef, double ep, double nf, double np) {
        try {
            double failRatio = ef / (ef + nf);
            double passRatio = ep / (ep + np);

            return failRatio / (passRatio + failRatio);
        } catch (ArithmeticException e) {
            return Double.NaN;
        }
    }

}
