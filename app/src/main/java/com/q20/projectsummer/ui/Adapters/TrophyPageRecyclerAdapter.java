package com.q20.projectsummer.ui.Adapters;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.q20.projectsummer.R;

/**
 * Created by mohammadmahdi on 9/28/16.
 */
public class TrophyPageRecyclerAdapter extends RecyclerView.Adapter<TrophyPageRecyclerAdapter.ViewHolder> {

    private String[] texts;
    private int[] ids;

    public TrophyPageRecyclerAdapter(String[] texts, int[] ids){
        this.texts = texts;
        this.ids = ids;
    }

    @Override
    public TrophyPageRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.trophy_page_recycler_cardview_template, parent, false);
        return  new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(TrophyPageRecyclerAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        TextView textView = (TextView)cardView.findViewById(R.id.trophy_page_recycler_inner_textview);
        ImageView imageView = (ImageView)cardView.findViewById(R.id.trophy_page_recycler_inner_imageview);
        Drawable drawable = cardView.getResources().getDrawable(ids[position]);

        textView.setText(texts[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(texts[position]);

    }

    @Override
    public int getItemCount() {
        return texts.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
