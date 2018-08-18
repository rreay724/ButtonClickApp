package com.rreay.buttonclickapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private static final String TAG = "MainActivity"; // added this to set value to TAG
    private final String TEXT_CONTENTS = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.editText);
        userInput.setText("");
        final Button button = findViewById(R.id.button);  // had a variable up top for button but had a warning. Deleted it, highlighted button on this line and did "create local variable"
        textView = findViewById(R.id.textView);
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod()); // makes textView scroll after adding vertical scroll bar in layout
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString(); // had an error because it is a String but the result is android.text.Editable. Added .toString
                result = result + "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);       // in this instance we put it after the super because it retrieves the data from the bundle first and restore the values
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
//        textView.setText(savedString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS)); // shortcut to the above two lines
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());  // saves current value of whatever is into the textView into the bundle
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }
}
