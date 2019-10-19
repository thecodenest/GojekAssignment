package rajendra.gojekassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.schedulers.Schedulers;
import rajendra.gojekassignment.adapter.RecyclerViewAdapter;
import rajendra.gojekassignment.model.GitRepo;
import rajendra.gojekassignment.retrofit.ApiClient;
import rajendra.gojekassignment.retrofit.ApiInterface;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton menu;

    ApiInterface apiInterface;
    private List<rajendra.gojekassignment.model.RecyclerView> data ;
    private RecyclerView recyclerView ;
    RecyclerViewAdapter dataAdapter;


    CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu= findViewById(R.id.menu);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        setuprecyclerview();

        fetchData();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, menu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }

        });


    }

    private void fetchData() {

        compositeDisposable.add(apiInterface.getRepositories()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<GitRepo>>() {
            @Override
            public void accept(List<GitRepo> gitRepos) throws Exception {

                displaydata(gitRepos);

            }
        }));


    }

    private void displaydata(List<GitRepo> gitRepos) {

        dataAdapter = new RecyclerViewAdapter(this, gitRepos);
        recyclerView.setAdapter(dataAdapter);
    }

    private void setuprecyclerview() {


        // adapter ini and setup
        recyclerView = findViewById(R.id.recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}



