package marina.toolbar.control;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import marina.toolbar.R;


public class ListaAvatar extends Fragment {
    public Button bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_avatar, container, false);

        MainActivity.t.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        MainActivity.t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        bt = (Button) view.findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment();
            }
        });

        return view;
    }


    private void replaceFragment(){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        DetalheAvatar detalheAvatar = new DetalheAvatar();
        transaction.replace(R.id.fragment_container, detalheAvatar);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
