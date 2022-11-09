package hu.szte.inf.sed.fl.coverage.data.io.reader;

import hu.szte.inf.sed.fl.coverage.data.BinaryMethodCoverageData;
import hu.szte.inf.sed.fl.coverage.data.CoverageData;

import java.io.DataInputStream;
import java.io.IOException;


public class NumericMethodCoverageDataReader extends CoverageDataReader<Short, Long> {

    public NumericMethodCoverageDataReader(final DataInputStream inputStream) {
        super(inputStream);

        coverage = new BinaryMethodCoverageData();
    }

    @Override
    public CoverageData<Short, Long> read() throws IOException {
        checkTypeSizes(Short.BYTES, Long.BYTES);

        final int numOfElements = inputStream.readInt();

        for (int i = 0; i < numOfElements; ++i)
            coverage.add(inputStream.readShort(), inputStream.readLong());

        return coverage;
    }

}
