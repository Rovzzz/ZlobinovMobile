package com.example.zlobinovmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection connection;
    String ConnectionResult = "";
    public final int[] i = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurationNextButton();
        configurationNextButton1();
        Del();
    }
    private  void Del()
    {
        Button DelData = findViewById(R.id.delData);
        DelData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper conectionHellper = new ConnectionHelper();
                    connection = conectionHellper.conclass();

                    if (connection != null) {

                        String query2 = "DELETE FROM Base WHERE Base_Id = " + i[0] + "";
                        Statement statement2 = connection.createStatement();
                        statement2.execute(query2);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Удаление прошло успешно, перейдите на другие данные", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        ConnectionResult = "Check Connection";
                    }
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }
    private void configurationNextButton() {
        Button addData = (Button) findViewById(R.id.addData);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddData.class));
            }
        });
    }
    private void configurationNextButton1() {
        Button Poiski = (Button) findViewById(R.id.Poiski);
        Poiski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Poisk.class));
            }
        });
    }
    public void GetTextFromSql1(View a) {
        TextView ID = findViewById(R.id.id);
        TextView FirstName = findViewById(R.id.FirstName);
        TextView LastName = findViewById(R.id.LastName);
        TextView login_user = findViewById(R.id.login_user);
        TextView password_user = findViewById(R.id.password_user);
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.conclass();
            if (connection != null) {

                String query0 = "select count(id) from Users ";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c = 0;
                while (resultSet0.next()) {
                    c = resultSet0.getInt(1);
                }

                int finalC = c;

                if (i[0] != finalC) {
                    i[0] = i[0] + 1;
                }
                Button IzmData = (Button) findViewById(R.id.IzmData);
                IzmData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, IzmData.class);
                        intent.putExtra("FirstName",FirstName.getText().toString());
                        intent.putExtra("LastName",LastName.getText().toString());
                        intent.putExtra("login_user",login_user.getText().toString());
                        intent.putExtra("password_user",password_user.getText().toString());
                        startActivity(intent);
                    }
                });

                String query = "Select * From Users where id=" + i[0] + "";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    ID.setText(resultSet.getString(1));
                    FirstName.setText(resultSet.getString(2));
                    LastName.setText(resultSet.getString(3));
                    login_user.setText(resultSet.getString(4));
                    password_user.setText(resultSet.getString(5));
                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {
        }
    }
    public void GetTextFromSql(View a) {
        TextView ID = findViewById(R.id.id);
        TextView FirstName = findViewById(R.id.FirstName);
        TextView LastName = findViewById(R.id.LastName);
        TextView login_user = findViewById(R.id.login_user);
        TextView password_user = findViewById(R.id.password_user);
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.conclass();

            if (connection != null) {

                String query3 = "select count(id) from Users ";
                Statement statement3 = connection.createStatement();
                ResultSet resultSet3= statement3.executeQuery(query3);
                int c = 0;
                while (resultSet3.next()) {
                    c = resultSet3.getInt(1);
                }
                if (i[0] != 1) {
                    i[0] = i[0] - 1;
                }

                Button IzmData = (Button) findViewById(R.id.IzmData);
                IzmData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, IzmData.class);
                        intent.putExtra("FirstName",FirstName.getText().toString());
                        intent.putExtra("LastName",LastName.getText().toString());
                        intent.putExtra("login_user",login_user.getText().toString());
                        intent.putExtra("password_user",password_user.getText().toString());
                        startActivity(intent);
                    }
                });

                String query4 = "Select * From Users where id=" + i[0] + "";
                Statement statement4 = connection.createStatement();
                ResultSet resultSet4 = statement4.executeQuery(query4);
                while (resultSet4.next()) {
                    ID.setText(resultSet4.getString(1));
                    FirstName.setText(resultSet4.getString(2));
                    LastName.setText(resultSet4.getString(3));
                    login_user.setText(resultSet4.getString(4));
                    password_user.setText(resultSet4.getString(5));
                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {

        }

    }
    public void GetTextFromSql2(View a) {
        TextView ID = findViewById(R.id.id);
        TextView FirstName = findViewById(R.id.FirstName);
        TextView LastName = findViewById(R.id.LastName);
        TextView login_user = findViewById(R.id.login_user);
        TextView password_user = findViewById(R.id.password_user);
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.conclass();

            if (connection != null) {


                Button IzmData = (Button) findViewById(R.id.IzmData);
                IzmData.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, IzmData.class);
                        intent.putExtra("FirstName",FirstName.getText().toString());
                        intent.putExtra("LastName",LastName.getText().toString());
                        intent.putExtra("login_user",login_user.getText().toString());
                        intent.putExtra("password_user",password_user.getText().toString());
                        startActivity(intent);
                    }
                });

                String query7 = "Select * From Users where id=" + i[0] + "";
                Statement statement7 = connection.createStatement();
                ResultSet resultSet7 = statement7.executeQuery(query7);
                while (resultSet7.next()) {
                    ID.setText(resultSet7.getString(1));
                    FirstName.setText(resultSet7.getString(2));
                    LastName.setText(resultSet7.getString(3));
                    login_user.setText(resultSet7.getString(4));
                    password_user.setText(resultSet7.getString(5));
                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {

        }

    }

}