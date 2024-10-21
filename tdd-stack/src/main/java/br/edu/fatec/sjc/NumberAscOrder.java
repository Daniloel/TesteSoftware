package br.edu.fatec.sjc;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<E extends Number> {

    private CustomStack<E> stack;

    public NumberAscOrder(CustomStack<E> stack) {
        this.stack = stack;
    }

    public CustomStack<E> getStack() {
        return this.stack;
    }

    // Método sort() que retorna uma lista com os elementos em ordem crescente
    public List<E> sort() {
        // Verifica se a pilha está vazia
        if (stack == null || stack.isEmpty()) {
            throw new IllegalStateException("A pilha está vazia ou não inicializada.");
        }

        // Cria uma lista temporária para armazenar os elementos da pilha
        List<E> sortedList = new ArrayList<>();

        // Transfere os elementos da pilha para a lista temporária
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }

        // Ordena a lista
        Collections.sort(sortedList, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));

        // Retorna a lista ordenada
        return sortedList;
    }