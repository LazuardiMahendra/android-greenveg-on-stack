package com.example.projectgreenveg.Helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ImageConverter {

    public static  byte[] toImage (Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0,stream );
        return stream.toByteArray();
    }

    public static  Bitmap toImage (byte [] array){
        return BitmapFactory.decodeByteArray(array, 0, array.length);
    }
}
