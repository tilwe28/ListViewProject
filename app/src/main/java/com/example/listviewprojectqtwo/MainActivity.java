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
    ArrayList<Game> games = new ArrayList<>();
    TextView textViewDate, textViewType, textViewDescription;
    CharSequence date="Release Date:", type="Type: ", description="Description";
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
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "onRestoreInstanceState method");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("SAVE", games);
        outState.putCharSequence("DATE", date);
        outState.putCharSequence("TYPE", type);
        outState.putCharSequence("DESCRIPTION", description);
        Log.d("TAG", "Games and TextViews saved");
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

        if (savedInstanceState != null) {
            Log.d("TAG", "Games and TextViews restored");
            games = (ArrayList<Game>) savedInstanceState.getSerializable("SAVE");
            date = savedInstanceState.getCharSequence("DATE");
            type = savedInstanceState.getCharSequence("TYPE");
            description = savedInstanceState.getCharSequence("DESCRIPTION");
        } else {
            Log.d("TAG", "Games filled");
            games.add(new Game(R.drawable.destinytakenking, "Destiny", "September 9, 2014", "Shared World Shooter", "Destiny is a combination of a shooter and free roam story game. It was the first game I ever played on my ps4, and I've met many friends through Destiny. Destiny is very fun to play by yourself or even with friends, because you get to complete quests as a group."));
            games.add(new Game(R.drawable.bo3, "Black Ops 3", "November 6, 2015", "First Person Shooter", "Call of Duty Black Ops III is a FPS that has multiplayer and zombies game modes. It was the firt FPS I lpayed, and the zombies game mode is something me and my friends played for multiple summers. In my opinion, Black Ops 3 is the best Black Ops because all the multiplayer maps were fun, there were many balanced guns, and the zombies had many different maps that each had great easter eggs."));
            games.add(new Game(R.drawable.fortnitebr, "Fortnite", "September 26, 2017", "Battle Royale", "Fortnite is one of the biggest games to ever be released, and with it's creative game mode, me and my friends played many different types of puzzle and death run maps. Fortnite is definitely one of the best battle royales because of the aspect of being able to build and destroy structures."));
            games.add(new Game(R.drawable.nba2k20, "NBA 2k20", "September 5, 2019", "Sport Simulation", "NBA 2k20 is one of my favorite games because I have always loved basketball. Especially when it's played with your real life teammates. Nba 2k20 was not that good in terms of gameplay, because it was an exact repeat as 2k19 but with slower mechanics."));
            games.add(new Game(R.drawable.assassinscreedsyndicate, "Assassin's Creed Syndicate", "October 23, 2015", "Action-Adventure Stealth", "Assassin's Creed is a single player story game based in London. It was a game I played when I was bored, and I would play while listening to music. Assassin's creed is a very calming game to play because all the missions are about being stealthy."));
            games.add(new Game(R.drawable.gtav, "Grand Theft Auto V", "September 17, 2013", "Action-Adventure", "GTA V is one of the most fun games because you can do almost anything you want. I also really like it because it was the game that me and my friends started playing when the pandamic first started and we had nothing else to do. GTA V is one of the best games of all time because of the wide variety of things you could do, and Rockstar games frequently adds new content."));
            games.add(new Game(R.drawable.warzone, "Call of Duty Warzone", "March 10, 2020", "Fist Person Battle Royale", "Warzone has been the biggest games during quarantine, and it's the game that I played the most this year. I really like Warzone because it's literally the battle royale version of Call of Duty. The only part about Warzone I dislike is the fact that there is skill based matchmaking and that there are some overpowered weapons."));
        }

        textViewDate.setText(date);
        textViewType.setText(type);
        if (getResources().getConfiguration().orientation==2)
            textViewDescription.setText(description);

        adapter = new ListViewAdapter(this, R.layout.adapter_listview, games);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(true);
        adapter.notifyDataSetChanged();
    }//OnCreate

    public class Game {
        int image;
        String name, dateG, typeG, descriptionG;

        public Game (int image, String name, String dateG, String typeG, String descriptionG) {
            this.image = image;
            this.name = name;
            this.dateG = dateG;
            this.typeG = typeG;
            this.descriptionG = descriptionG;
        }//Constructor for Game

        //Accessor methods
        public int getImage() {
            return image;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return dateG;
        }

        public String getType() {
            return typeG;
        }

        public String getDescription() {
            return descriptionG;
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
                        description = listy.get(position).getDescription();
                    }
                    if (getResources().getConfiguration().orientation==2) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                        textViewDescription.setText(""+listy.get(position).getDescription());
                        description = textViewDescription.getText();
                    }
                    date = textViewDate.getText();
                    type = textViewType.getText();
                    Log.d("TAG", "Image clicked");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getResources().getConfiguration().orientation==1) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                        description = listy.get(position).getDescription();
                    }
                    if (getResources().getConfiguration().orientation==2) {
                        textViewDate.setText("Release Date: "+listy.get(position).getDate());
                        textViewType.setText("Type: "+listy.get(position).getType());
                        textViewDescription.setText(""+listy.get(position).getDescription());
                        description = textViewDescription.getText();
                    }
                    date = textViewDate.getText();
                    type = textViewType.getText();
                    Log.d("TAG", "Text clicked");
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", listy.get(position).getName()+" was removed");
                    final int position = listView.getPositionForView((View)v.getParent());
                    games.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            return adapterView;
        }//getView
    }//ListViewAdapter
}//MainActivity