package hu.szte.inf.sed.fl.coverage.data;

import hu.szte.inf.sed.fl.coverage.collection.MethodListener;

public interface MethodCoverageData<ID_TYPE extends Number, COUNTER_TYPE extends Number> extends CoverageData<ID_TYPE, COUNTER_TYPE>, MethodListener<ID_TYPE> {
}
