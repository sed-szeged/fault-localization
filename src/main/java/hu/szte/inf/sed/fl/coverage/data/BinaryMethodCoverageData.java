package hu.szte.inf.sed.fl.coverage.data;

import hu.szte.inf.sed.fl.coverage.data.io.writer.BinaryMethodCoverageDataWriter;
import hu.szte.inf.sed.fl.coverage.data.io.writer.CoverageDataWriter;
import lombok.ToString;
import org.javatuples.Pair;

import java.io.DataOutputStream;
import java.util.*;

@ToString
public class BinaryMethodCoverageData implements MethodCoverageData<Short, Long> {

    private final Set<Short> data = new HashSet<>();

    @Override
    public void add(final Short id) {
        data.add(id);
    }

    @Override
    public void add(final Short id, final Long count) {
        add(id);
    }

    @Override
    public boolean contains(final Short id) {
        return data.contains(id);
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
    public void onMethodEntry(final Short methodId) {
        data.add(methodId);
    }

    @Override
    public void onMethodExit(final Short methodId) {
    }

    @Override
    public CoverageDataWriter<Short, Long> writer(final DataOutputStream outputStream) {
        return new BinaryMethodCoverageDataWriter(this, outputStream);
    }

    @Override
    public Iterator<Pair<Short, Long>> iterator() {
        final List<Pair<Short, Long>> result = new ArrayList<>();

        for (final Short entry : data) {
            result.add(new Pair<>(entry, 1L));
        }

        return result.iterator();
    }

}
