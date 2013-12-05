package com.example.barcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity.CaptureActivity;

public class QRActivity extends Activity {
/** Called when the activity is first created. */
Button b1;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_qr);
b1 = (Button) findViewById(R.id.qrcode);
b1.setOnClickListener(new OnClickListener() {

public void onClick(View arg0) {
// TODO Auto-generated method stub
Intent intent = new Intent(QRActivity.this,CaptureActivity.class);
// Intent intent = new
// Intent("com.google.zxing.client.android.SCAN");
intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
startActivityForResult(intent, 0);
}
});

}

public void onActivityResult(int requestCode, int resultCode, Intent intent) {
if (requestCode == 0) {
if (resultCode == 1) {
// Handle successful scan
String capturedQrValue = intent.getStringExtra("RESULT");
//String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
Toast.makeText(QRActivity.this,"Scan Result:" + capturedQrValue, Toast.LENGTH_SHORT)
.show();

} else if (resultCode == RESULT_CANCELED) {
// Handle cancel
}
} else {

}
}
}