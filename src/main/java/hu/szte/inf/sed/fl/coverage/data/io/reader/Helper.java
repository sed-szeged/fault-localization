package hu.szte.inf.sed.fl.coverage.data.io.reader;

import hu.szte.inf.sed.fl.coverage.data.Granularity;

import java.io.DataInputStream;
import java.io.IOException;

public class Helper {

    public static CoverageDataReader<?,?> chooseReader(final DataInputStream inputStream) throws IOException {
        byte granularityId = inputStream.readByte();

        switch (Granularity.fromId(granularityId)) {
            case BINARY:
                return new BinaryMethodCoverageDataReader(inputStream);
            case COUNT:
                return new NumericMethodCoverageDataReader(inputStream);
            case CHAIN:
            default:
                throw new IllegalArgumentException(String.format("Invalid granularity value '%d'", granularityId));
        }
    }

}
