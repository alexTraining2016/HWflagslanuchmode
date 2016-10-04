package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Алексей on 03.10.2016.
 */

public class ThirdActivity extends AppCompatActivity {
    private final static String SECOND_ACTIVITY = "second";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MainActivity.lastActivity = SECOND_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FinishActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
    }
}
