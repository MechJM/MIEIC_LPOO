package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class ListFiltererTest {
    private List<Integer> list;

    @Before
    private void setup()
    {
        list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(3);
        list.add(5);
    }

    @Test
    public void filterPositive()
    {
        PositiveFilter posFilter = Mockito.mock(PositiveFilter.class);
        Mockito.when(posFilter.accept(-1)).thenReturn(false);
        Mockito.when(posFilter.accept(0)).thenReturn(false);
        Mockito.when(posFilter.accept(3)).thenReturn(true);
        Mockito.when(posFilter.accept(5)).thenReturn(true);

        ListFilterer filterer = new ListFilterer(list);

        List<Integer> result = filterer.filter(posFilter);

        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);

        assertEquals(expected,result);
    }

    @Test
    public void filterDivisible()
    {
        DivisibleByFilter divFilter = Mockito.mock(DivisibleByFilter.class);
        Mockito.when(divFilter.accept(-1)).thenReturn(false);
        Mockito.when(divFilter.accept(0)).thenReturn(true);
        Mockito.when(divFilter.accept(3)).thenReturn(false);
        Mockito.when(divFilter.accept(5)).thenReturn(false);

        ListFilterer filterer = new ListFilterer(list);
        List<Integer> result = filterer.filter(divFilter);

        List<Integer> expected = new ArrayList<>();
        expected.add(0);

        assertEquals(expected,result);
    }
}
