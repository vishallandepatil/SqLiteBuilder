package com.landepatil.vishal.sqlitebuilder;

import java.util.HashMap;

/**
 * Created by Administrator on 30.08.2017.
 */

public class Result
{
    private HashMap<String, String> values;

    public Result()
    {
        this.values = new HashMap<String, String>();
    }
    public void addValue(String name, String value)
    {
        values.put(name, value);
    }

    public String getValue(String name)
    {
        return values.get(name);
    }


}
