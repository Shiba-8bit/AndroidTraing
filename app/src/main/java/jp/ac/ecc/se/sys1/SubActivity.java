package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_sub); // コメントアウト
        setContentView(R.layout.activity_const); // 作成したレイアウトを適用
        // 宣言
        TextView nameLabel = findViewById(R.id.textView2);
        EditText nameText = findViewById(R.id.nameText);
        Button clearButton = findViewById(R.id.ClearButton);
        Button sendButton = findViewById(R.id.SendButton);
        Button confirmButton = findViewById(R.id.confirmButtom);
        setTitle("Sub Activity"); // 追加する
        nameLabel.setText("Name");
        sendButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
                setTitle("Button Clicked");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SendButton: Toast.makeText(getApplicationContext(),"送信クリック",Toast.LENGTH_SHORT).show();
                                  Intent intent = new Intent(this, EventActivity.class);
                                  intent.putExtra("age", 19);
                                  startActivity(intent);break;
            case R.id.confirmButtom: Toast.makeText(this,"確認クリック",Toast.LENGTH_SHORT).show();break;
        }
    }
}