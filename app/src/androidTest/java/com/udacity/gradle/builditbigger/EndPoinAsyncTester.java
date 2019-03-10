package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndPoinAsyncTester {
    View view;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void jokeIsNotEmpty() {
        EndPointsAsyncTask endPointsAsyncTask = new EndPointsAsyncTask(new AsyncResponse() {
            @Override
            public void processFinish(String output) {
                Assert.assertTrue(!output.equals(""));
            }
        });
        endPointsAsyncTask.execute(InstrumentationRegistry.getContext());


    }
    @Test
    public void responseVerification()
    {
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.jokesDisplay)).check(matches(isDisplayed()));
    }
}
