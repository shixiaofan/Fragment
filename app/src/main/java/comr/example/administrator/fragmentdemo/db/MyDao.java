package comr.example.administrator.fragmentdemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import comr.example.administrator.fragmentdemo.bean.Goods;

/**
 * Created by Administrator on 2017/11/24 0024.
 */

public class MyDao {
    private SqliteDb sqliteDb;
    public MyDao(Context context){
        sqliteDb=new SqliteDb(context);
    }
    ArrayList<Goods> al_goods=new ArrayList<>();
    public ArrayList<Goods> queryList(String select,int order){
        SQLiteDatabase db=sqliteDb.getWritableDatabase();
        al_goods.clear();
        Cursor cursor;
        if(order==0){
            cursor =db.query("shop", null, "name like '%" + select + "%' ", null, null, null, "price ");
        }else if(order==1){
            cursor = db.query("shop", null, "name like '%"+select+"%' ", null, null, null, "price desc ");//降序
        }else {
            //查询全部商品
            cursor = db.query("shop",null,null,null,null,null,null);

        }
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            int imageId = cursor.getInt(3);
            String content = cursor.getString(4);
            al_goods.add(new Goods(id,name,price,imageId,content));
        }
        db.close();
        return al_goods;
    }
}
