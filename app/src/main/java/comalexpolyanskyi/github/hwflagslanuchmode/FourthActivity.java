package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Алексей on 03.10.2016.
 */

public class FourthActivity extends AppCompatActivity {
    private final static String FOURTH_ACTIVITY = "fourth";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MainActivity.lastActivity = FOURTH_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FifthActivity.class));
    }
}
