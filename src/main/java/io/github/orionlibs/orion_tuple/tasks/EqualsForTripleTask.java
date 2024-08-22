package io.github.orionlibs.orion_tuple.tasks;

import io.github.orionlibs.orion_stream.OrionArrays;
import io.github.orionlibs.orion_tuple.Triple;
import java.util.Arrays;

public class EqualsForTripleTask
{
    @SuppressWarnings("unchecked")
    public static <T1, T2, T3> boolean run(Object object1, Object object2)
    {
        if(object2 == null || object1.getClass() != object2.getClass())
        {
            return false;
        }
        else
        {
            Triple<T1, T2, T3> thisObject = (Triple<T1, T2, T3>)object1;
            Triple<T1, T2, T3> other = (Triple<T1, T2, T3>)object2;
            boolean areFirstEqual = false;
            boolean areSecondEqual = false;
            boolean areThirdEqual = false;
            if(thisObject.getFirst().getClass().isArray() && other.getFirst().getClass().isArray())
            {
                Object[] firstAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getFirst());
                Object[] otherFirstAsObjects = OrionArrays.getAsArrayOfObjects((T1[])other.getFirst());
                areFirstEqual = Arrays.equals(firstAsObjects, otherFirstAsObjects);
            }
            else
            {
                areFirstEqual = thisObject.getFirst().equals(other.getFirst());
            }
            if(thisObject.getSecond().getClass().isArray() && other.getSecond().getClass().isArray())
            {
                Object[] secondAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getSecond());
                Object[] otherSecondAsObjects = OrionArrays.getAsArrayOfObjects((T1[])other.getSecond());
                areSecondEqual = Arrays.equals(secondAsObjects, otherSecondAsObjects);
            }
            else
            {
                areSecondEqual = thisObject.getSecond().equals(other.getSecond());
            }
            if(thisObject.getThird().getClass().isArray() && other.getThird().getClass().isArray())
            {
                Object[] thirdAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getThird());
                Object[] otherThirdAsObjects = OrionArrays.getAsArrayOfObjects((T1[])other.getThird());
                areThirdEqual = Arrays.equals(thirdAsObjects, otherThirdAsObjects);
            }
            else
            {
                areThirdEqual = thisObject.getThird().equals(other.getThird());
            }
            return areFirstEqual && areSecondEqual && areThirdEqual;
        }
    }
}