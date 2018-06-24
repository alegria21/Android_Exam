package com.bryan_alegria.androidexam;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bryan_alegria.androidexam.API.ApiMethods;
import com.bryan_alegria.androidexam.Holder.PersonHolder;
import com.bryan_alegria.androidexam.Model.InternalStorage;
import com.bryan_alegria.androidexam.Model.PersonData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PersonActivity extends AppCompatActivity {
private RecyclerView recycler_view_persons;
    private ArrayList<PersonData> personData;
    private PersonHolder mRecyclerViewAdapter;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        recycler_view_persons = (RecyclerView) findViewById (R.id.recycler_view_persons);
        GetPersons getpersons = new GetPersons();
        getpersons.execute();
    }
    private class GetPersons extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog = new ProgressDialog(PersonActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setTitle("Gathering data...");
            progressDialog.setMessage("Please wait.");
            progressDialog.show();
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)

        @Override
        protected String doInBackground(String... strings) {
            personData = new ArrayList<PersonData>();
            String person_data = null;
            JSONObject persons = new ApiMethods(PersonActivity.this).GetPersons();

            try {
                person_data = persons.getString("Data");
                JSONArray jsonArray = new JSONArray(person_data);
                if (jsonArray.length() > 0){
                    for (int i = 0; i < jsonArray.length(); i++) {
                        PersonData data = gson.fromJson(jsonArray.getString(i), PersonData.class);
                        personData.add(data);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();

            LinearLayoutManager llm = new LinearLayoutManager(PersonActivity.this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recycler_view_persons.setLayoutManager(llm);
            mRecyclerViewAdapter = new PersonHolder(personData, PersonActivity.this);
            recycler_view_persons.setAdapter(mRecyclerViewAdapter);
        }
    }
}
