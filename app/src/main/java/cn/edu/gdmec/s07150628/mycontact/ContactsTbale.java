package cn.edu.gdmec.s07150628.mycontact;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/23 0023.
 */
public class ContactsTbale {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTbale(Context context) {
        db = new MyDB(context);
        if (!db.isTableExit(TABLENAME)) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS" + TABLENAME + "(id_DB integer)" + "primary key AUTOINCREMENU"
                    + User.NAME + "VARCHAR," +
                    User.MOBILE + "VARCHAR," +
                    User.QQ + "VARCHAR," +
                    User.DANWEI + "VARCHAR," +
                    User.ADDRESSE + "VARCHAR)";
            db.createTable(createTableSql);
        }
    }
    public boolean addData(User user) {
       ContentValues values=new ContentValues();
        values.put(User.NAME,user.getNAME());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESSE,user.getAddress());

        return db.save(TABLENAME,values);
    }



    }


