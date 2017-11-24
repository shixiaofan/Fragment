package comr.example.administrator.fragmentdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import comr.example.administrator.fragmentdemo.R;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
public class SqliteDb extends SQLiteOpenHelper {
    public SqliteDb(Context context) {
        super(context, "shop", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table shop (_id integer primary key autoincrement ,name vachar(20),price integer,imageid integer,content vachar(100))");
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"火箭A",100, R.drawable.t2,"这是一款可以让你们上天的神器"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"坦克A",200, R.drawable.t2,"这是一个坦克"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"航母A",300,R.drawable.t2,"这是一个航母"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"飞船A",400,R.drawable.t2,"这是一个飞船"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"战舰A",500,R.drawable.t2,"这是一款战舰"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"飞碟A",600,R.drawable.t2,"这是一个飞碟"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"范冰冰Q",700,R.drawable.t2,"我是范冰冰"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"邓超Q",8000,R.drawable.t2,"我是邓超"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"王宝强Q",900,R.drawable.t2,"我是王宝强"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"黄渤Q",1000,R.drawable.t2,"我是黄渤"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"古天乐Q",2000,R.drawable.t2,"我是古天乐"});
        db.execSQL("insert into shop (name,price,imageId,content) values(?,?,?,?)",new Object[]{"李若彤Q",3000,R.drawable.t2,"我是李若彤"});

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
