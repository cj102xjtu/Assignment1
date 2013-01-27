package com.example.assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageButton    o_previousImageButton = null;
	private ImageButton    o_nextImageButton = null;
	private ImageDisplayer o_imageDisplayer = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        o_previousImageButton = (ImageButton) findViewById(R.id.previousImageButton);
        o_nextImageButton = (ImageButton) findViewById(R.id.nextImageButton);
        o_imageDisplayer = new ImageDisplayer((ImageView) findViewById(R.id.imageView), getAssets() );

        
        o_previousImageButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                o_imageDisplayer.showAnotherImage(false);
            }
            
        });
        
        o_previousImageButton.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(v == o_previousImageButton && event.getActionMasked() == MotionEvent.ACTION_DOWN )
                {
                    Toast.makeText(getApplicationContext(), R.string.toast_info_previous, Toast.LENGTH_SHORT).show();                
                }
                return false;
            }
        });
        
        
        o_nextImageButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                o_imageDisplayer.showAnotherImage(true);
                
            }
        });
        
        o_nextImageButton.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(v == o_nextImageButton && event.getActionMasked() == MotionEvent.ACTION_DOWN )
                {
                    Toast.makeText(getApplicationContext(), R.string.toast_info_next, Toast.LENGTH_SHORT).show();                    
                }
                return false;
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
