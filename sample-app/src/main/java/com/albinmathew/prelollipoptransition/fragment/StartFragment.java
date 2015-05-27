package com.albinmathew.prelollipoptransition.fragment;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albinmathew.transitions.fragment.FragmentTransitionLauncher;
import com.albinmathew.prelollipoptransition.R;

/**
 * Created by takam on 2015/05/16.
 */
public class StartFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.support_fragment_start, container, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EndFragment toFragment = new EndFragment();
                FragmentTransitionLauncher
                        .with(view.getContext())
                        .image(BitmapFactory.decodeResource(getResources(), R.drawable.photo))
                        .from(view.findViewById(R.id.imageView)).prepare(toFragment);
                getFragmentManager().beginTransaction().replace(R.id.content, toFragment).addToBackStack(null).commit();
            }
        });
        return v;
    }
}
