/**
 * This class provides the implementation of Set of Stacks with push, pop and popAt methods. In case you have a threshold value
 * for the size of particular stack then this class will be used.
 */

package StackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Tushar on 5/21/2017.
 */
public class SetOfStacks {

    ArrayList<Stack> myList = new ArrayList<>();
    int threshold = 3;

    //This method will push a value to the top of the stack
    public void push(int data) {

        int size = myList.size();

        if(size > 0) {
            Stack obj = myList.get(size-1);
            if(obj.size() < threshold){
                obj.push(data);
                return;
            }
        }

        Stack st = new Stack();
        st.push(data);
        myList.add(st);

    }

    //This method will remove & return the top value from the stack
    public Object pop() {

        int size = myList.size();
        if(size == 0){
            throw new EmptyStackException();
        }

        Stack st = myList.get(size-1);
        Object val = st.pop();

        if (st.size() == 0){
            myList.remove(size-1);
        }
        return val;

    }

    //This method will remove & return the top value from the stack which is present on the specified index
    public Object popAt(int index) {

        int size = myList.size();
        if(size < index+1){
            throw new EmptyStackException();
        }

        Stack st = myList.get(index);
        Object val = st.pop();

        if (st.size() == 0){
            myList.remove(index);
        }
        return val;

    }


    public static void main(String[] args){

        SetOfStacks setObj = new SetOfStacks();

        setObj.push(10);
        setObj.push(20);
        setObj.push(30);
        setObj.push(40);
        setObj.push(50);
        setObj.push(60);
        setObj.push(70);

        System.out.println(setObj.pop());
        System.out.println(setObj.pop());
        System.out.println(setObj.popAt(0));
        System.out.println(setObj.pop());

    }
}
