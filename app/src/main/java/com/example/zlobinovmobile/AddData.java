package com.example.zlobinovmobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddData extends AppCompatActivity {
    Connection connection;
    String ConnectionResult = "";
    TextView FirstNameAdd;
    TextView LastNameAdd;
    TextView login_userAdd;
    TextView password_userAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        configureBackButton();
    }
    private void configureBackButton() {
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void SetTextFromSql(View v) {
        FirstNameAdd = findViewById(R.id.FirstNameAdd);
        LastNameAdd = findViewById(R.id.LastNameAdd);
        login_userAdd = findViewById(R.id.login_userAdd);
        password_userAdd = findViewById(R.id.password_userAdd);
        String FirstName = FirstNameAdd.getText().toString();
        String LastName = LastNameAdd.getText().toString();
        String login_user = login_userAdd.getText().toString();
        String password_user = password_userAdd.getText().toString();
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.conclass();
            if (FirstNameAdd.getText().length()==0 || LastNameAdd.getText().length()==0 || login_userAdd.getText().length()==0 || password_userAdd.getText().length()==0)
            {
                Toast.makeText(this,"Не заполнены обязательные поля", Toast.LENGTH_LONG).show();
                return;
            }
            if (connection != null) {

                String query = "INSERT INTO Users (FirstName, LastName, login_user, password_user) values ('" + FirstName + "','" + LastName + "'," + login_user + ",'"+ password_user +"')";
                Statement statement = connection.createStatement();
                statement.execute(query);
                Toast.makeText(this,"Успешно добавлено", Toast.LENGTH_LONG).show();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
