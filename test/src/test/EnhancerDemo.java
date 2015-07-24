package test;
import java.lang.reflect.Method;  
import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  

public class EnhancerDemo {  
    public static void main(String[] args) {  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(EnhancerDemo.class);  
        enhancer.setCallback(new MethodInterceptorImpl());  
           
        EnhancerDemo demo = (EnhancerDemo) enhancer.create();  
        demo.add("呵呵",22);           
        System.out.println(demo);  
    }  
       
    public void test() {  
        System.out.println("EnhancerDemo test()");  
    }  
    public void add(String name,int age) {  
    	System.out.println("EnhancerDemo add()"+name+"-"+age);  
    }  

   
    private static class MethodInterceptorImpl implements MethodInterceptor {  
        @Override 
        public Object intercept(Object obj, Method method, Object[] args,  
                MethodProxy proxy) throws Throwable {  
            System.err.println("Before invoke " + method);  
            Object result = proxy.invokeSuper(obj, args);  
            System.err.println("After invoke" + method);  
            return result;  
        }            
    }  

} 