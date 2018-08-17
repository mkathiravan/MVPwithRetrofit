package com.example.abacus.mvpwithretrofit.ui.activity.MainActivity.presenter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.abacus.mvpwithretrofit.R;
import com.example.abacus.mvpwithretrofit.data.network.model.Actors;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ViewHolder> {

    public interface OnMovieAdapter{
        void onMovieClicked(Actors actors);
    }

    private List<Actors> mItems;
    private OnMovieAdapter mListener;

    public ActorsAdapter(OnMovieAdapter listener) {
        mListener = listener;
        mItems = new ArrayList<>();
    }

    public void setItems(List<Actors> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Actors actors = getItem(position);

        holder.setOnClickListener(actors);
        holder.setTitle(actors.getName());
        holder.setImage(actors.getImage());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private Actors getItem(int position) {
        return mItems.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setImage(String imageUrl) {
            Glide.with(itemView.getContext()).load(imageUrl).into(image);

            }

            private void setOnClickListener(Actors actors) {
            itemView.setTag(actors);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onMovieClicked((Actors) view.getTag());
        }
    }
}
