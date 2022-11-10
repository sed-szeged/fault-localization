package hu.szte.inf.sed.fl.coverage.data;

import hu.szte.inf.sed.fl.coverage.data.io.writer.CoverageDataWriter;
import hu.szte.inf.sed.fl.coverage.data.io.writer.NumericMethodCoverageDataWriter;
import org.javatuples.Pair;

import java.io.DataOutputStream;
import java.util.*;

public class NumericMethodCoverageData implements MethodCoverageData<Short, Long> {

    private final Map<Short, Long> data = new HashMap<>();

    @Override
    public void add(Short id) {
        if (data.containsKey(id)) {
            data.put(id, data.get(id) + 1);
        } else {
            data.put(id, 1L);
        }
    }

    @Override
    public void add(Short id, Long count) {
        if (data.containsKey(id)) {
            data.put(id, data.get(id) + count);
        } else {
            data.put(id, count);
        }
    }

    @Override
    public boolean contains(final Short id) {
        return data.containsKey(id);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void onMethodEntry(Short methodId) {
        add(methodId);
    }

    @Override
    public void onMethodExit(Short methodId) {
    }

    @Override
    public CoverageDataWriter<Short, Long> writer(DataOutputStream outputStream) {
        return new NumericMethodCoverageDataWriter(this, outputStream);
    }

    @Override
    public Iterator<Pair<Short, Long>> iterator() {
        final List<Pair<Short, Long>> result = new ArrayList<>();

        for (final Map.Entry<Short, Long> entry : data.entrySet()) {
            result.add(new Pair<>(entry.getKey(), entry.getValue()));
        }

        return result.iterator();
    }

}
