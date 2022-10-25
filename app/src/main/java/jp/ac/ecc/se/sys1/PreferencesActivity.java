package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        // 宣言
        EditText thoughtsText = findViewById(R.id.thoughtsText);
        Button saveBt = findViewById(R.id.saveButton);
        Button cancelBt = findViewById(R.id.cancelButton);
        Intent inten = getIntent();
        int name = inten.getIntExtra("name",4);
        String[] curry = {"ドライカレー","カツカレー","チーズカレー","スープカレー"};
        // 設定ファイルのオブジェクト生成
        SharedPreferences pref = getSharedPreferences(curry[name],Context.MODE_PRIVATE);
        // プレファレンスへの書き込み処理
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("memo", thoughtsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
            }
        });
        // データ取得
        String thoughtsSt = pref.getString("memo", "");     // 仮に memo というキーが存在しない場合は、空文字が返却される
        // EditTextに文字列をセット
        thoughtsText.setText(thoughtsSt);
        // 画面を閉じる処理
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "終了します", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}