package com.bryan_alegria.androidexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class PersonDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        TextView text_first_name = (TextView) findViewById (R.id.text_first_name);
        TextView text_last_name = (TextView) findViewById (R.id.text_last_name);
        TextView text_birthday = (TextView) findViewById (R.id.text_birthday);
        TextView text_age = (TextView) findViewById (R.id.text_age);
        TextView text_email = (TextView) findViewById (R.id.text_email);
        TextView text_mobile_number = (TextView) findViewById (R.id.text_mobile_number);
        TextView text_address = (TextView) findViewById (R.id.text_address);
        TextView text_contact_person = (TextView) findViewById (R.id.text_contact_person);
        TextView text_contact_person_s_phone_number = (TextView) findViewById (R.id.text_contact_person_s_phone_number);

        text_first_name.setText(getIntent().getExtras().getString("FirstName"));
        text_last_name.setText(getIntent().getExtras().getString("LastName"));
        text_birthday.setText(getIntent().getExtras().getString("Bday"));
        text_email.setText(getIntent().getExtras().getString("EmailAddress"));
        text_mobile_number.setText(getIntent().getExtras().getString("MobileNumber"));
        text_address.setText(getIntent().getExtras().getString("Address"));
        text_contact_person.setText(getIntent().getExtras().getString("ContactPerson"));
        text_contact_person_s_phone_number.setText(getIntent().getExtras().getString("ContactPersonsPhoneNumber"));


        text_age.setText(getAge());
    }

    private String getAge() {
        String[] split1 = getIntent().getExtras().getString("Bday").split(",");
        String[] split2 = split1[0].split("\\s+");
        int year = Integer.parseInt(String.valueOf(split1[1]));
        int day = Integer.parseInt(String.valueOf(split2[1]));
        Calendar today = Calendar.getInstance();

        int ages = today.get(Calendar.YEAR) - year;

        if (today.get(Calendar.DAY_OF_YEAR) < day ){
            ages--;
        }

        Integer ageInt = new Integer(ages);
        String age = ageInt.toString();

        return age;
    }
}
