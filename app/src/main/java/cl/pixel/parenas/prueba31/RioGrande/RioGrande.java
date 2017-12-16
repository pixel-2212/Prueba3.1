package cl.pixel.parenas.prueba31.RioGrande;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.pixel.parenas.prueba31.Porvenir.Porvenir;
import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.RioGrande.EDS.EdsRioGrande;
import cl.pixel.parenas.prueba31.RioGrande.Hoteles.HotelesRioGrande;
import cl.pixel.parenas.prueba31.RioGrande.Talleres.TalleresRioGrande;

public class RioGrande extends AppCompatActivity {
    private String[] opciones={"Hoteles","Talleres","Estaciones de Servicio"};
    private ListView opc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rio_grande);
        ListView opc = (ListView)findViewById(R.id.opcrgrande);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opciones);
        opc.setAdapter(adapter);
        opc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent riogrande=new Intent(RioGrande.this, HotelesRioGrande.class);
                    startActivity(riogrande);
                }else if (position == 1){
                    Intent riogrande=new Intent(RioGrande.this, TalleresRioGrande.class);
                    startActivity(riogrande);
                }else{
                    Intent riogrande=new Intent(RioGrande.this, EdsRioGrande.class);
                    startActivity(riogrande);
                }
            }
        });
    }
}
