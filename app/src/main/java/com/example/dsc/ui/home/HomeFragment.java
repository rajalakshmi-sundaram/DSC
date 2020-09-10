package com.example.dsc.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dsc.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "HomeFrag";

    public HomeFragment(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recy);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //layoutManager = new LinearLayoutManager(,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(this, viewItems);
        mRecyclerView.setAdapter(mAdapter);

        addItemsFromJSON();
        return root;
    }
        @RequiresApi(api = Build.VERSION_CODES.O)
        private void addItemsFromJSON(){
            try {


                String file = "src/main/res/Raw/events.json";
                String jsonDataString = readFileAsString(file);



                JSONArray jsonArray = new JSONArray(jsonDataString);

                for (int i = 0; i < jsonArray.length(); ++i) {

                    JSONObject itemObj = jsonArray.getJSONObject(i);

                    String name = itemObj.getString("name");
                    String date = itemObj.getString("date");

                    Events events = new Events(name, date);
                    viewItems.add(events);
                }

            } catch (IOException | JSONException e) {
                Log.d(TAG, "addItemsFromJSON: ", e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
