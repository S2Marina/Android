package marina.toolbar.control;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import marina.toolbar.R;

public class DetalheAvatar extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalhe_avatar, container, false);
        setHasOptionsMenu(true);

        MainActivity.t.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        MainActivity.t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        MainActivity.t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuitem_salvar: {
                        replaceFragment();
                        break;
                    }
                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detalhe_avatar, menu);
    }

    private void replaceFragment(){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        CadastrarJogador cadastrar = new CadastrarJogador();
        transaction.replace(R.id.fragment_container, cadastrar);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
