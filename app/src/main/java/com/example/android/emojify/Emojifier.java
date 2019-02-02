package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Gopal on 1/19/2019.
 */

// TODO (1): Create a Java class called Emojifier
// TODO (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.


public class Emojifier {
     private static String TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap){

        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                //.setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        Toast.makeText(context,"Number of faces detected" + faces.size(), Toast.LENGTH_SHORT).show();

        // Log the number of faces
        Log.d(TAG, "detectFaces: number of faces = " + faces.size());

        // If there are no faces detected, show a Toast message
        if(faces.size() == 0){
            Toast.makeText(context,"No faces deteced", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Faces deteced " + faces.size(), Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        detector.release();

    }
}
