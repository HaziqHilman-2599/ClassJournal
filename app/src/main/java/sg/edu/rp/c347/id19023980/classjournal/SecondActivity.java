package sg.edu.rp.c347.id19023980.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
    String link = "";
    int response = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        lv = this.findViewById(R.id.lvInfo);
        tvGrades = findViewById(R.id.tvGrades);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.btnEmail);

        Intent intentReceived = getIntent();
        String module = intentReceived.getStringExtra("Code");

        al = new ArrayList<Info>();

        if (module.equals("C302")) {
            al.add(new Info("A", 1));
            al.add(new Info("B", 2));
            link = "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C219";

        } else if (module.equals("C347")) {
            al.add(new Info("B", 1));
            al.add(new Info("C", 2));
            al.add(new Info("A", 3));
            link = "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C346";
        }

        aa = new InfoAdapter(this, R.layout.info, al);
        lv.setAdapter(aa);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info DG = new Info("", al.size() + 1);
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                i.putExtra("weekNum", al.size()+1);
                startActivityForResult(i, response);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse(link));
                startActivity(rpIntent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                String text = "";
                for(int z = 0; z < al.size() ; z++){
                    text += "Week "+al.get(z).getWeek()+": DG: "+al.get(z).getGrade()+"\n";
                }
                String textSend = "Hi faci, \nI am ... \nPlease see my remarks so far, thank you! \n"+text;
                email.putExtra(Intent.EXTRA_TEXT, textSend);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                String like = data.getStringExtra("chooses");
                if (requestCode == response) {
                    al.add(new Info(data.getStringExtra("grade"), al.size() + 1));
                }
                aa = new InfoAdapter(this, R.layout.row, al);
                lv.setAdapter(aa);
            }
        }
    }
}
