package hu.szte.inf.sed.fl.formula.sbfl;

import hu.szte.inf.sed.fl.coverage.data.TestExecution;
import hu.szte.inf.sed.fl.coverage.data.spectrum.Spectrum;
import hu.szte.inf.sed.fl.formula.Formula;

import java.util.HashMap;
import java.util.Map;

public abstract class SBFLFormula implements Formula {

    public Map<Short, Double> analyse(final Spectrum spectrum) {
        Map<Short, Double> scores = new HashMap<>();

        for (final Short id : spectrum.getCodeElements()) {
            double ef = 0, ep = 0, nf = 0, np = 0;

            for (final TestExecution testExecution : spectrum.getTestExecutions()) {
                boolean covered = testExecution.getCoverage().contains(id);

                switch (testExecution.getOutcome()) {
                    case FAIL:
                        if (covered)
                            ef++;
                        else
                            nf++;
                        break;
                    case PASS:
                        if (covered)
                            ep++;
                        else
                            np++;
                }
            }

            double score = compute(ef, ep, nf, np);

            scores.put(id, score);
        }

        return scores;
    }

    public abstract String getName();

    public abstract double compute(double ef, double ep, double nf, double np);

}
