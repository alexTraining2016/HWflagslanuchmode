package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class FinishActivity extends AppCompatActivity {
    private final static String FINISH_ACTIVITY = "finish";
    private final static String LAUNCH_KEY = "launch";
    public static final String KEY_STORE = "key_store";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAUNCH_KEY, FINISH_ACTIVITY);
        editor.apply();
    }
}
