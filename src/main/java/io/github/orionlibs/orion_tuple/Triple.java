package io.github.orionlibs.orion_tuple;

import io.github.orionlibs.orion_tuple.tasks.EqualsForTripleTask;
import java.util.Arrays;
import java.util.List;

public class Triple<T1, T2, T3> implements Tuple
{
    private T1 first;
    private T2 second;
    private T3 third;


    public Triple()
    {
    }


    public Triple(T1 first, T2 second, T3 third)
    {
        setFirst(first);
        setSecond(second);
        setThird(third);
    }


    public static <T1, T2, T3> Triple<T1, T2, T3> of()
    {
        return new Triple<T1, T2, T3>();
    }


    public static <T1, T2, T3> Triple<T1, T2, T3> of(T1 first, T2 second, T3 third)
    {
        return new Triple<T1, T2, T3>(first, second, third);
    }


    @Override
    public boolean isEmpty()
    {
        return getFirst() == null || getSecond() == null || getThird() == null;
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
        else if(index == 2)
        {
            return getThird();
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
                        {getFirst(), getSecond(), getThird()};
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
        hash = defaultPrimeNumberForHashing * hash + getSecond().hashCode();
        return defaultPrimeNumberForHashing * hash + getThird().hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return EqualsForTripleTask.<T1, T2, T3>run(this, object);
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


    public T3 getThird()
    {
        return this.third;
    }


    public void setThird(T3 third)
    {
        this.third = third;
    }
}