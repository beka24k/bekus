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
