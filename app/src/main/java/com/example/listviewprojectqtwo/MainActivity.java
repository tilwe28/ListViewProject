package com.example.listviewprojectqtwo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Console> consoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_listView);

        consoles = new ArrayList<>();
        consoles.add(new Console(R.drawable.wii, "Wii"));
        consoles.add(new Console(R.drawable.switchnintendo, "Nintendo Switch"));
        consoles.add(new Console(R.drawable.xbox360, "Xbox 360"));
        consoles.add(new Console(R.drawable.xboxone, "Xbox One"));
        consoles.add(new Console(R.drawable.ps3, "PS3"));
        consoles.add(new Console(R.drawable.ps4, "PS4"));

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.adapter_listview, consoles);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class Console {
        int image;
        String text;

        public Console (int image, String text) {
            this.image = image;
            this.text = text;
        }

        public int getImage() {
            return image;
        }

        public String getText() {
            return text;
        }
    }

    public class ListViewAdapter extends ArrayAdapter<Console> {
        Context myContext;
        int xml;
        List<Console> listy;

        public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Console> objects) {
            super(context, resource, objects);
            myContext = context;
            xml = resource;
            listy = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView= inflater.inflate(xml,null);
            ImageView imageView = adapterView.findViewById(R.id.adapter_imageView);
            TextView textView = adapterView.findViewById(R.id.adapter_textView);
            Button button = adapterView.findViewById(R.id.adapter_button);

            imageView.setImageResource(listy.get(position).getImage());
            textView.setText(listy.get(position).getText());
            button.setText("DELETE");

            return adapterView;
        }
    }
}