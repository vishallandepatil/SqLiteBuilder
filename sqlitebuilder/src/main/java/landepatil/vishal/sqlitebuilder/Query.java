package landepatil.vishal.sqlitebuilder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import landepatil.vishal.sqlitebuilder.clause.Group;
import landepatil.vishal.sqlitebuilder.clause.Order;
import landepatil.vishal.sqlitebuilder.clause.Projection;
import landepatil.vishal.sqlitebuilder.clause.Restriction;

import static android.database.Cursor.FIELD_TYPE_BLOB;
import static android.database.Cursor.FIELD_TYPE_FLOAT;
import static android.database.Cursor.FIELD_TYPE_INTEGER;
import static android.database.Cursor.FIELD_TYPE_NULL;
import static android.database.Cursor.FIELD_TYPE_STRING;

/**
 * Created by Administrator on 23.08.2017.
 */
public class Query {

    SQLiteDatabase db;

    private final ThreadLocal<Restriction> restriction = new ThreadLocal<>();
    private Order order;
    private Projection projection;
    private Group group;
    private LeftJoin join;

    public LeftJoin getJoin() {
        return join;
    }

    public Query setJoin(LeftJoin join) {
        this.join = join;
        return this;
    }

    public Group getGroupBy() {
        return group;
    }

    public Query setGroupBy(Group group) {
        this.group = group;
        return this;
    }

    private Query() {
    }

    public Restriction getRestriction() {
        return restriction.get();
    }

    public Query setRestriction(Restriction restriction) {
        this.restriction.set(restriction);
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public Query setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Projection getProjection() {
        return projection;
    }

    public Query setProjection(Projection projection) {
        this.projection = projection;
        return this;
    }

    public static Query createQuery(SQLiteOpenHelper db) {
        Query query = new Query();

        query.db = db.getWritableDatabase();
        return query;
    }

    private ArrayList<Object> createObject(Projection projection, Cursor cursor) {
        ArrayList<Object> listResult = new ArrayList<Object>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                try {
                    Result objTable = new Result();
                    ArrayList<String> listcolumn = projection.getList();
                    for (String column : listcolumn) {

                        String value = cursor.getString(cursor.getColumnIndex(column));
                        objTable.addValue(column, value);

                    }
                    listResult.add(objTable);
                    cursor.moveToNext();
                } catch (Exception e) {

                }
            }
        }
        return listResult;
    }

    private ArrayList<Object> createObject(List<Class> T, Class table, Cursor cursor) {
        ArrayList<Object> listResult = new ArrayList<Object>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                try {
                    Result objTable = new Result();
                    for (Class t : T) {
                        Field[] listcolumn = t.getDeclaredFields();
                        for (Field column : listcolumn) {

                            String value = cursor.getString(cursor.getColumnIndex(column.getName()));
                            objTable.addValue(column.getName(), value);
                        }
                    }
                    Field[] listcolumn = table.getDeclaredFields();
                    for (Field column : listcolumn) {

                        String value = cursor.getString(cursor.getColumnIndex(column.getName()));
                        objTable.addValue(column.getName(), value);
                    }
                    listResult.add(objTable);
                    cursor.moveToNext();
                } catch (Exception e) {

                }
            }
        }
        return listResult;
    }

    private ArrayList<Object> createObject(Class table, Cursor cursor) {
        ArrayList<Object> listTable = new ArrayList<Object>();


        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                try {
                    Object objTable = table.newInstance();
                    Field[] columns = table.getDeclaredFields();
                    for (Field column : columns) {
                        if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                            try {
                                Method method = table.getMethod("set" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH)), column.getType());
                                Class[] parameterTypes = method.getParameterTypes();
                                if (column.getType() == (int.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (Integer.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else  if (column.getType() == (short.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (Short.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (long.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else  if (column.getType() == (Long.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (float.class)) {
                                    method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                                } else  if (column.getType() == (Float.class)) {
                                    method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (double.class)) {
                                    method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (Double.class)) {
                                    method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                                } else  if (column.getType() == (boolean.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())) > 0);
                                } else  if (column.getType() == (Boolean.class)) {
                                    method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())) > 0);
                                } else if (column.getType() == (byte.class)) {
                                    method.invoke(objTable, cursor.getBlob(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (Byte.class)) {
                                    method.invoke(objTable, cursor.getBlob(cursor.getColumnIndex(column.getName())));
                                } else if (column.getType() == (char.class)) {
                                    method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));
                                } else  if (column.getType() == (String.class)) {
                                    method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));
                                }else {

                                    method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));

                                }
                            } catch (Exception e) {
                                // e.printStackTrace();
                            }
                        }
                    }
                    listTable.add(objTable);
                    cursor.moveToNext();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return listTable;
    }

    private Object createSingleObject(Class table, Cursor cursor) {


        if (cursor != null) {
            cursor.moveToFirst();
            try {
                Object objTable = table.newInstance();
                Field[] columns = table.getDeclaredFields();
                for (Field column : columns) {
                    if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                        try {
                            Method method = table.getMethod("set" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH)), column.getType());
                            Class[] parameterTypes = method.getParameterTypes();
                            if (column.getType() == (int.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (Integer.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else  if (column.getType() == (short.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (Short.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (long.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else  if (column.getType() == (Long.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (float.class)) {
                                method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                            } else  if (column.getType() == (Float.class)) {
                                method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (double.class)) {
                                method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (Double.class)) {
                                method.invoke(objTable, cursor.getFloat(cursor.getColumnIndex(column.getName())));
                            } else  if (column.getType() == (boolean.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())) > 0);
                            } else  if (column.getType() == (Boolean.class)) {
                                method.invoke(objTable, cursor.getInt(cursor.getColumnIndex(column.getName())) > 0);
                            } else if (column.getType() == (byte.class)) {
                                method.invoke(objTable, cursor.getBlob(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (Byte.class)) {
                                method.invoke(objTable, cursor.getBlob(cursor.getColumnIndex(column.getName())));
                            } else if (column.getType() == (char.class)) {
                                method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));
                            } else  if (column.getType() == (String.class)) {
                                method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));
                            }else {

                                method.invoke(objTable, cursor.getString(cursor.getColumnIndex(column.getName())));

                            }

                        } catch (NoSuchMethodException e) {
                            // e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return objTable;

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    private Object createSingleObject(Projection projection, Cursor cursor) {

        if (cursor != null) {
            cursor.moveToFirst();

            try {
                Result objTable = new Result();
                ArrayList<String> listcolumn = projection.getList();
                for (String column : listcolumn) {
                    String value = cursor.getString(cursor.getColumnIndex(column));
                    objTable.addValue(column, value);

                }
                return objTable;

            } catch (Exception e) {

            }

        }
        return null;
    }

    private Object createSingleObject(List<Class> T, Class table, Cursor cursor) {

        if (cursor != null) {
            cursor.moveToFirst();

            try {
                Result objTable = new Result();
                for (Class t : T) {
                    Field[] listcolumn = t.getDeclaredFields();
                    for (Field column : listcolumn) {

                        String value = cursor.getString(cursor.getColumnIndex(column.getName()));
                        objTable.addValue(column.getName(), value);
                    }
                }
                Field[] listcolumn = table.getDeclaredFields();
                for (Field column : listcolumn) {

                    String value = cursor.getString(cursor.getColumnIndex(column.getName()));
                    objTable.addValue(column.getName(), value);
                }
                return objTable;

            } catch (Exception e) {

            }

        }
        return null;
    }

    public Cursor loadCursor(Class table) {

        List<Object> listTable = new ArrayList<Object>();
        String projections = "*";
        String limit = "";
        String orderby = "";
        String groupby = "";
        if (projection != null) {
            List<String> list = projection.getList();
            int i = 0;
            for (String field : list) {
                if (i == 0) {
                    projections = field;
                } else {
                    projections = projections + "," + field;
                }
            }
        }
        String select = "SELECT " + projections + " FROM " + table.getSimpleName();
        if (join != null) {


            select = select + " " + join.getLeftjoin();

        }


        if (restriction.get() != null) {
            select = select + restriction.get().getWhere();
            if (restriction.get().getMaxResults() > 0) {
                limit = " LIMIT " + restriction.get().getMaxResults() + " OFFSET  " + restriction.get().getFirstResult();
            }
        }
        if (order != null) {
            if (!order.getAsc().equalsIgnoreCase("")) {
                orderby = " ORDER BY (" + order.getAsc() + ") ASC";
            }
            if (!order.getDesc().equalsIgnoreCase("")) {
                if (orderby.equalsIgnoreCase("")) {
                    orderby = " ORDER BY (" + order.getDesc() + ") DESC";
                } else {
                    orderby = orderby + " (" + order.getDesc() + ") DESC";
                }
            }

        }

        if (group != null) {
            groupby = " GROUP BY " + group.getGroup();
        }
        select = select + groupby + orderby + limit;

        // = DatabaseHandler.getInstance(context).getWritableDatabase();
        return db.rawQuery(select, null);
        //  return null;
    }

    public List<Object> load(Class table) {

        List<Object> listTable = new ArrayList<Object>();
        String projections = "*";
        String limit = "";
        String orderby = "";
        String groupby = "";
        if (projection != null) {
            List<String> list = projection.getList();

            for (String field : list) {
                if (projections.equalsIgnoreCase("*")) {
                    projections = field;
                } else {
                    projections = projections + "," + field;
                }
            }
        }
        String select = "SELECT " + projections + " FROM " + table.getSimpleName();
        if (join != null) {


            select = select + " " + join.getLeftjoin();

        }


        if (restriction.get() != null) {
            select = select + restriction.get().getWhere();
            if (restriction.get().getMaxResults() > 0) {
                limit = " LIMIT " + restriction.get().getMaxResults() + " OFFSET  " + restriction.get().getFirstResult();
            }
        }
        if (order != null) {
            if (!order.getAsc().equalsIgnoreCase("")) {
                orderby = " ORDER BY (" + order.getAsc() + ") ASC";
            }
            if (!order.getDesc().equalsIgnoreCase("")) {
                if (orderby.equalsIgnoreCase("")) {
                    orderby = " ORDER BY (" + order.getDesc() + ") DESC";
                } else {
                    orderby = orderby + " (" + order.getDesc() + ") DESC";
                }
            }

        }

        if (group != null) {
            groupby = " GROUP BY " + group.getGroup();
        }
        select = select + groupby + orderby + limit;

        // = DatabaseHandler.getInstance(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if (projection == null) {

            if (join == null) {
                return createObject(table, cursor);
            } else {
                return createObject(join.getT(), table, cursor);
            }
        } else {
            return createObject(projection, cursor);


        }
        //  return null;
    }

    public Object loadObject(Class table) {
        List<Object> listTable = new ArrayList<Object>();
        String projections = "*";
        String limit = "";
        String orderby = "";
        String groupby = "";
        if (projection != null) {
            List<String> list = projection.getList();

            for (String field : list) {
                if (projections.equalsIgnoreCase("*")) {
                    projections = field;
                } else {
                    projections = projections + "," + field;
                }
            }
        }
        String select = "SELECT " + projections + " FROM " + table.getSimpleName();
        if (join != null) {


            select = select + " " + join.getLeftjoin();

        }


        if (restriction.get() != null) {
            select = select + restriction.get().getWhere();
            if (restriction.get().getMaxResults() > 0) {
                limit = " LIMIT " + restriction.get().getMaxResults() + " OFFSET  " + restriction.get().getFirstResult();
            }
        }
        if (order != null) {
            if (!order.getAsc().equalsIgnoreCase("")) {
                orderby = " ORDER BY (" + order.getAsc() + ") ASC";
            }
            if (!order.getDesc().equalsIgnoreCase("")) {
                if (orderby.equalsIgnoreCase("")) {
                    orderby = " ORDER BY (" + order.getDesc() + ") DESC";
                } else {
                    orderby = orderby + " (" + order.getDesc() + ") DESC";
                }
            }

        }

        if (group != null) {
            groupby = " GROUP BY " + group.getGroup();
        }
        select = select + groupby + orderby + limit;

        // = DatabaseHandler.getInstance(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        if (projection == null) {

            if (join == null) {
                return createSingleObject(table, cursor);
            } else {
                return createSingleObject(join.getT(), table, cursor);
            }
        } else {
            return createSingleObject(projection, cursor);


        }
        //  return null;
    }

    public boolean insert(Object row) {

        String name = row.getClass().getSimpleName();
        Class table = row.getClass();
        ContentValues values = new ContentValues();
        Field[] columns = table.getDeclaredFields();
        for (Field column : columns) {
            try {
                if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                    String a = "get" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                    Method method = table.getMethod(a);
                    values.put(column.getName(), String.valueOf(method.invoke(row)));

                }
            } catch (Exception e) {
            }
        }
        long i = db.insert(name, null, values);
        return true;
    }

    public boolean insertList(ArrayList rows) {

        long i = 0;
        for (Object row : rows) {
            try {
                String name = row.getClass().getSimpleName();
                Class table = row.getClass();
                //= DatabaseHandler.getInstance(context).getWritableDatabase();
                ContentValues values = new ContentValues();
                Field[] columns = table.getDeclaredFields();
                for (Field column : columns) {
                    if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                        try {
                            String a = "get" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                            Method method = table.getMethod(a);
                            values.put(column.getName(), String.valueOf(method.invoke(row)));

                        } catch (Exception e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                }
                i += db.insert(name, null, values);

            } catch (Exception e) {

            }
        }

        return true;
    }

    public boolean delete(Class table, String where) {

        long i = db.delete(table.getSimpleName(), where, null);
        return true;
    }

    public long updateold(Object row, String where) {

        String name = row.getClass().getSimpleName();
        Class table = row.getClass();
        ContentValues values = new ContentValues();
        Field[] columns = table.getDeclaredFields();
        for (Field column : columns) {
            try {
                if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                    String a = "";
                    if (column.getType() == (boolean.class)) {
                        a = "is" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                        Method method = table.getMethod(a);

                        values.put(column.getName(), ((Boolean) method.invoke(row)) ? 1 : 0);

                    } else {
                        a = "get" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                        Method method = table.getMethod(a);
                        values.put(column.getName(), String.valueOf(method.invoke(row)));

                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long i = db.update(name, values, where, null);
        return i;
    }

    public long update(Object row, String where) {

        String name = row.getClass().getSimpleName();
        Class table = row.getClass();
        ContentValues values = new ContentValues();
        Field[] columns = table.getDeclaredFields();
        for (Field column : columns) {
            try {
                if (!java.lang.reflect.Modifier.isStatic(column.getModifiers())) {
                    String a = "";
                    if (column.getType() == (boolean.class)) {
                        a = "is" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                        Method method = table.getMethod(a);

                        if (((Boolean) method.invoke(row)) == null) {

                        } else {
                            values.put(column.getName(), ((Boolean) method.invoke(row)) ? 1 : 0);

                        }
                    } else {
                        a = "get" + column.getName().replaceFirst(column.getName().substring(0, 1), column.getName().substring(0, 1).toUpperCase(Locale.ENGLISH));
                        Method method = table.getMethod(a);
                        if ((method.invoke(row)) == null) {

                        } else {
                            values.put(column.getName(), String.valueOf(method.invoke(row)));

                        }
                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long i = db.update(name, values, where, null);
        return i;
    }

    private ArrayList<Object> createObject1(Cursor cursor) {
        ArrayList<Object> listResult = new ArrayList<Object>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                try {
                    Result objTable = new Result();
                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        int type = cursor.getType(i);
                        switch (type) {
                            case FIELD_TYPE_BLOB:
                                byte[] value = cursor.getBlob(i);

                                break;
                            case FIELD_TYPE_FLOAT:
                                break;
                            case FIELD_TYPE_INTEGER:
                                break;
                            case FIELD_TYPE_NULL:
                                break;
                            case FIELD_TYPE_STRING:
                                break;


                        }
                        String value = cursor.getString(i);
                        objTable.addValue(cursor.getColumnName(i), value);
                    }
                    listResult.add(objTable);
                    cursor.moveToNext();
                } catch (Exception e) {

                }
            }
        }
        return listResult;
    }

}
