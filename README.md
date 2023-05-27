# bekus
# Binary Search Tree (BST) Implementation

This is a Java implementation of a Binary Search Tree (BST) data structure. It provides functionality for inserting key-value pairs, retrieving values associated with keys, removing nodes by key, and iterating over the keys in the BST.

## BST Class

The `BST` class is a generic class that can store key-value pairs. It implements the `Iterable` interface, allowing for easy iteration over the keys in ascending order.

### Constructor

java
public BST()
Creates an empty BST.

## Methods
__int size()__: Returns the number of elements in the BST.
__void put(K key, V val)__: Inserts a key-value pair into the BST.
__V get(K key)__: Retrieves the value associated with the given key from the BST.
__void delete(K key)__: Removes the node with the given key from the BST.
__Iterator<K> iterator()__: Returns an iterator for iterating over the keys in the BST.
### __Example Usage__
Here's an example usage of the BST class:
```ruby
BST<Integer, String> bst = new BST<>();
bst.put(5, "Five");
bst.put(3, "Three");
bst.put(7, "Seven");

System.out.println("Size: " + bst.size()); // Output: Size: 3

System.out.println("Value at key 3: " + bst.get(3)); // Output: Value at key 3: Three

bst.delete(5);

System.out.println("Size after deletion: " + bst.size()); // Output: Size after deletion: 2

System.out.print("Iterating over keys: ");
for (Integer key : bst) {
    System.out.print(key + " "); // Output: Iterating over keys: 3 7
}
```
