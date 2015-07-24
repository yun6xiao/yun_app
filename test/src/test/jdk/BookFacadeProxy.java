package test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDK的动态代理依靠接口实现，如果有些类并没有实现接口，则不能使用JDK代理，这就要使用cglib动态代理了。 
 * @author admin
 *
 */
public class BookFacadeProxy implements InvocationHandler {

	 private Object target;  
	    /** 
	     * 绑定委托对象并返回一个代理类 
	     * @param target 
	     * @return 
	     */  
	    public Object bind(Object target) {  
	        this.target = target;  
	        //取得代理对象  
	        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),  
	                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，lcglib弥补了这一缺陷)  
	        System.out.println(proxyInstance);
	        return proxyInstance;
	    }  
	  
	    /** 
	     * 调用方法 
	     */  
	    @Override  
	    public Object invoke(Object proxy, Method method, Object[] args)  
	            throws Throwable {  
	        Object result=null;  
//	        System.out.println(proxy);
	        System.out.println("事物开始");  
	        //执行方法  
	        result=method.invoke(target, args);  
	        System.out.println("事物结束");  
	        return result;  
	    }  

}
