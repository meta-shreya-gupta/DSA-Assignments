package Assignment1;

public class BSTDictionary<K extends Comparable<K>, V> implements MyDictionary <K,V>{
    public class Node{
        K key;
        V value;
        Node left;
        Node right;
        public Node(K key , V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return key + "->" + value;
        }
    }
    Node root;
    /**
     * extracts root of the BST
     * @return root of BST
     */
    public Node getRoot(){
        return root;
    }
    
    public BSTDictionary(K[] keys , V[] values){
        for(int index = 0 ; index < keys.length ; index ++){
            add(keys[index] , values[index]);
        }
    }
    
    /**
     * adds key and value to the Node of BST
     * @param key which we want to add(word of dictionary)
     * @param value which we want to add (meaning of word or some other info)
     */
    @Override
    public void add(K key , V value){
        root = insert(root , key , value);
    }
    /**
     * helper method to add new Node to the dictionary
     * @param root first node of the tree
     * @param key whcih we want to add to the tree
     * @param value which we want to add to the tree
     * @return Node which is build by the key and value
     */
    private Node insert(Node root, K key, V value) {
        if(root == null){
            root = new Node(key , value);
            return root;
        }
        int cmp = key.compareTo(root.key);
        if(cmp < 0){
            root.left = insert(root.left , key , value);
        }
        else{
            root.right = insert(root.right , key , value);
        }
        return root;
    }
    /**
     * deletes a node from the tree 
     * @param key of that node which we want to delete
     */
    @Override
    public void delete(K key) {
        root = deleteNode(root , key);

    }
    /**
     * helper method to delete a node from tree 
     * @param root main node of the tree
     * @param key of that node which we want to delete
     * @return main node of the tree after deleting the node
     */
    private Node deleteNode(Node root , K key){
        if(root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if(cmp < 0){                                    //checks if node to be deleted is on left
            root.left = deleteNode(root.left, key);
        }
        else if(cmp > 0){                               //checks if node to be deleted is on right
            root.right = deleteNode(root.right, key);
        }
        else {                                          //if we want to delete the current node
            if(root.left == null && root.right == null){      //if we are deleting the laef node of the tree
                return null;
            }
            else if(root.left == null){                         //if the node to be deleted has only right child then current node will be the right child 
                return root.right;
            }
            else if(root.right == null){                //if node to be deleted has only left child then current node will be the left child
                return root.left;
            }
            else{               //if it has both childs then current node will be the inorder successor of that node
                Node node = findInorderSuccessor(root.right);       //finds inorder successor of that node and sets it to current node and deletes it
                root.key = node.key;
                root.right = deleteNode(root.right, node.key);
            }
        }
        return root;
    }
    /**
     * helper method to find inorder successor
     * @param node represents current node
     * @return inorder successor node
     */
    private Node findInorderSuccessor(Node node) {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    /**
     * it returns the value of the specified key
     * @param key whose value we want to retrieve
     * @return value of the specified key
     */
    @Override
    public V getValue(K key) {
        Node temp = root;
        while(temp != null){
            int cmp = key.compareTo(temp.key);
            if(cmp < 0){
                temp = temp.left;
            }
            else if(cmp > 0){
                temp = temp.right;
            }
            else{
                return temp.value;
            }
        }
        return null;
    }
    /**
     * prints the sorted list
     * NOTE - sorted list is given by inorder as in BST smallst element is on left of the root and larger elements are on the right of the root
     * inorder(BST) = left root right
     */
    @Override
    public void sortedList() {
        if(root == null){
            return ;
        }
        inorder(root);
    }
    /**
     * helper method to print inorder of the BST
     * @param root main node of the tree
     */
    public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }
    /**
     * sorts the list for all the keys >=K1 and <=K2
     * @param key1 K1 parameter
     * @param key2 K2 parameter
     */
    @Override
    public void sortedListByKeys(K key1, K key2) {
        printSort(root , key1 , key2);
    }
    /**
     * helper method to sort the list based on the two keys specified
     * @param root main node of the BST
     * @param key1 lower parameter of key
     * @param key2 higher parameter of key
     */
    private void printSort(Node root , K key1 , K key2){
        if(root == null){
            return ;
        }
        if(key1.compareTo(root.key) <= 0 && key2.compareTo(root.key) >= 0){
            printSort(root.left, key1, key2);
            System.out.println(root);
            printSort(root.right, key1, key2);
        }
        else if(key1.compareTo(root.key) < 0 && key2.compareTo(root.key) < 0){
            printSort(root.left, key1, key2);
            System.out.println(root);
        }
        else{
            printSort(root.right, key1, key2);
            System.out.println(root);
        }
    }
}
