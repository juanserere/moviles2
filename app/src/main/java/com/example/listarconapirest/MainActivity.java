package com.example.listarconapirest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity
{

    private EditText etUsuario, etContrasena;
    private String Usuario, Contrasena;
    //private String URL = "http://192.168.88.100:8080/LoginGrupoDeBello/login.php";
    private String URL = "http://10.2.6.49/LoginGrupoDeBello/login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario = Contrasena = "";
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);

    }

    public void login(View view)
    {
        Usuario = etUsuario.getText().toString().trim();
        Contrasena = etContrasena.getText().toString().trim();

        //String URL = "http://192.168.88.100:8080/LoginGrupoDeBello/login.php"
        //        + "?codAlu="+Usuario.toString()+"&pasUsu="+Contrasena.toString()+"";;

        if(!Usuario.equals("") && !Contrasena.equals(""))
        {
            URL = URL + "?codAlu="+Usuario.toString()+
                    "&pasUsu="+Contrasena.toString()+"";
            //Log.d("res", URL);
            StringRequest stringRequest = new
                    StringRequest(
                            Request.Method.GET, URL,
                            new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    Log.d("res", response);
                    if (response.equals("correcto"))
                    {
                        Intent intent = new Intent(MainActivity.this, AdministracionCrud.class);
                        startActivity(intent);
                        finish();
                    }
                    else if (response.equals("error"))
                    {
                        Toast.makeText(MainActivity.this,
                                "Inválido usuario/contraseña",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String, String> data = new HashMap<>();
                    data.put("usuario", Usuario);
                    data.put("contrasena", Contrasena);
                    return data;
                }
            };
            RequestQueue requestQueue =
                    Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
        else
        {
            Toast.makeText(this, "Campos no pueden estar vacíos!", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view)
    {
        Intent intent = new
                Intent(this,
                AdministracionCrud.class);
        startActivity(intent);
        finish();
    }

}