import java.util.ArrayList;
import java.util.List;

public class BoxOffice {


    public static List<Ticket> buy(Concert concert,int num) throws InvalidTicket
    {
        List<Ticket> result = new ArrayList<>();
        for (int i=0;i<num;i++)
        {
            result.add(new Ticket(concert.lastTicketNum,concert));
            concert.incrementTicketNum();
        }
        return result;
    }
}
