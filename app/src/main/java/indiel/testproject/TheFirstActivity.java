package indiel.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kori_ on 21.03.2017.
 */

public class TheFirstActivity extends AppCompatActivity {

    public static final String TEXT_KEY = "TextKey";

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_first_activity);

        list = new ArrayList<>();
        list.add("Мяу1");
        list.add("Мяу2");
        list.add("Мяу3");
        list.add("Мяу4");
        list.add("Мяу5");

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

    }

    public void goTo (View view) {
        Intent intent = new Intent(TheFirstActivity.this, TheSecondActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data ==null){
            return;
        }
        list.add(data.getStringExtra(TEXT_KEY));
        adapter.notifyDataSetChanged();
    }

}
