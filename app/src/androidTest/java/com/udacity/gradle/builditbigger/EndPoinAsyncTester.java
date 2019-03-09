package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndPoinAsyncTester {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void jokeIsNotEmpty() throws Exception
    {
        EndPoinAsyncTest asyncTest = new EndPoinAsyncTest();
        asyncTest.execute(InstrumentationRegistry.getContext());
        String jokes = asyncTest.get(5, TimeUnit.SECONDS);
        Assert.assertTrue(!jokes.equals(""));
    }
    @Test
    public void responseVerification()
    {
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.jokesDisplay)).check(matches(isDisplayed()));
    }
}
