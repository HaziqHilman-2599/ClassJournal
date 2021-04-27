package sg.edu.rp.c347.id19023980.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class InfoAdapter extends ArrayAdapter<Info> {
    private ArrayList<Info> info;
    private Context context;
    private TextView tvGrade;
    private TextView tvWeek;
    public InfoAdapter(@NonNull Context context, int resource,ArrayList<Info> objects) {
        super(context, resource, objects);

        info = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.info, parent, false);

        tvGrade = rowView.findViewById(R.id.tvGrades);
        tvWeek = rowView.findViewById(R.id.tvWeek);

        tvGrade.setText(info.get(position).getGrade());
        tvWeek.setText("Week " + info.get(position).getWeek());
        return rowView;
    }
}
