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

  HashTable(int buckets){
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

}

