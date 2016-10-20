class LinkedHashEntry{
  String key;
  int value;
  LinkedHashEntry next;

  LinkedHashEntry(String key, int value){
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

class HashTable{
  private int numOfBuckets;
  private int size;
  private LinkedHashEntry[] table;

  public HashTable(int buckets){
    numOfBuckets = buckets;
    size = 0;
    table = new LinkedHashEntry[numOfBuckets];

    for(int i = 0; i < numOfBuckets; i++){
      table[i] = null;
    }
  }

  public int get(String key){
    int hashKey = myHash(key) % numOfBuckets;
    if(table[hashKey] == null)
      return -1;
    else{
      LinkedHashEntry entry = table[hashKey];
      while(entry != null && entry.key != key){
        entry = entry.next;
      }
      if(entry == null)
        return -1;
      else
        return entry.value;
    }
  }

  public void insert(String key, int value){
    int hashKey = myHash(key) % numOfBuckets;
    if(table[hashKey] == null)
      table[hashKey] = new LinkedHashEntry(key, value);
    else{
      LinkedHashEntry entry = table[hashKey];
      while(entry.next!=null && entry.key!=key){
        entry = entry.next;
      }
      if(entry.key == key)
        entry.value = value;
      else
        entry.next = new LinkedHashEntry(key, value);
    }
    size++;
  }

  public void remove(String key){
    int hashKey = myHash(key) % numOfBuckets;
    LinkedHashEntry prev = null;
    LinkedHashEntry entry = table[hashKey];
    if(table[hashKey] != null){
      while(entry.next!=null && entry.key!=key){
        prev = entry;
        entry = entry.next;
      }
      if(entry.key == key){
        if(prev == null){
          table[hashKey] = entry.next;
        }
        else{
          prev.next = entry.next;
        }
        size--;
      }      
    }  
  }

  private int myHash(String x)
  {
    int hashVal = x.hashCode( );
    hashVal %= TABLE_SIZE;
    if (hashVal < 0)
        hashVal += TABLE_SIZE;
    return hashVal;
  }

}

