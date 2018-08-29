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

public class StepOneMain extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_PERMISSION_SUCCESS = 200;
    private EditText contentView;
    private Button saveButton;
    private boolean readPermission;
    private boolean writePermission;
    private String dirPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one_main);

        init();
    }

    private void init() {
        contentView = findViewById(R.id.content_view);
        saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);

        checkExternalDevicePermission();
        requestExternalDevicePermission();
    }

    private void requestExternalDevicePermission() {
        if(readPermission && writePermission) return;
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_PERMISSION_SUCCESS);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode != REQUEST_PERMISSION_SUCCESS || grantResults.length < 1) return;
        List grantedPermission = Arrays.asList(grantResults);
        System.out.println(grantedPermission);
        System.out.println(grantedPermission.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE));
        if(grantedPermission.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            writePermission = true;
        }
        if(grantedPermission.contains(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            readPermission = true;
        }
    }

    private void checkExternalDevicePermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            this.writePermission = true;
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            this.readPermission = true;
        }
    }

    @Override
    public void onClick(View view) {
        if(readPermission && writePermission) {
            String content = contentView.getText().toString();
            PrintWriter printWriter = null;
            try {
                if(dirPath == null) {
                    dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myApp";
                }
                File directory = new File(dirPath);
                if(!directory.exists()) {
                    directory.mkdir();
                }
                File file = new File(dirPath,"mytext.txt");
                if(file.exists()) {
                    file.delete();
                    file.createNewFile();
                } else {
                    file.createNewFile();
                }
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
                printWriter.print(content);

                Intent intent = new Intent(this, StepOneResult.class);
                startActivity(intent);
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(printWriter != null) {
                    printWriter.close();
                }
            }
        }else {
            toasting("No adequate permissions, please set the permission first.");
        }
    }

    private void toasting(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
