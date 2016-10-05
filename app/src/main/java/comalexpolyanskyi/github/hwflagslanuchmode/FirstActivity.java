package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class FirstActivity extends AppCompatActivity {
    private final static String FIRST_ACTIVITY = "first";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MainActivity.lastActivity = FIRST_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
