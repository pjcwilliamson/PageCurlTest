package org.williamsonministry.pagecurltest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayCardsFragment extends Fragment {
    public static final String ARG_NAME = "name";

    private String mName;
    private TextView textView;

    public DisplayCardsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mName Parameter 1.
     * @return A new instance of fragment DisplayCardsFragment.
     */
    // TOD0: Rename and change types and number of parameters
    public static DisplayCardsFragment newInstance(String mName) {
        DisplayCardsFragment fragment = new DisplayCardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, mName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_0_fragment, container, false);

        textView = v.findViewById(R.id.textView2);

        textView.setText(mName);

        return v;
    }
}
