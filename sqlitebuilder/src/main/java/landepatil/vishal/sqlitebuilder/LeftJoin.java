package landepatil.vishal.sqlitebuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 08.09.2017.
 */

public class LeftJoin {
    public String getLeftjoin() {
        return leftjoin;
    }


    String leftjoin;

    public List<Class> getT() {
        return T;
    }

    List<Class> T;
    //v=m

    private LeftJoin()
    {

    }
    public LeftJoin(Class T, String on)
    {
        this.T=new ArrayList<Class>();
        this.T.add(T);
        leftjoin=" LEFT JOIN "+T.getSimpleName()+" ON("+on+") ";


    }

    LeftJoin  addLeftjoinTable(Class T, String on)
    {
        this.T.add(T);
        leftjoin=leftjoin+ " LEFT JOIN "+T.getSimpleName()+" ON("+on+") ";
        return this;
    }
}
