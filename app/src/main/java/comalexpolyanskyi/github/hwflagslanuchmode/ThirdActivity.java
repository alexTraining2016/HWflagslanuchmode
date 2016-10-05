package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ThirdActivity extends AppCompatActivity {
    private final static String THIRD_ACTIVITY = "third";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        MainActivity.lastActivity = THIRD_ACTIVITY;
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FourthActivity.class));
    }
}
