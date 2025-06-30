package com.example.proyectobiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    TextInputEditText usuarioInput, claveInput;
    Button btnIngresar;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar elementos
        usuarioInput = findViewById(R.id.usuarioInput);
        claveInput = findViewById(R.id.claveInput);
        btnIngresar = findViewById(R.id.button);// Botón manual si no está aún en layout
        dbHelper = new DBHelper(this);

        // Si tienes un botón en el XML, usa:
        // btnIngresar = findViewById(R.id.btnIngresar); ← debes agregarlo en XML

        // Listener del botón
        btnIngresar.setOnClickListener(view -> {
            String usuario = usuarioInput.getText().toString().trim();
            String clave = claveInput.getText().toString().trim();

            if (usuario.isEmpty() || clave.isEmpty()) {
                Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean valido = dbHelper.validarUsuario(usuario, clave);
            if (valido) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, Principal.class));
                finish(); // cerrar login
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });

        // Edge-to-edge (no afecta lógica)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}