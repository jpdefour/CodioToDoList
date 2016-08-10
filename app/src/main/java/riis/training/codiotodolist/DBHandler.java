package riis.training.codiotodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import riis.training.codiotodolist.Model.Item;

/**
 * Created by John on 8/8/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "todoItemsDB.db";
    private static final String TABLE_ITEMS = "items";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEMS_TABLE = "CREATE TABLE " +
                TABLE_ITEMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT," + COLUMN_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    public void addItem(Item item) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.getName());
        values.put(COLUMN_DESCRIPTION, item.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();

        long value = db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public List<Item> findItems() {
        String query = "SELECT * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getWritableDatabase();

        List<Item> items = new ArrayList<>();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {

            while (!cursor.isAfterLast()) {
                //item parameters to add to Item object
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setDescription(description);

                items.add(item);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return items;
    }

    public boolean deleteProduct(int id) {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE "
                + COLUMN_ID + " = \""  + id + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Item item = new Item();

        if (cursor.moveToFirst()) {
            item.setId(id);
            db.delete(TABLE_ITEMS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(item.getId())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
