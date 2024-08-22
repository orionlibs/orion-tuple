package io.github.orionlibs.orion_tuple;

import io.github.orionlibs.orion_tuple.tasks.EqualsForSingleTask;
import java.util.Arrays;
import java.util.List;

public class Single<T1> implements Tuple
{
    private T1 first;


    public Single()
    {
    }


    public Single(T1 first)
    {
        setFirst(first);
    }


    public static <T1> Single<T1> of()
    {
        return new Single<T1>();
    }


    public static <T1> Single<T1> of(T1 first)
    {
        return new Single<T1>(first);
    }


    @Override
    public boolean isEmpty()
    {
        return getFirst() == null;
    }


    @Override
    public Object get(int index)
    {
        return (index == 0) ? getFirst() : null;
    }


    @Override
    public Object[] getAsArray()
    {
        return new Object[]
                        {getFirst()};
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
        return defaultPrimeNumberForHashing * hash + getFirst().hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return EqualsForSingleTask.<T1>run(this, object);
    }


    public T1 getFirst()
    {
        return this.first;
    }


    public void setFirst(T1 first)
    {
        this.first = first;
    }
}