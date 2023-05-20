import java.util.Iterator;
import java.util.Stack;
/**
 * Binary Search Tree implementation.
 *
 * @param <K> the type of keys stored in the BST.
 * @param <V> the type of values associated with the keys in the BST.
 */
public class BST<K extends Comparable<K>, V> implements Iterable<K> {

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

    private Node<K, V> root;
    private int size;

    /**
     * Constructs an empty BST.
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of elements in the BST.
     *
     * @return the size of the BST.
     */
    public int size() {
        return size;
    }

    /**
     * Inserts a key-value pair into the BST.
     *
     * @param key the key to insert.
     * @param val the value associated with the key.
     */
    private Node<K, V> insert(Node<K, V> current, K key, V val) {
        if (current == null) {
            return new Node<>(val, key);
        }
        if (key.compareTo(current.key) < 0) {
            current.left = insert(current.left, key, val);
        } else {
            current.right = insert(current.right, key, val);
        }
        return current;
    }

    /**
     * Inserts a key-value pair into the BST.
     *
     * @param key the key to insert.
     * @param val the value associated with the key.
     */
    public void put(K key, V val) {
        root = insert(root, key, val);
        size++;
    }

    /**
     * Recursively searches for a node with the given key in the BST.
     *
     * @param current the current node being visited.
     * @param key     the key to search for.
     * @return the node with the given key, or null if not found.
     */
    private Node<K, V> getNode(Node<K, V> current, K key) {
        if (current == null || key.compareTo(current.key) == 0) {
            return current;
        }
        if (key.compareTo(current.key) < 0) {
            return getNode(current.left, key);
        } else {
            return getNode(current.right, key);
        }
    }

    /**
     * Retrieves the value associated with the given key from the BST.
     *
     * @param key the key to search for.
     * @return the value associated with the key, or null if the key is not found.
     */
    public V get(K key) {
        Node<K, V> node = getNode(root, key);
        if (node == null) {
            return null;
        }
        return node.data;
    }

    /**
     * Removes the node with the given key from the BST.
     *
     * @param current the current node being visited.
     * @param key     the key to remove.
     * @return the modified subtree after removal.
     */
    private Node<K, V> remove(Node<K, V> current, K key) {
        if (current == null)
            return null;
        if (key.compareTo(current.key) < 0) {
            current.left = remove(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = remove(current.right, key);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            K smallestValue = findSmallestValue(current.right);
            current.data = (V) smallestValue;
            current.right = remove(current.right, smallestValue);
        }
        return current;
    }

    /**
     * Finds the smallest value in the given subtree.
     *
     * @param current the current node being visited.
     * @return the smallest value in the subtree.
     */
    private K findSmallestValue(Node<K, V> current) {
        if (current.left == null) {
            return current.key;
        }
        return findSmallestValue(current.left);
    }

    /**
     * Removes the node with the given key from the BST.
     *
     * @param key the key to remove.
     */
    public void delete(K key) {
        root = remove(root, key);
        size--;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTIterator();
    }

    /**
     * Iterator class for iterating over the keys in the BST.
     */
    private class BSTIterator implements Iterator<K> {
        private Stack<Node<K, V>> stack;

        /**
         * Constructs a new iterator for the BST.
         */
        public BSTIterator() {
            stack = new Stack<>();
            pushLeftNodes(root);
        }

        /**
         * maker inorder traversal method
         * @param root the root node of BST
         */
        public void inOrder(Node root) {
            if(root==null)return ;
            inOrder(root.left);
            System.out.println(root.data+" ");
            inOrder(root.right);
        }
        /**
         * Helper method to push all left nodes of a subtree onto the stack.
         *
         * @param node the root node of the subtree.
         */
        private void pushLeftNodes(Node<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node<K, V> node = stack.pop();
            pushLeftNodes(node.right);
            return node.key;
        }
    }
}
