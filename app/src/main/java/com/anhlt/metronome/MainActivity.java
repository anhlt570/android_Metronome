package com.anhlt.metronome;

import android.content.Context;
import android.content.PeriodicSync;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public static final String TAG = "AnhLT";
    private ImageView imgWheel;
    private TextView tvSpeed;

    public static final String KEY_CURRENT_SPEED= "current.speed";
    private float mCurrentSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentSpeed = getSavedCurrentSpeed();
        initViews();
    }


    public void initViews() {
        tvSpeed = (TextView) findViewById(R.id.tv_speed);
        imgWheel = (ImageView) findViewById(R.id.img_wheel);
        Log.d(TAG, "initViews: "+ imgWheel.getPivotX() + " - "+ imgWheel.getY());
        Log.d(TAG, "initViews: "+ imgWheel.getWidth() + " - "+ imgWheel.getHeight());
        imgWheel.setOnTouchListener(this);
        initTemposListView();
    }

    public void initTemposListView() {

        ListView lvTempos = (ListView) findViewById(R.id.lv_tempos);
        TemposListAdapter adapter = new TemposListAdapter(this);
        lvTempos.setAdapter(adapter);

        lvTempos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Tempo tempo= Data.getInstance().getTemposList().get(position);
                Log.d(TAG, "onItemClick: "+ tempo.getAverageSpeed()+tvSpeed.getId());
                tvSpeed.setText(tempo.getAverageSpeed()+"");
            }
        });
    }

    public void saveCurrentSpeed()
    {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(KEY_CURRENT_SPEED,mCurrentSpeed);
        editor.apply();
    }

    public float getSavedCurrentSpeed()
    {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        return preferences.getFloat(KEY_CURRENT_SPEED,0);
    }


    private float x0,y0;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view.getId() == R.id.img_wheel)
        {
            switch (motionEvent.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    x0= motionEvent.getX();
                    y0= motionEvent.getY();
                    Log.d(TAG, "onTouch: down "+x0+" - "+y0);
                    break;
                case MotionEvent.ACTION_MOVE:
                    float x1 ,y1;
                    x1 = motionEvent.getX();
                    y1 = motionEvent.getY();
                    Log.d(TAG, "onTouch: move "+ x1+ " - "+y1);
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d(TAG, "onTouch: up");
                    break;
            }
        }
        return true;
    }
}
