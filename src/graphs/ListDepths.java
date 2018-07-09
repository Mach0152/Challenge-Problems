package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListDepths {
    public static ArrayList<LinkedList<BinaryTree>> listAtDepth(BinaryTree t) {
        ArrayList<LinkedList<BinaryTree>> lists = new ArrayList<>();
        listAtDepth(0, t, lists);
        return lists;

    }

    private static ArrayList<LinkedList<BinaryTree>> listAtDepth(int depth, BinaryTree t, ArrayList<LinkedList<BinaryTree>> lists){
        if (t == null) return lists;
        if (depth > lists.size()-1) {
            lists.add(new LinkedList<BinaryTree>());
        }
        lists.get(depth).add(t);
        listAtDepth(depth+1, t.left, lists);
        listAtDepth(depth+1, t.right, lists);
        return lists;
    }
}

class BinaryTree{
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;
    public int n;

}