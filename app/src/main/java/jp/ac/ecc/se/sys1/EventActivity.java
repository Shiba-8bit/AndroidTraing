package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_const2);
        // 宣言
        EditText password = findViewById(R.id.PassWord);
        Button clearButton = findViewById(R.id.ClearButton);
        Button clearButton2 = findViewById(R.id.ClearButton2);
        Button confirm = findViewById(R.id.kakunin);
        RadioGroup radioGroup = findViewById(R.id.RadioGroup);
        RadioButton rdMan = findViewById(R.id.radioButton);

        clearButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                motionEvent.getAction();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setTitle(password.getText());
                        break;
                    case MotionEvent.ACTION_UP:
                        setTitle("練習アプリ");
                        break;
                }
                return false;
            }
        });

        confirm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //radioGroup.getCheckedRadioButtonId();
                if (rdMan.isChecked()){
                    Toast.makeText(getApplicationContext(),"性別：男",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"性別：女",Toast.LENGTH_SHORT).show();
                }
                finish();
                return false;
            }
        });



        clearButton.setOnClickListener(this);
        clearButton2.setOnClickListener(this);
        confirm.setOnClickListener(this);

        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        Toast.makeText(this, "年齢："+age, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        EditText namePro = findViewById(R.id.Name_Pro);
        EditText password = findViewById(R.id.PassWord);
        switch (view.getId()) {
            case R.id.ClearButton:namePro.setText("");break;
            case R.id.ClearButton2:password.setText("");break;
            case R.id.kakunin:Toast.makeText(getApplicationContext(),"名前："+namePro.getText(),Toast.LENGTH_SHORT).show();break;
        }
    }
}
