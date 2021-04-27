package sg.edu.rp.c347.id19023980.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter<Modules> {
    private ArrayList<Modules> modules;
    private Context context;
    private TextView tvName;
    private TextView tvCode;

    public ModulesAdapter(@NonNull Context context, int resource, ArrayList<Modules> objects) {
        super(context, resource, objects);

        modules = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row,parent, false);

        tvName = rowView.findViewById(R.id.textViewModule);
        tvCode = rowView.findViewById(R.id.textViewCode);

        return rowView;

    }
}
