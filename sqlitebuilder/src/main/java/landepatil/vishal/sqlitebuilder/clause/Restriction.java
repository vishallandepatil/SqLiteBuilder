package landepatil.vishal.sqlitebuilder.clause;


/**
 * Created by Administrator on 26.08.2017.
 */

public class Restriction {
    int firstResult = 0;
    int MaxResults = 0;
    public String where = "";

    public int getFirstResult() {
        return firstResult;
    }

    public Restriction setFirstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public int getMaxResults() {
        return MaxResults;
    }

    public Restriction setMaxResults(int maxResults) {
        MaxResults = maxResults;
        return this;

    }

    public String getWhere() {
        return where;
    }

    public Restriction addEquals(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "='" + value + "'";
        } else {
            where = where + " AND " + property + "='" + value + "'";
        }
        return this;
    }

    public Restriction addEquals(String property, boolean value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "=" + (value ? 1 : 0) + "";

        } else {
            where = where + " AND " + property + "=" + (value ? 1 : 0) + "";
        }
        return this;
    }

    public Restriction addEqualsOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "='" + value + "'";

        } else {
            where = where + " OR " + property + "='" + value + "'";
        }
        return this;
    }

    public Restriction addEquals(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "=" + value + "";
        } else {
            where = where + " AND " + property + "=" + value + "";
        }
        return this;
    }

    public Restriction addEqualsOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "=" + value + "";
        } else {
            where = where + " OR " + property + "=" + value + "";
        }
        return this;
    }

    public Restriction addNotEquals(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "!='" + value + "'";
        } else {
            where = where + " AND " + property + "!='" + value + "'";
        }
        return this;
    }

    public Restriction addNotEqualsOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "!='" + value + "'";

        } else {
            where = where + " OR " + property + "!='" + value + "'";
        }
        return this;
    }

    public Restriction addNotEquals(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "!=" + value + "";
        } else {
            where = where + " AND " + property + "!=" + value + "";
        }
        return this;
    }

    public Restriction addNotEqualsOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "!=" + value + "";
        } else {
            where = where + " OR " + property + "!=" + value + "";
        }
        return this;
    }

    public Restriction addGT(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">" + value + "";

        } else {
            where = where + " AND " + property + ">" + value + "";
        }
        return this;
    }

    public Restriction addGTE(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">" + value + "";
        } else {
            where = where + " AND " + property + ">" + value + "";
        }
        return this;
    }

    public Restriction addLTE(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "<" + value + "";
        } else {
            where = where + " AND " + property + "<" + value + "";
        }
        return this;
    }

    public Restriction addGTOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">" + value + "";

        } else {
            where = where + " OR " + property + ">" + value + "";
        }
        return this;
    }

    public Restriction addLT(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "<" + value + "";

        } else {
            where = where + " AND " + property + "<" + value + "";
        }
        return this;
    }

    public Restriction addLTOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">" + value + "";

        } else {
            where = where + " OR " + property + ">" + value + "";
        }
        return this;
    }

    public Restriction addGTE(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">=" + value + "";

        } else {
            where = where + " AND " + property + ">=" + value + "";
        }
        return this;
    }

    public Restriction addGTEOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + ">=" + value + "";

        } else {
            where = where + " OR " + property + ">=" + value + "";
        }
        return this;
    }

    public Restriction addLTE(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "<=" + value + "";

        } else {
            where = where + " AND " + property + "<=" + value + "";
        }
        return this;
    }

    public Restriction addLTEOr(String property, int value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + "<=" + value + "";

        } else {
            where = where + " OR " + property + "<=" + value + "";
        }
        return this;
    }

    public Restriction addLike(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " LIKE '" + value + "'";

        } else {
            where = where + " AND " + property + " LIKE '" + value + "'";
        }
        return this;

    }

    public Restriction addLikeOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " LIKE '" + value + "'";

        } else {
            where = where + " OR " + property + " LIKE '" + value + "'";
        }
        return this;
    }

    public Restriction addNotLike(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " NOT LIKE '" + value + "'";

        } else {
            where = where + " AND " + property + "  NOT LIKE '" + value + "'";
        }
        return this;

    }

    public Restriction addNotLikeOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " NOT LIKE '" + value + "'";

        } else {
            where = where + " OR " + property + "  NOT LIKE '" + value + "'";
        }
        return this;
    }

    public Restriction addIN(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " IN(" + value + ")";

        } else {
            where = where + " AND " + property + " IN(" + value + ")";
        }

        return this;
    }

    public Restriction addINOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " IN(" + value + ")";

        } else {
            where = where + " OR " + property + " IN(" + value + ")";
        }

        return this;
    }

    public Restriction addNotIN(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " NOT IN(" + value + ")";

        } else {
            where = where + " AND " + property + " NOT IN(" + value + ")";
        }

        return this;
    }

    public Restriction addNotINOr(String property, String value) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " NOT IN(" + value + ")";

        } else {
            where = where + " OR " + property + " NOT IN(" + value + ")";
        }

        return this;
    }

    public Restriction addBwtweenOr(String property, String start, String end) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " (BETWEEN " + start + " AND " + end + ")";

        } else {
            where = where + " OR " + property + " (BETWEEN " + start + " AND " + end + ")";
        }

        return this;
    }

    public Restriction addBwtween(String property, String start, String end) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " BETWEEN " + start + " AND " + end + "";

        } else {
            where = where + " AND " + property + " BETWEEN " + start + " AND " + end + "";
        }

        return this;
    }

    public Restriction addNotBwtweenOr(String property, String start, String end) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " (NOT BETWEEN " + start + " AND " + end + ")";

        } else {
            where = where + " OR " + property + " (NOT BETWEEN " + start + " AND " + end + ")";
        }

        return this;
    }

    public Restriction addNotBwtween(String property, String start, String end) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " (NOT BETWEEN " + start + " AND " + end + ")";

        } else {
            where = where + " AND " + property + " (NOT BETWEEN " + start + " AND " + end + ")";
        }

        return this;
    }

    public Restriction addIsNull(String property) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + " " + property + " IS NULL";
        } else {
            where = where + " AND " + property + " IS NULL";
        }

        return this;

    }

    public Restriction addIsNotNull(String property) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + property + " IS NOT NULL";
        } else {
            where = where + " AND " + property + " IS NOT NULL";
        }

        return this;

    }

    public Restriction addIsEmpty(String property) {
        if (where.equalsIgnoreCase("")) {
            where = " WHERE " + " " + property + " IS NOT NULL";
        } else {
            where = where + " AND " + property + " IS NOT NULL";
        }

        return this;

    }

    public Restriction clear() {
        firstResult = 0;
        MaxResults = 0;
        where = "";
        return this;
    }

}
