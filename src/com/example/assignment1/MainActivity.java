package com.example.assignment1;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageButton    o_previousImageButton = null;
	private ImageButton    o_nextImageButton = null;
	private ImageView      o_imageView = null;
	
	private AssetManager   o_assetManager = null;
	private List<String>   o_imageNameList = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        o_previousImageButton = (ImageButton) findViewById(R.id.previousImageButton);
        o_nextImageButton = (ImageButton) findViewById(R.id.nextImageButton);
        o_imageView = (ImageView) findViewById(R.id.imageView);
        o_assetManager = getAssets();
        

        
        // To get names of all files inside the folder
        try {
            o_imageNameList = Arrays.asList(o_assetManager.list(""));

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        // set default image for image view
        InputStream inStream = null;
        try {
            inStream = o_assetManager.open(o_imageNameList.get(0));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(inStream, null);
        o_imageView.setImageDrawable(d);
        
        o_previousImageButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                showAnotherImage(false);
            }
        });
        
        o_nextImageButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                showAnotherImage(true);
                
            }
        });
        

        

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void showAnotherImage(boolean bANext)
    {
        // test code
        if(bANext)
        {
            Log.d("MainActivity", "show image hydrangeas" );
//            o_imageView.setImageResource(R.drawable.hydrangeas);
        }
        else
        {
            Log.d("MainActivity", "show image jellyfish" );
        }
    }
    
}
