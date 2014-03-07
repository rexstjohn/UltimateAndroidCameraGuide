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

package com.ultimate.camera.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ultimate.camera.R;
import com.ultimate.camera.views.TwoWayView;

/**
 * A demonstration of showing images in a horizontal image gallery.
 *
 * Created by Rex St. John (on behalf of AirPair.com) on 3/4/14.
 */
public class HorizontalPhotoGalleryFragment extends SimplePhotoGalleryListFragment {

    // Left and right scrolling two way view
    private TwoWayView mHorizontalListView;

    public HorizontalPhotoGalleryFragment(){
        super();
    }

    /**
     * Static factory method
     * @param sectionNumber
     * @return
     */
    public static HorizontalPhotoGalleryFragment newInstance(int sectionNumber) {
        HorizontalPhotoGalleryFragment fragment = new HorizontalPhotoGalleryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Create View!
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_horizontal_gallery, container, false);

        // Set the mAdapter
        mEmptyTextView = (TextView)view.findViewById(R.id.empty);
        mHorizontalListView = (TwoWayView)  view.findViewById(R.id.horizontalList);
        mHorizontalListView.setAdapter(mAdapter);
        mHorizontalListView.setItemMargin(10);

        resolveEmptyText();

        return view;
    }
}
