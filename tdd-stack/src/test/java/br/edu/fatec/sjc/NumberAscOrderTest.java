package br.edu.fatec.sjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NumberAscOrderTest {
    @Test
    public void testSortWithNumbersInStack() throws StackEmptyException {
        // Criação do mock da pilha
        CustomStack<Number> customStackMock = mock(CustomStack.class);

        // Configuração do comportamento do mock
        when(customStackMock.isEmpty()).thenReturn(false, false, false, false, false, false,false, true);
        when(customStackMock.pop()).thenReturn(120, 110, 100, 90, 80, 60); // Ordem invertida

        // Instancia a classe a ser testada
        NumberAscOrder<Number> numberAscOrder = new NumberAscOrder<>(customStackMock);

        // Executa o método de ordenação
        List<Number> sortedNumbers = numberAscOrder.sort();

        // Verifica o tamanho da lista retornada
        assertEquals(6, sortedNumbers.size());

        // Verifica a ordem dos números
        assertEquals(60, sortedNumbers.get(0));
        assertEquals(80, sortedNumbers.get(1));
        assertEquals(90, sortedNumbers.get(2));
        assertEquals(100, sortedNumbers.get(3));
        assertEquals(110, sortedNumbers.get(4));
        assertEquals(120, sortedNumbers.get(5));
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        CustomStack<Number> customStackMock = mock(CustomStack.class);
        when(customStackMock.isEmpty()).thenReturn(true);

        NumberAscOrder numberAscOrder = new NumberAscOrder(customStackMock);
        List<Integer> sortedNumbers = numberAscOrder.sort();

        assertTrue(sortedNumbers.isEmpty());
    }
}