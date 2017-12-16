package cl.pixel.parenas.prueba31;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.pixel.parenas.prueba31.Porvenir.Porvenir;
import cl.pixel.parenas.prueba31.RioGrande.RioGrande;

public class MainActivity extends AppCompatActivity {
    private String[] opciones={"Porvenir", "Rio Grande"};
    private ListView opc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView opc = (ListView)findViewById(R.id.ciudades);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opciones);
        opc.setAdapter(adapter);
        opc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent porvenir=new Intent(MainActivity.this, Porvenir.class);
                    startActivity(porvenir);
                }else{
                    Intent riogrande=new Intent(MainActivity.this, RioGrande.class);
                    startActivity(riogrande);
                }
            }
        });
    }
}
