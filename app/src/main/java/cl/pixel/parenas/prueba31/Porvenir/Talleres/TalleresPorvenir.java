package cl.pixel.parenas.prueba31.Porvenir.Talleres;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class TalleresPorvenir extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talleres_porvenir);
        DatabaseHelper basedeDatos = new DatabaseHelper(this); //creacion del puntero
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from TALLERESPP", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(0);
                    ;
                    arreglo[i] = linea;
                    i++;
                } while (c.moveToNext());
            }
            ListView opc = (ListView)findViewById(R.id.talleresporvenir);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            opc.setAdapter(adapter);
            opc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(TalleresPorvenir.this, InfoTalleresPorvenir.class);
                    intent.putExtra(InfoTalleresPorvenir.EXTRA_TALLER_NUMERO,position);
                    startActivity(intent);
                }
            });
        }
        db.close();
    }
    /*@Override
    public void onListItemClick(ListView listView, View item, int posicion, long id){
        Intent intent=new Intent(TalleresPorvenir.this,InfoTalleresPorvenir.class);
        //intent.putExtra(InfoTalleresPorvenir.EXTRA_CLIENTE_NUMERO,posicion);
        startActivity(intent);
    }*/
}
