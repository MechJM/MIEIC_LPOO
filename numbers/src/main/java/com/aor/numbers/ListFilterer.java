package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private List<Integer> list;

    ListFilterer(List<Integer> list)
    {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter)
    {
        List<Integer> result = new ArrayList<>();

        for (Integer i: list)
        {
            if (filter.accept(i)) result.add(i);
        }
        return result;
    }
}
