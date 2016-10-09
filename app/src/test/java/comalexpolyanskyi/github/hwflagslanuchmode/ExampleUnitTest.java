package comalexpolyanskyi.github.hwflagslanuchmode;

import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 17)
public class ExampleUnitTest {

    private SomeApi someApi;
    private MainActivity mainActivity;
    private View view;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        someApi =  Mockito.spy(new SomeApi());
        mainActivity = Mockito.spy(Robolectric.setupActivity(MainActivity.class));
        view = mainActivity.findViewById(R.id.messageBtn);
    }

    @Test
    public void visibleMessageBtnTest() throws Exception {
        Mockito.when(someApi.isVisibleMessageBtn()).thenCallRealMethod();
        someApi.setVisibilityMessageBtn();
        mainActivity.initMessageBtn(someApi);
        assertEquals(View.VISIBLE, view.getVisibility());

        Mockito.when(someApi.isVisibleMessageBtn()).thenReturn(false);
        someApi.setVisibilityMessageBtn();
        mainActivity.initMessageBtn(someApi);
        assertEquals(View.GONE, view.getVisibility());
    }

    @Test
    public void seasonsTest(){
        Mockito.when(someApi.getSeasonType()).thenReturn(11);
        assertEquals("autumn", someApi.getSeason());
        Mockito.when(someApi.getSeasonType()).thenReturn(4);
        assertEquals("spring", someApi.getSeason());
        Mockito.when(someApi.getSeasonType()).thenReturn(6);
        assertEquals("summer", someApi.getSeason());
        Mockito.when(someApi.getSeasonType()).thenReturn(12);
        assertEquals("winter", someApi.getSeason());
    }
}