package landepatil.vishal.sqlitebuilder.clause;

/**
 * Created by Administrator on 30.08.2017.
 */

public class Group {
    public String getGroup() {
        return group;
    }

    public Group setGroup(String group) {

        if(this.group.equalsIgnoreCase("")) {
            this.group = group;
        }
        else
        {
            this.group =this.group+","+ group;
        }
        return this;
    }

   private String group="";

}
