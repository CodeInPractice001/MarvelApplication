package com.example.marvelapp.view

import androidx.lifecycle.MediatorLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.marvelapp.R
import com.example.marvelapp.utils.Response
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

@RunWith(AndroidJUnit4ClassRunner::class)
class MarvelListFragmentTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_mainActivityIsDisplayed() {

        Espresso.onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentArticleListVisible() {

        Espresso.onView(withId(R.id.marvelList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isRecyclerviewVisible() {
        onView(withId(R.id.recyclerview)).check(
            matches(
                isDisplayed()
            )
        )

    }
    @Test
    fun test_isRecyclerViewItemIsClickable() {

        onView(withId(R.id.recyclerview))
            .perform(click())


    }

}