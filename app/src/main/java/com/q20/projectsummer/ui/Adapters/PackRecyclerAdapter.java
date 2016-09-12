package com.q20.projectsummer.ui.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.q20.projectsummer.R;
import com.q20.projectsummer.ui.PackSelectorActivity;

public class PackRecyclerAdapter extends RecyclerView.Adapter<PackRecyclerAdapter.ViewHolder> {
    private String[] packNames;
    private String[] packInfos;

    public PackRecyclerAdapter(String[] packNames, String[] packInfos) {
        this.packNames = packNames;
        this.packInfos = packInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.view_pack, parent, false);

        return new ViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LinearLayout linearLayout = holder.linearLayout;

        TextView packName = (TextView) linearLayout.findViewById(R.id.pack_name);
        TextView packInfo = (TextView) linearLayout.findViewById(R.id.pack_info);

        String check = packNames[position];
        packName.setText(packNames[position]);
        packInfo.setText(packInfos[position]);
    }

    @Override
    public int getItemCount() {
        return PackSelectorActivity.packNumbers;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        public ViewHolder(LinearLayout view){
            super(view);
            this.linearLayout = view;
        }
    }
}
