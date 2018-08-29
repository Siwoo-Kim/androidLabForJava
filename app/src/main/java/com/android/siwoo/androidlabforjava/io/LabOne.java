package com.android.siwoo.androidlabforjava.io;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.siwoo.androidlabforjava.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LabOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one4);

        TextView fileResult = findViewById(R.id.fileResult);

        File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/myApp/myfile.txt");
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer = new StringBuffer();
            String input = null;
            while ((input=fileReader.readLine()) != null) {
                stringBuffer.append(input);
            }
            fileResult.setText(stringBuffer.toString());
        }catch (IOException e) {

        }finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
