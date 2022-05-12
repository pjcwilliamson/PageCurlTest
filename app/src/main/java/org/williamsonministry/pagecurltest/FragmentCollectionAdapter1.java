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
        String word1 = words.get((position+1)*2-2);
        String word2;
        if (words.size() > (position+1)*2-1) {
            word2 = words.get((position + 1) * 2 - 1);
        } else  {
            word2 = "Blank";
        }
        DisplayCardsFragment fragment = DisplayCardsFragment.newInstance(word1, word2);
        return fragment;
    }

    @Override
    public int getCount() {
        if (words.size() % 2 == 0)  {
            return words.size()/2;
        }   else    {
            return (1+words.size())/2;
        }
    }

//    @Override
//    public float getPageWidth(int position) {
//        return (0.5f);
//    }
}
