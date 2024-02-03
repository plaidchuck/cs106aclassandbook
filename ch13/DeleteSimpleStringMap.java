/* Simplified map class */
public class DeleteSimpleStringMap {
	
/* Creates new SimpleStringMap with no key/value pairs */
	public DeleteSimpleStringMap() {
		bucketArray = new HashEntry[N_BUCKETS];
	}
	
/**
 * Sets value associated with key. Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			entry = new HashEntry(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
		} else {
			entry.setValue(value);
		}
	}
	
/**
 * Retrieves value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @param value The value associated with key, or null otherwise
 */
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			return null;
		} else {
			return entry.getValue();
		}
	}

/**
 * If it exists, removes the entry containing the specified key and value associated 
 * with that key from the map
 * @param key
 */
	public void delete(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		HashEntry previousEntry = getPreviousEntry(bucketArray[bucket], key);
		System.out.println(previousEntry.getKey());
		if (entry != null) {
			if (entry.equals(bucketArray[bucket]) && entry.getLink() == null) {
				bucketArray[bucket] = null;
			}
			else if (entry.equals(bucketArray[bucket]) && entry.getLink() != null) {
				bucketArray[bucket] = entry.getLink();
			}
			else if (!entry.equals(bucketArray[bucket]) &&  entry.getLink() != null) {
				previousEntry.setLink(entry.getLink());
			}
			else previousEntry.setLink(null);
		}
	}
	
/*
 * Scans the entry chain looking for an entry that matches the specified key.
 * If no such entry exists, findEntry returns null.
 */
	private HashEntry findEntry(HashEntry entry, String key) {
		while (entry != null) {
			if (entry.getKey().equals(key)) return entry;
			entry = entry.getLink();
		}
		return null;
	}
	
/*
 * Scans the entry chain looking for an entry that matches the specified key.
 * Returns the previous entry in the chain. Returns null if the entry does not exist.
 */
	private HashEntry getPreviousEntry(HashEntry entry, String key) {
		HashEntry previousEntry = entry;
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				return previousEntry;
			} else {
				previousEntry = entry;
				entry = entry.getLink();
			}
		}
		return null;
	}
	
/* Private constants*/
	private static final int N_BUCKETS = 1;
	
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
	
/* Returns the next link in the entry chain*/
	public HashEntry getLink() {
		return entryLink;
	}

/* Sets the link to the next entry in the chain */
	public void setLink (HashEntry nextEntry) {
		entryLink = nextEntry;
	}

/* Private instance */
	private String entryKey; //Key component for current HashEntry
	private String entryValue; // Value component for current HashEntry
	private HashEntry entryLink; // Reference to the next entry in the chain

}
