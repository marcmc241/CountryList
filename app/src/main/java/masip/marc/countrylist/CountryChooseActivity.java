package masip.marc.countrylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_choose);

        ListView list = (ListView) findViewById(R.id.list);
        final String[] countries = getResources().getStringArray(R.array.countries);//és final perque sino el adapterview no pot accedir-hi

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );//adapptador que construeix la llista. android.R.layout son layouts predefinits d'android

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent data = new Intent();
                data.putExtra("country", countries[position]);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
