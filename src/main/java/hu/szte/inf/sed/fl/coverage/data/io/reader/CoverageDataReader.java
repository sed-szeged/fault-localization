package hu.szte.inf.sed.fl.coverage.data.io.reader;

import hu.szte.inf.sed.fl.coverage.data.CoverageData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.DataInputStream;
import java.io.IOException;

@Getter
@RequiredArgsConstructor
public abstract class CoverageDataReader<ID_TYPE extends Number, COUNTER_TYPE extends Number> {

    CoverageData<ID_TYPE, COUNTER_TYPE> coverage;
    final DataInputStream inputStream;

    public abstract CoverageData<ID_TYPE, COUNTER_TYPE> read() throws IOException;

    protected void checkTypeSizes(final int expectedIdTypeSize, final int expectedCounterTypeSize) throws IOException {
        final byte idTypeSize = inputStream.readByte();
        assert idTypeSize == expectedIdTypeSize;

        final byte counterTypeSize = inputStream.readByte();
        assert counterTypeSize == expectedCounterTypeSize;
    }

}
