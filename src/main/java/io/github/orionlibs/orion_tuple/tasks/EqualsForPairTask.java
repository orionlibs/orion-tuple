package io.github.orionlibs.orion_tuple.tasks;

import io.github.orionlibs.orion_stream.OrionArrays;
import io.github.orionlibs.orion_tuple.Pair;
import java.util.Arrays;

public class EqualsForPairTask
{
    @SuppressWarnings("unchecked")
    public static <T1, T2> boolean run(Object object1, Object object2)
    {
        if(object2 == null || object1.getClass() != object2.getClass())
        {
            return false;
        }
        else
        {
            Pair<T1, T2> thisObject = (Pair<T1, T2>)object1;
            Pair<T1, T2> otherPair = (Pair<T1, T2>)object2;
            boolean areFirstEqual = false;
            boolean areSecondEqual = false;
            if(thisObject.getFirst().getClass().isArray() && otherPair.getFirst().getClass().isArray())
            {
                Object[] firstAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getFirst());
                Object[] otherFirstAsObjects = OrionArrays.getAsArrayOfObjects((T1[])otherPair.getFirst());
                areFirstEqual = Arrays.equals(firstAsObjects, otherFirstAsObjects);
            }
            else
            {
                areFirstEqual = thisObject.getFirst().equals(otherPair.getFirst());
            }
            if(thisObject.getSecond().getClass().isArray() && otherPair.getSecond().getClass().isArray())
            {
                Object[] secondAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getSecond());
                Object[] otherSecondAsObjects = OrionArrays.getAsArrayOfObjects((T1[])otherPair.getSecond());
                areSecondEqual = Arrays.equals(secondAsObjects, otherSecondAsObjects);
            }
            else
            {
                areSecondEqual = thisObject.getSecond().equals(otherPair.getSecond());
            }
            return areFirstEqual && areSecondEqual;
        }
    }
}