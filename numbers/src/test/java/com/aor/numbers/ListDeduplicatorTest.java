package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    private List<Integer> list,expected;

    @Before
    public void setup()
    {
        list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate2()
    {
        /*
        class ListSorterStub implements IListSorter
        {

            @Override
            public List<Integer> sort() {
                List<Integer> nums = new ArrayList<>();
                nums.add(1);
                nums.add(2);
                nums.add(2);
                nums.add(4);
                return nums;
            }
        }

         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter listSorter = Mockito.mock(IListSorter.class);
        Mockito.when(listSorter.sort()).thenReturn(expected);

        List<Integer> output = deduplicator.deduplicate(listSorter);

        assertEquals(expected,output);
    }
}