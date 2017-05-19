package ArraysAndStrings;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable<K,V> {

	public class MapNode<K, V> {
		K key;
		V value;
		MapNode<K,V> next;

		public MapNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private int bucketSize = 20;  		
	private int size=0;				// Total Number of elements in the Hash Table 
	@SuppressWarnings("unchecked")
	List<MapNode<K,V>>[] ht = new LinkedList[bucketSize];
	
	// Function to insert values in the hash table
	public void put(K key, V value) {

		int index = getIndex(key);

		if(ht[index] == null) {
			List<MapNode<K, V>> list = new LinkedList<MapNode<K,V>>();
			ht[index] = list;
			MapNode<K, V> listObj = new MapNode<>(key,value);
			list.add(listObj);
			size++; 
		} else {
			List<MapNode<K, V>> list = ht[index];
			MapNode<K, V> listObj = list.get(0);

			while(listObj.next != null && listObj.key != key){
				listObj = listObj.next;
			}

			if(listObj.key == key) {
				listObj.value = value;
			} else {
				MapNode<K, V> obj = new MapNode<>(key, value);
				listObj.next = obj;
				obj.next = null;
				size++;
			}
		}
	}

	// Return the array index corresponding to a particular key.
	public int getIndex(K key){
		int hashcode = key.hashCode();
		return hashcode%bucketSize;
	}
	
	//Function to get a value corresponding to a particular key from a hash table
	public V get(K key) {

		int index = getIndex(key);
		List<MapNode<K, V>> list = ht[index];
		MapNode<K, V> listObj = list.get(0);

		while(listObj.next != null && listObj.key != key){
			listObj = listObj.next;
		}

		if(listObj.key == key) {
			return listObj.value;
		} else {
			return null;
		}
	}
	
	// Function to get the total number of elements in the hash table	
	public int tableSize() {
		return size;
	}

	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	
	//Function to remove a value corresponding to a particular key from a hash table
	public V remove(K key) {

		int index = getIndex(key);
		List<MapNode<K, V>> list = ht[index];
		MapNode<K, V> listObj = list.get(0);
		MapNode<K, V> prev = null;

		while(listObj.next != null && listObj.key != key){
			prev = listObj;
			listObj = listObj.next;
		}

		if(listObj.key == key){
			V returnValue = listObj.value;
			if(prev == null){
				listObj = null;
			}
			else if(listObj.next == null){ 
				prev.next = null;
			}
			else {
				prev.next = listObj.next;
			}
			return returnValue;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		MyHashTable<String, Integer> map = new MyHashTable<>();
		
		map.put("this",1 );
		map.put("coder",2 );
		map.put("this",4 );
		map.put("hi",5 );
		
        System.out.println(map.tableSize());
        System.out.println(map.isEmpty());
		System.out.println(map.remove("coder"));
	}
}
