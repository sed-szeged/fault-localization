package hu.szte.inf.sed.fl;

import hu.szte.inf.sed.fl.formula.Formula;
import hu.szte.inf.sed.fl.method.FaultLocalization;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RequiredArgsConstructor
public class CSVReportWriter {

    final String inputDirectory;
    final String outputDirectory;
    final Formula formula;

    public void createReport() throws IOException {
        FaultLocalization fl = new FaultLocalization(formula);

        Path output = Paths.get(outputDirectory, formula.getName().toLowerCase() + ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output.toFile()))) {
            writer.write("name;score\n");

            for (Map.Entry<String, Double> entry : fl.analyse(inputDirectory).entrySet()) {
                writer.write("\"" + entry.getKey() + "\";" + entry.getValue() + "\n");
            }
        }
    }

}
