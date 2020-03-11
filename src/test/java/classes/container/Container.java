package classes.container;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Container<T> {
    private final ArrayList<T> ListOfEntities;

    protected Container() {
        ListOfEntities = new ArrayList<>();
    }

    public void Add(T element)
    {
        ListOfEntities.add(element);
    }

    public int getLength(){return ListOfEntities.size();}

    protected ArrayList<T> findWhere (Predicate<T>... conditions)
    {
        ArrayList<T> result = new ArrayList<>();
        for (T entity:ListOfEntities) {
            boolean flag = true;
            for (Predicate<T> condition: conditions) {
                flag = flag && condition.test(entity);
            }
            if(flag){result.add(entity);}
        }
        return result;
    }

    protected <E> ArrayList<E> getListOf (Function<T,E> function)
    {
        ArrayList<E> result = new ArrayList<>();
        for (T entity:ListOfEntities) {
            E e = function.apply(entity);
            if(!result.contains(e))
            {
                result.add(e);
            }
        }
        return result;
    }

    protected <E> ArrayList<T> sortByAscending(Function<T,E> function)
    {
        ArrayList<T> sortedArray = new ArrayList<>(ListOfEntities);
        sortedArray.sort(Comparator.comparing(o -> (function.apply(o)).toString()));
        return sortedArray;
    }

    protected <E> ArrayList<T> sortByDescending(Function<T,E> function)
    {
        ArrayList<T> sortedArray = new ArrayList<>(ListOfEntities);
        sortedArray.sort((o1, o2) -> {
            int compareResult = (function.apply(o1)).toString().compareTo(function.apply(o2).toString());
            return Integer.compare(0, compareResult);
        });
        return sortedArray;
    }
}
