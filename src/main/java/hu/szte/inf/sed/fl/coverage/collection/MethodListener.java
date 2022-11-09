package hu.szte.inf.sed.fl.coverage.collection;

public interface MethodListener<ID_TYPE extends Number> {

    void onMethodEntry(ID_TYPE methodId);
    void onMethodExit(ID_TYPE methodId);

}
