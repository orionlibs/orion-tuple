package io.github.orionlibs.orion_tuple;

import io.github.orionlibs.orion_assert.Assert;
import io.github.orionlibs.orion_tuple.tasks.EqualsForNTupleTask;
import java.util.Arrays;
import java.util.List;

public class NTuple implements Tuple
{
    private Object[] elements;


    public NTuple()
    {
    }


    public NTuple(Object[] elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        this.elements = elements;
    }


    public NTuple(List<Object> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        this.elements = elements.toArray();
    }


    public static NTuple of()
    {
        return new NTuple();
    }


    public static NTuple of(Object[] elements)
    {
        return new NTuple(elements);
    }


    public static NTuple of(List<Object> elements)
    {
        return new NTuple(elements);
    }


    @Override
    public boolean isEmpty()
    {
        return getElements().length == 0;
    }


    @Override
    public Object get(int index)
    {
        return getElements()[index];
    }


    @Override
    public Object[] getAsArray()
    {
        return getElements();
    }


    @Override
    public List<Object> getAsList()
    {
        return Arrays.asList(getAsArray());
    }


    public int getSize()
    {
        return getElements().length;
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + Arrays.hashCode(getElements());
    }


    @Override
    public boolean equals(Object object)
    {
        return EqualsForNTupleTask.run(this, object);
    }


    public Object[] getElements()
    {
        return this.elements;
    }
}