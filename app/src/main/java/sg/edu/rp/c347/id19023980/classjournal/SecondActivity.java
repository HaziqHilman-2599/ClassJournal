package sg.edu.rp.c347.id19023980.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tvGrades;
    ArrayList<Info> al;
    ArrayAdapter<Info> aa;
    Button btnInfo, btnAdd, btnEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        lv = this.findViewById(R.id.lvInfo);
        tvGrades = findViewById(R.id.tvGrades);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        Intent intentReceived = getIntent();
        String module = intentReceived.getStringExtra("Code");

        al = new ArrayList<Info>();

        if (module.equals("C302")){
            al.add(new Info("A",1));
            al.add(new Info("B",2));

        }else if (module.equals("C347")){
            al.add(new Info("B",1));
            al.add(new Info("C",2));
            al.add(new Info("A",3));

        }

        aa = new InfoAdapter(this,R.layout.info,al);
        lv.setAdapter(aa);
    }
}
