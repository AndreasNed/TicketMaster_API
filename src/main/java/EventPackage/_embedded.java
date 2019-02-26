package EventPackage;

public class _embedded
{
    private Events[] events;

    public Events[] getEvents ()
    {
        return events;
    }

    public void setEvents (Events[] events)
    {
        this.events = events;
    }

    @Override
    public String toString()
    {
        return "[events = "+events+"]";
    }
}