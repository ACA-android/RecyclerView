package com.dm.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;

    private List<Car> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        final Resources resources = getResources();
        data.add(new Car(
                "M5",
                Color.GRAY,
                "BMW",
                360,
                BitmapFactory.decodeResource(resources, R.drawable.bmw)
        ));

        data.add(new Car(
                "2600",
                Color.RED,
                "ZAZ",
                40,
                BitmapFactory.decodeResource(resources, R.drawable.bmw)
        ));

        data.add(new Car(
                "Golf",
                Color.GREEN,
                "VolksWagen",
                360,
                BitmapFactory.decodeResource(resources, R.drawable.bmw)
        ));




        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager manager =
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(manager);

        final MyAdapter adapter = new MyAdapter(data);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Car car, int position) {
                car.setSelected(true);
                adapter.notifyItemChanged(position);
            }
        });
        recyclerView.setAdapter(adapter);



        addBtn = findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(new Car(
                        "Golf",
                        Color.GREEN,
                        "VolksWagen",
                        360,
                        BitmapFactory.decodeResource(resources, R.drawable.bmw)
                ));
                adapter.notifyItemInserted(data.size() - 1);
            }
        });




    }
}
