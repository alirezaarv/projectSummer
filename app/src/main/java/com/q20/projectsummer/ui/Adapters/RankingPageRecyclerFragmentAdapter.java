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

/**
 * Created by mohammadmahdi on 9/20/16.
 */
public class RankingPageRecyclerFragmentAdapter extends RecyclerView.Adapter<RankingPageRecyclerFragmentAdapter.ViewHolder> {

    String[] texts;
    int[] ids;

    public RankingPageRecyclerFragmentAdapter(String[] texts, int[] ids){
        this.texts = texts;
        this.ids = ids;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.ranking_page_cardview_template, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        TextView textView = (TextView)cardView.findViewById(R.id.ranking_page_inner_cardview_text);
        ImageView imageView = (ImageView)cardView.findViewById(R.id.ranking_page_inner_cardview_image);
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
        CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
