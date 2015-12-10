package com.anji.volley;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends Activity {
    TextView textView;
    Button btnRequest;
    RequestQueue queue;
    StringRequest stringRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView=(TextView)findViewById(R.id.text_hello);
        btnRequest = (Button)findViewById(R.id.btn_send_request);


        // Instantiate the RequestQueue
//        queue= Volley.newRequestQueue(this);
        queue=Singleton.getInstance(this.getApplicationContext()).getRequestQueue();

        String url="http://involgix.com/poultryone/mobileapp/login.php?username=9948562267&password=727298";
        // Request a string response from the provided URL.
        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Volley",response);
                textView.setText(response);
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
//                Singleton.getInstance(this).addToRequestQueue(stringRequest);
            }
        });

    }

}
