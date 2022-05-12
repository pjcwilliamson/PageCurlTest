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
    public static final String ARG_NAME_1 = "name1";
    public static final String ARG_NAME_2 = "name2";

    private String mName1, mName2;
    private TextView txtLeft, txtRight;

    public DisplayCardsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mName1 Parameter 1.
     * @param mName2 Parameter 2
     * @return A new instance of fragment DisplayCardsFragment.
     */
    // TOD0: Rename and change types and number of parameters
    public static DisplayCardsFragment newInstance(String mName1, String mName2) {
        DisplayCardsFragment fragment = new DisplayCardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME_1, mName1);
        args.putString(ARG_NAME_2, mName2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName1 = getArguments().getString(ARG_NAME_1);
            mName2 = getArguments().getString(ARG_NAME_2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_0_fragment, container, false);

        txtLeft = v.findViewById(R.id.txtLeft);

        txtLeft.setText(mName1);

        txtRight = v.findViewById(R.id.txtRight);

        txtRight.setText(mName2);

        return v;
    }
}
