package com.example.hackathon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hackathon.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;

    private int [] slideImages={
            R.drawable.logo,R.drawable.whytwo,R.drawable.help,R.drawable.three
    };

    private String [] headings={
            "POSMENT","WHY THIS GAME?","HOW TO PLAY?","DEVELOPERS"
    };

    private String [] descriptions={
            "An Interactive game to develop positive psychology for women through choices.",
            "Since Crime against women are increasing day by day and child sex ratio is declining constantly" +
            ".\n\nThis game will develop general public understanding and generate respect for the rights and" +
            " dignity of women.This game will promote the objectives of Beti Bachao Beti Padhao movement initiated by government" ,

            "This game is totally based on choices the choice you choose,the scenario will be presented to you.\n\n" +
                    "For each situation there will be 4 options you have to choose one of the option and it will give you output" +
                    " according to it which will develop your psychology in positive way",

            " Ankita Bansal\n\n Ankit Sharma\n\n Anchit thakur\n\n Anand Kumar\n\n Kartik Daad\n\n Karan Parwani"
    };

    public SliderAdapter(Context context)
    {
        this.context = context;
    }



    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.slide_layout,container,false);

        TextView heading=v.findViewById(R.id.top);
        TextView bottom=v.findViewById(R.id.bottom);
        CircleImageView imageView=v.findViewById(R.id.pic);


        imageView.setImageResource(slideImages[position]);
        heading.setText(headings[position]);
        bottom.setText(descriptions[position]);


        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
