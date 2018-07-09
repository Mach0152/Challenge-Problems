package graphs;


public class Ancestor {
    public BinaryTree findFirstAncestor(BinaryTree root, BinaryTree node1, BinaryTree node2) {
        if ( root == null)
            return null;
        if(root == node1 || root == node2)
            return root;
        BinaryTree left = findFirstAncestor(root.left, node1, node2);
        if (left != null && left != node1 && left != node2)
            return left;
        BinaryTree right = findFirstAncestor(root.right, node1, node2);
        



        return null;
    }
}
