package com.example.calculdemoyenne;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText note1,note2,note3;
    TextView textv;
    Button calculer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note1=findViewById(R.id.note1);
        note2=findViewById(R.id.note2);
        note3=findViewById(R.id.note3);
        textv=findViewById(R.id.textView2);
        calculer=findViewById(R.id.calcul);

        calculer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View view) {
                String val1=note1.getText().toString();
                String val2=note2.getText().toString();
                String val3 =note3.getText().toString();

                if (val1.isEmpty()|| val2.isEmpty() || val3.isEmpty()){
                    // alert
                    showAlertBox();}
                    else {
                        float num1=Float.parseFloat(val1);
                        float num2=Float.parseFloat(val2);
                        float num3=Float.parseFloat(val3);
                        float res=(num3+num2+num1)/3;

                    if ((num1>=0) && (num1<=20)){
                    if ((num2>=0) && (num2<=20)){
                       if ((num3>=0) && (num3<=20)){
                           if (res>=10.0){

                               Intent i = new Intent(MainActivity.this, ReussiActivity.class);
                               i.putExtra("moyenne",res);

                               startActivity(i);



                           }else
                           //redirect fail
                           textv.setText("fail avec moy "+res);
                       }else {
                           // notes entre 0 20
                           showAlertBox2();
                       }
                    }else {
                        // notes
                        showAlertBox2();

                    }

                }else {
                        // notes 0 20
                        showAlertBox2();
                    }


                }
            }



        });
        
    }
    private void showAlertBox() {


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Attention! ");
        alertDialog.setMessage("Veuillez saisir les 3 notes pour calculer la moyenne!");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alertDialog.show();
        clearfields();
    }
    public void clearfields(){
        note1.setText("");
        note2.setText("");
        note3.setText("");
    }
    private void showAlertBox2() {


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Attention! ");
        alertDialog.setMessage("Veuillez saisir des notes entre 0 et 20!");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        alertDialog.show();
        clearfields();
    }
    }



