package marina.toolbar.control;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import marina.toolbar.R;


public class CadastrarJogador extends Fragment {

    public Button btAvatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cadastrar_jogador, container, false);
        setHasOptionsMenu(true);

        btAvatar = (Button) view.findViewById(R.id.cadastrarJogador_btAvatar);

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
                        getFragmentManager().popBackStack();
                        break;
                    }
                }
                return true;
            }
        });


        btAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment();
            }
        });

        return view;

    }


    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_cadastrar_jogador, menu);
    }

    private void replaceFragment(){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ListaAvatar listaAvatar = new ListaAvatar();
        transaction.replace(R.id.fragment_container, listaAvatar);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}


