package io.github.orionlibs.orion_tuple;

import io.github.orionlibs.orion_tuple.tasks.EqualsForPairTask;
import java.util.Arrays;
import java.util.List;

public class Pair<T1, T2> implements Tuple
{
    private T1 first;
    private T2 second;


    public Pair()
    {
    }


    public Pair(T1 first, T2 second)
    {
        setFirst(first);
        setSecond(second);
    }


    public static <T1, T2> Pair<T1, T2> of()
    {
        return new Pair<T1, T2>();
    }


    public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second)
    {
        return new Pair<T1, T2>(first, second);
    }


    public Pair<T2, T1> reversePair()
    {
        return Pair.<T2, T1>of(second, first);
    }


    @Override
    public boolean isEmpty()
    {
        return getFirst() == null || getSecond() == null;
    }


    @Override
    public Object get(int index)
    {
        if(index == 0)
        {
            return getFirst();
        }
        else if(index == 1)
        {
            return getSecond();
        }
        else
        {
            return null;
        }
    }


    @Override
    public Object[] getAsArray()
    {
        return new Object[]
                        {getFirst(), getSecond()};
    }


    @Override
    public List<Object> getAsList()
    {
        return Arrays.asList(getAsArray());
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + getFirst().hashCode();
        return defaultPrimeNumberForHashing * hash + getSecond().hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return EqualsForPairTask.<T1, T2>run(this, object);
    }


    public T1 getFirst()
    {
        return this.first;
    }


    public void setFirst(T1 first)
    {
        this.first = first;
    }


    public T2 getSecond()
    {
        return this.second;
    }


    public void setSecond(T2 second)
    {
        this.second = second;
    }
}