package hashtable;

public class Hashmap <K, V> 
{

	float loadfactor = 0.75f;

	class HashEntry <K,V>{
		K key;
		V value;
		HashEntry <K,V>  next;
		HashEntry (K key , V value) {
			this.key = key;
			this.value = value;
		}
	}

	private HashEntry[] entries = null;
	private int size = 1;

	public Hashmap(int initialsize) {
		entries = (HashEntry<K,V>[]) new HashEntry[initialsize];
		//entries = new HashEntry[initialsize];
	}
	public Hashmap(int initialsize , float loadfactor) {
		this(initialsize);
		this.loadfactor = loadfactor;
	}

	static int hash(int hashcode) {
		hashcode ^= (hashcode >>>20) ^ (hashcode>>>12);
		hashcode ^= (hashcode >>>7) ^ (hashcode >>>4);
		return hashcode;
		
	}
	void resize(int newsize) {
		if(entries.length > newsize) {
			return;
		}
		System.out.println("Resizing array from " + entries.length + ": to : " + newsize);
		HashEntry<K,V> [] newArr = (HashEntry<K,V>[]) new HashEntry[newsize];
		for(int i = 0 ; i < entries.length; i++) {
			newArr[i] = entries[i];
		}
		entries = newArr;
	
	}

	public void put(K key, V value) {
			
		float curCapacity = ((float)size)/entries.length;
		System.out.println("put operation : currCapacity :" + curCapacity + ":" + size);
		if(curCapacity >= loadfactor) {
			resize (entries.length*2);
		}
		
		int index = hash(key.hashCode())  % entries.length;		
		if( entries[index] == null ) {
			entries[index] = new HashEntry(key, value);
			size++;
		}else {
			HashEntry entry = entries[index];
			while(entry.next != null) {
				entry = entry.next;
				if(entry.key.equals(key)) {
					entry.value = value;
					return;
				}
			}
			entry.next = new HashEntry(key, value);
			size++;
		}
	}

	public V get(K key) {
		int index = hash(key.hashCode()) % entries.length;
		if(entries[index] == null) {
			return null;
		}
		HashEntry<K,V> entry = entries[index];
		while(entry!= null)  {
			if(entry.key.equals(key))  {
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}

	public static void main(String[] args) {
		Hashmap<String, String>  map = new Hashmap<String, String>(4);
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");
		map.put("7", "seven");
		System.out.println("1 :" + map.get("1"));
		System.out.println("2 :" + map.get("2"));
		System.out.println("3 :" + map.get("3"));
		System.out.println("4 :" + map.get("4"));
		System.out.println("5 :" + map.get("5"));
		System.out.println("6 :" + map.get("6"));
		System.out.println("7 :" + map.get("7"));
	}


}
