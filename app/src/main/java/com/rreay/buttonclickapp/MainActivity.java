package com.rreay.buttonclickapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);  // had a variable up top for button but had a warning. Deleted it, highlighted button on this line and did "create local variable"
        textView = findViewById(R.id.textView);
        textView.setText(" ");
        textView.setMovementMethod(new ScrollingMovementMethod()); // makes textView scroll after adding vertical scroll bar in layout
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString(); // had an error because it is a String but the result is android.text.Editable. Added .toString
                result = result + "\n";
                textView.append(result);
            }
        };
    }
}
