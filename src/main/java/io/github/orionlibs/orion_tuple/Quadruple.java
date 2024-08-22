package io.github.orionlibs.orion_tuple;

import io.github.orionlibs.orion_tuple.tasks.EqualsForQuadrupleTask;
import java.util.Arrays;
import java.util.List;

public class Quadruple<T1, T2, T3, T4> implements Tuple
{
    private T1 first;
    private T2 second;
    private T3 third;
    private T4 fourth;


    public Quadruple()
    {
    }


    public Quadruple(T1 first, T2 second, T3 third, T4 fourth)
    {
        setFirst(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
    }


    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> of()
    {
        return new Quadruple<T1, T2, T3, T4>();
    }


    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> of(T1 first, T2 second, T3 third, T4 fourth)
    {
        return new Quadruple<T1, T2, T3, T4>(first, second, third, fourth);
    }


    @Override
    public boolean isEmpty()
    {
        return getFirst() == null || getSecond() == null || getThird() == null || getFourth() == null;
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
        else if(index == 3)
        {
            return getFourth();
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
                        {getFirst(), getSecond(), getThird(), getFourth()};
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
        hash = defaultPrimeNumberForHashing * hash + getThird().hashCode();
        return defaultPrimeNumberForHashing * hash + getFourth().hashCode();
    }


    @Override
    public boolean equals(Object object)
    {
        return EqualsForQuadrupleTask.<T1, T2, T3, T4>run(this, object);
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


    public T4 getFourth()
    {
        return this.fourth;
    }


    public void setFourth(T4 fourth)
    {
        this.fourth = fourth;
    }
}