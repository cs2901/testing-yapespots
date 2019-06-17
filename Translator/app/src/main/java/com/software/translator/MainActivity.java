package com.software.translator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    private Spinner origin;
    private Spinner result;
    private Translator traductor;
    EditText txtDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        origin = findViewById(R.id.originspinner);
        result = findViewById(R.id.resultspinner);
        txtDescription = findViewById(R.id.edittext);
    }
    public String getSpinnerOrigin() {
        String text = origin.getSelectedItem().toString();
        return text;
    }
    public String getSpinnerresult() {
        String text = result.getSelectedItem().toString();
        return text;
    }
    public void Onclick(View view) throws IOException, SAXException, ParserConfigurationException {

        String message = txtDescription.getText().toString();
        String origin = getSpinnerOrigin();
        String trans = getSpinnerresult();
        traductor = new Translator(message,origin,trans);
        String result = traductor.getTranslate(message);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}
