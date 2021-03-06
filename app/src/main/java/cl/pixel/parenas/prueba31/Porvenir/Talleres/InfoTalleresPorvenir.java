package cl.pixel.parenas.prueba31.Porvenir.Talleres;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class InfoTalleresPorvenir extends AppCompatActivity {
    public static final String EXTRA_TALLER_NUMERO="TallerNro";
    String nom = new String();
    Double lat;
    Double lon;
    int tnro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_talleres_porvenir);
        int TallerNro=(Integer)getIntent().getExtras().get(EXTRA_TALLER_NUMERO);
        TextView nombre=(TextView)findViewById(R.id.nom_taller);
        TextView latitud=(TextView)findViewById(R.id.lat_taller);
        TextView longitud=(TextView)findViewById(R.id.long_taller);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (db != null){
            Cursor c = db.rawQuery("select * from TALLERESPP",null);
            c.move(TallerNro);
            if (TallerNro == 0){
                c.moveToFirst();
                String linean = c.getString(0);
                Double lineala = c.getDouble(1);
                Double linealo = c.getDouble(2);
                nom = linean;
                lat = lineala;
                lon = linealo;
            }else{
                if (c.move(TallerNro)){
                    String linean = c.getString(0);
                    Double lineala = c.getDouble(1);
                    Double linealo = c.getDouble(2);
                    nom = linean;
                    lat = lineala;
                    lon = linealo;
                }
            }
            nombre.setText(nom);
            latitud.setText(""+lat);
            longitud.setText(""+lon);
        }
        tnro=TallerNro;
        db.close();
    }
    public void verMapaTaller (View view){
        Intent intent = new Intent(InfoTalleresPorvenir.this, MapaTalleresPorvenir.class);
        intent.putExtra(MapaTalleresPorvenir.EXTRA_NOMBRE,tnro);
        /*intent.putExtra(MapsActivity.EXTRA_LATITUD,lat);
        intent.putExtra(MapsActivity.EXTRA_LONGITUD,lon);*/
        startActivity(intent);
    }
}
