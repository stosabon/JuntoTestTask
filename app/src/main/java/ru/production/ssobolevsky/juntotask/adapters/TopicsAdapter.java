package ru.production.ssobolevsky.juntotask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.production.ssobolevsky.juntotask.R;
import ru.production.ssobolevsky.juntotask.activities.MainActivity;
import ru.production.ssobolevsky.juntotask.models.Topic;

/**
 * Created by pro on 11.04.2018.
 */

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.ViewHolder> {


    private Context mContext;
    private LayoutInflater mInflater;

    private List<Topic> mTopics;

    public TopicsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mTopics = new ArrayList<Topic>();
        this.mContext = context;
    }


    @NonNull
    @Override
    public TopicsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.topic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicsAdapter.ViewHolder holder, int position) {

        final Topic topic = mTopics.get(position);
        holder.mName.setText(topic.getName());
        holder.mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("Slug", topic.getSlug());
                intent.putExtra("Topic", topic.getName());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.topic_name);
        }
    }

    public List<Topic> getTopics() {
        return mTopics;
    }

    public void setTopics(List<Topic> topics) {
        mTopics = topics;
    }
}
