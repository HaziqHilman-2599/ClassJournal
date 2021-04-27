package sg.edu.rp.c347.id19023980.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Modules> al;
    ArrayAdapter<Modules> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.lvModules);

        al = new ArrayList<Modules>();
        al.add(new Modules("Web Services","C302"));
        al.add(new Modules("Android Programming II","C347"));

        aa = new ModulesAdapter(this,R.layout.row,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Code", al.get(position).getCode());
                startActivity(intent);
            }
        });
    }
}
