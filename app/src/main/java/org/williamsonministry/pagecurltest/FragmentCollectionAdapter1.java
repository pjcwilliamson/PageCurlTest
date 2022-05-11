package org.williamsonministry.pagecurltest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentCollectionAdapter1 extends FragmentStatePagerAdapter {
    ArrayList<String> words;


    public FragmentCollectionAdapter1(@NonNull FragmentManager fm, int behavior, ArrayList<String> words) {
        super(fm, behavior);
        this.words = words;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        DisplayCardsFragment fragment = DisplayCardsFragment.newInstance(words.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public float getPageWidth(int position) {
        return (0.5f);
    }
}
