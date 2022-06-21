package com.test.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableseekBar);
        timeTableListView = (ListView) findViewById(R.id.timeTableListView);
        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);
        generateTimesTable(10);
        timeTableSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        int min = 1;
                        int timesTable;
                        if (progress < min) {
                            timesTable = min;
                            timeTableSeekBar.setProgress(min);
                        } else {
                            timesTable = progress;
                        }
                        generateTimesTable(timesTable);

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    public void generateTimesTable(int timesTable) {
        ArrayList<String> timesTableContent = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timeTableListView.setAdapter(arrayAdapter);
    }
}