package com.albinmathew.prelollipoptransition.support_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albinmathew.transitions.fragment.ExitFragmentTransition;
import com.albinmathew.transitions.fragment.FragmentTransition;
import com.albinmathew.prelollipoptransition.R;

/**
 * Created by takam on 2015/05/16.
 */
public class SupportEndFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.support_fragment_end, container, false);
        final ExitFragmentTransition exitFragmentTransition = FragmentTransition.with(this).to(v.findViewById(R.id.fragment_imageView)).start(savedInstanceState);
        exitFragmentTransition.startExitListening();
        return v;
    }

}
