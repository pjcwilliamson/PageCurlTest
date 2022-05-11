package org.williamsonministry.pagecurltest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentCollectionAdapter extends FragmentStateAdapter {
    public FragmentCollectionAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new PageFragment(position);
    }

    @Override
    public int getItemCount() {

        return 4;
    }
}
