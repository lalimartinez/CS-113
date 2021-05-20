package miracosta.edu.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
	ArrayList<E> stack = new ArrayList<E>();
	
	public boolean empty() {
		return stack.isEmpty();
	}
	
	public E peek() {
		if(empty())
			throw new EmptyStackException();
		else
			return stack.get(stack.size() - 1);
	}
	
	public E pop() {
		if(empty())
			throw new EmptyStackException();
		else {
			E temp = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return temp;
		}
	}
	
	public E push(E obj) {
		stack.add(obj);
		return obj;
	}
}
