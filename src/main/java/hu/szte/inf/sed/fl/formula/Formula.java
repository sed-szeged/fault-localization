package hu.szte.inf.sed.fl.formula;

import hu.szte.inf.sed.fl.coverage.data.spectrum.Spectrum;

import java.util.Map;

public interface Formula {

    Map<Short, Double> analyse(Spectrum spectrum);
    String getName();

}
