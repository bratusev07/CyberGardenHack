package ru.bratusev.cybergardenhack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> students;
    private LayoutInflater layoutInflater;

    public StudentsAdapter(Context context, ArrayList<String> students) {
        this.context = context;
        this.students = students;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public String getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_student, viewGroup, false);
        }

        ((TextView)view.findViewById(R.id.studentName)).setText(students.get(position));
        return view;
    }
}
