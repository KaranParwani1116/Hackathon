package com.example.hackathon.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hackathon.R;
import com.example.hackathon.adapters.SliderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    private SliderAdapter adapter;

    private int mCurrentPage;

    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //setting up onboarding screen
        adapter = new SliderAdapter(this);
        pager.setAdapter(adapter);

        addDotIndicator(0);

        //recording the page movement of viewpager

        pager.addOnPageChangeListener(onPageChangeListener);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotIndicator(position);
            mCurrentPage = position;

            if (position == 0) {
                button.setVisibility(View.GONE);
                button.setEnabled(false);
                button2.setEnabled(true);
                button.setText("");
                button2.setText("Next");
            } else if (position == dots.length - 1) {
                button.setEnabled(true);
                button2.setEnabled(true);
                button.setVisibility(View.VISIBLE);
                button.setText("Back");
                button2.setText("Finish");

            } else {
                button.setEnabled(true);
                button2.setEnabled(true);
                button.setVisibility(View.VISIBLE);
                button.setText("Back");
                button2.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @OnClick({R.id.button})
    public void buttonButtonControls()
    {
       pager.setCurrentItem(mCurrentPage-1);
    }

    @OnClick(R.id.button2)
    public void button2ButtonControls()
    {
        pager.setCurrentItem(mCurrentPage+1);

        if(mCurrentPage == 3)
        {
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void addDotIndicator(int position) {
        dots = new TextView[4];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(Color.WHITE);
            dots[i].setTextSize(35);
            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(Color.GRAY);
        }
    }



}
