package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Алексей on 03.10.2016.
 */

public class FourthActivity extends AppCompatActivity {
    private final static String FOURTH_ACTIVITY = "fourth";
    private final static String LAUNCH_KEY = "launch";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("a", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAUNCH_KEY, FOURTH_ACTIVITY);
        editor.apply();
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FifthActivity.class));
    }
}
