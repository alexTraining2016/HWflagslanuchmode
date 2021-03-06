package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {
    private final static String FIRST_ACTIVITY = "first";
    private final static String SECOND_ACTIVITY = "second";
    private final static String THIRD_ACTIVITY = "third";
    private final static String FOURTH_ACTIVITY = "fourth";
    private final static String FIFTH_ACTIVITY = "fifth";
    private final static String FINISH_ACTIVITY = "finish";
    private final static String NULL_ACTIVITY = "null";
    private final static String LAUNCH_KEY = "launch";
    public static final String KEY_STORE = "key_store";
    private String lastActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(KEY_STORE, MODE_PRIVATE);
        lastActivity = sharedPreferences.getString(LAUNCH_KEY, NULL_ACTIVITY);
        launchActivity();
        Toast.makeText(this, lastActivity, Toast.LENGTH_LONG).show();
    }

    private void launchActivity(){
        if(lastActivity.equals(NULL_ACTIVITY) || lastActivity.equals(FIRST_ACTIVITY)) {
            startActivity(new Intent(this, FirstActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
        }else if(lastActivity.equals(SECOND_ACTIVITY)){
            startActivity(new Intent(this, SecondActivity.class));
        }else if(lastActivity.equals(THIRD_ACTIVITY)){
            startActivity(new Intent(this, ThirdActivity.class));
        }else if(lastActivity.equals(FOURTH_ACTIVITY)){
            startActivity(new Intent(this, FourthActivity.class));
        }else if(lastActivity.equals(FIFTH_ACTIVITY) || lastActivity.equals(FINISH_ACTIVITY)){
            startActivity(new Intent(this, FinishActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
        }
    }
}
