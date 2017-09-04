package app.akexorcist.joystickcontroller;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main extends Activity {
	RelativeLayout layout_joystick_left, layout_joystick_right;
	ImageView image_joystick, image_border;
	TextView textViewXLeft, textViewYLeft, textViewAngleLeft, textViewDistanceLeft, textViewDirectionLeft;
	TextView textViewXRight, textViewYRight, textViewAngleRight, textViewDistanceRight, textViewDirectionRight;
	
	JoyStickClass js_left, js_right;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		// Joystick de gauche
        textViewXLeft = (TextView)findViewById(R.id.textViewXLeft);
        textViewYLeft = (TextView)findViewById(R.id.textViewYLeft);
        textViewAngleLeft = (TextView)findViewById(R.id.textViewAngleLeft);
        textViewDistanceLeft = (TextView)findViewById(R.id.textViewDistanceLeft);
        textViewDirectionLeft = (TextView)findViewById(R.id.textViewDirectionLeft);

		layout_joystick_left = (RelativeLayout)findViewById(R.id.layout_joystick_left);

		js_left = new JoyStickClass(getApplicationContext(), layout_joystick_left, R.drawable.image_button);
		js_left.setStickSize(100, 100);
		js_left.setLayoutSize(200, 500);
		js_left.setLayoutAlpha(150);
		js_left.setStickAlpha(150);
		js_left.setOffset(50);
		js_left.setMinimumDistance(25);

		textViewXLeft = (TextView)findViewById(R.id.textViewXLeft);
		textViewYLeft = (TextView)findViewById(R.id.textViewYLeft);
		textViewAngleLeft = (TextView)findViewById(R.id.textViewAngleLeft);
		textViewDistanceLeft = (TextView)findViewById(R.id.textViewDistanceLeft);
		textViewDirectionLeft = (TextView)findViewById(R.id.textViewDirectionLeft);

		layout_joystick_left.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent arg1) {
				js_left.drawStick(arg1);
				if(arg1.getAction() == MotionEvent.ACTION_DOWN
						|| arg1.getAction() == MotionEvent.ACTION_MOVE) {
					textViewXLeft.setText("X : " + String.valueOf(js_left.getX()));
					textViewYLeft.setText("Y : " + String.valueOf(js_left.getY()));
					textViewAngleLeft.setText("Angle : " + String.valueOf(js_left.getAngle()));
					textViewDistanceLeft.setText("Distance : " + String.valueOf(js_left.getDistance()));

					int direction = js_left.get8Direction();
					if(direction == JoyStickClass.STICK_UP) {
						textViewDirectionLeft.setText("Direction : Up");
					} else if(direction == JoyStickClass.STICK_UPRIGHT) {
						textViewDirectionLeft.setText("Direction : Up Right");
					} else if(direction == JoyStickClass.STICK_RIGHT) {
						textViewDirectionLeft.setText("Direction : Right");
					} else if(direction == JoyStickClass.STICK_DOWNRIGHT) {
						textViewDirectionLeft.setText("Direction : Down Right");
					} else if(direction == JoyStickClass.STICK_DOWN) {
						textViewDirectionLeft.setText("Direction : Down");
					} else if(direction == JoyStickClass.STICK_DOWNLEFT) {
						textViewDirectionLeft.setText("Direction : Down Left");
					} else if(direction == JoyStickClass.STICK_LEFT) {
						textViewDirectionLeft.setText("Direction : Left");
					} else if(direction == JoyStickClass.STICK_UPLEFT) {
						textViewDirectionLeft.setText("Direction : Up Left");
					} else if(direction == JoyStickClass.STICK_NONE) {
						textViewDirectionLeft.setText("Direction : Center");
					}
				} else if(arg1.getAction() == MotionEvent.ACTION_UP) {
					textViewXLeft.setText("X :");
					textViewYLeft.setText("Y :");
					textViewAngleLeft.setText("Angle :");
					textViewDistanceLeft.setText("Distance :");
					textViewDirectionLeft.setText("Direction :");
				}
				return true;
			}
		});


		// Joystick de droite
		textViewXRight = (TextView)findViewById(R.id.textViewXRight);
		textViewYRight = (TextView)findViewById(R.id.textViewYRight);
		textViewAngleRight = (TextView)findViewById(R.id.textViewAngleRight);
		textViewDistanceRight = (TextView)findViewById(R.id.textViewDistanceRight);
		textViewDirectionRight = (TextView)findViewById(R.id.textViewDirectionRight);

		layout_joystick_right = (RelativeLayout)findViewById(R.id.layout_joystick_right);

		js_right = new JoyStickClass(getApplicationContext()
				, layout_joystick_right, R.drawable.image_button);
		js_right.setStickSize(150, 150);
		js_right.setLayoutSize(500, 500);
		js_right.setLayoutAlpha(150);
		js_right.setStickAlpha(100);
		js_right.setOffset(90);
		js_right.setMinimumDistance(50);
	    
	    layout_joystick_right.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent arg1) {
				js_right.drawStick(arg1);
				if(arg1.getAction() == MotionEvent.ACTION_DOWN
						|| arg1.getAction() == MotionEvent.ACTION_MOVE) {
					textViewXRight.setText("X : " + String.valueOf(js_right.getX()));
					textViewYRight.setText("Y : " + String.valueOf(js_right.getY()));
					textViewAngleRight.setText("Angle : " + String.valueOf(js_right.getAngle()));
					textViewDistanceRight.setText("Distance : " + String.valueOf(js_right.getDistance()));
					
					int direction = js_right.get8Direction();
					if(direction == JoyStickClass.STICK_UP) {
						textViewDirectionRight.setText("Direction : Up");
					} else if(direction == JoyStickClass.STICK_UPRIGHT) {
						textViewDirectionRight.setText("Direction : Up Right");
					} else if(direction == JoyStickClass.STICK_RIGHT) {
						textViewDirectionRight.setText("Direction : Right");
					} else if(direction == JoyStickClass.STICK_DOWNRIGHT) {
						textViewDirectionRight.setText("Direction : Down Right");
					} else if(direction == JoyStickClass.STICK_DOWN) {
						textViewDirectionRight.setText("Direction : Down");
					} else if(direction == JoyStickClass.STICK_DOWNLEFT) {
						textViewDirectionRight.setText("Direction : Down Left");
					} else if(direction == JoyStickClass.STICK_LEFT) {
						textViewDirectionRight.setText("Direction : Left");
					} else if(direction == JoyStickClass.STICK_UPLEFT) {
						textViewDirectionRight.setText("Direction : Up Left");
					} else if(direction == JoyStickClass.STICK_NONE) {
						textViewDirectionRight.setText("Direction : Center");
					}
				} else if(arg1.getAction() == MotionEvent.ACTION_UP) {
					textViewXRight.setText("X :");
					textViewYRight.setText("Y :");
					textViewAngleRight.setText("Angle :");
					textViewDistanceRight.setText("Distance :");
					textViewDirectionRight.setText("Direction :");
				}
				return true;
			}
        });
    } 	
}
