package cl.pixel.parenas.prueba31.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pixel on 14-12-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="granpremio.db";
    private static final int DB_VERSION=1;

    public DatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTalleresrg="CREATE TABLE TALLERESRG(" +
                "NOMBRE TEXT, LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlTalleresrg);
        String sqlTallerespp="CREATE TABLE TALLERESPP(" +
                "NOMBRE TEXT, LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlTallerespp);
        String sqlEsrg="CREATE TABLE ESRG(" +
                "NOMBRE TEXT, LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlEsrg);
        String sqlEspp="CREATE TABLE ESTACIONPP(" +
                "NOMBRE TEXT, LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlEspp);
        String sqlHotelesrg="CREATE TABLE HOTELESRG(" +
                "NOMBRE TEXT, DIRECCION TEXT, TELEFONO TEXT," +
                " LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlHotelesrg);
        String sqlHotelespp="CREATE TABLE HOTELESPP(" +
                "NOMBRE TEXT, DIRECCION TEXT, TELEFONO TEXT," +
                " INDIVI TEXT, DOBLE TEXT, MATRIMONIAL TEXT," +
                " LATITUD TEXT, LONGITUD TEXT)";
        sqLiteDatabase.execSQL(sqlHotelespp);
        String sqltrg1="INSERT INTO TALLERESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Don Aldo','-53.78322206977153','-67.71864295005798')";
        sqLiteDatabase.execSQL(sqltrg1);
        String sqltrg2="INSERT INTO TALLERESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('La Casa del Bulon','-53.791626803353246','-67.69345164299011')";
        sqLiteDatabase.execSQL(sqltrg2);
        String sqltpp1="INSERT INTO TALLERESPP(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Callin','-53.29284862085492','-70.36265730857849')";
        sqLiteDatabase.execSQL(sqltpp1);
        String sqltpp2="INSERT INTO TALLERESPP(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Chomelo','-53.29247667127625','-70.36121964454651')";
        sqLiteDatabase.execSQL(sqltpp2);
        String sqlhotelpp1="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Barlovento','Villa Barlovento S/N','612581000','59000','70000','70000','-53.28999990000001','-70.38002670000003')";
        sqLiteDatabase.execSQL(sqlhotelpp1);
        String sqlhotelpp2="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Central','Bernardo Philippi 298','612581884','15000','25000','25000','-53.29613189734769','-70.36959886550903')";
        sqLiteDatabase.execSQL(sqlhotelpp2);
        String sqlhotelpp3="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('España','Croacia 698','612580160','20000','20000','30000','-53.2974913051401','-70.37275314331055')";
        sqLiteDatabase.execSQL(sqlhotelpp3);
        String sqlhotelpp4="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Los Canelos','Croacia 356','612581949','14000','28000','25000','-53.297170693993536','-70.36621928215027')";
        sqLiteDatabase.execSQL(sqlhotelpp4);
        String sqlhotelpp5="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Despertar De Job','Croacia 896','612580467','12000','20000','25000','-53.297722143675415','-70.37666916847229')";
        sqLiteDatabase.execSQL(sqlhotelpp5);
        String sqlhotelpp6="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('El Chispa','Señoret esquina Oscar Viel','612580054','70000','13000','15000','-53.297927332437204','-70.36351561546326')";
        sqLiteDatabase.execSQL(sqlhotelpp6);
        String sqlhotelpp7="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Kawi','Pedro Silva 144','612581570','18000','30000','24000','-53.29609342291266','-70.37508130073547')";
        sqLiteDatabase.execSQL(sqlhotelpp7);
        String sqlhotelpp8="INSERT INTO HOTELESPP(NOMBRE, DIRECCION, TELEFONO, INDIVI, DOBLE, MATRIMONIAL, LATITUD, LONGITUD) " +
                "VALUES('Yendegaia','Croacia 702','612581919','35000','55000','58000','-53.29763237328216','-70.3733217716217')";
        sqLiteDatabase.execSQL(sqlhotelpp8);
        String sqlhotelrg1="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Don Fiori','Sebastian Elcano 507','424681, 504757','-53.78257000000001','-67.69469730000003')";
        sqLiteDatabase.execSQL(sqlhotelrg1);
        String sqlhotelrg2="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Grande Hotel','Echelaine 251','436500','-53.7876391','-67.7324658')";
        sqLiteDatabase.execSQL(sqlhotelrg2);
        String sqlhotelrg3="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Status','Av. San Martin 268','435700','-53.7882719','-67.69722430000002')";
        sqLiteDatabase.execSQL(sqlhotelrg3);
        String sqlhotelrg4="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Villa','Av. San Martin 281','424998','-53.7880414','-67.69716740000001')";
        sqLiteDatabase.execSQL(sqlhotelrg4);
        String sqlhotelrg5="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('El Huemul','Echelain 607','434378','-53.7876355','-67.73747370000001')";
        sqLiteDatabase.execSQL(sqlhotelrg5);
        String sqlhotelrg6="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Gran Hotel Laserre','Laserre 566','504805, 433623','-53.7848236','-67.6978464')";
        sqLiteDatabase.execSQL(sqlhotelrg6);
        String sqlhotelrg7="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Atlantida','Av. Belgano 582','431915','-53.7848294','-67.70015890000002')";
        sqLiteDatabase.execSQL(sqlhotelrg7);
        String sqlhotelrg8="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Antaes','Echeverria 49','420722','-53.7842083','-67.6929361')";
        sqLiteDatabase.execSQL(sqlhotelrg8);
        String sqlhotelrg9="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Yawar','Viedma 230','421880','-53.7731216','-67.709697')";
        sqLiteDatabase.execSQL(sqlhotelrg9);
        String sqlhotelrg10="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Noal','Rafael Obligado 557','427516','-53.78978370000001','-67.70618200000001')";
        sqLiteDatabase.execSQL(sqlhotelrg10);
        String sqlhotelrg11="INSERT INTO HOTELESRG(NOMBRE,DIRECCION,TELEFONO,LATITUD,LONGITUD) " +
                "VALUES('Vientos del Sur','Av. San Martin 64','420969','-53.7898588','-67.69413129999998')";
        sqLiteDatabase.execSQL(sqlhotelrg11);
        String sqlespp1="INSERT INTO ESTACIONPP(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Copec','-53.30019716734401','-70.36542534828186')";
        sqLiteDatabase.execSQL(sqlespp1);
        String sqlesrg1="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('YPF','-53.7808667','-67.71532709999997')";
        sqLiteDatabase.execSQL(sqlesrg1);
        String sqlesrg2="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Rivadavia','-53.7878384','-67.69840690000001')";
        sqLiteDatabase.execSQL(sqlesrg2);
        String sqlesrg3="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Elcano','-53.7790444','-67.6980848')";
        sqLiteDatabase.execSQL(sqlesrg3);
        String sqlesrg4="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Oasis SRL','-53.7737816','-67.7245843')";
        sqLiteDatabase.execSQL(sqlesrg4);
        String sqlesrg5="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('Axon','-53.7737816','-67.7245843')";
        sqLiteDatabase.execSQL(sqlesrg5);
        String sqlesrg6="INSERT INTO ESRG(NOMBRE, LATITUD, LONGITUD) " +
                "VALUES('AutoSur Circunvlacion','-53.80957154683726','-67.78028011322021')";
        sqLiteDatabase.execSQL(sqlesrg6);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TALLERESPP");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOTELESPP");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ESTACIONPP");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TALLERESRG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOTELESRG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ESRG");
    }
}
