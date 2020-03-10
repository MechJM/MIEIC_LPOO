package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListFilterTest {

    @Test
    public void PositiveFilter()
    {
        PositiveFilter filter = new PositiveFilter();

        boolean result = filter.accept(3);

        assertEquals(true,result);
    }

    @Test
    public void PositiveFilter2()
    {
        PositiveFilter filter = new PositiveFilter();

        boolean result = filter.accept(-2);

        assertEquals(false,result);
    }

    @Test
    public void DivisibleFilter()
    {
        DivisibleByFilter filter = new DivisibleByFilter(2);

        boolean result = filter.accept(4);

        assertEquals(true,result);
    }

    @Test
    public void DivisibleFilter2()
    {
        DivisibleByFilter filter = new DivisibleByFilter(3);

        boolean result = filter.accept(2);

        assertEquals(false,result);
    }
}
