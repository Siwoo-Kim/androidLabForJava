package com.android.siwoo.androidlabforjava.io;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.siwoo.androidlabforjava.R;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class LabOneMain extends AppCompatActivity implements View.OnClickListener{
    private EditText editor;
    private Button saveButton;

    private boolean writePermission;
    private boolean readPermission;
    private static final int PERMISSION_GRANTED = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one_main);
        editor = findViewById(R.id.content);
        saveButton = findViewById(R.id.btn);
        saveButton.setOnClickListener(this);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            writePermission = true;
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            readPermission = true;
        }
        if(!writePermission || !readPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_GRANTED);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_GRANTED && grantResults.length > 0) {
            List results = Arrays.asList(grantResults);

            if(results.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                readPermission = true;
            }
            if(results.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                writePermission = true;
            }
        }
    }

    @Override
    public void onClick(View view) {
        String content = editor.getText().toString();
        if(writePermission && readPermission) {
            PrintWriter fileWriter = null;
            try {
                String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myApp";
                File directory = new File(dirPath);
                if(!directory.exists()) {
                    directory.mkdir();
            }
                File file = new File(dirPath + "/myfile.txt");
                if(!file.exists()) {
                    file.createNewFile();
                }
                fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
                fileWriter.print(content);

                Intent intent = new Intent(this, LabOne.class);
                startActivity(intent);

            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fileWriter != null) {
                    fileWriter.close();
                }
            }
        } else {
            toasting("No Adequate Permission. Please set the permission to execute");
        }
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
