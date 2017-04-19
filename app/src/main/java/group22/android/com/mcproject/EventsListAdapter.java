package group22.android.com.mcproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lakshmisagar on 4/14/2017.
 */

public class EventsListAdapter extends RecyclerView.Adapter<EventsListAdapter.ViewHolder> {
    private ArrayList<String> eventsList;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventTitle;
        public ViewHolder(View v) {
            super(v);
            eventTitle = (TextView) v.findViewById(R.id.title);
        }
    }

    public void eventsList(int position, String item) {
        eventsList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = eventsList.indexOf(item);
        eventsList.remove(position);
        notifyItemRemoved(position);
    }

    public EventsListAdapter(ArrayList<String> myDataset) {
        eventsList = myDataset;
    }

    @Override
    public EventsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventsrow, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = eventsList.get(position);
        holder.eventTitle.setText(eventsList.get(position));
        holder.eventTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(name);    // Do something
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

}