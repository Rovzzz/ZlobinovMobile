package com.example.zlobinovmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Poisk extends AppCompatActivity {
    Connection connection;
    String ConnectionResult = "";
    String Poisk;
    public final int[] i = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poisk);
        configureBackButton();
    }

    private void configureBackButton() {
        Button back_poisk = (Button) findViewById(R.id.back_poisk);
        back_poisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void GetTextFromSql(View a) {
        TextView BaseId_poisk = findViewById(R.id.BaseId_poisk);
        TextView BaseName_poisk = findViewById(R.id.BaseName_poisk);
        TextView GeographyPosition_poisk = findViewById(R.id.GeografPosition_poisk);
        TextView NumberOfParse_poisk = findViewById(R.id.NumberOfParts_poisk);
        ImageView imageView_poisk = findViewById(R.id.image_poisk);
        TextView poisk=findViewById(R.id.Stroka_Poiska);
        Poisk=poisk.getText().toString();
        try {
            ConectionHellper conectionHellper = new ConectionHellper();
            connection = conectionHellper.connectionClass();

            if (connection != null) {

                String query3 = "select count(Base_Id) from Base where BaseName LIKE '"+Poisk+"%'";
                Statement statement3 = connection.createStatement();
                ResultSet resultSet3= statement3.executeQuery(query3);
                int c = 0;
                while (resultSet3.next()) {
                    c = resultSet3.getInt(1);
                }
                if (i[0] != 1) {
                    i[0] = i[0] - 1;
                }
                String query100 = "select Base_Id from Base where BaseName LIKE '"+Poisk+"%'";
                Statement statement100 = connection.createStatement();
                ResultSet resultSet100 = statement100.executeQuery(query100);
                int[] index= new int[c];
                int b=0;
                while (resultSet100.next()) {
                    index[b] = resultSet100.getInt(1);
                    b++;
                }
                b=0;
                String query4 = "Select * From Base where Base_Id=" + index[b] + "";
                Statement statement4 = connection.createStatement();
                ResultSet resultSet4 = statement4.executeQuery(query4);
                while (resultSet4.next()) {
                    BaseId_poisk.setText(resultSet4.getString(1));
                    BaseName_poisk.setText(resultSet4.getString(2));
                    GeographyPosition_poisk.setText(resultSet4.getString(3));
                    NumberOfParse_poisk.setText(resultSet4.getString(4));
                    Img_poisk = (resultSet4.getString(5));
                    imageView_poisk.setImageBitmap(getImgBitmap(Img_poisk));
                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {

        }

    }
}
