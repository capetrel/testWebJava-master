package hello.models;

/**
 * Created by capetrel on 06/06/2016.
 */
public class CounterModel {

    long count ;
    public long inc( long value )
    {
        return this.count += value ;
    }
}