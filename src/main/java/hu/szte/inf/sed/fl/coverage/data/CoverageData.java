package hu.szte.inf.sed.fl.coverage.data;

import hu.szte.inf.sed.fl.coverage.data.io.writer.CoverageDataWriter;
import org.javatuples.Pair;

import java.io.DataOutputStream;

public interface CoverageData<ID_TYPE extends Number, COUNTER_TYPE extends Number> extends Iterable<Pair<ID_TYPE, COUNTER_TYPE>> {

    void add(ID_TYPE id);

    void add(ID_TYPE id, COUNTER_TYPE count);

    boolean contains(ID_TYPE id);

    void clear();

    boolean isEmpty();

    int size();

    CoverageDataWriter<ID_TYPE, COUNTER_TYPE> writer(DataOutputStream outputStream);

}
