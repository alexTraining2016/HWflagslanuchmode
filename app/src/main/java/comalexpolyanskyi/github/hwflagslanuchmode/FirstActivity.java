package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Алексей on 03.10.2016.
 */

public class FirstActivity extends AppCompatActivity {
    private final static String FIRST_ACTIVITY = "first";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        MainActivity.lastActivity = FIRST_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
