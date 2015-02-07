package com.emmaguy.cucumberespresso.test;

import android.test.ActivityInstrumentationTestCase2;

import com.emmaguy.cucumberespresso.CucumberActivity;
import com.emmaguy.cucumberespresso.R;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@CucumberOptions(features = "features")
public class CucumberActivitySteps extends ActivityInstrumentationTestCase2<CucumberActivity> {

    public CucumberActivitySteps() {
        super(CucumberActivity.class);
    }

    @Given("^I have a CucumberActivity$")
    public void I_have_a_CucumberActivity() {
        assertNotNull(getActivity());

        String expectedTitle = getActivity().getString(R.string.app_name);
        assertEquals(expectedTitle, getActivity().getActionBar().getTitle());
    }

    @Then("^I should see an important message on the display$")
    public void I_should_see_an_important_message_on_the_display() {
        onView(withId(R.id.cucumber_textview_important_message_1)).check(matches(isDisplayed()));
    }
}
