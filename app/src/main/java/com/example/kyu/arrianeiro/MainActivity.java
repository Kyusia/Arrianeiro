package com.example.kyu.arrianeiro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.kyu.arrianeiro.R.id.extremlyHighFrequency;
import static com.example.kyu.arrianeiro.R.id.localUserTerminal;
import static com.example.kyu.arrianeiro.R.id.longRangeAidToNavigation;
import static com.example.kyu.arrianeiro.R.id.underwaterLocatorBeacon;


public class MainActivity extends Activity implements OnItemSelectedListener {
    Spinner spinnerDialog1, spinnerDialog2, spinnerDialog3, spinnerDialog4, spinnerDialog5, spinnerDialog6, datesSpinner1, datesSpinner2, datesSpinner3;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2, checkBox3;
    EditText EditText1, EditText2, EditText3, EditText4, editWodaMorska, editPaliwo, editOgienNiskiejIntensywnosci, editOgienWysokiejIntensywnosci, editCiezar, editJednostkiPrzeciazenia;
    RadioButton rb;
    String sLocalUserTerminal, sUnderwaterLocatorBeacon, sExtremlyHighFrequency, sLongRangeAidToNavigation, selected1, selected2, selected3, selected4, selected5, selected6, date1, date2, date3, wodaMorska, paliwo, ogienNiskiejIntensywnosci, ogienWysokiejIntensywnosci, ciezar, jednostkiPrzeciazenia;
    TextView result;
    int score;
    int bestScore;
    String answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Question1 and fullfilled checkboxes to compare results
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        //Question2 with events to match to proper dates
        datesSpinner1 = (Spinner) findViewById(R.id.spinner1);
        datesSpinner2 = (Spinner) findViewById(R.id.spinner2);
        datesSpinner3 = (Spinner) findViewById(R.id.spinner3);

        // Question3 with editable fields to fill
        EditText1 = (EditText) findViewById(localUserTerminal);
        EditText2 = (EditText) findViewById(underwaterLocatorBeacon);
        EditText3 = (EditText) findViewById(extremlyHighFrequency);
        EditText4 = (EditText) findViewById(longRangeAidToNavigation);

        //Question4: Checking if proper radio Button was chosen
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        rb = (RadioButton) findViewById(R.id.radioButton2);

        //Question5 and its list with items to choose
        spinnerDialog1 = (Spinner) findViewById(R.id.spinner_dialog1);
        spinnerDialog2 = (Spinner) findViewById(R.id.spinner_dialog2);
        spinnerDialog3 = (Spinner) findViewById(R.id.spinner_dialog3);
        spinnerDialog4 = (Spinner) findViewById(R.id.spinner_dialog4);
        spinnerDialog5 = (Spinner) findViewById(R.id.spinner_dialog5);
        spinnerDialog6 = (Spinner) findViewById(R.id.spinner_dialog6);

        //Q5: Editable fields to fill with names with the proper answers
        editWodaMorska = (EditText) findViewById(R.id.editText4);
        editPaliwo = (EditText) findViewById(R.id.editText5);
        editOgienNiskiejIntensywnosci = (EditText) findViewById(R.id.editText6);
        editOgienWysokiejIntensywnosci = (EditText) findViewById(R.id.editText7);
        editCiezar = (EditText) findViewById(R.id.editText8);
        editJednostkiPrzeciazenia = (EditText) findViewById(R.id.editText9);

        result = (TextView) findViewById(R.id.Ans); // TextView for reacbed score

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        ArrayAdapter dates = ArrayAdapter.createFromResource(this, R.array.third_question, android.R.layout.simple_spinner_item);
        spinnerDialog1.setAdapter(adapter);
        spinnerDialog2.setAdapter(adapter);
        spinnerDialog3.setAdapter(adapter);
        spinnerDialog4.setAdapter(adapter);
        spinnerDialog5.setAdapter(adapter);
        spinnerDialog6.setAdapter(adapter);

        datesSpinner1.setAdapter(dates);
        datesSpinner2.setAdapter(dates);
        datesSpinner3.setAdapter(dates);

        spinnerDialog1.setOnItemSelectedListener(MainActivity.this);
        spinnerDialog2.setOnItemSelectedListener(MainActivity.this);
        spinnerDialog3.setOnItemSelectedListener(MainActivity.this);
        spinnerDialog4.setOnItemSelectedListener(MainActivity.this);
        spinnerDialog5.setOnItemSelectedListener(MainActivity.this);
        spinnerDialog6.setOnItemSelectedListener(MainActivity.this);

        datesSpinner1.setOnItemSelectedListener(MainActivity.this);
        datesSpinner2.setOnItemSelectedListener(MainActivity.this);
        datesSpinner3.setOnItemSelectedListener(MainActivity.this);
        radioGroup = (RadioGroup) findViewById(R.id.btnGroup);

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView spinnerDialogText = (TextView) view;
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void submit(View view) {

        //Strings with given answers to compare results
        sLocalUserTerminal = String.valueOf(EditText1.getText());
        sUnderwaterLocatorBeacon = String.valueOf(EditText2.getText());
        sExtremlyHighFrequency = String.valueOf(EditText3.getText());
        sLongRangeAidToNavigation = String.valueOf(EditText4.getText());


        //Q5: Strings with choosen answers of given threats to choose the proper order (depends on duration)
        selected1 = spinnerDialog1.getSelectedItem().toString();
        selected2 = spinnerDialog2.getSelectedItem().toString();
        selected3 = spinnerDialog3.getSelectedItem().toString();
        selected4 = spinnerDialog4.getSelectedItem().toString();
        selected5 = spinnerDialog5.getSelectedItem().toString();
        selected6 = spinnerDialog6.getSelectedItem().toString();

        //Q2: Strings with matched answers
        date1 = datesSpinner1.getSelectedItem().toString();
        date2 = datesSpinner2.getSelectedItem().toString();
        date3 = datesSpinner3.getSelectedItem().toString();


        //Q5: Strings with fullfield duration of threats
        wodaMorska = String.valueOf(editWodaMorska.getText());
        paliwo = String.valueOf(editPaliwo.getText());
        ogienNiskiejIntensywnosci = String.valueOf(editOgienNiskiejIntensywnosci.getText());
        ogienWysokiejIntensywnosci = String.valueOf(editOgienWysokiejIntensywnosci.getText());
        ciezar = String.valueOf(editCiezar.getText());
        jednostkiPrzeciazenia = String.valueOf(editJednostkiPrzeciazenia.getText());

        checkCompabilityOfAnswers();
    }

    public void checkCompabilityOfAnswers() {
        score = 0;
        bestScore = 16;
        answers = " ";
        //checking validation of all answers
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();
        endStatement();
    }
    public void checkQuestion1(){
        if (checkBox1.isChecked() && checkBox3.isChecked() && !checkBox2.isChecked()) {score = score + 2;answers = "Question 1 is correct!";} else if ((checkBox1.isChecked() || checkBox3.isChecked()) && !checkBox2.isChecked()) {score = score + 1;answers = "Question 1 is almost correct!";}
        else {answers = "\nQuestion 1 is incorrect :(";}}


    public void checkQuestion2(){
        if (date1.equals("The creation")) {score = score + 1; answers = answers + "\nQuestion 2a is correct!"; }
        else { answers = answers + "\nQuestion 2a is incorrect :(";}
        if (date2.equals("The change of used frequencies")) {score = score + 1;answers = answers + "\nQuestion 2b is correct!";}
        else {answers = answers + "\nQuestion 2b is incorrect :(";}
        if (date3.equals("The Poland\'s accession")) {score = score + 1;answers = answers + "\nQuestion 2c is correct!";}
        else {answers = answers + "\nQuestion 2c is incorrect :(";}}


    public void checkQuestion3(){
        if (sLocalUserTerminal.toUpperCase().equals("LOCAL USER TERMINAL")) {score = score + 1;answers = answers + "\nQuestion 3a is correct!";}
        else {answers = answers + "\nQuestion 3a is incorrect :(";}
        if (sUnderwaterLocatorBeacon.toUpperCase().equals("UNDERWATER LOCATOR BEACON")) {score = score + 1;answers = answers + "\nQuestion 3b is correct!";}
        else {answers = answers + "\nQuestion 3b is incorrect :(";}
        if (sExtremlyHighFrequency.toUpperCase().equals("EXTREMLY HIGH FREQUENCY")) {score = score + 1;answers = answers + "\nQuestion 3c is correct!";}
        else {answers = answers + "\nQuestion 3c is incorrect :(";}
        if (sLongRangeAidToNavigation.toUpperCase().equals("LONG RANGE AID TO NAVIGATION")) {score = score + 1;answers = answers + "\nQuestion 3d is correct!";}
        else {answers = answers + "\nQuestion 3d is incorrect :(";}}

    public void checkQuestion4(){
        if (rb.isChecked()) {score = score + 1;answers = answers + "\nQuestion 4 is correct!";}
        else {answers = answers + "\nQuestion 4 is incorrect :(";}}


    public void checkQuestion5(){
        if (selected1.equals("Woda morska") && wodaMorska.equals("30 dni")) {score = score + 1;answers = answers + "\nQuestion 5a is correct!";}
        else {answers = answers + "\nQuestion 5a is incorrect :(";}
        if (selected2.equals("Paliwo") && paliwo.equals("24 h")) {score = score + 1;answers = answers + "\nQuestion 5b is correct!";}
        else {answers = answers + "\nQuestion 5b is incorrect :(";}
        if (selected3.equals("Ogień niskiej intensywności") && ogienNiskiejIntensywnosci.equals("10 h")) {score = score + 1;answers = answers + "\nQuestion 5c is correct!";}
        else {answers = answers + "\nQuestion 5c is incorrect :(";}
        if (selected4.equals("Ogień wysokiej intensywności") && ogienWysokiejIntensywnosci.equals("30 min")) {score = score + 1;answers = answers + "\nQuestion 5d is correct!";}
        else {answers = answers + "\nQuestion 5d is incorrect :(";}
        if (selected5.equals("5000lb ciężaru") && ciezar.equals("5 min")) {score = score + 1;answers = answers + "\nQuestion 5e is correct!";}
        else {answers = answers + "\nQuestion 5e is incorrect :(";}
        if (selected6.equals("4400 jednostek przeciążenia") && (jednostkiPrzeciazenia.equals("6.5 ms") || jednostkiPrzeciazenia.equals("6,5 ms"))) {score = score + 1;answers = answers + "\nQuestion 5f is correct!";}
        else {answers = answers + "\nQuestion 5f is incorrect :(";}}

public void endStatement(){
        //End statement with percentage result
        String endStatement = "Zdobyłeś: " + (score * 100 / bestScore) + "%!" + "\n\nGratulacje!" + "\n\nPodsumowanie: \n" + answers; //Shows how many percent user received
        result.setText(endStatement);}
    }



