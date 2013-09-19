package nupterp.comparator;

import java.util.Comparator;
import java.util.Hashtable;

public class NameComparator<T> implements Comparator<T> {
	public int compare(T a, T b) {
		Hashtable<?, ?> hashA = (Hashtable<?, ?>) a;
		Hashtable<?, ?> hashB = (Hashtable<?, ?>) b;
		if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
			return -1;
		} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
			return 1;
		} else {
			return ((String) hashA.get("filename")).compareTo((String) hashB
					.get("filename"));
		}
	}
}
