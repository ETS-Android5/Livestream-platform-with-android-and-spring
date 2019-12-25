package com.t4.androidclient.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t4.androidclient.R;
import com.t4.androidclient.ui.channel.ChannelStreamsOfTypeActivity;

import java.util.ArrayList;
import java.util.List;

import viewModel.StreamTypeViewModel;


public class ChannelTypeAdapter extends RecyclerView.Adapter<ChannelTypeAdapter.ViewHolder>{
    private List<StreamTypeViewModel> listTypeView;
    private Context context;
    private ArrayList<String> dataList;
    byte[] imageBytes;
    Bitmap thumnailImage;

    public ChannelTypeAdapter(List<StreamTypeViewModel> listTypeView, Context context, ArrayList<String> dataList) {
        this.listTypeView = listTypeView;
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_channel_type_stream, parent, false);
        // Return a new holder instance
        ChannelTypeAdapter.ViewHolder viewHolder = new ChannelTypeAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StreamTypeViewModel typeViewModel = listTypeView.get(position);

        if (typeViewModel.getTypeThumnailImage() != null) {

        }
        ImageView thumnailImageView = holder.thumnailImage;
        if (thumnailImage != null && thumnailImage.getByteCount() > 0) {
            thumnailImageView.setImageBitmap(thumnailImage);
        } else {
            thumnailImageView.setImageDrawable(context.getDrawable(R.drawable.background_channel));
        }

        TextView typeNameView = holder.typeName;
        typeNameView.setText(typeViewModel.getTypeName());

        TextView numberOfTypeView = holder.numberOfType;
        numberOfTypeView.setText(typeViewModel.getNumberOfType()+" streams");

        TextView numberOfTypeTextView = holder.numberOfTypeText;
        int numberText = typeViewModel.getNumberOfType();
        if(numberText<1000){
            numberOfTypeTextView.setText(numberText+"");
        }else{
            numberOfTypeTextView.setText(numberText/1000+" N");
        }
    }

    @Override
    public int getItemCount() {
        return listTypeView.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumnailImage;
        public TextView typeName;
        public TextView numberOfType;
        public TextView numberOfTypeText;

        public ViewHolder(View itemView) {
            super(itemView);
            thumnailImage = (ImageView) itemView.findViewById(R.id.item_type_thumbail_image);
            typeName = (TextView) itemView.findViewById(R.id.item_type_name);
            numberOfType = (TextView) itemView.findViewById(R.id.item_type_number_stream);
            numberOfTypeText = (TextView) itemView.findViewById(R.id.item_type_number_stream_text);

            // Handle item click and set the selection
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int typeID = listTypeView.get(getAdapterPosition()).getId();
                    int numberOfType= listTypeView.get(getAdapterPosition()).getNumberOfType();
                    String typeName= listTypeView.get(getAdapterPosition()).getTypeName();
                    Intent intent=new Intent(context, ChannelStreamsOfTypeActivity.class);
                    intent.putExtra("type_id",typeID);
                    intent.putExtra("owner_id",Integer.valueOf(dataList.get(0)));
                    intent.putExtra("channel_name",dataList.get(1));
                    intent.putExtra("type_name",typeName);
                    intent.putExtra("stream_number",numberOfType);
                    context.startActivity(intent);
                }
            });
        }
    }

    // interface AsyncResponse
    public interface AsyncResponse {
        void processFinish(String output);
    }

}
