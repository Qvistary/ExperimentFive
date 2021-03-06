package top.qvisa.experimentfive;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {
    private EditText mEditText_Account;
    private EditText mEditText_Password;
    private Button mButton_Login;
    private CheckBox mCheckBox_rememberPass;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mPref_Editor;
    private Button mButton_sve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPref = PreferenceManager.getDefaultSharedPreferences(this);
        mEditText_Account = findViewById(R.id.et_account);
        mEditText_Password = findViewById(R.id.et_password);
        mCheckBox_rememberPass = findViewById(R.id.cb_remember_pass);
        mButton_Login = findViewById(R.id.bt_login);
        mButton_sve = findViewById(R.id.bt_save);
        boolean isRemember = mPref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = mPref.getString("account", "");
            String password = mPref.getString("password", "");
            mEditText_Account.setText(account);
            mEditText_Password.setText(password);
        }

        mButton_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mEditText_Account.getText().toString();
                String password = mEditText_Password.getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    mPref_Editor = mPref.edit();
                    if (mCheckBox_rememberPass.isChecked()) {
                        mPref_Editor.putBoolean("remember_password", true);
                        mPref_Editor.putString("account", account);
                        mPref_Editor.putString("password", password);
                    } else {
                        mPref_Editor.clear();
                    }
                    mPref_Editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Account or Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButton_sve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mEditText_Account.getText().toString();
                String password = mEditText_Password.getText().toString();
                save(account,password);
            }
        });
    }
    public void save(String account,String password){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput("data.INI", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(account);
            writer.write(password);
            Toast.makeText(this,"Save successfully",Toast.LENGTH_SHORT).show();
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
