package indiel.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kori_ on 21.03.2017.
 */

public class TheFirstActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> miau;

//    private String[] miau = {"Мяу1", "Мяу2", "Мяу3", "Мяу4", "Мяу5", "Мяу6",
//            "Мяу7", "Мяу8", "Мяу9", "Мяу10", "Мяу11", "Мяу12",
//            "Мяу13", "Мяу14", "Мяу15"};


//        private ArrayList miau = new ArrayList();
//            miau.add("Мяу1")

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_first_activity);

        miau = new ArrayList<String>();
        miau.add("Мяу1");
        miau.add("Мяу2");
        miau.add("Мяу3");
        miau.add("Мяу4");
        miau.add("Мяу5");

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, miau);

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
        miau.add(data.getStringExtra(""));
        adapter.notifyDataSetChanged();
    }

}
