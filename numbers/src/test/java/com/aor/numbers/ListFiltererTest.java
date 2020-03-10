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
    public void setup()
    {
        list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(3);
        list.add(5);
    }

    @Test
    public void filter()
    {
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(3)).thenReturn(true);
        Mockito.when(filter.accept(-1)).thenReturn(true);
        Mockito.when(filter.accept(0)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(false);

        ListFilterer filterer = new ListFilterer(list);

        List<Integer> result = filterer.filter(filter);

        List<Integer> expected = new ArrayList<>();
        expected.add(-1);
        expected.add(3);

        assertEquals(expected,result);
    }
}
