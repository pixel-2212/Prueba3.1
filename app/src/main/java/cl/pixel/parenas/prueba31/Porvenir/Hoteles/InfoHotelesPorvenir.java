package cl.pixel.parenas.prueba31.Porvenir.Hoteles;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class InfoHotelesPorvenir extends AppCompatActivity {
    public static final String EXTRA_HOTEL_NUMERO="HotelNro";
    String nom = new String();
    String dire;
    String tele;
    String pre;
    int hnro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hoteles_porvenir);
        int HotelNro=(Integer)getIntent().getExtras().get(EXTRA_HOTEL_NUMERO);
        TextView nombre=(TextView)findViewById(R.id.nom_hotel);
        TextView direccion=(TextView)findViewById(R.id.direccion_hotel);
        TextView telefono=(TextView)findViewById(R.id.telefono_hotel);
        TextView precios=(TextView)findViewById(R.id.precios_hotel);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (db != null){
            Cursor c = db.rawQuery("select * from HOTELESPP",null);
            c.move(HotelNro);
            if (HotelNro == 0){
                c.moveToFirst();
                String linean = c.getString(0);
                String lineadir = c.getString(1);
                String lineatel = c.getString(2);
                String lineaprecios = "Individual: $"+c.getString(3)+"| Doble: $"+c.getString(4)+"| Matrimonial: $"+c.getString(5);
                nom = linean;
                dire = lineadir;
                tele = lineatel;
                pre = lineaprecios;
            }else{
                if (c.move(HotelNro)){
                    String linean = c.getString(0);
                    String lineadir = c.getString(1);
                    String lineatel = c.getString(2);
                    String lineaprecios = "Individual: $"+c.getString(3)+"| Doble: $"+c.getString(4)+"| Matrimonial: $"+c.getString(5);
                    nom = linean;
                    dire = lineadir;
                    tele = lineatel;
                    pre = lineaprecios;
                }
            }
            nombre.setText(nom);
            direccion.setText(dire);
            telefono.setText(tele);
            precios.setText(pre);
        }
        hnro=HotelNro;
        db.close();
    }
    public void verMapaHotelPor (View view){
        Intent intent = new Intent(InfoHotelesPorvenir.this, MapaHotelesPorvenir.class);
        intent.putExtra(MapaHotelesPorvenir.EXTRA_HOTEL_NRO,hnro);
        /*intent.putExtra(MapsActivity.EXTRA_LATITUD,lat);
        intent.putExtra(MapsActivity.EXTRA_LONGITUD,lon);*/
        startActivity(intent);
    }
}
