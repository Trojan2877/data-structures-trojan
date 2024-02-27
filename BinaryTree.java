public class BinaryTree{

    Node root;

    BinaryTree(){root = null;}

    public void preOrderTraversal(Node node){
        if (node == null)
            return;

        System.out.println(node.val);

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node){
        if(node == null)
            return;
        
        inOrderTraversal(node.left);
            
        System.out.println(node.val);

        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node){
        if(node == null)
            return;
        
        postOrderTraversal(node.left);

        postOrderTraversal(node.right);

        System.out.println(node.val);
    }

    public static void main(String[] args) {
        BinaryTree tree = getTree();

        System.out.println(
            "Preorder traversal of binary tree is ");
        tree.preOrderTraversal(tree.root);

        System.out.println(
            "Inorder traversal of binary tree is ");
        tree.inOrderTraversal(tree.root);

        System.out.println(
            "Postorder traversal of binary tree is ");
        tree.postOrderTraversal(tree.root);
    }

    private static BinaryTree getTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        return tree;
    }

}