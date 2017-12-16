package cl.pixel.parenas.prueba31.Porvenir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.pixel.parenas.prueba31.MainActivity;
import cl.pixel.parenas.prueba31.Porvenir.EDS.EdsPorvenir;
import cl.pixel.parenas.prueba31.Porvenir.Hoteles.HotelesPorvenir;
import cl.pixel.parenas.prueba31.Porvenir.Talleres.TalleresPorvenir;
import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.RioGrande.RioGrande;

public class Porvenir extends AppCompatActivity {
    private String[] opciones={"Hoteles","Talleres","Estaciones de Servicio"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porvenir);
        ListView opc = (ListView)findViewById(R.id.opcporve);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opciones);
        opc.setAdapter(adapter);
        opc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent porvenir=new Intent(Porvenir.this, HotelesPorvenir.class);
                    startActivity(porvenir);
                }else if(position==1){
                    Intent porvenir=new Intent(Porvenir.this, TalleresPorvenir.class);
                    startActivity(porvenir);
                }else {
                    Intent porvenir=new Intent(Porvenir.this, EdsPorvenir.class);
                    startActivity(porvenir);
                }
            }
        });
    }
}
