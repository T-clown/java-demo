package patterns.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before run...");
        System.out.println("superName " + methodProxy.getSuperName());
        methodProxy.invokeSuper(o, objects);
        System.out.println("after run...");
        return null;
    }
}