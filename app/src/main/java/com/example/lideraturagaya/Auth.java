package com.example.lideraturagaya;

import android.content.Intent;

import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Auth extends AppCompatActivity {
    Spinner spinner;
    Button button, dl_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        dl_link = findViewById(R.id.dl_link);
        setTitle("CHOOSE JUDGE# TO PROCEED");
        ArrayList<String> judges = new ArrayList<>();
        judges.add("judge1");
        judges.add("judge2");
        judges.add("judge3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, judges);
        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Auth.this, MainActivity.class);
                go.putExtra("Judge", spinner.getSelectedItem().toString());
                startActivity(go);
            }
        });

        dl_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final Document mDoc = new Document();
                final String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                final String currentTime = new SimpleDateFormat(" hh:mm:ss a", Locale.US).format(new Date());
                final String heading = currentDate + currentTime;
                final String mFilePath = Environment.getExternalStorageDirectory() + "/LipSyncBattle.pdf";
                final FirebaseFirestore FireInstance = FirebaseFirestore.getInstance();
                final DecimalFormat decim = new DecimalFormat("0.00");



                final Double[] total = new Double[40]; //HOW MANY?  //TODO: EDIT THIS
                //TODO: STRING con1, con2, con3, --- ??
                final String[] con1 = new String[4];
                final String[] con2 = new String[4];
                final String[] con3 = new String[4];
                final String[] con4 = new String[4];
                final String[] con5 = new String[4];
                final String[] con6 = new String[4];
                final String[] con7 = new String[4];
                final String[] con8 = new String[4];
                final String[] con9 = new String[4];

                //TODO: PRINT PATH
                final DocumentReference c1 = FireInstance.collection("print").document(""+MainActivity.contestant1);
                final DocumentReference c2 = FireInstance.collection("print").document(""+MainActivity.contestant2);
                final DocumentReference c3 = FireInstance.collection("print").document(""+MainActivity.contestant3);
                final DocumentReference c4 = FireInstance.collection("print").document(""+MainActivity.contestant4);
                final DocumentReference c5 = FireInstance.collection("print").document(""+MainActivity.contestant5);
                final DocumentReference c6 = FireInstance.collection("print").document(""+MainActivity.contestant6);
                final DocumentReference c7 = FireInstance.collection("print").document(""+MainActivity.contestant7);
                final DocumentReference c8 = FireInstance.collection("print").document(""+MainActivity.contestant8);
                final DocumentReference c9 = FireInstance.collection("print").document(""+MainActivity.contestant9);


                //TODO: START OF COPY
                c1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                DocumentSnapshot document = task.getResult();
                                if (task.isSuccessful()) {
                                    if (document.exists()) {
                                        con1[1] = document.get("j1").toString(); //TODO: EDIT THIS
                                        con1[2] = document.get("j2").toString(); //TODO: EDIT THIS
                                        con1[3] = document.get("j3").toString(); //TODO: EDIT THIS
                                        total[1] = (Double.parseDouble(//TODO: EDIT THIS
                                                con1[1])+Double.parseDouble(//TODO: EDIT THIS
                                                        con1[2])+Double.parseDouble(//TODO: EDIT THIS
                                                                con1[3]))/3; //TODO: EDIT THIS
                                        //TODO: START OF COPY
                                        c2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                DocumentSnapshot document = task.getResult();
                                                if (task.isSuccessful()) {
                                                    if (document.exists()) {
                                                        con2[1] = document.get("j1").toString(); //TODO: EDIT THIS
                                                        con2[2] = document.get("j2").toString(); //TODO: EDIT THIS
                                                        con2[3] = document.get("j3").toString(); //TODO: EDIT THIS
                                                        total[2] = (Double.parseDouble(//TODO: EDIT THIS
                                                                con2[1])+Double.parseDouble(//TODO: EDIT THIS
                                                                con2[2])+Double.parseDouble(//TODO: EDIT THIS
                                                                con2[3]))/3; //TODO: EDIT THIS
                                                        //TODO: START OF COPY
                                                        c3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                DocumentSnapshot document = task.getResult();
                                                                if (task.isSuccessful()) {
                                                                    if (document.exists()) {
                                                                        con3[1] = document.get("j1").toString(); //TODO: EDIT THIS
                                                                        con3[2] = document.get("j2").toString(); //TODO: EDIT THIS
                                                                        con3[3] = document.get("j3").toString(); //TODO: EDIT THIS
                                                                        total[3] = (Double.parseDouble(//TODO: EDIT THIS
                                                                                con3[1])+Double.parseDouble(//TODO: EDIT THIS
                                                                                con3[2])+Double.parseDouble(//TODO: EDIT THIS
                                                                                con3[3]))/3; //TODO: EDIT THIS

                                                                        //TODO: START OF COPY
                                                                        c4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                DocumentSnapshot document = task.getResult();
                                                                                if (task.isSuccessful()) {
                                                                                    if (document.exists()) {
                                                                                        con4[1] = document.get("j1").toString(); //TODO: con#
                                                                                        con4[2] = document.get("j2").toString(); //TODO: con#
                                                                                        con4[3] = document.get("j3").toString(); //TODO: con#
                                                                                        total[4] = (Double.parseDouble(//TODO: total[#]
                                                                                                con4[1])+Double.parseDouble(//TODO: con#
                                                                                                con4[2])+Double.parseDouble(//TODO: con#
                                                                                                con4[3]))/3; //TODO: con#

                                                                                        //TODO: START OF COPY
                                                                                        c5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                            @Override
                                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                DocumentSnapshot document = task.getResult();
                                                                                                if (task.isSuccessful()) {
                                                                                                    if (document.exists()) {
                                                                                                        con5[1] = document.get("j1").toString(); //TODO: con#
                                                                                                        con5[2] = document.get("j2").toString(); //TODO: con#
                                                                                                        con5[3] = document.get("j3").toString(); //TODO: con#
                                                                                                        total[5] = (Double.parseDouble(//TODO: total[#]
                                                                                                                con5[1])+Double.parseDouble(//TODO: con#
                                                                                                                con5[2])+Double.parseDouble(//TODO: con#
                                                                                                                con5[3]))/3; //TODO: con#

                                                                                                        //TODO: START OF COPY
                                                                                                        c6.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                                            @Override
                                                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                                DocumentSnapshot document = task.getResult();
                                                                                                                if (task.isSuccessful()) {
                                                                                                                    if (document.exists()) {
                                                                                                                        con6[1] = document.get("j1").toString(); //TODO: con#
                                                                                                                        con6[2] = document.get("j2").toString(); //TODO: con#
                                                                                                                        con6[3] = document.get("j3").toString(); //TODO: con#
                                                                                                                        total[6] = (Double.parseDouble(//TODO: total[#]
                                                                                                                                con6[1])+Double.parseDouble(//TODO: con#
                                                                                                                                con6[2])+Double.parseDouble(//TODO: con#
                                                                                                                                con6[3]))/3; //TODO: con#

                                                                                                                        //TODO: START OF COPY
                                                                                                                        c7.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                                                            @Override
                                                                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                                                DocumentSnapshot document = task.getResult();
                                                                                                                                if (task.isSuccessful()) {
                                                                                                                                    if (document.exists()) {
                                                                                                                                        con7[1] = document.get("j1").toString(); //TODO: con#
                                                                                                                                        con7[2] = document.get("j2").toString(); //TODO: con#
                                                                                                                                        con7[3] = document.get("j3").toString(); //TODO: con#
                                                                                                                                        total[7] = (Double.parseDouble(//TODO: total[#]
                                                                                                                                                con7[1])+Double.parseDouble(//TODO: con#
                                                                                                                                                con7[2])+Double.parseDouble(//TODO: con#
                                                                                                                                                con7[3]))/3; //TODO: con#

                                                                                                                                        //TODO: START OF COPY
                                                                                                                                        c8.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                                                                            @Override
                                                                                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                                                                DocumentSnapshot document = task.getResult();
                                                                                                                                                if (task.isSuccessful()) {
                                                                                                                                                    if (document.exists()) {
                                                                                                                                                        con8[1] = document.get("j1").toString(); //TODO: con#
                                                                                                                                                        con8[2] = document.get("j2").toString(); //TODO: con#
                                                                                                                                                        con8[3] = document.get("j3").toString(); //TODO: con#
                                                                                                                                                        total[8] = (Double.parseDouble(//TODO: total[#]
                                                                                                                                                                con8[1])+Double.parseDouble(//TODO: con#
                                                                                                                                                                con8[2])+Double.parseDouble(//TODO: con#
                                                                                                                                                                con8[3]))/3; //TODO: con#
                                                                                                                                                        //TODO: START OF COPY
                                                                                                                                                        c9.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                                                                                                                            @Override
                                                                                                                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                                                                                                                DocumentSnapshot document = task.getResult();
                                                                                                                                                                if (task.isSuccessful()) {
                                                                                                                                                                    if (document.exists()) {
                                                                                                                                                                        con9[1] = document.get("j1").toString(); //TODO: con#
                                                                                                                                                                        con9[2] = document.get("j2").toString(); //TODO: con#
                                                                                                                                                                        con9[3] = document.get("j3").toString(); //TODO: con#
                                                                                                                                                                        total[9] = (Double.parseDouble(//TODO: total[#]
                                                                                                                                                                                con9[1])+Double.parseDouble(//TODO: con#
                                                                                                                                                                                con9[2])+Double.parseDouble(//TODO: con#
                                                                                                                                                                                con9[3]))/3; //TODO: con#

                                                                                                                                                                        //TODO: START OF COPY. GENERATING DATA
                                                                                                                                                                        try {
                                                                                                                                                                            PdfWriter.getInstance(mDoc, new FileOutputStream(mFilePath));
                                                                                                                                                                            mDoc.open();
                                                                                                                                                                            try{
                                                                                                                                                                                mDoc.add(new Paragraph("Event: LipSync Battle Season 3"));
                                                                                                                                                                                mDoc.add(new Paragraph("File Created: "+heading));
                                                                                                                                                                                mDoc.add(new Paragraph(" "));
                                                                                                                                                                                mDoc.add(new LineSeparator());
                                                                                                                                                                                PdfPTable cell = new PdfPTable(5);
                                                                                                                                                                                PdfPCell nameCol = new PdfPCell(new Paragraph("NAME"));
                                                                                                                                                                                PdfPCell j1 = new PdfPCell(new Paragraph("Judge #1"));
                                                                                                                                                                                PdfPCell j2 = new PdfPCell(new Paragraph("Judge #2"));
                                                                                                                                                                                PdfPCell j3 = new PdfPCell(new Paragraph("Judge #3"));
                                                                                                                                                                                PdfPCell finalCol = new PdfPCell(new Paragraph("Final Score"));
                                                                                                                                                                                nameCol.setBackgroundColor(BaseColor.ORANGE);
                                                                                                                                                                                j1.setBackgroundColor(BaseColor.ORANGE);
                                                                                                                                                                                j2.setBackgroundColor(BaseColor.ORANGE);
                                                                                                                                                                                j3.setBackgroundColor(BaseColor.ORANGE);
                                                                                                                                                                                finalCol.setBackgroundColor(BaseColor.ORANGE);
                                                                                                                                                                                nameCol.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                                                                                                                                                j1.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                                                                                                                                                j2.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                                                                                                                                                j3.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                                                                                                                                                finalCol.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                                                                                                                                                cell.addCell(nameCol);
                                                                                                                                                                                cell.addCell(j1);
                                                                                                                                                                                cell.addCell(j2);
                                                                                                                                                                                cell.addCell(j3);
                                                                                                                                                                                cell.addCell(finalCol);

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c1name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant1 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName1)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c1g1 = new PdfPCell(new Paragraph(""+con1[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c1g2 = new PdfPCell(new Paragraph(""+con1[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c1g3 = new PdfPCell(new Paragraph(""+con1[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c1g4 = new PdfPCell(new Paragraph(""+decim.format(total[1]))); //TODO: EDIT THIS

                                                                                                                                                                                c1name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c1g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c1g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c1g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c1g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------
                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c2name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant2 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName2)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c2g1 = new PdfPCell(new Paragraph(""+con2[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c2g2 = new PdfPCell(new Paragraph(""+con2[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c2g3 = new PdfPCell(new Paragraph(""+con2[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c2g4 = new PdfPCell(new Paragraph(""+decim.format(total[2]))); //TODO: EDIT THIS

                                                                                                                                                                                c2name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c2g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c2g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c2g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c2g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------
                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c3name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant3 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName3)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c3g1 = new PdfPCell(new Paragraph(""+con3[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c3g2 = new PdfPCell(new Paragraph(""+con3[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c3g3 = new PdfPCell(new Paragraph(""+con3[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c3g4 = new PdfPCell(new Paragraph(""+decim.format(total[3]))); //TODO: EDIT THIS

                                                                                                                                                                                c3name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c3g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c3g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c3g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c3g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c4name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant4 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName4)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c4g1 = new PdfPCell(new Paragraph(""+con4[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c4g2 = new PdfPCell(new Paragraph(""+con4[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c4g3 = new PdfPCell(new Paragraph(""+con4[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c4g4 = new PdfPCell(new Paragraph(""+decim.format(total[4]))); //TODO: EDIT THIS

                                                                                                                                                                                c4name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c4g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c4g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c4g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c4g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c5name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant5 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName5)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c5g1 = new PdfPCell(new Paragraph(""+con5[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c5g2 = new PdfPCell(new Paragraph(""+con5[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c5g3 = new PdfPCell(new Paragraph(""+con5[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c5g4 = new PdfPCell(new Paragraph(""+decim.format(total[5]))); //TODO: EDIT THIS

                                                                                                                                                                                c5name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c5g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c5g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c5g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c5g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c6name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant6 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName6)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c6g1 = new PdfPCell(new Paragraph(""+con6[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c6g2 = new PdfPCell(new Paragraph(""+con6[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c6g3 = new PdfPCell(new Paragraph(""+con6[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c6g4 = new PdfPCell(new Paragraph(""+decim.format(total[6]))); //TODO: EDIT THIS

                                                                                                                                                                                c6name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c6g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c6g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c6g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c6g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c7name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant7 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName7)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c7g1 = new PdfPCell(new Paragraph(""+con7[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c7g2 = new PdfPCell(new Paragraph(""+con7[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c7g3 = new PdfPCell(new Paragraph(""+con7[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c7g4 = new PdfPCell(new Paragraph(""+decim.format(total[7]))); //TODO: EDIT THIS

                                                                                                                                                                                c7name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c7g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c7g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c7g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c7g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c8name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant8 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName8)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c8g1 = new PdfPCell(new Paragraph(""+con8[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c8g2 = new PdfPCell(new Paragraph(""+con8[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c8g3 = new PdfPCell(new Paragraph(""+con8[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c8g4 = new PdfPCell(new Paragraph(""+decim.format(total[8]))); //TODO: EDIT THIS

                                                                                                                                                                                c8name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c8g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c8g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c8g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c8g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------

                                                                                                                                                                                //TODO: START OF COPY ---------------------------
                                                                                                                                                                                PdfPCell c9name = new PdfPCell(new Paragraph(""
                                                                                                                                                                                        +MainActivity.contestant9 +" - " //TODO: EDIT THIS
                                                                                                                                                                                        +MainActivity.starName9)); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c9g1 = new PdfPCell(new Paragraph(""+con9[1])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c9g2 = new PdfPCell(new Paragraph(""+con9[2])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c9g3 = new PdfPCell(new Paragraph(""+con9[3])); //TODO: EDIT THIS
                                                                                                                                                                                PdfPCell c9g4 = new PdfPCell(new Paragraph(""+decim.format(total[9]))); //TODO: EDIT THIS

                                                                                                                                                                                c9name.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c9g1.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c9g2.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c9g3.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                c9g4.setHorizontalAlignment(Element.ALIGN_CENTER); //TODO: EDIT THIS
                                                                                                                                                                                //TODO: -----------------------------------------




                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c1name);
                                                                                                                                                                                cell.addCell(c1g1);
                                                                                                                                                                                cell.addCell(c1g2);
                                                                                                                                                                                cell.addCell(c1g3);
                                                                                                                                                                                cell.addCell(c1g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c2name);
                                                                                                                                                                                cell.addCell(c2g1);
                                                                                                                                                                                cell.addCell(c2g2);
                                                                                                                                                                                cell.addCell(c2g3);
                                                                                                                                                                                cell.addCell(c2g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c3name);
                                                                                                                                                                                cell.addCell(c3g1);
                                                                                                                                                                                cell.addCell(c3g2);
                                                                                                                                                                                cell.addCell(c3g3);
                                                                                                                                                                                cell.addCell(c3g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c4name);
                                                                                                                                                                                cell.addCell(c4g1);
                                                                                                                                                                                cell.addCell(c4g2);
                                                                                                                                                                                cell.addCell(c4g3);
                                                                                                                                                                                cell.addCell(c4g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c5name);
                                                                                                                                                                                cell.addCell(c5g1);
                                                                                                                                                                                cell.addCell(c5g2);
                                                                                                                                                                                cell.addCell(c5g3);
                                                                                                                                                                                cell.addCell(c5g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c6name);
                                                                                                                                                                                cell.addCell(c6g1);
                                                                                                                                                                                cell.addCell(c6g2);
                                                                                                                                                                                cell.addCell(c6g3);
                                                                                                                                                                                cell.addCell(c6g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c7name);
                                                                                                                                                                                cell.addCell(c7g1);
                                                                                                                                                                                cell.addCell(c7g2);
                                                                                                                                                                                cell.addCell(c7g3);
                                                                                                                                                                                cell.addCell(c7g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c8name);
                                                                                                                                                                                cell.addCell(c8g1);
                                                                                                                                                                                cell.addCell(c8g2);
                                                                                                                                                                                cell.addCell(c8g3);
                                                                                                                                                                                cell.addCell(c8g4);
                                                                                                                                                                                //TODO: -------------
                                                                                                                                                                                //TODO: EDIT THIS EACH!
                                                                                                                                                                                cell.addCell(c9name);
                                                                                                                                                                                cell.addCell(c9g1);
                                                                                                                                                                                cell.addCell(c9g2);
                                                                                                                                                                                cell.addCell(c9g3);
                                                                                                                                                                                cell.addCell(c9g4);
                                                                                                                                                                                //TODO: -------------

                                                                                                                                                                                //UPDATE LATER
                                                                                                                                                                                cell.setWidthPercentage(100);
                                                                                                                                                                                mDoc.add(cell);
                                                                                                                                                                                Toast.makeText(Auth.this, "DONE!", Toast.LENGTH_SHORT).show();

                                                                                                                                                                            }
                                                                                                                                                                            catch (DocumentException e){
                                                                                                                                                                                e.printStackTrace();

                                                                                                                                                                            }
                                                                                                                                                                            mDoc.close();
                                                                                                                                                                        }
                                                                                                                                                                        catch (Exception e){

                                                                                                                                                                        }
                                                                                                                                                                        //TODO: END OF FETCHING DATA

                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        });
                                                                                                                                                        //TODO: END OF COPY

                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                        //TODO: END OF COPY
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        });
                                                                                                                        //TODO: END OF COPY
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                        //TODO: END OF COPY
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        });
                                                                                        //TODO: END OF COPY
                                                                                    }
                                                                                }
                                                                            }
                                                                        });
                                                                        //TODO: END OF COPY
                                                                    }
                                                                }
                                                            }
                                                        });
                                                        //TODO: END OF COPY
                                                    }
                                                }
                                            }
                                        });
                                        //TODO: END OF COPY
                                    }
                                }
                            }
                        });
                //TODO: END OF COPY

            }
        });
    }
}
