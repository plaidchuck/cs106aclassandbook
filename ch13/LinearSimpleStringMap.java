/* Simplified map class */
public class LinearSimpleStringMap {
	
/* Creates new SimpleStringMap with no key/value pairs */
	public LinearSimpleStringMap() {
		bucketArray = new HashEntry[N_BUCKETS];
	}
	
/**
 * Sets value associated with key. Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = new HashEntry(key, value);
		if (bucketArray[bucket] == null) {
			bucketArray[bucket] = entry;
			} 
		else if  (probe(bucket) == -1) {
			System.out.println("Array is full");
		} else {
			bucketArray[probe(bucket)] = entry;
			}
	}
	
	
/**
 * Retrieves value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @param value The value associated with key, or null otherwise
 */
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = bucketArray[bucket];
		if (entry != null && entry.getKey().equals(key)) {
			return entry.getValue();
		}
		int originalBucket = bucket;
		bucket++;
		while (originalBucket != bucket) {
			entry = bucketArray[bucket];
			if (entry != null && entry.getKey().equals(key)) {
				return entry.getValue();
			}
			bucket = (bucket + 1) % N_BUCKETS;
		}
		return null;
	}

/*
 * Helper method when the original hashed bucket is filled so that the array is probed
 *  to find the next available bucket for the entry to be hashed into. If the end of the array is
 *  reached, the probe wraps around to the beginning of the array to search for any available buckets
 *  remaining.
 */
	private int probe(int bucket) {
		int originalBucket = bucket;
		while (true) {
			if (bucket == (N_BUCKETS - 1)) {
				bucket = bucket % (N_BUCKETS - 1);
			} else {
				bucket++;
			}
			if (bucketArray[bucket] == null) {
				return bucket;
			}
			else if (bucket % N_BUCKETS == originalBucket) {
				break;
			}
		}
		return -1;
	}
	
/* Private constants*/
	private static final int N_BUCKETS = 10;
	
/* Private instance*/
	private HashEntry[] bucketArray;

}
	
/* Represents a pair of key and value, along with reference to the next HashEntry in chain. 
 * Only consists of getters and setters.
 */
class HashEntry {

/* Creates new HashEntry for the specified key/value pair */
	public HashEntry(String key, String value) {
		entryKey = key;
		entryValue = value;
	}

/* Returns the key component of HashEntry */
	public String getKey() {
		return entryKey;
	}

/* Returns the value component of HashEntry */
	public String getValue() {
		return entryValue;
}

/* Sets value component of HashEntry to a new value */
	public void setValue(String value) {
		entryValue = value;
	}
	

/* Private instance */
	private String entryKey; //Key component for current HashEntry
	private String entryValue; // Value component for current HashEntry

}