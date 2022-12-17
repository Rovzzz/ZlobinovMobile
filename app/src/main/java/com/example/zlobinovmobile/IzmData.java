package com.example.zlobinovmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IzmData extends AppCompatActivity {
    Connection connection;
    String ConnectionResult = "";
    TextView FirstNameIzm;
    TextView LastNameIzm;
    TextView login_userIzm;
    TextView password_userIzm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izm_data);

        FirstNameIzm = findViewById(R.id.FirstNameIzm);
        LastNameIzm = findViewById(R.id.LastNameIzm);
        login_userIzm = findViewById(R.id.login_userIzm);
        password_userIzm=findViewById(R.id.password_userIzm);
        Intent intent = getIntent();
        String FirstName = intent.getStringExtra("FirstName");
        String LastName=intent.getStringExtra("LastName");
        String login_user=intent.getStringExtra("login_user");
        String password_user=intent.getStringExtra("password_user");
        FirstNameIzm.setText(FirstName);
        LastNameIzm.setText(LastName);
        login_userIzm.setText(login_user);
        password_userIzm.setText(password_user);
    }
    public void IzmTextFromSql(View v) {

        String FirstName = FirstNameIzm.getText().toString();
        String LastName = LastNameIzm.getText().toString();
        String login_user = login_userIzm.getText().toString();
        String password_user = password_userIzm.getText().toString();
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.conclass();
            Intent intent = getIntent();
            String Base = intent.getStringExtra("FirstName");
            if (connection != null) {
                String query11 = "select id from Users where FirstName = '" + FirstName + "'";
                Statement statement11 = connection.createStatement();
                ResultSet resultSet11 = statement11.executeQuery(query11);
                int i = 0;
                while (resultSet11.next())
                {
                    i=resultSet11.getInt(1);
                }
                String query12 = "update Users set FirstName = '" + FirstName + "', LastName ='" + LastName + "',login_user =" + login_user + ", password_user = '"+ password_user +"' where id = "+i+"";
                Statement statement12 = connection.createStatement();
                statement12.execute(query12);
                finish();
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Данные успешно изменены, обновите их", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
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
}
