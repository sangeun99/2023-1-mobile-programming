package com.example.project8_2;
import java.io.File;
import java.io.FileFilter;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    MyPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFname;
    TextView tvNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어(수정)");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPicture = findViewById(R.id.myPictureView1);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        imageFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Pictures").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.getName().startsWith(".");
            }
        });

        imageFname = imageFiles[0].toString();
        myPicture.imagePath=imageFname;
        tvNumber.setText("1" + "/" + imageFiles.length);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum <= 0) {
                    curNum = imageFiles.length - 1;
                } else {
                    curNum--;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum >= imageFiles.length - 1) {
                    curNum = 0;
                } else {
                    curNum++;
                }
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
                tvNumber.setText((curNum + 1) + "/" + imageFiles.length);
            }
        });
    }
}