package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NumberAscOrderTest {

    private CustomStack<Integer> mockStack;
    private NumberAscOrder<Integer> numberAscOrder;

    // Inicializa o mock e a instância de NumberAscOrder antes de cada teste
    @BeforeEach
    public void setUp() {
        // Cria o mock da CustomStack
        mockStack = Mockito.mock(CustomStack.class);
        // Inicializa a classe sob teste com o mock
        numberAscOrder = new NumberAscOrder<>(mockStack);
    }

    @Test
    public void testSortWithFilledStack() {
        // Simula o comportamento da pilha com 6 números aleatórios
        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop()).thenReturn(15, 5, 30, 7, 20, 10);

        // Executa o método sort() e captura a lista ordenada
        List<Integer> sortedList = numberAscOrder.sort();

        // Verifica se a lista está ordenada corretamente
        assertEquals(List.of(5, 7, 10, 15, 20, 30), sortedList);

        // Verifica se pop() foi chamado 6 vezes
        verify(mockStack, times(6)).pop();
        // Verifica se isEmpty() foi chamado
        verify(mockStack, times(7)).isEmpty();
    }

    @Test
    public void testSortWithEmptyStack() {
        // Simula o comportamento de uma pilha vazia
        when(mockStack.isEmpty()).thenReturn(true);

        // Verifica se o método lança a exceção correta
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            numberAscOrder.sort();
        });

        // Verifica a mensagem da exceção
        assertEquals("A pilha está vazia ou não inicializada.", exception.getMessage());

        // Verifica se isEmpty() foi chamado uma vez
        verify(mockStack, times(1)).isEmpty();
    }
}
