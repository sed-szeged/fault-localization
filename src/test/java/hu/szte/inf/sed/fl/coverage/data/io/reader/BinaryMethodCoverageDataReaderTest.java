package hu.szte.inf.sed.fl.coverage.data.io.reader;

import hu.szte.inf.sed.fl.CSVReportWriter;
import hu.szte.inf.sed.fl.coverage.data.spectrum.Spectrum;
import hu.szte.inf.sed.fl.coverage.data.spectrum.SpectrumReader;
import hu.szte.inf.sed.fl.formula.sbfl.Ochiai;
import hu.szte.inf.sed.fl.formula.sbfl.Tarantula;
import hu.szte.inf.sed.fl.method.FaultLocalization;
import org.junit.Test;

import java.io.IOException;

import static hu.szte.inf.sed.fl.formula.sbfl.Formulas.DSTAR;
import static hu.szte.inf.sed.fl.formula.sbfl.Formulas.TARANTULA;

public class BinaryMethodCoverageDataReaderTest {

    @Test
    public void testReader() throws IOException {
        CSVReportWriter writer = new CSVReportWriter(
                "R:\\Doc\\SED\\gyogypelda\\coverage",
                "R:\\Doc\\SED\\gyogypelda\\coverage",
                TARANTULA.getFormula()
        );
        writer.createReport();
    }

}
