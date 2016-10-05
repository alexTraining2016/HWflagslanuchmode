package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class FirstActivity extends AppCompatActivity {
    private final static String FIRST_ACTIVITY = "first";
    private final static String LAUNCH_KEY = "launch";
    public static final String KEY_STORE = "key_store";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAUNCH_KEY, FIRST_ACTIVITY);
        editor.apply();
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
