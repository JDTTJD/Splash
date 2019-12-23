package com.tuoren.splash.main.beijing;

/**
 * Create by JDT on 2019-12-23.
 */
public class ProcessDataTest {

    private static ProcessDataTest mInstance;

    private String processDec;

    private ProcessDataTest() {

    }

    public static synchronized ProcessDataTest getInstance() {
        if (mInstance == null) {
            mInstance = new ProcessDataTest();
        }
        return mInstance;
    }

    public String getProcessDec() {
        return processDec;
    }

    public ProcessDataTest setProcessDec(String processDec) {
        this.processDec = processDec;
        return this;
    }
}
