package test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChanjetTest {
	public String name;//public修饰字段可以直接赋值
	private String age;
	public ChanjetTest() throws Exception {//构造函数可以抛出异常
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// TODO Auto-generated method stub
			System.out.println(11);
			HashMap map=new HashMap(5000);
			for (int i = 0; i < 100000; i++) {
				map.put("key"+i, "v"+i);
			}
			System.out.println(map.size());
			System.out.println(System.currentTimeMillis()-start);
			ConcurrentMap cMap=new ConcurrentHashMap();
//			cMap.put(null, null);
//			cMap.put(null, "yyy");
//			cMap.put("xxx", null);
			ThreadLocal<HashMap<String, Object>> tLocal=new ThreadLocal<HashMap<String,Object>>();
			tLocal.get().put("xxx", 1111);
			tLocal.get().get("xxx");
			
			System.out.println(cMap.toString());
			System.out.println(cMap.toString());
			System.out.println(cMap.toString());
			System.out.println(cMap.toString());
			System.out.println(cMap.toString());
	}

}
