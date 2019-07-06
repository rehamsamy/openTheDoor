package com.openthedoor.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openthedoor.R;
import com.openthedoor.pojo.NotficationItem;

import java.util.List;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.Holder> {
    Context mContext;
    List<NotficationItem> notficationList;
    public PaginationAdapter(Context context,List<NotficationItem> mList){
        mContext=context;
        notficationList=mList;
    }

    @NonNull
    @Override
    public PaginationAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.pagination_item,viewGroup,false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaginationAdapter.Holder holder, int position) {
        NotficationItem item=notficationList.get(position);
        String time=item.getCreatedAt();
       TextView notifyTime= (TextView) holder.item.findViewById(R.id.notify_time);
       notifyTime.setText(time);
       TextView notifyData=(TextView) holder.item.findViewById(R.id.notify_message_info);
       notifyData.setText(item.getUserNotfEn());

    }

    @Override
    public int getItemCount() {
        return notficationList.size();
    }

    public void setTasks(List<NotficationItem> notficationItems) {
        this.notficationList=notficationItems;
        notifyDataSetChanged();
    }

    public class Holder  extends RecyclerView.ViewHolder{

        View item;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item=itemView;
        }
    }
}
