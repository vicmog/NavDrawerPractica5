package com.example.navdrawerpractica5;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private List<ItemRopa> items;
    private TypedArray arrayImagenes;
    private Resources res;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = view.findViewById(R.id.btfloat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        v = view;
        res = view.getResources();
        arrayImagenes = res.obtainTypedArray(R.array.imagenes_ropa_hombre);//array hombres

        cargaArrays();
        cargaReciclerView();


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return true;
    }

    private void cargaReciclerView() {
        RecyclerView miRecicler = v.findViewById(R.id.miRecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items,v,getActivity());
        miRecicler.setAdapter(adapter);
        miRecicler.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @SuppressLint("ResourceType")
    private void cargaArrays() {
        items = new ArrayList<>();
        ItemRopa itemAux1 = new ItemRopa("Camiseta casual blanca con el dibujo de un tres en raya.",29.99,arrayImagenes.getDrawable(0));
        ItemRopa itemAux2 = new ItemRopa("Camiseta azul del equipo de los Warriors con el numero 88.",16.77,arrayImagenes.getDrawable(1));
        ItemRopa itemAux3 = new ItemRopa("Camiseta blanca con lineas negras dispersas por ella.",10,arrayImagenes.getDrawable(2));
        ItemRopa itemAux4 = new ItemRopa("Pantalones verde pistacho de la marca Jordan",40.50,arrayImagenes.getDrawable(3));
        ItemRopa itemAux5 = new ItemRopa("Pantalones vaqueros azul marino",26.77,arrayImagenes.getDrawable(4));
        ItemRopa itemAux6 = new ItemRopa("Pantalones grises nike con el logo en los lados.",36.33,arrayImagenes.getDrawable(5));
        ItemRopa itemAux7 = new ItemRopa("Chaqueta azul celeste para vestir",136.27,arrayImagenes.getDrawable(6));
        ItemRopa itemAux8 = new ItemRopa("Chaqueta gris celeste para vestir",59.99,arrayImagenes.getDrawable(7));
        ItemRopa itemAux9 = new ItemRopa("Camisa rosa con puntos negros dispersos.",99.99,arrayImagenes.getDrawable(8));
        ItemRopa itemAux10 = new ItemRopa("Gafas marrones y negras con lentes color negras",20.50,arrayImagenes.getDrawable(9));
        ItemRopa itemAux11 = new ItemRopa("Gafas negras con lentes verdes para uso diario.",16.80,arrayImagenes.getDrawable(10));
        ItemRopa itemAux12= new ItemRopa("Gafas de tono azul y con lentes rojizas para uso diario",66.90,arrayImagenes.getDrawable(11));

        items.add(itemAux1);
        items.add(itemAux2);
        items.add(itemAux3);
        items.add(itemAux4);
        items.add(itemAux5);
        items.add(itemAux6);
        items.add(itemAux7);
        items.add(itemAux8);
        items.add(itemAux9);
        items.add(itemAux10);
        items.add(itemAux11);
        items.add(itemAux12);


    }

}