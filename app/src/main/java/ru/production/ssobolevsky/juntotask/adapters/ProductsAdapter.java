package ru.production.ssobolevsky.juntotask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ru.production.ssobolevsky.juntotask.R;
import ru.production.ssobolevsky.juntotask.activities.MainActivity;
import ru.production.ssobolevsky.juntotask.activities.ProductActivity;
import ru.production.ssobolevsky.juntotask.models.TechPostCard;

/**
 * Created by pro on 06.04.2018.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater mInflater;

    private List<TechPostCard> mTechPostCards;

    public ProductsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mTechPostCards = new ArrayList<TechPostCard>();
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final TechPostCard techPostCard = mTechPostCards.get(position);
        holder.mName.setText(techPostCard.getName());
        holder.mDescription.setText(techPostCard.getDescription());
        holder.mVotesCount.setText(techPostCard.getVotesCount() + " upvotes");
        Picasso.get().load(techPostCard.getThumbnail().getImageUrl()).into(holder.mThumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductActivity.class);
                intent.putExtra("name", techPostCard.getName());
                intent.putExtra("desc", techPostCard.getDescription());
                intent.putExtra("votes", techPostCard.getVotesCount());
                intent.putExtra("page", techPostCard.getWebPage());
                intent.putExtra("screenshot", techPostCard.getScreenshot().getSmallScreenshot());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTechPostCards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mDescription;
        TextView mVotesCount;
        ImageView mThumbnail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.post_name);
            mDescription = (TextView) itemView.findViewById(R.id.post_description);
            mVotesCount = (TextView) itemView.findViewById(R.id.post_votes);
            mThumbnail = (ImageView) itemView.findViewById(R.id.post_thumnail);
        }
    }

    public List<TechPostCard> getTechPostCards() {
        return mTechPostCards;
    }

    public void setTechPostCards(List<TechPostCard> techPostCards) {
        mTechPostCards = techPostCards;
    }
}
