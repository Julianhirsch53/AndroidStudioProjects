package com.example.jhirsch.gehirntrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView countdown;
    TextView aufgabe;
    TextView fortschritt;
    TextView resultat;
    TextView ergebnis;
    TextView richtig;
    Button lösung1;
    Button lösung2;
    Button lösung3;
    Button lösung4;
    Button neustarten;
    int Zahl1;
    int Zahl2;
    int Rechenart;
    int Auswahl;
    int Lösungplus;
    int Lösungminus;
    int counter = 0;

    final CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            countdown.setText(String.valueOf(millisUntilFinished/1000) + "s");
        }

        @Override
        public void onFinish() {
            fortschritt.animate().translationXBy(-440).setDuration(2000);
            fortschritt.animate().translationYBy(450).setDuration(2000);
            fortschritt.animate().scaleXBy(3).setDuration(2000);
            fortschritt.animate().scaleYBy(3).setDuration(2000);
            richtig = findViewById(R.id.richtig);
            if(fortschritt.getText().toString().equals("1")) {
                richtig.setText("richtige Antwort!");
            }else {
                richtig.setText("richtige Antworten!");
            }
            richtig.setVisibility(View.VISIBLE);
            neustarten = findViewById(R.id.neustarten);
            neustarten.setVisibility(View.VISIBLE);
            neustarten.setText("Neu Starten");
            countdown.setVisibility(View.INVISIBLE);
            aufgabe.setVisibility(View.INVISIBLE);
            resultat.setVisibility(View.INVISIBLE);
            ergebnis.setVisibility(View.INVISIBLE);
            lösung1.setVisibility(View.INVISIBLE);
            lösung2.setVisibility(View.INVISIBLE);
            lösung3.setVisibility(View.INVISIBLE);
            lösung4.setVisibility(View.INVISIBLE);

        }
    }.start();

    public void NeuStarten(View view) {
        fortschritt.animate().translationXBy(440).setDuration(500);
        fortschritt.animate().translationYBy(-450).setDuration(500);
        fortschritt.animate().scaleXBy(-3).setDuration(500);
        fortschritt.animate().scaleYBy(-3).setDuration(500);
        countdown.setVisibility(View.VISIBLE);
        aufgabe.setVisibility(View.VISIBLE);
        resultat.setVisibility(View.VISIBLE);
        ergebnis.setVisibility(View.VISIBLE);
        lösung1.setVisibility(View.VISIBLE);
        lösung2.setVisibility(View.VISIBLE);
        lösung3.setVisibility(View.VISIBLE);
        lösung4.setVisibility(View.VISIBLE);
        richtig.setVisibility(View.INVISIBLE);
        countDownTimer.start();
        counter = 0;
        fortschritt.setText(Integer.toString(counter));
        neustarten.setVisibility(View.INVISIBLE);
    }



    public void checkIfRight(View view) {
        if(Rechenart == 0) {
            if(lösung1.getText().toString().equals(Integer.toString(Lösungplus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));

            }else{
                resultat.setText("Leider falsch");
            }
        }else {
            if(lösung1.getText().toString().equals(Integer.toString(Lösungminus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));

            } else {
                resultat.setText("Leider falsch");
            }
        }

        Zahl1 = (int) (Math.random()*100);
        Zahl2 = (int) (Math.random()*100);
        Rechenart = (int) (Math.random()*2);
        Auswahl = (int) (Math.random()*4);

        if(Rechenart == 0) {
            aufgabe.setText(Integer.toString(Zahl1) + " + " + Integer.toString(Zahl2));
            Lösungplus = Zahl1 + Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungplus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungplus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungplus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungplus));
                    break;
            }
        } else {
            aufgabe.setText(Integer.toString(Zahl1) + " - " + Integer.toString(Zahl2));
            Lösungminus = Zahl1 - Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungminus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungminus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungminus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungminus));
                    break;
            }
        }

        countDownTimer.cancel();
        countDownTimer.start();
    }

    public void checkIfRight2(View view) {
        if(Rechenart == 0) {
            if(lösung2.getText().toString().equals(Integer.toString(Lösungplus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            }else{
                resultat.setText("Leider falsch");
            }
        }else {
            if(lösung2.getText().toString().equals(Integer.toString(Lösungminus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            } else {
                resultat.setText("Leider falsch");
            }
        }

        Zahl1 = (int) (Math.random()*100);
        Zahl2 = (int) (Math.random()*100);
        Rechenart = (int) (Math.random()*2);
        Auswahl = (int) (Math.random()*4);

        if(Rechenart == 0) {
            aufgabe.setText(Integer.toString(Zahl1) + " + " + Integer.toString(Zahl2));
            Lösungplus = Zahl1 + Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungplus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungplus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungplus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungplus));
                    break;
            }
        } else {
            aufgabe.setText(Integer.toString(Zahl1) + " - " + Integer.toString(Zahl2));
            Lösungminus = Zahl1 - Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungminus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungminus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungminus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungminus));
                    break;
            }
        }

        countDownTimer.cancel();
        countDownTimer.start();
    }

    public void checkIfRight3(View view) {
        if(Rechenart == 0) {
            if(lösung3.getText().toString().equals(Integer.toString(Lösungplus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            }else{
                resultat.setText("Leider falsch");
            }
        }else {
            if(lösung3.getText().toString().equals(Integer.toString(Lösungminus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            } else {
                resultat.setText("Leider falsch");
            }
        }

        Zahl1 = (int) (Math.random()*100);
        Zahl2 = (int) (Math.random()*100);
        Rechenart = (int) (Math.random()*2);
        Auswahl = (int) (Math.random()*4);

        if(Rechenart == 0) {
            aufgabe.setText(Integer.toString(Zahl1) + " + " + Integer.toString(Zahl2));
            Lösungplus = Zahl1 + Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungplus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungplus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungplus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungplus));
                    break;
            }
        } else {
            aufgabe.setText(Integer.toString(Zahl1) + " - " + Integer.toString(Zahl2));
            Lösungminus = Zahl1 - Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungminus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungminus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungminus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungminus));
                    break;
            }
        }

        countDownTimer.cancel();
        countDownTimer.start();
    }

    public void checkIfRight4(View view) {
        if(Rechenart == 0) {
            if(lösung4.getText().toString().equals(Integer.toString(Lösungplus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            }else{
                resultat.setText("Leider falsch");
            }
        }else {
            if(lösung4.getText().toString().equals(Integer.toString(Lösungminus))) {
                counter++;
                resultat.setText("Korrekt");
                fortschritt.setText(Integer.toString(counter));
            } else {
                resultat.setText("Leider falsch");
            }
        }

        Zahl1 = (int) (Math.random()*100);
        Zahl2 = (int) (Math.random()*100);
        Rechenart = (int) (Math.random()*2);
        Auswahl = (int) (Math.random()*4);

        if(Rechenart == 0) {
            aufgabe.setText(Integer.toString(Zahl1) + " + " + Integer.toString(Zahl2));
            Lösungplus = Zahl1 + Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungplus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungplus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungplus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungplus));
                    break;
            }
        } else {
            aufgabe.setText(Integer.toString(Zahl1) + " - " + Integer.toString(Zahl2));
            Lösungminus = Zahl1 - Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungminus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungminus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungminus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungminus));
                    break;
            }
        }

        countDownTimer.cancel();
        countDownTimer.start();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdown = findViewById(R.id.Countdown);
        aufgabe = findViewById(R.id.Aufgabe);
        fortschritt = findViewById(R.id.Fortschritt);
        resultat = findViewById(R.id.Resultat);
        lösung1 = findViewById(R.id.Lösung1);
        lösung2 = findViewById(R.id.Lösung2);
        lösung3 = findViewById(R.id.Lösung3);
        lösung4 = findViewById(R.id.Lösung4);
        ergebnis = findViewById(R.id.Ergebnis);

        lösung1.setScaleX(0);
        lösung1.animate().scaleX(1).setDuration(500);
        lösung2.setScaleX(0);
        lösung2.animate().scaleX(1).setStartDelay(500).setDuration(500);
        lösung3.setScaleX(0);
        lösung3.animate().scaleX(1).setStartDelay(1000).setDuration(500);
        lösung4.setScaleX(0);
        lösung4.animate().scaleX(1).setStartDelay(1500).setDuration(500);






        Zahl1 = (int) (Math.random()*100);
        Zahl2 = (int) (Math.random()*100);
        Rechenart = (int) (Math.random()*2);
        Auswahl = (int) (Math.random()*4);



        if(Rechenart == 0) {
            aufgabe.setText(Integer.toString(Zahl1) + " + " + Integer.toString(Zahl2));
            Lösungplus = Zahl1 + Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungplus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungplus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungplus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungplus));
                    break;
            }
        } else {
            aufgabe.setText(Integer.toString(Zahl1) + " - " + Integer.toString(Zahl2));
            Lösungminus = Zahl1 - Zahl2;
            switch(Auswahl) {
                case 0:
                    lösung1.setText(Integer.toString(Lösungminus));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 1:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString(Lösungminus));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 2:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString(Lösungminus));
                    lösung4.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    break;
                case 3:
                    lösung1.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung2.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung3.setText(Integer.toString((int) ((Math.random()*200)+1)));
                    lösung4.setText(Integer.toString(Lösungminus));
                    break;
            }
        }
    }
}
