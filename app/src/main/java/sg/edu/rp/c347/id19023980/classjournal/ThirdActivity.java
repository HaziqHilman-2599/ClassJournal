package sg.edu.rp.c347.id19023980.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ThirdActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5, rbtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

        btnSubmit= findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create intent & pass in String data
                Intent i = new Intent();

                rbtn1 = findViewById(R.id.radioButton);
                if (rbtn1.isChecked()){
                    i.putExtra("grade", "A");
                }
                rbtn2 = findViewById(R.id.radioButton2);
                if (rbtn2.isChecked()){
                    i.putExtra("grade", "B");
                }
                rbtn3 = findViewById(R.id.radioButton3);
                if (rbtn3.isChecked()){
                    i.putExtra("grade", "C");
                }
                rbtn4 = findViewById(R.id.radioButton4);
                if (rbtn4.isChecked()){
                    i.putExtra("grade", "D");
                }
                rbtn5 = findViewById(R.id.radioButton5);
                if (rbtn5.isChecked()){
                    i.putExtra("grade", "F");
                }
                rbtn6 = findViewById(R.id.radioButton6);
                if (rbtn6.isChecked()){
                    i.putExtra("grade", "X");
                }

                setResult(RESULT_OK, i);
                finish();

            }});

    }
}