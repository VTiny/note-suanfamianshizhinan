package ch1_stack_queue;

import java.util.Stack;

/**
 * 题目：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 * 1. pop、push、getMin操作的时间复杂度都是O(1)
 * 2. 设计的栈的类型可以使用现成的栈结构
 * <p>
 * Created by pokerface_lx on 16/8/8.
 */
public class _01_StackWithGetMin {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public _01_StackWithGetMin() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer num) {
        dataStack.push(num);
        if (minStack.isEmpty()) {
            minStack.push(num);
        } else {
            if (num <= getMin()) {
                minStack.push(num);
            }
        }
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("ur stack is empty");
        }
        int value = dataStack.pop();
        if (value == getMin()) {
            minStack.pop();
        }
        return value;
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("ur stack is empty");
        }
        return minStack.peek();
    }

}
