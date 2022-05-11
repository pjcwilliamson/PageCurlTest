package org.williamsonministry.pagecurltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ViewPager2Adapter adapter;
    private ArrayList<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWords();

        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setPageTransformer(new HingeTransformation());
        adapter = new ViewPager2Adapter(this);
        adapter.setWords(words);
        viewPager2.setAdapter(adapter);


    }

    private void setWords() {
        words.add("Hydrogen");
        words.add("Helium");
        words.add("Lithium");
        words.add("Beryllium");
    }
}