package top.qvisa.experimentfive;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton_create_table;
    private Button mButton_insert;
    private Button mButton_delete;
    private Button mButton_update;
    private Button mButton_query;
    private EditText mEditText_name;
    private EditText mEditText_sex;
    private EditText mEditText_department;
    private EditText mEditText_salary;
    private RecyclerView mRecyclerView_query;

    private String name;
    private String department;
    private String sex;
    private String salary_string;
    private List<Staff> mList_staff = new ArrayList<>();




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init_recyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView_query.setLayoutManager(linearLayoutManager);
        Myadapter myadapter = new Myadapter(this, mList_staff);
        mRecyclerView_query.setAdapter(myadapter);
    }

    private void init_data() {
        name = mEditText_name.getText().toString();
        department = mEditText_department.getText().toString();
        sex = mEditText_sex.getText().toString();
        salary_string = mEditText_salary.getText().toString();
    }

    private void init() {
        mButton_create_table = findViewById(R.id.bt_create_table);
        mButton_create_table.setOnClickListener(this);

        mButton_delete = findViewById(R.id.bt_delete);
        mButton_delete.setOnClickListener(this);

        mButton_insert = findViewById(R.id.bt_insert);
        mButton_insert.setOnClickListener(this);

        mButton_update = findViewById(R.id.bt_update);
        mButton_update.setOnClickListener(this);

        mButton_query = findViewById(R.id.bt_query);
        mButton_query.setOnClickListener(this);

        mEditText_name = findViewById(R.id.ed_name);
        mEditText_department = findViewById(R.id.ed_department);
        mEditText_salary = findViewById(R.id.ed_salary);
        mEditText_sex = findViewById(R.id.ed_sex);

        mRecyclerView_query = findViewById(R.id.rv_query);
    }

    @Override
    public void onClick(View v) {
        DAO dao = new DAO(this);
        switch (v.getId()) {
            default:
            case R.id.bt_create_table:
                MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
                databaseHelper.getWritableDatabase();
                break;
            case R.id.bt_insert:
                init_data();
                dao.insert(name, sex, department, salary_string);
                Log.d("MainActivity", "insert");
                break;
            case R.id.bt_update:
                init_data();
                dao.update(name, sex, department, salary_string);
                Log.d("MainActivity", "update");
                break;
            case R.id.bt_delete:
                init_data();
                dao.delete(name);
                break;
            case R.id.bt_query:
                dao.query(mList_staff);
                init_recyclerView();
                break;
        }
    }
}
