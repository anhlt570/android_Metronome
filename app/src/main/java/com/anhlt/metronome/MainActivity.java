package com.anhlt.metronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public Button btnLeft, btnCenter, btnRight;
    public TextView tvTitle;
    public ImageView rotationObject;

    public double cX, cY;
    ArrayList<Vector> listMotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView() {
        listMotion = new ArrayList<>();
        btnLeft = (Button) findViewById(R.id.btn_left);
        btnCenter = (Button) findViewById(R.id.btn_center);
        btnRight = (Button) findViewById(R.id.btn_right);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        rotationObject = (ImageView) findViewById(R.id.rotation_object);
        rotationObject.setOnTouchListener(this);
    }

    public double preX, preY;
    public Vector v0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.rotation_object) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    cX = rotationObject.getWidth() / 2;
                    cY = rotationObject.getHeight() / 2;
                    v0 = new Vector(0, -cY);
                    preX = event.getX();
                    preY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float x = event.getX();
                    float y = event.getY();
                    listMotion.add(new Vector(x - cX, y - cY));
                    Vector preVector = new Vector(preX - cX, preY - cY);
                    Vector currentVector = listMotion.get(0);
                    listMotion.remove(0);
                    double preAngle = getAngle(v0, preVector, x < cX);
                    double currentAngle = getAngle(v0, currentVector, x < cX);
                    double delta;
                    if (preAngle - currentAngle > 180) delta = currentAngle + 360 - preAngle;
                    else if (currentAngle - preAngle > 180) delta = currentAngle - preAngle - 360;
                    else delta = currentAngle - preAngle;
                    if (Math.abs(delta) >= 1) {
                        if (Math.abs(delta) > 90) {
                            preX = x;
                            preY = y;
                            return true;
                        }

                        rotationObject.setRotation((float) Math.floor(rotationObject.getRotation() + delta));
                        int round = (int) (rotationObject.getRotation() % 2);
                        tvTitle.setText((int) (rotationObject.getRotation() * 240 / 360 + (round * 120)) + "");

                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private double getAngle(Vector v1, Vector v2, boolean isBigAngle) {
        double angle = 180 * Math.acos((v1.x * v2.x + v1.y * v2.y) / (v1.Magnitude() * v2.Magnitude())) / Math.PI;
        if (isBigAngle) return 360 - angle;
        return angle;
    }

    private class Vector {
        public double x, y;

        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double Magnitude() {
            return Math.sqrt(x * x + y * y);
        }
    }
}
