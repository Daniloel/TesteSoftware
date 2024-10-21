package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<numeros extends Number> {

    private CustomStack<numeros> stack;

    public NumberAscOrder(CustomStack<numeros> stack) {
        this.stack = stack;
    }

    public CustomStack<numeros> getStack() {
        return this.stack;
    }

    public List<numeros> sort() throws StackEmptyException {

        if (stack.isEmpty()) {
            return Collections.emptyList();
        }

        List<numeros> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        Collections.sort(list, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));


        return list;
    }


}
