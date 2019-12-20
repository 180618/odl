package be.ac.umons;


public class AgendaEntry
{
    private Date start_time;
    private Date end_time;
    AgendaEntry( Date start_time,Date end_time)
    {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Date getEnd_time() {
        return end_time;
    }
    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
    public Date getStart_time() {
        return start_time;
    }
    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String toString(){
        return "Début : " + start_time + "\nFin : " + end_time;
    }
}

