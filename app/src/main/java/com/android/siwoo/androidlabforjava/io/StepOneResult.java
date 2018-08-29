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
import java.util.Scanner;

public class StepOneResult extends AppCompatActivity {

    private TextView resultView;
    private static String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one_result2);

        init();
        readFile();
    }


    private void readFile() {
        if(path == null) {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myApp/myFile.txt";
        }
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
            StringBuffer stringBuffer = new StringBuffer();
            while (scanner.hasNextLine()) {
                stringBuffer.append(scanner.nextLine());
            }
            resultView.setText(stringBuffer.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    private void init() {
        resultView = findViewById(R.id.result_text);
    }
}
