package com.example.seandonato.va;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    private boolean rendererSet;

    public String fieldString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        tv.setText(stringFromJNI());

    }

    public void isValid(View view){


        EditText eT = (EditText) findViewById(R.id.editText);

        String f = eT.getText().toString();


        fieldString = eT.getText().toString();

        String isStringValid = stringCompare(fieldString);

        TextView tv = (TextView) findViewById(R.id.sample_text);

        if(isStringValid.equals("ok")) {

            tv.setText(isStringValid);
            nextActivity();

        }else{

            tv.setText("Sorry, try again");

        }

    }



    public native String stringCompare(String str);

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }




    public void nextActivity() {

        Intent intent;
        String shape;

        intent = new Intent(this, GL2JNIActivity.class);


        //shape = fieldString;

        //intent.putExtra("shape", shape);

        startActivity(intent);
    }

}