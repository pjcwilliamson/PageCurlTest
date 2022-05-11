package org.williamsonministry.pagecurltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager2;
    private FragmentCollectionAdapter1 adapter;
    private ArrayList<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWords();

        viewPager2 = findViewById(R.id.viewPager2);

        //viewPager2.setPageTransformer(new HingeTransformation());
//        adapter = new ViewPager2Adapter(this);
//
//        adapter.setWords(words);
//        viewPager2.setAdapter(adapter);
//        BookFlipPageTransformer2 bookFlipPageTransformer2 = new BookFlipPageTransformer2();
//        bookFlipPageTransformer2.setEnableScale(true);
//        bookFlipPageTransformer2.setScaleAmountPercent(10f);
//
//        viewPager2.setPageTransformer(bookFlipPageTransformer2);

        adapter = new FragmentCollectionAdapter1(getSupportFragmentManager(),1, words);
        viewPager2.setAdapter(adapter);

        BookFlipPageTransformer bookFlipPageTransformer2 = new BookFlipPageTransformer();
        bookFlipPageTransformer2.setEnableScale(true);
        bookFlipPageTransformer2.setScaleAmountPercent(10f);

        viewPager2.setPageTransformer(true, bookFlipPageTransformer2);


    }

    private void setWords() {
        words.add("Hydrogen");
        words.add("Helium");
        words.add("Lithium");
        words.add("Beryllium");
    }
}