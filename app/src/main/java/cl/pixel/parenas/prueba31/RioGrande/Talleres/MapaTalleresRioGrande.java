package cl.pixel.parenas.prueba31.RioGrande.Talleres;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.pixel.parenas.prueba31.R;
import cl.pixel.parenas.prueba31.basededatos.DatabaseHelper;

public class MapaTalleresRioGrande extends FragmentActivity implements OnMapReadyCallback {

    public static final String EXTRA_NOMBRE="Nombre";

    private GoogleMap mMap;

    String nombre;
    double lat;
    double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int tallernro=(Integer)getIntent().getExtras().get(EXTRA_NOMBRE);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (db != null){
            Cursor c = db.rawQuery("select * from TALLERESRG",null);
            c.move(tallernro);
            if (tallernro == 0){
                c.moveToFirst();
                String linean = c.getString(0);
                double lineala = c.getDouble(1);
                double linealo = c.getDouble(2);
                nombre = linean;
                lat = lineala;
                lon = linealo;
            }else{
                if (c.move(tallernro)){
                    String linean = c.getString(0);
                    double lineala = c.getDouble(1);
                    double linealo = c.getDouble(2);
                    nombre = linean;
                    lat = lineala;
                    lon = linealo;
                }
            }
        }
        db.close();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ubicacion = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title(nombre));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));
    }
}
