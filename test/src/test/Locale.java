package test;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class Locale implements Cloneable, Serializable {
  
	// cache to store singleton Locales
    private final static ConcurrentHashMap<String, Locale> cache = new ConcurrentHashMap<String, Locale>(32);
    public Locale(String language, String country, String variant) {
		// TODO Auto-generated constructor stub
	}
	static Locale getInstance(String language, String country, String variant) {
        if (language== null || country == null || variant == null) {
            throw new NullPointerException();
        }

	StringBuilder sb = new StringBuilder();
	sb.append(language).append('_').append(country).append('_').append(variant);
	String key = sb.toString();
	Locale locale = cache.get(key);
	if (locale == null) {
	    locale = new Locale(language, country, variant);
	    Locale l = cache.putIfAbsent(key, locale);
	    if (l != null) {
		locale = l;
	    }
	}
	return locale;
    }
	// ....
	public static void main(String[] args) {
		System.out.println("xx+++");
	}
}