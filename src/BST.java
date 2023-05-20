import java.util.Iterator;
import java.util.Stack;
/**
 * Binary Search Tree implementation.
 *
 * @param <K> the type of keys stored in the BST.
 * @param <V> the type of values associated with the keys in the BST.
 */
public class BST<K extends Comparable<K>, V>{

    /**
     * Node class representing a node in the BST.
     *
     * @param <K> the type of keys stored in the node.
     * @param <V> the type of values associated with the keys in the node.
     */
    private class Node<K, V> {
        V data;
        K key;
        Node<K, V> left, right;

        /**
         * Constructs a new node with the given data and key.
         *
         * @param data the value associated with the node.
         * @param key  the key of the node.
         */
        public Node(V data, K key) {
            this.data = data;
            this.key = key;
            left = right = null;
        }
    }


}
