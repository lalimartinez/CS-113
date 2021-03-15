package edu.miracosta.cs113;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> implements List<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  
  public void add(int index, E obj) { 
	  listIterator(index).add(obj); // Fill Here 
  }
  
  public void addFirst(E obj) { // Fill Here 
	  listIterator().add(obj);
  }
  public void addLast(E obj) { 
	  listIterator(size()).add(obj);
	
  }

  public E get(int index) 
  { 	
	  if(index < 0 || index >= size)
		  throw new IndexOutOfBoundsException(); 
	  return listIterator(index).next();
	  /*ListIterator<E> iter = listIterator(index); 
      	return iter.next();*/
  }  
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {  
	return size;
  } // Fill Here
  
  public void clear() {
	  head = null;
	  tail = null;
	  size = 0;
  }
  
  public boolean isEmpty() {
	  return size == 0;
  }
  
  public boolean add(E e) {
	  listIterator(size).add(e);
	  return true;
  }

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }
  
  public int indexOf(Object o) {
	  int count = 0;
	  ListIterator<E> listIterator = listIterator();
	  while(listIterator.hasNext()) {
		  Object current = listIterator.next();
		  if(current.equals(o))
			  return count;
		  count++;
	  }
	  return -1;
  }
  
  public boolean contains(Object o) {
	  if(indexOf(o) != -1)
		  return true;
	  else
		  return false;
  }
  
  public int lastIndexOf(Object o) {
	  int count = size - 1;
	  ListIterator<E> listIterator = listIterator(size);
	  while(listIterator.hasPrevious()) {
		  Object current = listIterator.previous();
		  if(current.equals(o))
			  return count;
		  count--;
	  }
	  return -1;
  }
  
  public E set(int index, E element) {
	  E temp;
	  if(index < 0 || index >= size)
		  throw new IndexOutOfBoundsException();
	  ListIterator<E> listIterator = listIterator(index);
	  temp = (E) listIterator.next();
	  listIterator.set(element);
	  return temp;
  }
  
  @Override
  public String toString() {
	  if(head == null)
		  return "[]";
	  
	  String output = "[";
	  Node<E> current = head;
	  output += current.data;
	  while(current.next != null) {
		  current = current.next;
		  output += ", " + current.data;
	  }
	  output += "]";
	  return output;
  }

  public Iterator<E> iterator() { return new ListIter(0);  }
  public ListIterator<E> listIterator() { return new ListIter(0);  }
  public ListIterator<E> listIterator(int index){return new ListIter(index);}
  public ListIterator<E> listIterator(ListIterator<E> iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     index = size;     nextItem = null;      }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    public boolean hasNext() {   return nextItem != null;    } // Fill Here
    
    public boolean hasPrevious() {   
    	return index > 0;  
    } // Fill Here
    
    public int previousIndex() {  return index-1;    } // Fill Here
    
    public int nextIndex() {  
    	if(index == size)
    		return size;
    	else
    		return index;
    } // Fill here
    public void set(E o)  { 
    	if(lastItemReturned == null)
    		throw new IllegalStateException();
    	else 
    		lastItemReturned.data = o;
    }  // not implemented
    
    public void remove(){
    	if(lastItemReturned == null)
    		throw new IllegalStateException();
    	else if(lastItemReturned.prev == null) {
    		head = nextItem;
    		head.prev = null;
    		size--;
    	}
    	else if(lastItemReturned.next == null) {
    		tail = tail.prev;
    		tail.next = null;
    		size--;
    	}
    	else {
    		lastItemReturned.prev.next = lastItemReturned.next;
    		lastItemReturned.next.prev = lastItemReturned.prev;
    		size--;
    	}
    }      // not implemented

    public E next()
    {  
        if(hasNext()) {
        	lastItemReturned = nextItem;
        	nextItem = nextItem.next;
        	index++;
        	return lastItemReturned.data;
        }
        throw new NoSuchElementException();// Fill Here 
    }

    public E previous() {  
    	if(!hasPrevious())
    		throw new NoSuchElementException();
    	if(nextItem == null)
    		nextItem = tail;
    	else
    		nextItem = nextItem.prev;
    	lastItemReturned = nextItem;
    	index--;
    	return lastItemReturned.data;
    	
        // Fill Here 
    }

    public void add(E obj) {
    	Node<E> fresh = new Node<E>(obj);
    	if(head == null) {
    		head = fresh;
    		tail = head;
    	}
    	else if(nextItem == head){
    		fresh.next = nextItem;
    		nextItem.prev = fresh;
    		head = fresh;
    	}
    	else if(nextItem == null) {
    		tail.next = fresh;
    		fresh.prev = tail;
    		tail = fresh;
    	}
    	else {
    		fresh.prev = nextItem.prev;
    		nextItem.prev.next = fresh;
    		fresh.next = nextItem;
    		nextItem.prev = fresh;
    	}
    	size++;
    	index++;
    	lastItemReturned = null;
    // Fill Here
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
