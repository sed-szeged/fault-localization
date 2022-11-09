package hu.szte.inf.sed.fl.coverage.data.io.writer;

import hu.szte.inf.sed.fl.coverage.data.CoverageData;
import hu.szte.inf.sed.fl.coverage.data.Granularity;
import lombok.RequiredArgsConstructor;

import java.io.DataOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public abstract class CoverageDataWriter<ID_TYPE extends Number, COUNTER_TYPE extends Number> {

    final CoverageData<ID_TYPE, COUNTER_TYPE> coverage;
    final DataOutputStream outputStream;

    public abstract void write() throws IOException;

    protected void writeHeader(final Granularity granularity, final int idTypeSize, final int counterTypeSize) throws IOException {
        outputStream.writeByte(granularity.getId());
        outputStream.writeByte(idTypeSize);
        outputStream.writeByte(counterTypeSize);
        outputStream.writeInt(coverage.size());
    }

}
