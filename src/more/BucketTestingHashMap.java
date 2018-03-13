package more;

import java.util.HashMap;
import java.util.Map;

public class BucketTestingHashMap {

	static public class Value {
		int hash;
		boolean eq;
		Value(int hash, boolean eq) { this.hash = hash; this.eq = eq; }
		int hashcode() { return hash; }
		boolean equals() { return eq; }
	}
	
	public static void main(String[] args) {
		//Same hash different values
		int[] hashes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Map<Value, Value> map = new HashMap<>(4);
		for(int h : hashes) {
			Value v = new Value(h, true);
			map.put(v, v);
		}
	}
	
}
