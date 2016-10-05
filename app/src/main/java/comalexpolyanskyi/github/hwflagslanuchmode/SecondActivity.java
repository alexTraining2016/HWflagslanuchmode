package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    private final static String SECOND_ACTIVITY = "second";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MainActivity.lastActivity = SECOND_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
