package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class FifthActivity extends AppCompatActivity {
    private final static String FIFTH_ACTIVITY = "fifth";
    private final static String LAUNCH_KEY = "launch";
    public static final String KEY_STORE = "key_store";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAUNCH_KEY, FIFTH_ACTIVITY);
        editor.apply();
    }

    public void onClickNext(View view) {
        startActivity(new Intent(this, FinishActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
    }
}
