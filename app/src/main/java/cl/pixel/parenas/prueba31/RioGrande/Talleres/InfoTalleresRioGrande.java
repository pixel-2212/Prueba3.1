package cl.pixel.parenas.prueba31.RioGrande.Talleres;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class InfoTalleresRioGrande extends AppCompatActivity {

    public static final String EXTRA_TALLER_NUMERO="TallerNro";
    String nom = new String();
    double lat;
    double lon;
    int tnro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_talleres_rio_grande);
        int TallerNro=(Integer)getIntent().getExtras().get(EXTRA_TALLER_NUMERO);
        TextView nombre=(TextView)findViewById(R.id.nom_taller);
        TextView latitud=(TextView)findViewById(R.id.lat_taller);
        TextView longitud=(TextView)findViewById(R.id.long_taller);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (db != null){
            Cursor c = db.rawQuery("select * from TALLERESRG",null);
            c.move(TallerNro);
            if (TallerNro == 0){
                c.moveToFirst();
                String linean = c.getString(0);
                double lineala = c.getDouble(1);
                double linealo = c.getDouble(2);
                nom = linean;
                lat = lineala;
                lon = linealo;
            }else{
                if (c.move(TallerNro)){
                    String linean = c.getString(0);
                    double lineala = c.getDouble(1);
                    double linealo = c.getDouble(2);
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
        Intent intent = new Intent(InfoTalleresRioGrande.this, MapaTalleresRioGrande.class);
        intent.putExtra(MapaTalleresRioGrande.EXTRA_NOMBRE,tnro);
        /*intent.putExtra(MapsActivity.EXTRA_LATITUD,lat);
        intent.putExtra(MapsActivity.EXTRA_LONGITUD,lon);*/
        startActivity(intent);
    }
}
