package com.example.javaproject;
import java.util.*;

public class Functions {
    static Node[] Root = new  Node[100];
    static int[] number_of_nodes = new int[100]; // this is to count the number of nodes.
    static String navigation = "";
    static boolean isDelete = false;

    public static void add(double value,Node[] Root,int index){

        Root[index] = addnode(Root[index] ,value );
        number_of_nodes[index]++;
    }
    private static Node addnode(Node node,double value){
        if(node == null)
        {
            return new Node(value);
        }
        if(value < node.Data){
            node.Left = addnode(node.Left , value);
        }
        else if(value > node.Data){
            node.Right = addnode(node.Right , value);
        }
        else return node;
        return node;
    }
    static String Level_order(int index){
        Node node = Root[index];
        queue Queue = new  queue();
        String navigation = "";
        if(node == null) return "Tree is Empty!";
        else{
            while(node != null){
                navigation = navigation + node.Data + "  ";
                if(node.Left != null) Queue.add(node.Left);
                if(node.Right != null) Queue.add(node.Right);
                node = (Node) Queue.remove();
            }
            return navigation;
        }

    }
    static String Pre_order(Node node){
        if(node == null)return "Tree is Empty!";
        else{
            navigation = navigation + node.Data + "  ";
            Pre_order(node.Left);
            Pre_order(node.Right);
        }
        return navigation;

    }
    static String in_order(Node node ){
        if(node == null) return "Tree is Empty!";
        else{
            in_order(node.Left);
            navigation = navigation + node.Data + "  ";
            in_order(node.Right);
        }
        return navigation;

    }
    static String post_order(Node node){
        if(node == null) return "Tree is Empty!";
        else{
            post_order(node.Left);
            post_order(node.Right);
            navigation = navigation + node.Data + "  ";
        }
        return navigation;

    }
    static double max_Element(int index){
        Node node = Root[index];
        double max = node.Data;
        queue Queue = new  queue();

        while(node != null){
            if(max < node.Data) max = node.Data;
            if(node.Left != null) Queue.add(node.Left);
            if(node.Right != null) Queue.add(node.Right);
            node = (Node) Queue.remove();
        }
        return max;
    }
    static double min_Element(int index){
        Node node = Root[index];
        double max = node.Data;
        queue Queue = new  queue();

        while(node != null){
            if(max > node.Data) max = node.Data;
            if(node.Left != null) Queue.add(node.Left);
            if(node.Right != null) Queue.add(node.Right);
            node = (Node) Queue.remove();
        }
        return max;
    }
    static boolean binary_search(Node node ,double element){
        if(node == null) return false;
        else{
            if(element == node.Data) return true;
            else if(element > node.Data) return binary_search(node.Right ,element);
            else return binary_search(node.Left ,element);
        }
    }
    static boolean Compare(int index_1,int index_2){

        Node node1 = Root[index_1];
        Node node2 = Root[index_2];
        queue Queue1 = new  queue();
        queue Queue2 = new  queue();

        while(node1 != null || node2 != null){
            if(node1.Data != node2.Data) return false;

            if(node1.Left != null) Queue1.add(node1.Left);
            if(node1.Right != null) Queue1.add(node1.Right);
            node1 = (Node) Queue1.remove();

            if(node2.Left != null) Queue2.add(node2.Left);
            if(node2.Right != null) Queue2.add(node2.Right);
            node2 = (Node) Queue2.remove();
        }
        return true;

    }
    static boolean delete_all_of_nodes(Node node,int index){

        if(node == null) return true;
        else{
            delete_all_of_nodes(node.Left ,index);
            delete_all_of_nodes(node.Right ,index);
            node = null;
            System.gc();
        }
        Root[index] = null;
        return true;
    }
    static int tree_Depth(Node node){
        if(node == null) return 0;
        else{
            int left_Depth = tree_Depth(node.Right);
            int right_Depth = tree_Depth(node.Right);

            if(left_Depth > right_Depth)    return left_Depth + 1;
            else    return right_Depth + 1;
        }
    }
    static int tree_height(int index){
        int height = 0;
        Node node = Root[index];
        Queue<Node> q = new LinkedList();

        q.add(node);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.remove();

            if(temp == null) height++;

            if(temp != null){
                if(temp.Left != null) q.add(temp.Left);
                if(temp.Right != null) q.add(temp.Right);
            }
            else if(!q.isEmpty()) q.add(null);
        }
        return height-1;

    }
    static int number_of_leaves(int index){
        int number_of_leaves = 0;
        Node node = Root[index];
        queue q = new queue();
        if(node == null) return 1;
        else{
            while(node != null){
                if(node.Left == null && node.Right == null) number_of_leaves++;
                if(node.Left != null) q.add(node.Left);
                if(node.Right != null) q.add(node.Right);
                node = (Node) q.remove();
            }
        }
        return number_of_leaves;
    }
    static boolean Complete(Node node,int index,int number){
        if(node == null) return true;

        if(index >= number) return false;

        return (Complete(node.Left ,2*index + 1, number)
                &&
                Complete(node.Right ,2*index + 2, number));
    }
    static boolean Change_Node(Node node ,double pre_value ,double new_value){
        if(node == null) return false;
        else{
            if(pre_value == node.Data){
                node.Data = new_value;
                return true;
            }
            else if(pre_value > node.Data) return Change_Node(node.Right ,pre_value ,new_value);
            else return Change_Node(node.Left ,pre_value , new_value);
        }
    }
    static double minvalue(Node node) {
        double min = node.Data;
        while(node.Left != null){
            min = node.Left.Data;
            node = node.Left;
        }
        return min;
    }
    static void delete(double value , int index){
        Root[index] = deletevalue(Root[index] ,value );
    }
    static Node deletevalue(Node node ,double value ){

        if(node == null)    return node;

        if(value < node.Data)   node.Left = deletevalue(node.Left , value);
        else if(value > node.Data)  node.Right = deletevalue(node.Right ,value);
        else{
            if(node.Left == null)   return  node.Right;
            else if(node.Right == null)     return  node.Left;
            else if(node.Right != null && node.Left!= null){
                node.Data = minvalue(node.Right);
                node.Right = deletevalue(node.Right , node.Data);
            }
            else node = null;
        }
        return node;

    }
}
