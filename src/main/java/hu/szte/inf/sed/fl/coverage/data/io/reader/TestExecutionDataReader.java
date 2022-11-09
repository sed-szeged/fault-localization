package hu.szte.inf.sed.fl.coverage.data.io.reader;

import hu.szte.inf.sed.fl.coverage.data.CoverageData;
import hu.szte.inf.sed.fl.coverage.data.TestExecution;
import hu.szte.inf.sed.fl.coverage.data.TestOutcome;
import lombok.Getter;

import java.io.DataInputStream;
import java.io.IOException;

@Getter
public class TestExecutionDataReader {

    private final TestExecution testExecution = new TestExecution();

    public TestExecution readFrom(final DataInputStream inputStream) throws IOException {
        readCoverage(inputStream);
        readMetaData(inputStream);

        return testExecution;
    }

    private void readCoverage(final DataInputStream inputStream) throws IOException {
        testExecution.setCoverage((CoverageData<Short, Long>) Helper.chooseReader(inputStream).read());
    }

    private void readMetaData(final DataInputStream inputStream) throws IOException {
        testExecution.setExecutionTime(inputStream.readLong());
        testExecution.setOutcome(TestOutcome.values()[inputStream.readShort()]);
        testExecution.setTestName(inputStream.readUTF());
    }

}
