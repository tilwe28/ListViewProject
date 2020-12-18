package com.example.listviewprojectqtwo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    TextView textViewDate, textViewType, textViewDescription;
    ListViewAdapter adapter;

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop Method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart Method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy Method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume Method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause Method");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "OnCreate Method");

        listView = findViewById(R.id.main_listView);
        textViewDate = findViewById(R.id.textView_date);
        textViewType = findViewById(R.id.textView_type);
        textViewDescription = findViewById(R.id.textView_description);

        games = new ArrayList<>();
        games.add(new Game(R.drawable.destinytakenking, "Destiny", "September 9, 2014", "Shared World Shooter", "Destiny is a combination of a shooter and free roam story game. It was the first game I ever played on my ps4. and I've met many friends through Destiny."));
        games.add(new Game(R.drawable.bo3, "Black Ops 3", "November 6, 2015", "First Person Shooter", "Call of Duty Black Ops III is a FPS that has multiplayer and zombies game modes. It was the firt FPS I lpayed, and the zombies game mode is something me and my friends played for multiple summers."));
        games.add(new Game(R.drawable.fortnitebr, "Fortnite", "September 26, 2017", "Battle Royale", "Fortnite is one of the biggest games to ever be released, and with it's creative game mode, me and my friends played many different types of puzzle and deathrun maps."));
        games.add(new Game(R.drawable.nba2k20, "NBA 2k20", "September 5, 2019", "Sport Simulation", "NBA 2k20 is one of my favorite games because I have always loved basketball. Especially when it's played with your real life teammates."));
        games.add(new Game(R.drawable.assassinscreedsyndicate, "Assassin's Creed Syndicate", "October 23, 2015", "Action-Adventure Stealth", "Assassin's Creed is a single player story game based in London. It was a game I played when I was bored, and I would play while listening to music."));
        games.add(new Game(R.drawable.gtav, "Grand Theft Auto V", "September 17, 2013", "Action-Adventure", "GTA V is one of the most fun games because you can do almost anything you want. I also really like it because it was the game that me and my friends started playing when the pandamic first started and we had nothing else to do."));

        adapter = new ListViewAdapter(this, R.layout.adapter_listview, games);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(true);
        adapter.notifyDataSetChanged();
    }//OnCreate

    public class Game {
        int image;
        String name, date, type, description;

        public Game (int image, String name, String date, String type, String description) {
            this.image = image;
            this.name = name;
            this.date = date;
            this.type = type;
            this.description = description;
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

        public String getDescription() {
            return description;
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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = inflater.inflate(xml,null);
            ImageView imageView = adapterView.findViewById(R.id.adapter_imageView);
            final TextView textView = adapterView.findViewById(R.id.adapter_textView_name);
            Button button = adapterView.findViewById(R.id.adapter_button);

            imageView.setImageResource(listy.get(position).getImage());
            textView.setText(listy.get(position).getName());
            button.setText("DELETE");

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getResources().getConfiguration().orientation==1) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                    }
                    if (getResources().getConfiguration().orientation==2) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                        textViewDescription.setText(""+listy.get(position).getDescription());
                    }
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getResources().getConfiguration().orientation==1) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                    }
                    if (getResources().getConfiguration().orientation==2) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                        textViewDescription.setText(""+listy.get(position).getDescription());
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", listy.get(position).getName()+" was removed");
                    removeItem(v);
                }
            });

            return adapterView;
        }//getView
    }//ListViewAdapter

    public void removeItem(View v) {
        final int position = listView.getPositionForView((View)v.getParent());
        games.remove(position);
        adapter.notifyDataSetChanged();
    }
}//MainActivity