package hu.szte.inf.sed.fl.coverage.data.spectrum;

import hu.szte.inf.sed.fl.coverage.data.TestExecution;
import lombok.Getter;
import lombok.ToString;
import org.javatuples.Pair;

import java.util.*;

@Getter
@ToString
public class Spectrum {

    List<TestExecution> testExecutions = new ArrayList<>();
    Map<Short, String> codeElementNameMapping = new HashMap<>();

    Set<Short> codeElements = new HashSet<>();

    public void addTestExecution(final TestExecution testExecution) {
        testExecutions.add(testExecution);

        for (final Pair<Short, Long> data : testExecution.getCoverage()) {
            codeElements.add(data.getValue0());
        }
    }

    public void addCodeElementNameMapping(final Short id, final String name) {
        codeElementNameMapping.put(id, name);
    }

}
