package com.q20.projectsummer.ui.Adapters;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.q20.projectsummer.R;


public class FindRivalRecyclerAdapter extends RecyclerView.Adapter<FindRivalRecyclerAdapter.ViewHolder>{

    String[] texts;
    int[] ids;

    public FindRivalRecyclerAdapter(String[] texts, int[] ids){
        this.texts = texts;
        this.ids = ids;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.find_rival_cardview_template, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CardView cardView = holder.cardView;

        TextView textView = (TextView)cardView.findViewById(R.id.find_rival_card_template_text);
        textView.setText(texts[position]);

        ImageView imageView = (ImageView)cardView.findViewById(R.id.find_rival_card_template_image_view);
        Drawable drawable = cardView.getResources().getDrawable(ids[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(texts[position]);
    }

    @Override
    public int getItemCount() {
        return texts.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
