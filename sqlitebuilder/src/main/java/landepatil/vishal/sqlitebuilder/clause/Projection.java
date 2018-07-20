package landepatil.vishal.sqlitebuilder.clause;

import java.util.ArrayList;

/**
 * Created by Administrator on 26.08.2017.
 */

public class Projection
{
    ArrayList<String> list;
    public Projection()
    {
        list=new ArrayList<String>();
    }
   public Projection avg(String propertyName)
    {
        list.add("avg("+propertyName+")");
        return this;
    }
    public Projection count(String propertyName)
    {
        list.add("count("+propertyName+")");
        return this;
    }
    public Projection countDistinct(String propertyName)
    {
        list.add("count("+propertyName+")");
        return this;
    }
    public Projection max(String propertyName)
    {
        list.add("max("+propertyName+")");
        return this;
    }
    public Projection min(String propertyName)
    {
        list.add("min("+propertyName+")");
        return this;
    }
    public Projection rowCount(){
        list.add("count(*)");
        return this;
    }
    public Projection  sum(String propertyName)
    {
        list.add("sum("+propertyName+")");
        return this;
    }
    public Projection column(String propertyName)
    {
        list.add(propertyName);
        return this;
    }

    public Projection group_concat(String propertyName)
    {
        list.add("group_concat("+propertyName+")");
        return this;
    }
    public Projection group_concat(String propertyName, String separater)
    {
        list.add("group_concat("+propertyName+","+separater+")");
        return this;
    }
   public ArrayList<String> getList()
    {
        return list;
    }
}
