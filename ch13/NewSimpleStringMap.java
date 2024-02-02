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
			bucketCount++;
		} else {
			valuesBucket[keyElement] = value;
		}
		System.out.println(valuesBucket[bucketCount - 1]);
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


	

	
//	private String[] doubleArrayCapacity(String[] oldArray) {
//		String[] newArray = new String[2 * oldArray.length];
//		for (int i = 0; i < oldArray.length; i++) {
//				newArray[i] = oldArray[i];
//			}
//			return newArray;
//		}
	
	
/* Private instance parallel arrays to hold key/value pairs */
	private String[] keysBucket;
	private String[] valuesBucket;
	private int bucketCount; // to hold index of most recently added key/value pair
}