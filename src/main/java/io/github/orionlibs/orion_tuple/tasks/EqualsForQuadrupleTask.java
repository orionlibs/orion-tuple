package io.github.orionlibs.orion_tuple.tasks;

import io.github.orionlibs.orion_stream.OrionArrays;
import io.github.orionlibs.orion_tuple.Quadruple;
import java.util.Arrays;

public class EqualsForQuadrupleTask
{
    @SuppressWarnings("unchecked")
    public static <T1, T2, T3, T4> boolean run(Object object1, Object object2)
    {
        if(object2 == null || object1.getClass() != object2.getClass())
        {
            return false;
        }
        else
        {
            Quadruple<T1, T2, T3, T4> thisObject = (Quadruple<T1, T2, T3, T4>)object1;
            Quadruple<T1, T2, T3, T4> other = (Quadruple<T1, T2, T3, T4>)object2;
            boolean areFirstEqual = false;
            boolean areSecondEqual = false;
            boolean areThirdEqual = false;
            boolean areFourthEqual = false;
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
            if(thisObject.getFourth().getClass().isArray() && other.getFourth().getClass().isArray())
            {
                Object[] fourthAsObjects = OrionArrays.getAsArrayOfObjects((T1[])thisObject.getFourth());
                Object[] otherFourthAsObjects = OrionArrays.getAsArrayOfObjects((T1[])other.getFourth());
                areFourthEqual = Arrays.equals(fourthAsObjects, otherFourthAsObjects);
            }
            else
            {
                areFourthEqual = thisObject.getFourth().equals(other.getFourth());
            }
            return areFirstEqual && areSecondEqual && areThirdEqual && areFourthEqual;
        }
    }
}