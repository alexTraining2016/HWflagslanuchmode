package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class FifthActivity extends AppCompatActivity {
    private final static String FIFTH_ACTIVITY = "fifth";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MainActivity.lastActivity = FIFTH_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FinishActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
    }
}
