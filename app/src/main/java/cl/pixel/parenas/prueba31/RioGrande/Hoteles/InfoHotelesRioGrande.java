package cl.pixel.parenas.prueba31.RioGrande.Hoteles;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class InfoHotelesRioGrande extends AppCompatActivity {
    public static final String EXTRA_HOTEL_NUMERO="HotelNro";
    String nom = new String();
    String dire;
    String tele;
    int hnro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hoteles_rio_grande);
        int HotelNro=(Integer)getIntent().getExtras().get(EXTRA_HOTEL_NUMERO);
        TextView nombre=(TextView)findViewById(R.id.nom_hotel_rio);
        TextView direccion=(TextView)findViewById(R.id.direccion_hotel_rio);
        TextView telefono=(TextView)findViewById(R.id.telefono_hotel_rio);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (db != null){
            Cursor c = db.rawQuery("select * from HOTELESRG",null);
            c.move(HotelNro);
            if (HotelNro == 0){
                c.moveToFirst();
                String linean = c.getString(0);
                String lineadir = c.getString(1);
                String lineatel = c.getString(2);
                nom = linean;
                dire = lineadir;
                tele = lineatel;

            }else{
                if (c.move(HotelNro)){
                    String linean = c.getString(0);
                    String lineadir = c.getString(1);
                    String lineatel = c.getString(2);
                    nom = linean;
                    dire = lineadir;
                    tele = lineatel;
                }
            }
            nombre.setText(nom);
            direccion.setText(dire);
            telefono.setText(tele);
        }
        hnro=HotelNro;
        db.close();
    }
    public void verMapaHotelPor (View view){
        Intent intent = new Intent(InfoHotelesRioGrande.this, MapaHotelesRioGrande.class);
        intent.putExtra(MapaHotelesRioGrande.EXTRA_HOTEL_NRO,hnro);
        /*intent.putExtra(MapsActivity.EXTRA_LATITUD,lat);
        intent.putExtra(MapsActivity.EXTRA_LONGITUD,lon);*/
        startActivity(intent);
    }
}
