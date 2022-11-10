package hu.szte.inf.sed.fl.coverage.data.spectrum;

import hu.szte.inf.sed.fl.coverage.data.io.reader.TestExecutionDataReader;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpectrumReader {

    private final Spectrum spectrum = new Spectrum();

    public Spectrum readFrom(final String dir) {
        readTestExecutions(dir);
        readNameMapping(dir);

        return spectrum;
    }

    private void readTestExecutions(final String dir) {
        try (final DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dir), "*.trc")) {
            for (final Path path : dirStream) {
                TestExecutionDataReader reader = new TestExecutionDataReader();
                try {
                    reader.readFrom(new DataInputStream(Files.newInputStream(path)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                spectrum.addTestExecution(reader.getTestExecution());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readNameMapping(final String dir) {
        Path file = Paths.get(dir, "trace.trc.names");

        if (!Files.exists(file))
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] splitted = line.trim().split(":");

                final short methodID = Short.parseShort(splitted[0]);
                final String methodName = splitted[1];

                spectrum.addCodeElementNameMapping(methodID, methodName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
