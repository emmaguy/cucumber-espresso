package com.emmaguy.cucumberespresso.test;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;

import cucumber.api.android.CucumberInstrumentationCore;

// Used in build.gradle for testInstrumentationRunner
public class Instrumentation extends MonitoringInstrumentation {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        instrumentationCore.create(bundle);
        start();
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
