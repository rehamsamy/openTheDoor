package com.openthedoor.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.openthedoor.R;
import com.openthedoor.pojo.ReviewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.Holder> {

    Context context;
    List<ReviewsItem> reviewsItemList;
    OnItemInterface onItemInterface;


    public interface  OnItemInterface{
        void onItemClick(int position,Holder holder);
    }

    public ReviewAdapter(Context mContext,List<ReviewsItem> mList ,OnItemInterface itemInterface) {
        context=mContext;
        reviewsItemList=mList;
        onItemInterface=itemInterface;
    }
    @NonNull
    @Override
    public ReviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.review_list_item,viewGroup,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.Holder holder, int pos) {
        onItemInterface.onItemClick(pos,holder);
        ReviewsItem item=reviewsItemList.get(pos);
//        String userName=item.getUserName();
        String reviewText=item.getNotes();
       String image=item.getProviderImage();
       // int rate=item.getRate();

        TextView name=(TextView)holder.item.findViewById(R.id.user_name);
        TextView note=(TextView) holder.item.findViewById(R.id.review_txt);
        ImageView imageView=(ImageView) holder.item.findViewById(R.id.user_image);
        RatingBar ratingBar=(RatingBar) holder.item.findViewById(R.id.reviews_ratingBar_id);

        name.setText(item.getProviderName());
        note.setText(reviewText);
//        ratingBar.setRating(rate);

        Picasso.get().load(image).placeholder(R.drawable.review_user_pic).into(imageView);

    }

    @Override
    public int getItemCount() {

        return reviewsItemList.size();
    }

    public class Holder  extends RecyclerView.ViewHolder{

        View item;
        public Holder(@NonNull View itemView) {
            super(itemView);
            item=itemView;
        }
    }
}
