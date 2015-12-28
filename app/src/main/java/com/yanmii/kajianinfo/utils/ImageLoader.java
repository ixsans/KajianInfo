package com.yanmii.kajianinfo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class ImageLoader {

    public static void displayThumbnail(Context context, String url, ImageView imageView){
        try{
            Animation anim = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .animate(anim)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(new BitmapImageViewTarget(imageView){
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCornerRadius(5);
                            imageView.setImageDrawable(circularBitmapDrawable);
                        }
                    });

        }catch(IllegalArgumentException iae){
            Glide.clear(imageView);
        }
    }


    public static void displayImage(Context context, String url, ImageView imageView){
        try{
            Animation anim = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .animate(anim)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(imageView);

        }catch(IllegalArgumentException iae){
            Glide.clear(imageView);
        }
    }
}
