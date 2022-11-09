package hu.szte.inf.sed.fl.coverage.data;

import hu.szte.inf.sed.fl.coverage.data.io.reader.TestExecutionDataReader;
import hu.szte.inf.sed.fl.coverage.data.io.writer.TestExecutionDataWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestExecution {

    String testName;
    CoverageData<Short, Long> coverage;
    TestOutcome outcome;
    long executionTime;

    public boolean isFailed() {
        return outcome == TestOutcome.FAIL;
    }

    public TestExecutionDataWriter writer() {
        return new TestExecutionDataWriter(this);
    }

    public static TestExecutionDataReader reader() {
        return new TestExecutionDataReader();
    }

}
