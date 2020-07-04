package com.example.lideraturagaya;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.warkiz.widget.IndicatorSeekBar;

public class MainActivity extends AppCompatActivity {

    public static String cat1 = "LipSynchronization";
    public static String cat2 = "AppearanceStageImpact";
    public static String cat3 = "Choreography";
    public static String cat4 = "Entertainment";
    //TODO: CONTESTANT VARIABLE
    public static String contestant1 = "Archiel Nouf Espino";
    public static String starName1 = "Camila Cabello";
    public static String contestant2 = "Adrian Velasco";
    public static String starName2 = "Miley Cyrus";
    public static String contestant3 = "John Allen Castro";
    public static String starName3 = "Lady Gaga";
    public static String contestant4 = "The Chugugs - Group";
    public static String starName4 = "Little Mix";
    public static String contestant5 = "RYZ (Rise)";
    public static String starName5 = "Nicki M., Ariana G., Jessie J.";
    public static String contestant6 = "BIANS - Group";
    public static String starName6 = "Nicki Minaj, Little Mix";
    public static String contestant7 = "The Amazing Grace of Alexa - Group";
    public static String starName7 = "Shawn Mendez, Camilla Cabello";
    public static String contestant8 = "Renel Angelo C. Acuesta";
    public static String starName8 = "IV of Spades (Zild and Blaster)";
    public static String contestant9 = "John Jacob Portillano";
    public static String starName9 = "Whitney Houston";



    ImageView takipan;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //TODO: DONE VARIABLE
    public int done1 = 0;
    public int done2 = 0;
    public int done3 = 0;
    public int done4 = 0;
    public int done5 = 0;
    public int done6 = 0;
    public int done7 = 0;
    public int done8 = 0;
    public int done9 = 0;

    private ViewPager mViewPager;
    String judge;

    FirebaseFirestore FireInstance = FirebaseFirestore.getInstance();
    TextView contestantName;
    TextView starName;
    ImageView starPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra("Judge")){
            judge = getIntent().getExtras().getString("Judge");
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        final FloatingActionButton fab =  findViewById(R.id.fab);
         takipan = findViewById(R.id.takipan);

        mViewPager =findViewById(R.id.container);
        contestantName =findViewById(R.id.candidateName);
        starName =findViewById(R.id.starName);
        starPic =findViewById(R.id.starPic);


        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) { }
            @SuppressLint("RestrictedApi")
            @Override
            public void onPageSelected(int i) {
                //TODO: CHECKER IF VOTE WAS DONE
                final IndicatorSeekBar sb1_1 = findViewById(R.id.seekbar);
                final IndicatorSeekBar sb2_1 = findViewById(R.id.seekbar2);
                final IndicatorSeekBar sb3_1 = findViewById(R.id.seekbar3);
                final IndicatorSeekBar sb4_1 = findViewById(R.id.seekbar4);
                sb1_1.setProgress(1);
                sb2_1.setProgress(1);
                sb3_1.setProgress(1);
                sb4_1.setProgress(1);
                final ImageView done = findViewById(R.id.done);
                //TODO: START OF COPY
                if (i == 0){
                    contestantName.setText(contestant1);
                    starName.setText(starName1);
                    starPic.setImageResource(R.drawable.contestant1);  //TODO: picture
                    if (done1 == 1){
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                if (i == 1){
                    contestantName.setText(contestant2);
                    starName.setText(starName2);
                    starPic.setImageResource(R.drawable.contestant2); //TODO: picture
                    if (done2 == 1){
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);

                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                if (i == 2){
                    contestantName.setText(contestant3);
                    starName.setText(starName3);
                    starPic.setImageResource(R.drawable.contestant3); //TODO: picture
                    if (done3 == 1){
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: START OF COPY
                if (i == 3){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant4);  //TODO: contestant#
                    starName.setText(starName4);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant4);  //TODO: contestant#
                    if (done4 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                //TODO: START OF COPY
                if (i == 4){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant5);  //TODO: contestant#
                    starName.setText(starName5);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant5);  //TODO: contestant#
                    if (done5 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                //TODO: START OF COPY
                if (i == 5){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant6);  //TODO: contestant#
                    starName.setText(starName6);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant6);  //TODO: contestant#
                    if (done6 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                //TODO: START OF COPY
                if (i == 6){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant7);  //TODO: contestant#
                    starName.setText(starName7);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant7);  //TODO: contestant#
                    if (done7 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                //TODO: START OF COPY
                if (i == 7){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant8);  //TODO: contestant#
                    starName.setText(starName8);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant8);  //TODO: contestant#
                    if (done8 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY
                //TODO: START OF COPY
                if (i == 8){  //TODO: 0 1 2 3 4 5 6 7
                    contestantName.setText(contestant9);  //TODO: contestant#
                    starName.setText(starName9);  //TODO: starName#
                    starPic.setImageResource(R.drawable.contestant9);  //TODO: contestant#
                    if (done9 == 1){ //TODO: done#
                        fab.setVisibility(View.INVISIBLE);
                        sb1_1.setEnabled(false);
                        sb2_1.setEnabled(false);
                        sb3_1.setEnabled(false);
                        sb4_1.setEnabled(false);
                        done.setVisibility(View.VISIBLE);
                    }
                    else {
                        fab.setVisibility(View.VISIBLE);
                        sb1_1.setEnabled(true);
                        sb2_1.setEnabled(true);
                        sb3_1.setEnabled(true);
                        sb4_1.setEnabled(true);
                        done.setVisibility(View.INVISIBLE);
                    }
                }
                //TODO: END OF COPY

            }

            @Override
            public void onPageScrollStateChanged(int i) { }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                final IndicatorSeekBar sb1_1 = findViewById(R.id.seekbar);
                                final IndicatorSeekBar sb2_1 = findViewById(R.id.seekbar2);
                                final IndicatorSeekBar sb3_1 = findViewById(R.id.seekbar3);
                                final IndicatorSeekBar sb4_1 = findViewById(R.id.seekbar4);
                                final String name;

                                if (mViewPager.getCurrentItem() == 0) {
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant1; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                            score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                             )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done1 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                    mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done1 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done1 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                            //TODO: END OF COPY

                                }
                                else if (mViewPager.getCurrentItem() == 1){

                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant2; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done2 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done2 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done2 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 2){

                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant3; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done3 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done3 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done3 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 3){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant4; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done4 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done4 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done4 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 4){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant5; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done5 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done5 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done5 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 5){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant6; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done6 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done6 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done6 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 6){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant7; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done7 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done7 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done7 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 7){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant8; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done8 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done8 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done8 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                else if (mViewPager.getCurrentItem() == 8){
                                    //TODO: START OF COPY
                                    final int total = sb1_1.getProgress() + sb2_1.getProgress() + sb3_1.getProgress() +sb4_1.getProgress();
                                    name = contestant9; //TODO: EDIT THIS!
                                    final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                    progressDialog.setMessage("Please Wait...");
                                    progressDialog.setTitle("Saving");
                                    progressDialog.show();
                                    DocumentReference score = FireInstance
                                            .collection("scores")
                                            .document(""+judge)
                                            .collection(""+name)
                                            .document("0");
                                    score.update(
                                            ""+cat1, ""+sb1_1.getProgress(),
                                            ""+cat2, ""+sb2_1.getProgress(),
                                            ""+cat3, ""+sb3_1.getProgress(),
                                            ""+cat4, ""+sb4_1.getProgress(),
                                            "Total", ""+total
                                    )
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    if (judge.equals("judge1")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j1",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done9 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge2")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j2",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done9 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }

                                                    if (judge.equals("judge3")){
                                                        FireInstance.collection("print")
                                                                .document(""+name)
                                                                .update("j3",""+total)
                                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                    @Override
                                                                    public void onSuccess(Void aVoid) {
                                                                        done9 = 1;//TODO: EDIT THIS!
                                                                        progressDialog.dismiss();
                                                                        Snackbar.make(view, "Success! The score was sent to the database!", Snackbar.LENGTH_LONG)
                                                                                .setAction("Okay", null).show();
                                                                        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
                                                                    }
                                                                });
                                                    }
                                                }
                                            });
                                    //TODO: END OF COPY
                                }
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final IndicatorSeekBar sb1 = findViewById(R.id.seekbar);
                final IndicatorSeekBar sb2 = findViewById(R.id.seekbar2);
                final IndicatorSeekBar sb3 = findViewById(R.id.seekbar3);
                final IndicatorSeekBar sb4 = findViewById(R.id.seekbar4);

                builder.setMessage("Is this final? \n \n" +cat1+": "+sb1.getProgress()+"/20\n" +cat2+": "+sb2.getProgress()+"/30\n" +cat3+": "+sb3.getProgress()+"/30\n" +cat4+": "+sb4.getProgress()+"/20\n")
                        .setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

            }
        });

    }
    public static void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup)child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child, 0);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //TODO: MAX VALUE
            return 9;  //TODO: EDIT THIS!
        }
    }
}
