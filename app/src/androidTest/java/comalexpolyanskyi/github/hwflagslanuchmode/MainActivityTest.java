package comalexpolyanskyi.github.hwflagslanuchmode;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withClassName(is("android.support.v7.widget.AppCompatImageButton")),
                        withParent(allOf(withId(R.id.toolbar_layout),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Перейти вверх"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.toolbar_layout)))),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction imageButton = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar_layout),
                                childAtPosition(
                                        withId(R.id.app_bar),
                                        0)),
                        3),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction vectorImageTextView = onView(
                allOf(withText("Фотография"),
                        withParent(withId(R.id.mesandphotobtn)),
                        isDisplayed()));
        vectorImageTextView.perform(click());

        ViewInteraction vectorImageTextView2 = onView(
                allOf(withText("Новая запись"),
                        withParent(withId(R.id.mesandphotobtn)),
                        isDisplayed()));
        vectorImageTextView2.perform(click());

        ViewInteraction vectorImageTextView3 = onView(
                allOf(withText("Показать информацию"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView3.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("115 подпосчиков"),
                        childAtPosition(
                                allOf(withId(R.id.info),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                2),
                        isDisplayed()));
        textView.check(matches(withText("115 подпосчиков")));

        ViewInteraction vectorImageTextView4 = onView(
                allOf(withText("184 друга"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView4.perform(click());

        ViewInteraction vectorImageTextView5 = onView(
                allOf(withText("Изменить статус"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView5.perform(click());

        ViewInteraction vectorImageTextView6 = onView(
                allOf(withText("Изменить статус"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView6.perform(click());

        ViewInteraction vectorImageTextView7 = onView(
                allOf(withText("115 подпосчиков"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView7.perform(click());

        ViewInteraction vectorImageTextView8 = onView(
                allOf(withText("115 подпосчиков"),
                        withParent(withId(R.id.info)),
                        isDisplayed()));
        vectorImageTextView8.perform(click());

        ViewInteraction vectorImageTextView9 = onView(
                allOf(withText("Новая запись"),
                        withParent(withId(R.id.mesandphotobtn)),
                        isDisplayed()));
        vectorImageTextView9.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withText("Фотография"),
                        childAtPosition(
                                allOf(withId(R.id.mesandphotobtn),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                2),
                        isDisplayed()));
        textView2.check(matches(withText("Фотография")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
