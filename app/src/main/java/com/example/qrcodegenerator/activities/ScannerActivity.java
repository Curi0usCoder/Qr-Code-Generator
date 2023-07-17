package com.example.qrcodegenerator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qrcodegenerator.R;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner;
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions;
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning;

import org.w3c.dom.Text;

public class ScannerActivity extends AppCompatActivity {

    TextView ScannedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        ScannedText=findViewById(R.id.scanned_text);

        GmsBarcodeScannerOptions options = new GmsBarcodeScannerOptions.Builder()
                .setBarcodeFormats(
                        Barcode.FORMAT_QR_CODE,
                        Barcode.FORMAT_AZTEC)
                .build();


        GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(this);
// Or with a configured options
// GmsBarcodeScanner scanner = GmsBarcodeScanning.getClient(context, options);

        scanner.startScan()
                .addOnSuccessListener(
                        barcode -> {
                            // Task completed successfully

                            String rawValue = barcode.getRawValue();
                            Log.d("sarath","Scanned value : "+rawValue);
                            ScannedText.setText(rawValue);
                        })
                .addOnCanceledListener(
                        () -> {
                            // Task canceled
                            Toast.makeText(this, "Error : "+"Canceled", Toast.LENGTH_SHORT).show();
                        })
                .addOnFailureListener(
                        e -> {
                            // Task failed with an exception
                            Toast.makeText(this, "Error : "+e, Toast.LENGTH_SHORT).show();
                        });

    }
}