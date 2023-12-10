package com.example.myapplicationcs137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private RadioGroup phtype;
    private RadioButton radiobutton;
    private RadioButton radiobutton2;
    private Button button;
    private Button button2;
    private RadioGroup depth;
    private TextView textview;
    private ProgressBar progressBar;

    int progress = 0;
 //   private Spinner spin;




    private static double[][] amicrp = {
            {6.62,2.56,1.02,0.43,10.92},
            {7.89,3.084,1.24,0.53,12.92},
            {6.38,2.53,1.027,0.42,10.48},
            {6.75,2.66,1.074,0.45,10.68},
            {8.47,3.59,1.45,0.64,12.15},
            {11.43,4.50,1.82,0.76,17.98},
            {8.058,2.98,1.19,0.48,12.46},
            {5.32,2.17,0.85,0.35,8.35},
            {6.68,2.65,1.074,0.44,11.04},
            {5.68,2.16,0.84,0.369,8.45},
            {9.50,3.42,1.39,0.58,15.01},
            {5.629,2.41,1.01,0.42,9.43},
            {6.72,2.85,1.212,0.481,10.84},
            {12.311,4.536,1.86,0.79,19.39},
            {7.13,2.77,1.16,0.45,11.43}
    };

    private static double[][] aficrp = {
            {7.20,2.79,1.089,0.45,11.51},
            {8.33,3.07,1.23,0.499,13.19},
            {7.35,2.95,1.196,0.48,11.93},
            {7.797,3.037,1.147,0.499,12.59},
            {8.57,3.49,1.51,0.62,13.90},
            {9.32,3.40,1.31,0.56,13.90},
            {9.76,3.60,1.33,0.56,14.48},
            {6.50,2.49,0.99,0.416,10.13},
            {7.45,2.90,1.16,0.48,11.86},
            {6.41,2.55,1.06,0.41,10.61},
            {9.75,3.55,1.43,0.59,15.27},
            {6.16,2.60,1.07,0.44,10.37},
            {6.88,2.96,1.22,0.51,11.54},
            {12.73,4.64,1.89,0.799,20.09},
            {7.73,2.97,1.16,0.50,12.27}
    };

    private static double[][] amornl = {
            {7.82,3.17,1.31,0.56,12.82},
            {7.68,2.78,1.096,0.45,12.067},
            {6.91,2.79,1.134,0.46,11.25},
            {7.54,2.89,1.16,0.48,11.96},
            {0.0,0.0,0.0,0.0,0.0},
            {9.49,3.51,1.45,0.61,15.14},
            {8.48,3.06,1.24,0.50,13.27},
            {5.55,2.19,0.85,0.145,8.82},
            {7.024,2.73,1.09,0.45,11.23},
            {2.03,0.84,0.34,0.13,3.34},
            {9.76,3.67,1.52,0.64,15.59},
            {0.0,0.0,0.0,0.0,0.0},
            {0.0,0.0,0.0,0.0,0.0},
            {11.41,4.22,1.74,0.74,18.093},
            {6.45,2.52,1.005,0.42,10.35}
    };

    private static double[][] afornl = {
            {8.99,3.61,1.49,0.63,14.71},
            {8.38,3.035,1.199,0.495,13.25},
            {7.33,2.91,1.17,0.48,11.82},
            {7.59,2.87,1.14,0.47,12.01},
            {9.30,3.92,1.66,0.71,15.37},
            {8.29,2.98,1.17,0.46,13.16},
            {9.33,3.36,1.37,0.56,14.68},
            {6.09,2.34,0.93,0.39,9.73},
            {7.55,2.87,1.15,0.48,12.01},
            {4.12,1.58,0.65,0.26,6.63},
            {9.87,3.76,1.56,0.66,15.85},
            {0.0,0.0,0.0,0.0,0.0},
            {0.0,0.0,0.0,0.0,0.0},
            {15.52,5.51,2.26,0.96,24.27},
            {7.07,2.70,1.08,0.45,11.28}
    };

    static double[][] wt = {
        {0.12}, //RBM
        {0.12}, //Colon
        {0.12}, //Lung
        {0.12}, //Stomach
        {0.12}, //Breast
        {0.08}, //gonads
        {0.04}, //Bladder
        {0.04}, //esophagus
        {0.04}, //liver
        {0.04}, //thyroid
        {0.01},  //endosteum
        {0.01}, //brain
        {0.01},  //salivary glands
        {0.01}, //skin
        {0.12}, //remainder
    };

    private double  mf = 0.03156;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
      //  addListenerOnButton2();

    }


        public void addListenerOnButton () {

            phtype = (RadioGroup) findViewById(R.id.phtype);
            button = (Button) findViewById(R.id.button);
            depth = (RadioGroup) findViewById(R.id.depth);

            progressBar = (ProgressBar) findViewById(R.id.progressBar4);






            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {


                    // get selected radio button from radioGroup
                    int selectedId = phtype.getCheckedRadioButtonId();
                    int selectedId2 = depth.getCheckedRadioButtonId();



                    // find the radiobutton by returned id
                    radiobutton = (RadioButton) findViewById(selectedId);
                    radiobutton2 = (RadioButton) findViewById(selectedId2);

                  //  Toast.makeText(MainActivity.this,
                  //          radiobutton.getText(), Toast.LENGTH_SHORT).show();

                    final TextView textView = (TextView) findViewById(R.id.textView4);
                  //  String string = getString(radiobutton.getText());
/*
                    if(radiobutton.getText().toString()=="AM (ICRP)"){
                        String text1;
                        text1 = "Adult male ICRP";



                    }
*/

                    Spinner spinner = (Spinner)findViewById(R.id.spinner);
                    String text = spinner.getSelectedItem().toString();

                    int org =0;

                    if(text.equals("RBM"))
                    {
                        org = 1;
                    }

                    if(text.equals("Colon"))
                    {
                        org = 2;
                    }

                    if(text.equals("Lung"))
                    {
                        org = 3;
                    }

                    if(text.equals("Stomach"))
                    {
                        org = 4;
                    }

                    if(text.equals("Breast"))
                    {
                        org = 5;
                    }

                    if(text.equals("Gonads"))
                    {
                        org = 6;
                    }

                    if(text.equals("Bladder"))
                    {
                        org = 7;
                    }

                    if(text.equals("Esophagus"))
                    {
                        org = 8;
                    }
                    if(text.equals("Liver"))
                    {
                        org = 9;
                    }
                    if(text.equals("Thyroid"))
                    {
                        org = 10;
                    }
                    if(text.equals("Endosteum"))
                    {
                        org = 11;
                    }
                    if(text.equals("Brain"))
                    {
                        org = 12;
                    }
                    if(text.equals("Salivary Glands"))
                    {
                        org = 13;
                    }
                    if(text.equals("Skin"))
                    {
                        org = 14;
                    }
                    if(text.equals("Remainder"))
                    {
                        org = 15;
                    }

                    String dph = radiobutton2.getText().toString();
                    int dz =0;
                    if(dph.equals("0-5 cm"))
                    { dz=1; }
                    if(dph.equals("5-10 cm"))
                    { dz=2; }
                    if(dph.equals("10-15 cm"))
                    { dz=3; }
                    if(dph.equals("15-20 cm"))
                    { dz=4; }
                    if(dph.equals("0-20 cm"))
                    { dz=5; }






                    EditText edtxt = (EditText)findViewById(R.id.editTextNumberDecimal);
                    String text2 = edtxt.getText().toString();

                    double number = Double.valueOf(edtxt.getText().toString());

                    String phnt = radiobutton.getText().toString();



                    String val1 = "error 001";
                    String val2 = "error 002";
                    if (phnt.equals("AM (ICRP)"))
                    {

                        double cc = amicrp[org-1][dz-1];

                        double vald = cc*number*mf;

                        val1 = String.valueOf(vald);


                        double effamicrp = 0.;
                        for(int i=0; i<15; i++)
                        {
                            double eqdosem;
                            double eqdosef;
                            double eqdoseav;

                            eqdosem = amicrp[i][dz-1] * mf * number;

                            eqdosef = aficrp[i][dz-1] * mf * number;

                            eqdoseav = ((eqdosem+eqdosef)/(2.0) );

                            effamicrp = (eqdoseav * wt[i][0]) + effamicrp;
                            //     cout << amicrp[i][dz-1] << endl;
                        }

                       val2 = String.valueOf(effamicrp);


                       // val1 = vald.;
                    }


                    if (phnt.equals("AF (ICRP)"))
                    {

                        double cc = aficrp[org-1][dz-1];

                        double vald = cc*number*mf;

                        val1 = String.valueOf(vald);

                        double effamicrp = 0.;
                        for(int i=0; i<15; i++)
                        {
                            double eqdosem;
                            double eqdosef;
                            double eqdoseav;

                            eqdosem = amicrp[i][dz-1] * mf * number;

                            eqdosef = aficrp[i][dz-1] * mf * number;

                            eqdoseav = ((eqdosem+eqdosef)/(2.0) );

                            effamicrp = (eqdoseav * wt[i][0]) + effamicrp;

                           // effamicrp = (eqdose * wt[i][0]) + effamicrp;
                            //     cout << amicrp[i][dz-1] << endl;
                        }

                        val2 = String.valueOf(effamicrp);


                        // val1 = vald.;
                    }


                    if (phnt.equals("AM (ORNL)"))
                    {

                        double cc = amornl[org-1][dz-1];

                        double vald = cc*number*mf;

                        val1 = String.valueOf(vald);

                        double effamicrp = 0.;
                        for(int i=0; i<15; i++)
                        {
                           // double eqdose;
                            double eqdosem;
                            double eqdosef;
                            double eqdoseav;

                            eqdosem = amornl[i][dz-1] * mf * number;

                            eqdosef = afornl[i][dz-1] * mf * number;

                            eqdoseav = ((eqdosem+eqdosef)/(2.0) );

                            effamicrp = (eqdoseav * wt[i][0]) + effamicrp;



                           // eqdose = amornl[i][dz-1] * mf * number;

                          //  effamicrp = (eqdose * wt[i][0]) + effamicrp;
                            //     cout << amicrp[i][dz-1] << endl;
                        }

                        val2 = String.valueOf(effamicrp);


                        // val1 = vald.;
                    }


                    if (phnt.equals("AF (ORNL)"))
                    {

                        double cc = afornl[org-1][dz-1];

                        double vald = cc*number*mf;

                        val1 = String.valueOf(vald);

                        double effamicrp = 0.;
                        for(int i=0; i<15; i++)
                        {
                            double eqdosem;
                            double eqdosef;
                            double eqdoseav;

                            eqdosem = amornl[i][dz-1] * mf * number;

                            eqdosef = afornl[i][dz-1] * mf * number;

                            eqdoseav = ((eqdosem+eqdosef)/(2.0) );

                            effamicrp = (eqdoseav * wt[i][0]) + effamicrp;
                            //     cout << amicrp[i][dz-1] << endl;
                        }

                        val2 = String.valueOf(effamicrp);


                        // val1 = vald.;
                    }






/*
                    try {
                        Thread.sleep(1000);
                        progressBar.setProgress(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

*/

                    progressBar.setProgress(100);

                    textView.setText(phnt+ " chosen\n"+dph+ " depth\n"+text+" organ\n"+text2+" Bq/kg\n\n"+"Equivalent dose:\n"+val1+" uSv/year\n"+"Effective dose:\n"+val2+" uSv/year");

                   // progressBar.setProgress(0);



                }



            });


        }







    }
