package hu.szte.inf.sed.fl.coverage.data.io.writer;

import hu.szte.inf.sed.fl.coverage.data.CoverageData;
import hu.szte.inf.sed.fl.coverage.data.Granularity;
import org.javatuples.Pair;

import java.io.DataOutputStream;
import java.io.IOException;


public class BinaryMethodCoverageDataWriter extends CoverageDataWriter<Short, Long> {

    public BinaryMethodCoverageDataWriter(final CoverageData<Short, Long> coverage, final DataOutputStream outputStream) {
        super(coverage, outputStream);
    }

    @Override
    public void write() throws IOException {
        writeHeader(Granularity.BINARY, Short.BYTES, Long.BYTES);

        for (final Pair<Short, Long> item : coverage) {
            outputStream.writeShort(item.getValue0());
        }
    }
}
