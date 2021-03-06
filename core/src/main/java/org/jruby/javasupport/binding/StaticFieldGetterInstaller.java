package org.jruby.javasupport.binding;

import org.jruby.RubyModule;
import org.jruby.java.invokers.StaticFieldGetter;

import java.lang.reflect.Field;

/**
* Created by headius on 2/26/15.
*/
public class StaticFieldGetterInstaller extends FieldInstaller {
    final boolean warnConstant;

    public StaticFieldGetterInstaller(String name, Field field, boolean warnConstant) {
        super(name, STATIC_FIELD, field);

        this.warnConstant = warnConstant;
    }

    @Override void install(final RubyModule proxy) {
        if (isAccessible()) {
            proxy.getSingletonClass().addMethod(name, new StaticFieldGetter(name, proxy, field, warnConstant));
        }
    }
}
