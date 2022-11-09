package hu.szte.inf.sed.fl.method;

import hu.szte.inf.sed.fl.coverage.data.spectrum.Spectrum;
import hu.szte.inf.sed.fl.coverage.data.spectrum.SpectrumReader;
import hu.szte.inf.sed.fl.formula.Formula;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class FaultLocalization {

    private final Formula formula;

    public Map<String, Double> analyse(final String dir) {
        SpectrumReader reader = new SpectrumReader();

        Spectrum spectrum = reader.readFrom(dir);

        return analyse(spectrum);
    }

    public Map<String, Double> analyse(final Spectrum spectrum) {
        Map<String, Double> scores = new HashMap<>();

        for (final Map.Entry<Short, Double> entry : formula.analyse(spectrum).entrySet()) {
            final String name = spectrum.getCodeElementNameMapping().getOrDefault(entry.getKey(), entry.getKey().toString());
            scores.put(name, entry.getValue());
        }

        return scores;
    }

}
