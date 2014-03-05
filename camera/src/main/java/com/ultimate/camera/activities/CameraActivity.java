/*
 * Copyright (c) 2014 Rex St. John on behalf of AirPair.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.ultimate.camera.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * This activity assists in trapping the camera's "State" e.g. where the camera plans
 * on saving it's resulting file and URI. This activity saves this information to the bundle
 * and retrieves it on resume. This is necessary because when the Android external camera starts,
 * the file path anf URI get collected and won't be available on resume, resulting in a crash.
 * <p/>
 * Samsung devices, in particular may crash if you don't do this:
 * Reference: http://stackoverflow.com/questions/8248327/my-android-camera-uri-is-returning-a-null-value-but-the-samsung-fix-is-in-place
 * <p/>
 * Created by Rex St. John (on behalf of AirPair.com) on 3/4/14.
 */
public class CameraActivity extends ActionBarActivity {

    // Storage for camera image URI components
    private final static String CAPTURED_PHOTO_PATH_KEY = "mCurrentPhotoPath";
    private final static String CAPTURED_PHOTO_URI_KEY = "mCapturedImageURI";

    // Required for camera operations in order to save the image file on resume.
    private String mCurrentPhotoPath = null;
    private Uri mCapturedImageURI = null;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if (mCurrentPhotoPath != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_PATH_KEY, mCurrentPhotoPath);
        }
        if (mCapturedImageURI != null) {
            savedInstanceState.putString(CAPTURED_PHOTO_URI_KEY, mCapturedImageURI.toString());
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_PATH_KEY)) {
            mCurrentPhotoPath = savedInstanceState.getString(CAPTURED_PHOTO_PATH_KEY);
        }
        if (savedInstanceState.containsKey(CAPTURED_PHOTO_URI_KEY)) {
            mCapturedImageURI = Uri.parse(savedInstanceState.getString(CAPTURED_PHOTO_URI_KEY));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Getters and setters.
     */

    public String getCurrentPhotoPath() {
        return mCurrentPhotoPath;
    }

    public void setCurrentPhotoPath(String mCurrentPhotoPath) {
        this.mCurrentPhotoPath = mCurrentPhotoPath;
    }

    public Uri getCapturedImageURI() {
        return mCapturedImageURI;
    }

    public void setCapturedImageURI(Uri mCapturedImageURI) {
        this.mCapturedImageURI = mCapturedImageURI;
    }
}