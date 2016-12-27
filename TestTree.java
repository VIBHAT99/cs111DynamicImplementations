//TestTree.java
//CS 111 test program for hte tree structure

import java.util.Scanner;
import java.lang.Math.*;

public class TestTree
{

    public static void  main(String [] args)throws java.io.IOException
    {Tree<Integer> t= new Tree<Integer>();
    Scanner sc = new Scanner(System.in);
    int i, value;


    for (i=0; i<15;i++)
	{  value = (int)(Math.random()*100);
	   System.out.println ("about to insert " + value);
           t.insert (value);
	}

    System.out.println(" a preorder traversal is: ");
    t.preorder();

    System.out.println("an inorder traversal is : ");
    t.inorder();

    System.out.println("a postorder traversal is: ");
    t.postorder();


    System.out.println("the Tree is an Indorder traversal using the stack inorder process");
    t.inorders();


    System.out.print("\nenter a value to be removed from the tree: ");
    value = sc.nextInt();
    t.deleteitem(value);

    System.out.println(" a preorder traversal is: ");
    t.preorder();

    System.out.println("an inorder traversal is : ");
    t.inorder();

    System.out.println("a postorder traversal is: ");
    t.postorder();

    }
}
