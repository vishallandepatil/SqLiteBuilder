package landepatil.vishal.sqlitebuilder.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 23.08.2017.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull{
    String value() default "NOT NULL";
}