package pattern.proxy.dynamics;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Oliver Wang
 * @description 动态代理执行handler
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/24
 * @since
 */
@AllArgsConstructor
@Setter
public class BankClerkHandler implements InvocationHandler {
    /**
     * 实际被代理的对象
     */
    private Object object;

    /**
     * 直接生成代理对象
     *
     * @return
     */
    public static Object proxyFactory(Object object){
        Class<?> objectClass = object.getClass();
        return Proxy.newProxyInstance(objectClass.getClassLoader(),
                objectClass.getInterfaces(),new BankClerkHandler(object));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Console.log("BankClerkHandler 权鉴成功并完成流水落库，开始执行{} ...",method.getName());
        if (args != null){
            Console.log("invoke方法参数 {}",args);
        }
        try {
            Console.log("proxy class:{}",proxy.getClass());
            // 调用被代理对象的方法完成实际业务
            return method.invoke(object,args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
