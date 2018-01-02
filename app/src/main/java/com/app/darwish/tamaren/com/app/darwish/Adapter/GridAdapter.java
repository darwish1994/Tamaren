package com.app.darwish.tamaren.com.app.darwish.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.darwish.tamaren.R;
import com.app.darwish.tamaren.com.app.darwish.tamaren.users.Course;

import java.util.ArrayList;

/**
 * Created by Darwish on 12/31/2017.
 */

public class GridAdapter extends ArrayAdapter<Course> {

    private Context myContexr;
    private int myResource;
    private ArrayList<Course> myListItem;
    private TextView coursename,courseprocess;
    public GridAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Course> objects) {
        super(context, resource, objects);
        myContexr=context;
        myResource=resource;
        myListItem=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(myContexr);
            view = vi.inflate(R.layout.course, null);
        }


        ImageView course =(ImageView)view.findViewById(R.id.course_image);
        coursename=(TextView)view.findViewById(R.id.course_name_tex);
        courseprocess=(TextView) view.findViewById(R.id.courseProgres);
        Course courseInPostion=myListItem.get(position);
        coursename.setText(courseInPostion.getName());
        courseprocess.setText("%"+courseInPostion.getProcess());

        course.setImageResource(R.drawable.image);



        return view;

    }
}
