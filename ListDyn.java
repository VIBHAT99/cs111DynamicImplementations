//ListDyn.java
//cs111 sample program
//dynamic implementation of an ordered list
//the template class used must provide equals, compareTo and toString


public class ListDyn<T extends Comparable>
{


    private static class Node<T>
    {
	private T data;
	private Node<T> next;
	
	private Node (T d)
	{
	    data =d;
	    next= null;
	}
	
	private Node (T d, Node<T> ref)
	{
	    data =d;
	    next = ref;
	}
    }

    private Node<T> head;
    private int numElements;

    public ListDyn()
    { head =null;
      numElements=0;
    }


    public ListDyn(ListDyn<T> l)
    { Node<T> ptr, ptr2;
    if (l.head==null)
	{numElements=0;
	head =null;
	}
    else
	{head = new Node<T>(l.head.data);
	ptr=head;
	for (ptr2=l.head.next; ptr2!=null; ptr2= ptr2.next)
	    { ptr.next = new Node<T>(ptr2.data);
	      ptr = ptr.next;
	    }
	}
    numElements=l.numElements();
    }

    public void display_list()
    {
	Node<T> ptr;

	ptr=head;
	while (ptr !=null)
	    { System.out.println(ptr.data);
	      ptr= ptr.next;
	    }
    }

    public void insert (T it) 
    { Node<T> ptr, trav, prev;

      prev = null;
      trav= head;
      while (trav != null && it.compareTo(trav.data)>0)
	  {  prev= trav;
	     trav= trav.next;
	  }

      ptr = new Node<T>((T)it,trav);
      
      if (prev == null)
	  head = ptr;
      else
	  prev.next=ptr;
      numElements++;
    }


    public void remove (T it) throws ListEmptyException, NotInListException
    {
	Node<T> ptr, prev, trav;

	if (empty())
	    throw new ListEmptyException("list empty on remove");
  
	prev=null;
	trav = head;
	while (trav !=null && it.compareTo(trav.data)>0)
	    {
		//if (it.compareTo(trav.data)>0) throw new NotInListException("item not in list on remove");
		prev=trav;
		trav= trav.next;
	    }
	if (trav == null || !(trav.data.equals(it))) throw new NotInListException ("item not in list on remove");
	//if (trav==null)
	//  throw new NotInListException("item not in list on remove");
  
	if(prev==null)
	    head = trav.next;
	else
	    prev.next = trav.next;
	numElements--;
    }


    public boolean empty()
    {
	return head ==null;
    }


    public int numElements()
    {
	return numElements;
    }

    public void clear()
    {
	numElements =0;
	head=null;
    }
}




 
  


        
