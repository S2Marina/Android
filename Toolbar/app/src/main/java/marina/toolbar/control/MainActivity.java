package marina.toolbar.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import marina.toolbar.R;

public class MainActivity extends AppCompatActivity {

    public static Toolbar t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);


        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        //ListaAvatar l = new ListaAvatar();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, l).commit();

        SelecionarJogador sj = new SelecionarJogador();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, sj).commit();


    }
}
