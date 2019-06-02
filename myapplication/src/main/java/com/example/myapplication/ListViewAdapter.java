package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<ListViewItem> data;
    private int layout;

    public ListViewAdapter(Context context, int layout, ArrayList<ListViewItem> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getClass();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //!< ListView에 생성될 각 Row마다의 Element Object에 대한 설정
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }

        ListViewItem listViewItem = data.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.post_icon);
        icon.setImageResource(listViewItem.getIcon());

        TextView title = (TextView) convertView.findViewById(R.id.post_title);
        title.setText(listViewItem.getTitle());

        TextView uploader = (TextView) convertView.findViewById(R.id.post_uploader);
        uploader.setText(listViewItem.getUploader());

        TextView date = (TextView) convertView.findViewById(R.id.post_date);
        String date_string = listViewItem.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss"));

        /*String date_string = new SimpleDateFormat("yyyy-MM-dd aaa hh:mm:ss",
                new Locale(Locale.KOREAN.getLanguage(), Locale.KOREA.getCountry())).format(listViewItem.getDate());*/
        date.setText(date_string);

        return convertView;
    }

    public void setArrayList(ArrayList<ListViewItem> items) {
        this.data = items;
    }

    public ArrayList<ListViewItem> getArrayList() {
        return data;
    }
}
