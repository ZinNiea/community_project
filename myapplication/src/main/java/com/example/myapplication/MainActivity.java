package com.example.myapplication;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<ListViewItem> data = new ArrayList<>();
    ListViewAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        //!< ArrayList에 ListViewItem 타입의 객체가 add되고, ArrayList의 data set을 바탕으로 ListView를 출력한다.
        data.add(new ListViewItem("아침", "17학번",
                LocalDateTime.of(2019, 6, 1, 9, 0, 10),
                R.drawable.ic_launcher_foreground));

        data.add(new ListViewItem("점심", "18학번",
                LocalDateTime.of(2019, 7, 1, 14, 0, 10),
                R.drawable.ic_launcher_foreground));

        data.add(new ListViewItem("저녁", "19학번",
                LocalDateTime.of(2019, 6, 1, 19, 0, 10),
                R.drawable.ic_launcher_foreground));

        adapter = new ListViewAdapter(this, R.layout.item_post, data);
        listView.setAdapter(adapter);

        //!< ListView 요소를 터치했을때 동작하는 클릭 리스너
        //!< 게시글 내용을 보여주는 Activity를 시작하면 됨
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();

        /*data.add(new ListViewItem("저녁", "19학번",
                LocalDateTime.of(2019, 6, 1, 19, 0, 10),
                R.drawable.ic_launcher_foreground));*/

        adapter.notifyDataSetChanged();
    }
}

