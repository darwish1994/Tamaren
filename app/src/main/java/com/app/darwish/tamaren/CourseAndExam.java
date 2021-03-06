package com.app.darwish.tamaren;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.app.darwish.tamaren.com.app.darwish.exam.Exam;
import com.app.darwish.tamaren.com.app.darwish.exam.Question;
import com.app.darwish.tamaren.com.app.darwish.exam.QuestionChoice;
import com.app.darwish.tamaren.com.app.darwish.tamaren.users.Course;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CourseAndExam extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RadioButton ch1,ch2,ch3,ch4;
    private EditText answer;
    private Button brvise,next,result;
    private ArrayList<Exam> exams =new ArrayList<>();
    private Exam exam=new Exam();
    private Question[] question;
    private QuestionChoice[] questionChoices;
    private String[] strings={"1","2","3","4"};
    Course course;

    public CourseAndExam() {


        for(int i=0;i>5;i++) {
            question[i].setqNumber(i);
            question[i].setQuestion("heloo");
            question[i].setAnswer("ffjfj");
            questionChoices[i].setChoice(strings);
            questionChoices[i].setqNumber(i);
            questionChoices[i].setQuestion("heloo");
            questionChoices[i].setAnswer("ffjfj");
        }
        exam.setCompletQueton(question);
        exam.setQuestionChoices(questionChoices);
        exams.add(exam);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_and_exam);
        ch1=(RadioButton)findViewById(R.id.choice1);
        ch2=(RadioButton)findViewById(R.id.choice2);
        ch3=(RadioButton)findViewById(R.id.choice3);
        ch4=(RadioButton)findViewById(R.id.choice4);
        answer=(EditText)findViewById(R.id.complet_question);
        brvise=(Button)findViewById(R.id.privice);
        next=(Button)findViewById(R.id.next);
        result=(Button)findViewById(R.id.result);
        /***********************************************************/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().push().child("ccc");
        myRef.setValue(exams);




        /*******************************************************************/
        try {
            Bundle bundle=getIntent().getExtras();
            course=bundle.getParcelable("data");
            if(course!=null){
                Log.v("darwish",course.getName());

            }

        }catch (Exception e){
            Log.v("darwish",e.getMessage());
        }




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.course_and_exam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
