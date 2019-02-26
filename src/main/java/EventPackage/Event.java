package EventPackage;

public class Event
{
    private _embedded _embedded;

    public _embedded get_embedded ()
    {
        return _embedded;
    }

    public void set_embedded (_embedded _embedded)
    {
        this._embedded = _embedded;
    }

    @Override
    public String toString()
    {
        return "EventClass [_embedded = "+_embedded+"]";
    }
}