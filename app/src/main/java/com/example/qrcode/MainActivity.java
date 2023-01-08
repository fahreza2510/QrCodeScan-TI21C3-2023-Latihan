package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class MainActivity extends AppCompatActivity {
    private EditText editCode;
    private Button btnCode;
    private ImageView imgCode;
    private MultiFormatWriter multi = new MultiFormatWriter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCode = findViewById(R.id.edit_code);
        btnCode = findViewById(R.id.btn_code);
        imgCode = findViewById(R.id.img_code);

        btnCode.setOnClickListener(v -> {
            try {
                String code = editCode.getText().toString();
                BitMatrix bitMatrix = multi.encode(code, BarcodeFormat.QR_CODE, 300, 300);

                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap();
                imgCode.setImageBitmap(bitmap);
            }catch (WriterException e){
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}