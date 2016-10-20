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

}