package top.qvisa.experimentfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton_create_table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton_create_table=findViewById(R.id.bt_create_table);
        mButton_create_table.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_create_table:
                MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
                databaseHelper.getWritableDatabase();
                break;
        }
    }
}
