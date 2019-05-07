package com.example.problemstatementlesson3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondArrayAdapter extends ArrayAdapter<Objects> {

    // Create ArrayList of objects
    private ArrayList<Objects> object1;
    // To hold the context object
    private Context context;


    public SecondArrayAdapter(Context context, int resource, ArrayList<Objects> object) {
        super(context, resource, object);
        // Store the object that is passed to this adapter
        object1 = object;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        TextView tvgrade = rowView.findViewById(R.id.tvgrade);
        TextView tvweek = rowView.findViewById(R.id.tvweek);

        //  row ListView is requesting.
        //  We get back the object at the same index.
        Objects currentobjects = object1.get(position);

        // Set the TextView to show grade and week
        tvgrade.setText(((Objects) currentobjects).getOgrade());
        tvweek.setText(((Objects) currentobjects).getOweek());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
