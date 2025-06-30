package com.example.proyectobiblioteca;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

public class BibliotecaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_biblioteca_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_libros);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> libros = Arrays.asList("Libro 1", "Libro 2", "Libro 3");
        recyclerView.setAdapter(new LibroAdapter(libros));

        return view;
    }
}