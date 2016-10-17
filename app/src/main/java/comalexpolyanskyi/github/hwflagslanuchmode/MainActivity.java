package comalexpolyanskyi.github.hwflagslanuchmode;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_head);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Alex Alexeev");
        SomeApi api =  new SomeApi();
        String debug;
        if(BuildConfig.BETA){
            debug = BuildConfig.SOME_VARIABLE;
        }
        initMessageBtn(api);
    }

    public void initMessageBtn(SomeApi api){
        View messageButton = findViewById(R.id.messageBtn);
        if(api.isVisibleMessageBtn()){
            messageButton.setVisibility(View.VISIBLE);
        }else{
            messageButton.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
