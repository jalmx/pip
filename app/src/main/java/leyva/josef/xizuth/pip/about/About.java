package leyva.josef.xizuth.pip.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import leyva.josef.xizuth.pip.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Alejandro Leyva", "www.alejandro-leyva.com", "Desarrollador & Diseñador"));
        authors.add(new Author("Gustavo Maravilla", "uiabiblioteca@outlook.com", "Enfermero, Asesor"));

        ListView listView = (ListView) findViewById(R.id.list_author);

        AuthorAdapter authorAdapter = new AuthorAdapter(this, authors);

        listView.setAdapter(authorAdapter);

        findViewById(R.id.source_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jalmx89/pip")));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.alejandro-leyva.com/")));
            }
        });
    }


}
