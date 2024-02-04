/* Simplified map class */
public class NewSimpleStringMap {
	
private static final int N_BUCKETS = 10;
	
/* Creates new SimpleStringMap with no key/value pairs and parallel empty arrays */
	public NewSimpleStringMap() {
		keysBucket = new String[N_BUCKETS];
		valuesBucket = new String[N_BUCKETS];
		bucketCount = 0;
	}
	
/*
 * Produces a parallel array where one element contains a 
 * a unique state abbreviation and the parallel one contains a state name. If the key
 * matches a key already stored in the array, then the key is kept but the value
 * is replaced by the new value.
 */
	/**
 * Sets value associated with key. Any previous value for key is lost.
 * @param key The key used to refer to this value
 * @param value The new value to be associated with key
 */
	public void put(String key, String value) {
		if (bucketCount >= keysBucket.length) {
			doubleArrayCapacity();
		}
		int keyElement = 0;
		for (int i = 0; i < keysBucket.length; i++) {
			if (key.equals(keysBucket[i])) {
				keyElement = i;
				break;
			}
			keyElement = -1;
		}
		if (keyElement == -1) {
			keysBucket[bucketCount] = key;
			valuesBucket[bucketCount] = value;
			sortArrays();
			bucketCount++;
		} else {
			valuesBucket[keyElement] = value;
		}
	}
	
/*
 * Consumes a key and searches the keyBucket array for an element containing
 * the key. If found the value contained in the parallel element is returned.
 * If not, null is returned.
 */
/**
 * Retrieves value associated with key, or null if no such value exists.
 * @param key The key used to look up the value
 * @param value The value associated with key, or null otherwise
 */
	public String get(String key) {
		for (int i = 0; i < bucketCount; i++) {
			if (key.equals(keysBucket[i])) {
				return valuesBucket[i];
			} 
		}
		return null;
	
		}

/**
 * Retrieves and returns a String containing all keys currently stored in the map.
 */
	public String listKeys() {
		String keyList = "";
		for (int i = 0; i < keysBucket.length; i++) {
			if (keysBucket[i] != null) {
				keyList += keysBucket[i] + " ";
			}
		}
		return keyList;
	}
	
/**
 * Retrieves and returns a String containing all vaules currently stored in the map
 */
	
	public String listValues() {
		String valuesList = "";
		for (int i = 0; i < valuesBucket.length; i++) {
			if (valuesBucket[i] != null) {
				valuesList += valuesBucket[i] + " ";
			}
		}
		return valuesList;
	}
/*
 * Consumes the keysBucket and valuesBucket and produces arrays that are
 * sorted alphabetically by the key values after a value is added via the put method.
 */
	private void sortArrays() {
		int sortCount = bucketCount;
		String tempKey;
		String tempValue;
		while (sortCount > 0) {
			if (keysBucket[sortCount].compareTo(keysBucket[sortCount - 1]) < 0) {
				tempKey = keysBucket[sortCount - 1];
				tempValue = valuesBucket[sortCount - 1];
				keysBucket[sortCount - 1] = keysBucket[sortCount];
				valuesBucket[sortCount - 1] = valuesBucket[sortCount];
				keysBucket[sortCount] = tempKey;
				valuesBucket[sortCount] = tempValue;
				sortCount--;
			} else {
				sortCount--;
			}
		}
	}
	

	
	private void doubleArrayCapacity() {
		String[]  oldKeysBucket = new String[keysBucket.length];
		String[] oldValuesBucket = new String[valuesBucket.length];
		for (int i = 0; i < keysBucket.length; i++) {
			oldKeysBucket[i] = keysBucket[i];
			oldValuesBucket[i] = valuesBucket[i];
			}
		keysBucket = new String[2 * keysBucket.length];
		valuesBucket = new String[2 * valuesBucket.length];
		for (int i = 0; i < oldKeysBucket.length; i++) {
			keysBucket[i] = oldKeysBucket[i];
			valuesBucket[i] = oldValuesBucket[i];
			}
		}
	
	
/* Private instance parallel arrays to hold key/value pairs */
	private String[] keysBucket;
	private String[] valuesBucket;
	private int bucketCount; // to hold index of most recently added key/value pair
}