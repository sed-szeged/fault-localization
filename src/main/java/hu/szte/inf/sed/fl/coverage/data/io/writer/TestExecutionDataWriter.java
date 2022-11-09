package hu.szte.inf.sed.fl.coverage.data.io.writer;

import hu.szte.inf.sed.fl.coverage.data.TestExecution;
import lombok.RequiredArgsConstructor;

import java.io.DataOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class TestExecutionDataWriter {

    final TestExecution testExecution;

    public void writeTo(final DataOutputStream outputStream) throws IOException {
        writeCoverageTo(outputStream);
        writeMetaDataTo(outputStream);
    }

    private void writeCoverageTo(final DataOutputStream outputStream) throws IOException {
        testExecution.getCoverage().writer(outputStream).write();
    }

    private void writeMetaDataTo(final DataOutputStream outputStream) throws IOException {
        outputStream.writeLong(testExecution.getExecutionTime());
        outputStream.writeShort(testExecution.getOutcome().ordinal());
        outputStream.writeUTF(testExecution.getTestName());
    }

}
