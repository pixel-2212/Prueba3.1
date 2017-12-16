package cl.pixel.parenas.prueba31.Porvenir.Hoteles;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class HotelesPorvenir extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles_porvenir);
        DatabaseHelper basedeDatos = new DatabaseHelper(this); //creacion del puntero
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from HOTELESPP", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if (c.moveToFirst()) {
                do {
                    String linea = c.getString(0);
                    arreglo[i] = linea;
                    i++;
                } while (c.moveToNext());
            }
            ListView opc = (ListView)findViewById(R.id.hoteles_porvenir);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            opc.setAdapter(adapter);
            opc.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(HotelesPorvenir.this, InfoHotelesPorvenir.class);
                    intent.putExtra(InfoHotelesPorvenir.EXTRA_HOTEL_NUMERO,position);
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