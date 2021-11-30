package com.example.listarconapirest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
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

public class Alumnos extends AppCompatActivity {

    private EditText edtCodigo, edtNombre, edtDistrito, edtEstadoCivil, edtContrasena;
    private TextView tvStatus;
    private Button btnInsertar;
    //private String URL = "http://192.168.88.100:8080/LoginGrupoDeBello/registrar.php";
    private String URL = "http://10.2.6.49/LoginGrupoDeBello/registraralumnos.php";
    private String URLACTUALIZAR = "http://10.2.6.49/LoginGrupoDeBello/actualizaralumnos.php";
    private String URLDELETE = "http://10.2.6.49/LoginGrupoDeBello/borrarlumnos.php";
    private String URLSELECT = "http://10.2.6.49/LoginGrupoDeBello/consultaralumnos.php";
    private String codigo, nombre, distrito, estadocivil, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        edtCodigo = findViewById(R.id.edtCodigo);
        edtNombre = findViewById(R.id.edtNombre);
        edtDistrito = findViewById(R.id.edtDistrito);
        edtEstadoCivil = findViewById(R.id.edtEstadoCivil);
        edtContrasena = findViewById(R.id.edtContrasena);
        tvStatus = findViewById(R.id.tvStatus);
        btnInsertar = findViewById(R.id.btnInsertar);
        codigo = nombre = distrito = estadocivil = contrasena = "";

    }

    public void save(View view) {
        codigo = edtCodigo.getText().toString().trim();
        nombre = edtNombre.getText().toString().trim();
        distrito = edtDistrito.getText().toString().trim();
        estadocivil = edtEstadoCivil.getText().toString().trim();
        contrasena = edtContrasena.getText().toString().trim();
        //reenterPassword = etReenterPassword.getText().toString().trim();
         //if(!contrasena.equals(reenterPassword)){
        if(contrasena.equals("")){
            Toast.makeText(this, "Clave diferente", Toast.LENGTH_SHORT).show();
        }
        else if(!codigo.equals("") && !nombre.equals("") && !distrito.equals("") && !estadocivil.equals("") && !contrasena.equals("")){

            URL = URL +
                    "?codAlu="+codigo.toString()+
                    "&nombreAlu="+nombre.toString()+
                    "&distrito="+distrito.toString()+
                    "&estadocivil="+estadocivil.toString()+
                    "&pasUsu="+contrasena.toString()+"";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("correcto")) {
                        tvStatus.setText("Satisfactoriamente registrado.");
                        btnInsertar.setClickable(false);
                    } else if (response.equals("error")) {
                        tvStatus.setText("Por favor revise, hay errores!");                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("codAlu", codigo);
                    data.put("nombreAlu", nombre);
                    data.put("distrito", distrito);
                    data.put("estadocivil", estadocivil);
                    data.put("pasUsu", contrasena);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void update(View view) {
        codigo = edtCodigo.getText().toString().trim();
        nombre = edtNombre.getText().toString().trim();
        distrito = edtDistrito.getText().toString().trim();
        estadocivil = edtEstadoCivil.getText().toString().trim();
        contrasena = edtContrasena.getText().toString().trim();
        //reenterPassword = etReenterPassword.getText().toString().trim();
        //if(!contrasena.equals(reenterPassword)){
        if(contrasena.equals("")){
            Toast.makeText(this, "Clave diferente", Toast.LENGTH_SHORT).show();
        }
        else if(!codigo.equals("") && !nombre.equals("") && !distrito.equals("") && !estadocivil.equals("") && !contrasena.equals("")){

            URLACTUALIZAR = URLACTUALIZAR +
                    "?codAlu="+codigo.toString()+
                    "&nombreAlu="+nombre.toString()+
                    "&distrito="+distrito.toString()+
                    "&estadocivil="+estadocivil.toString()+
                    "&pasUsu="+contrasena.toString()+"";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLACTUALIZAR, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("correcto")) {
                        tvStatus.setText("Satisfactoriamente actualizado.");
                        btnInsertar.setClickable(false);
                    } else if (response.equals("error")) {
                        tvStatus.setText("Por favor revise, hay errores!");                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("codAlu", codigo);
                    data.put("nombreAlu", nombre);
                    data.put("distrito", distrito);
                    data.put("estadocivil", estadocivil);
                    data.put("pasUsu", contrasena);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void delete(View view) {
        codigo = edtCodigo.getText().toString().trim();
        nombre = edtNombre.getText().toString().trim();
        distrito = edtDistrito.getText().toString().trim();
        estadocivil = edtEstadoCivil.getText().toString().trim();
        contrasena = edtContrasena.getText().toString().trim();
        //reenterPassword = etReenterPassword.getText().toString().trim();
        //if(!contrasena.equals(reenterPassword)){
        if(contrasena.equals("")){
            Toast.makeText(this, "Clave diferente", Toast.LENGTH_SHORT).show();
        }
        else if(!codigo.equals("") && !nombre.equals("") && !distrito.equals("") && !estadocivil.equals("") && !contrasena.equals("")){

            URLDELETE = URLDELETE +
                    "?codAlu="+codigo.toString()+
                    "&nombreAlu="+nombre.toString()+
                    "&distrito="+distrito.toString()+
                    "&estadocivil="+estadocivil.toString()+
                    "&pasUsu="+contrasena.toString()+"";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLDELETE, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("correcto")) {
                        tvStatus.setText("Satisfactoriamente eliminado.");
                        btnInsertar.setClickable(false);
                    } else if (response.equals("error")) {
                        tvStatus.setText("Por favor revise, hay errores!");                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("codAlu", codigo);
                    data.put("nombreAlu", nombre);
                    data.put("distrito", distrito);
                    data.put("estadocivil", estadocivil);
                    data.put("pasUsu", contrasena);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    public void select(View view) {
        codigo = edtCodigo.getText().toString().trim();
        nombre = edtNombre.getText().toString().trim();
        distrito = edtDistrito.getText().toString().trim();
        estadocivil = edtEstadoCivil.getText().toString().trim();
        contrasena = edtContrasena.getText().toString().trim();
        //reenterPassword = etReenterPassword.getText().toString().trim();
        //if(!contrasena.equals(reenterPassword)){
        if(contrasena.equals("")){
            Toast.makeText(this, "Clave diferente", Toast.LENGTH_SHORT).show();
        }
        else if(!codigo.equals("") && !nombre.equals("") && !distrito.equals("") && !estadocivil.equals("") && !contrasena.equals("")){

            URLSELECT = URLSELECT +
                    "?codAlu="+codigo.toString()+
                    "&nombreAlu="+nombre.toString()+
                    "&distrito="+distrito.toString()+
                    "&estadocivil="+estadocivil.toString()+
                    "&pasUsu="+contrasena.toString()+"";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLSELECT, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("correcto")) {
                        tvStatus.setText("Satisfactoriamente eliminado.");
                        btnInsertar.setClickable(false);
                    } else if (response.equals("error")) {
                        tvStatus.setText("Por favor revise, hay errores!");                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("codAlu", codigo);
                    data.put("nombreAlu", nombre);
                    data.put("distrito", distrito);
                    data.put("estadocivil", estadocivil);
                    data.put("pasUsu", contrasena);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }





}