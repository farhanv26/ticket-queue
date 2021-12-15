public class Ticket {

  //declaring a variable for the ticket number
  private int ticketNum;

  //relate ticket number to constructor
  public Ticket(int ticketNum) {
    this.ticketNum = ticketNum;
  }

  //declaring a get variable to return the ticket number
  public int getTicketNum() {
    return ticketNum;
  }

  //incrementing the ticket number whenever the person is added to the back of the queue
  public void incrementTicketNum() {
    this.ticketNum++;
  }

}
