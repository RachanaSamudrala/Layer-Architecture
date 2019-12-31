package UI;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import dao.GuestDaoImpl;
import entities.Guest;
import exceptions.GuestNotFoundException;
import exceptions.IdIncorrectException;
import service.GuestServiceImpl;
import service.IGuestService;
import util.GuestComparator;

public class GuestUi {

	private IGuestService service = new GuestServiceImpl(new GuestDaoImpl());
	
	GuestComparator comparator = new GuestComparator();
	
	public static void main(String[] args)
	{
		GuestUi ui = new GuestUi();
		ui.execute();
		
	}
	
	public void execute()
	{
		try {
		Guest g1 = new Guest(1, "rachana");
		Guest g2 = new Guest(2, "alekya");
		Guest g3 = new Guest(3, "harika");
		
		service.addGuest(g1);
		service.addGuest(g2);
		service.addGuest(g3);
		
		Guest fetched1 = service.findGuestById(2);
		Guest fetched2 = service.findGuestById(3);
		
		System.out.println(fetched1.getName());
		System.out.println(fetched2.getName());
		
		System.out.println("***** prinitng all guests in ascending order *****");
		Set<Guest> guests1 = service.allGuestInOrder(true);
		printin(guests1);
		
		System.out.println("***** prinitng all guests in descending order *****");
		Set<Guest> guests2 = service.allGuestInOrder(false);
		printin(guests2);
		
		System.out.println("***** prinitng all guests *****");
		Set<Guest> guests3 = service.allGuest();
		print(guests3);
		
		}
		catch(GuestNotFoundException e) {
			System.out.println("guest not found");
		}
		catch(IdIncorrectException e) {
			System.out.println("incorrect id");
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("something went wrong");
		}
		
	}
	
	void print(Collection<Guest> guests)
	{
		Set<Guest> guestset = new TreeSet<>(comparator);
		guestset.addAll(guests);
		for(Guest g : guests)
		{
			System.out.println(g.getId()+" "+g.getName());
		}
	}
	
	void printin (Collection<Guest> guests)
	{
		for(Guest g : guests)
		{
			System.out.println(g.getId() + " " + g.getName());
		}
	}
	
}
