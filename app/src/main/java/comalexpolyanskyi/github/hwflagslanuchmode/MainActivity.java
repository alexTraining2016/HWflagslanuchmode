package comalexpolyanskyi.github.hwflagslanuchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {
    private final static String FIRST_ACTIVITY = "first";
    private final static String SECOND_ACTIVITY = "second";
    private final static String THIRD_ACTIVITY = "third";
    private final static String FOURTH_ACTIVITY = "fourth";
    private final static String FIFTH_ACTIVITY = "fifth";
    private final static String NULL_ACTIVITY = "null";
    private final static String LAUNCH_KEY = "launch";
    public static String lastActivity = NULL_ACTIVITY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            lastActivity = savedInstanceState.getString(LAUNCH_KEY);
        }
        launchActivity();
    }

    private void launchActivity(){
        if(lastActivity.equals(NULL_ACTIVITY) || lastActivity.equals(FIRST_ACTIVITY)) {
            lastActivity = FIRST_ACTIVITY;
            startActivity(new Intent(this, FirstActivity.class));
        }else if(lastActivity.equals(SECOND_ACTIVITY)){
            lastActivity = SECOND_ACTIVITY;
            startActivity(new Intent(this, SecondActivity.class));
        }else if(lastActivity.equals(THIRD_ACTIVITY)){
            lastActivity = THIRD_ACTIVITY;
            startActivity(new Intent(this, ThirdActivity.class));
        }else if(lastActivity.equals(FOURTH_ACTIVITY)){
            lastActivity = FOURTH_ACTIVITY;
            startActivity(new Intent(this, FourthActivity.class));
        }else if(lastActivity.equals(FIFTH_ACTIVITY)){
            startActivity(new Intent(this, FinishActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|FLAG_ACTIVITY_NEW_TASK));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(LAUNCH_KEY, lastActivity);
        super.onSaveInstanceState(outState);
    }
}
