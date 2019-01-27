package com.rasel.onboardingscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SlidePagerAdapter extends PagerAdapter {
    private Context context;

    SlidePagerAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return title.length;
    }

    private String[] title = {"FIND RESTAURANT", "PICK THE BEST", "CHOOSE YOUR MEAL", "MEAL IS ON THE WAY"};
    private String[] description = {"Find the best restaurant in your neighborhood",
            "Pick the right place using trusted rating and reviews", "Easily find the type of food your're craving"
            , "Get ready and comfortable while our biker bring your meal at your door"};

    private int[] imageList = {R.drawable.ic_restaurant, R.drawable.ic_free_breakfast, R.drawable.select_food, R.drawable.ic_delivery_bike};

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView imageView = view.findViewById(R.id.slideImageView);
        TextView textView = view.findViewById(R.id.slideTitle);

        imageView.setImageResource(imageList[position]);
        textView.setText(title[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
