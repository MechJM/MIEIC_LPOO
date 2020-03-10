package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private Integer num;

    DivisibleByFilter(Integer num)
    {
        this.num = num;
    }

    @Override
    public boolean accept(Integer number) {
        if (number % num == 0) return true;
        else return false;
    }
}
