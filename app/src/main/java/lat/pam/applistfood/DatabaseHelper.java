package lat.pam.applistfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends  SQLiteOpenHelper{

    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "FoodAppDB";

    // table name
    private static final String TABLE_MENU = "menus";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_TITTLE = "judul";
    private static final String KEY_DESCRIPTION = "deskripsi";
    private static final String KEY_PRICE = "harga";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_MENUS_TABLE = "CREATE TABLE " + TABLE_MENU + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITTLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_PRICE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_MENUS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        onCreate(sqLiteDatabase);
    }

    public void tambahData(Food menu){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITTLE, menu.judul);
        values.put(KEY_DESCRIPTION, menu.deskripsi);
        values.put(KEY_PRICE, menu.harga);

        sqLiteDatabase.insert(TABLE_MENU, null, values);
        sqLiteDatabase.close();
    }

    // get All Record
    public List<Food> getFoodData(Context context) {
        List<Food> contactList = new ArrayList<Food>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MENU + " LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        ArrayList<Integer> gambar = FoodData.getGambar();

        int index = 0;
        if (cursor.moveToFirst()) {
            do {
                if(index%5==0) {
                    index = 0;
                }
                String judul = cursor.getString(1);
                String deskripsi = cursor.getString(2);
                String harga = cursor.getString(3);

                Food menu = new Food(judul, deskripsi, harga, context.getDrawable(gambar.get(index)));

                contactList.add(menu);
                index++;
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }
}
