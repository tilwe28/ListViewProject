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
import java.util.List;//Imports

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Game> games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_listView);

        games = new ArrayList<>();
        games.add(new Game(R.drawable.destinytakenking, "Destiny", "September 9, 2014", "Shared World Shooter"));
        games.add(new Game(R.drawable.bo3, "Black Ops 3", "November 6, 2015", "First Person Shooter"));
        games.add(new Game(R.drawable.fortnitebr, "Fortnite", "September 26, 2017", "Battle Royale"));
        games.add(new Game(R.drawable.nba2k20, "NBA 2k20", "September 5, 2019", "Sport Simulation"));
        games.add(new Game(R.drawable.assassinscreedsyndicate, "Assassin's Creed Syndicate", "October 23, 2015", "Action-Adventure Stealth"));
        games.add(new Game(R.drawable.gtav, "Grand Theft Auto V", "September 17, 2013", "Action-Adventure"));

        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.adapter_listview, games);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }//OnCreate

    public class Game {
        int image;
        String name, date, type;

        public Game (int image, String name, String date, String type) {
            this.image = image;
            this.name = name;
            this.date = date;
            this.type = type;
        }//Constructor for Game

        //Accessor methods
        public int getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getType() {
            return type;
        }
    }//Game object

    public class ListViewAdapter extends ArrayAdapter<Game> {
        Context myContext;
        int xml;
        List<Game> listy;

        public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Game> objects) {
            super(context, resource, objects);
            myContext = context;
            xml = resource;
            listy = objects;
        }//Constructor for ListViewAdapter

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView= inflater.inflate(xml,null);
            ImageView imageView = adapterView.findViewById(R.id.adapter_imageView);
            TextView textView = adapterView.findViewById(R.id.adapter_textView_name);
            Button button = adapterView.findViewById(R.id.adapter_button);

            imageView.setImageResource(listy.get(position).getImage());
            textView.setText(listy.get(position).getName());
            button.setText("DELETE");

            return adapterView;
        }//getView
    }//ListViewAdapter
}//MainActivity