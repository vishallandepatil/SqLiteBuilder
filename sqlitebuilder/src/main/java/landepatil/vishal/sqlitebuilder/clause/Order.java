package landepatil.vishal.sqlitebuilder.clause;

/**
 * Created by Administrator on 26.08.2017.
 */

public class Order {

    public String getDesc() {
        return desc;
    }

    public Order setDesc(String desc) {

        if(this.desc.equalsIgnoreCase("")) {
            this.desc = desc;
        }
        else
        {
            this.desc =this.desc+","+ desc;
        }
        return this;
    }

    public String getAsc() {
        return asc;
    }

    public Order setAsc(String asc) {
         if(this.asc.equalsIgnoreCase("")) {
            this.asc = asc;
        }
        else
        {
            this.asc =this.asc+","+ asc;
        }
        return this;
    }

    String desc="";
    String asc="";

    public void clear()
    {
         desc="";
         asc="";
    }


}
