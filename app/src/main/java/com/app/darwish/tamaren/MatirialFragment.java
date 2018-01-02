package com.app.darwish.tamaren;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import com.app.darwish.tamaren.com.app.darwish.Adapter.GridAdapter;
import com.app.darwish.tamaren.com.app.darwish.tamaren.users.Course;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MatirialFragment extends Fragment {

    private String TAG=this.getClass().getSimpleName();
    private GridView gridLayout;
    private GridAdapter MyAdapter;
    private ArrayList<Course> MyCourses =new ArrayList<>();
    private Course course;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference rootRef,myref;

    public MatirialFragment() {

        MyCourses.add(new Course(1,"Arabic",80 ));
        MyCourses.add(new Course(2, "math",60));
        MyCourses.add(new Course(3, "english",50));
        MyCourses.add(new Course(4, "geographic",40));
        MyCourses.add(new Course(5, "french",30));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         rootRef= database.getReference();
//         myref=rootRef.child("courses");
//         myref.push().setValue(MyCourses);

        View view = inflater.inflate(R.layout.matirial_fragment, container, false);
        MyAdapter =new GridAdapter(view.getContext(),R.layout.course,MyCourses);
        gridLayout=(GridView) view.findViewById(R.id.courses_list);
        gridLayout.setAdapter(MyAdapter);
        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),CourseAndExam.class);
                Bundle bundle=new Bundle();
                bundle.putParcelable("data",MyCourses.get(1));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;
    }
}
