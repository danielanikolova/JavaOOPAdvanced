package Tests.fake;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Disposable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Burnable {
}
