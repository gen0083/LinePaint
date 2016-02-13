package jp.gcreate.sample.linepaint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.path_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.dot:
                startActivity(new Intent(this, DotActivity.class));
                return true;
            case R.id.historical_dot:
                startActivity(new Intent(this, HistoricalDotActivity.class));
                return true;
            case R.id.path:
                startActivity(new Intent(this, PathActivity.class));
                return true;
            case R.id.historical_path:
                startActivity(new Intent(this, HistoricalPathActivity.class));
                return true;
            case R.id.bezier_path:
                startActivity(new Intent(this, BezierPathActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
