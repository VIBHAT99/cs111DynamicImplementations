//Trees.java
//cs111 sample generic binary search tree

import java.util.Stack;

public class Tree<T extends Comparable>
{
    private static class Node<T>
    {
 private T value;
 private Node<T> left;
 private Node<T> right;
 
 private Node (T d)
 {
     value =d;
     left= null;
     right=null;
 }
    }

    private Node<T> root;

    public Tree()
    { root = null;}

    public  Tree (Tree<T> t)
    {}

    public boolean empty() { return root == null;}

    public void insert (T value)
    {
 root =  insertnode(value, root);
    }

    private Node<T> insertnode(T value, Node<T> tptr)
    { 
    if (tptr == null)
 { 
     tptr = new Node<T>(value);
 }
    else
 if (value.compareTo(tptr.value)<0)
     tptr.left = insertnode (value, tptr.left);
 else
     tptr.right =insertnode (value, tptr.right);
    return tptr;
    }

    public void deleteitem (T value)
    {
 root = deleteelement(value, root);
    }

    public void preorder() {pretrav(root);}
    public void postorder(){posttrav(root);}
    public void inorder() {intrav(root);}

    private Node<T> deleteelement (T value, Node<T> tptr)
    {
 if (tptr!=null)
     if (value.equals(tptr.value))
  tptr = deletenode (tptr);
     else if (value.compareTo(tptr.value)<0)
  {
    tptr.left = deleteelement (value, tptr.left);
  }
          else 
       {
    tptr.right = deleteelement (value, tptr.right);
       }
 return tptr;
    }

    private Node<T> deletenode (Node<T> tptr)
    { 
      T replace; 
 
      if (tptr != null)
   System.out.println("about to delete " + tptr.value); 
      if (tptr.left == null && tptr.right == null)
   {//a leaf
       tptr = null;
   }
      else if (!(tptr.left != null && tptr.right != null))
   {//one child
       if (tptr.left != null)
    tptr= tptr.left;
       else tptr=tptr.right;
   }
      else //two children
   {//find inorder successor
       replace = processleftmost(tptr, tptr.right);
       System.out.println ("tptr value -> " + tptr.value + " replace -> " + replace);
       tptr.value = replace;
   }
      return tptr;
    }

    private T processleftmost(Node<T> ptptr, Node<T> tptr)
    { T val=null;
  
    if (tptr.left == null)
    { val = tptr.value;
      System.out.println ("left is null in procesleftmost");
      deleteitem(val);
      /*if (ptptr.right.value == val)
        ptptr.right = tptr.right;
      else
        ptptr.left= tptr.right;*/
     }
      else val = processleftmost (tptr, tptr.left);
    return val;
    }

    private void pretrav(Node<T> tptr)
    {
 if (tptr != null)
     { System.out.println(tptr.value );
       pretrav (tptr.left);
       pretrav (tptr.right);
     }
    }

    private void posttrav(Node<T> tptr)
    {
 if (tptr != null)
     { posttrav(tptr.left);
       posttrav (tptr.right);
       System.out.println(tptr.value);
     }
    }

    private void intrav(Node<T> tptr)
    {
 if (tptr!=null)
     {intrav(tptr.left);
      System.out.println(tptr.value);
      intrav (tptr.right);
     }
    }


    public void inorders()
    {
 Stack<Node<T>> s = new Stack<Node<T>>();
 Node<T> r;
 boolean done = false;

 r = root;
 while (!done)
     {if (r != null)
  { s.push(r);
  r = r.left;
  }
     else
  { if (!s.empty())
      { r=s.pop();
      System.out.println (r.value);
      r = r.right;
      }
  else done = true;
  }
     }
    }
 


}












