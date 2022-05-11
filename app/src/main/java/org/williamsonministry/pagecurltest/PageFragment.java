package org.williamsonministry.pagecurltest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private String layoutName;

    public PageFragment(int i) {
        layoutName = "page_"+i+"_fragment";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int resID = getResources().getIdentifier(layoutName, "layout", getActivity().getPackageName());
        return inflater.inflate(resID, container, false);
    }
}
