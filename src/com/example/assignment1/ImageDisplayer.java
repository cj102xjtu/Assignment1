package com.example.assignment1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

public class ImageDisplayer 
{
    final static String LOG_TAG = "ImageDisplayer";
    final static int DEFAULT_IMAGE_INDEX = 0;
    
    private ImageView       o_imageView = null;
    private int             o_nImageIndex = 0;
    private AssetManager    o_assetManager = null;
    private List<String>    o_imageNameList = null;
    
    public ImageDisplayer(ImageView aImageView, AssetManager aAssetManager)
    {
        o_imageView = aImageView;
        o_assetManager = aAssetManager;
        
        // To get names of all files inside the folder
        try {
            o_imageNameList = Arrays.asList(o_assetManager.list("image"));

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        // set default image for image view
        showImageInIndex(DEFAULT_IMAGE_INDEX);
    }
    
    
    public void showAnotherImage(boolean bANext)
    {
        // show next image
        if(bANext)
        {
            Log.d(LOG_TAG, "show next image" );
            o_nImageIndex++;
            // show first image
            if(o_nImageIndex == o_imageNameList.size())
            {
                o_nImageIndex = 0;
            }
            showImageInIndex(o_nImageIndex);
        }
        else
        {
            Log.d(LOG_TAG, "show previous image" );
            o_nImageIndex--;
            // show last image
            if(o_nImageIndex < 0)
            {
                o_nImageIndex = o_imageNameList.size() - 1;
            }
            showImageInIndex(o_nImageIndex);
        }
    }
    
    private boolean showImageInIndex(int nAIndex)
    {
        boolean bResult = false;
        Log.d(LOG_TAG, "open index : "+ nAIndex + " image name: " + o_imageNameList.get(nAIndex));
        InputStream inStream = null;
        try {
            inStream = o_assetManager.open("image/" + o_imageNameList.get(nAIndex));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(inStream, o_imageNameList.get(nAIndex));
        o_imageView.setImageDrawable(d);
        return bResult;
    }
    
}
