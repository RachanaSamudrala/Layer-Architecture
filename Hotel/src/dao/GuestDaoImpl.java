package dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import entities.Guest;
import exceptions.GuestNotFoundException;
import util.GuestComparator;
import util.GuestComparatorDes;

public class GuestDaoImpl implements IGuestDao {
	
	Map<Integer , Guest> store = new TreeMap<>();

	@Override
	public void addGuest(Guest g) {

		store.put(g.getId(), g);
	}

	@Override
	public Guest findGuestById(int id) {

		Guest g = store.get(id);
		if(g == null)
		{
			throw new GuestNotFoundException("guest not found");
		}
		
		return g;
	}

	@Override
	public Set<Guest> allGuest() {

		Collection<Guest> guests = store.values();
		Set<Guest> guestSet = new HashSet<>(guests);
		return guestSet;
	}
	
	@Override
	
	public Set<Guest> allGuestInOrder(boolean order)
	{
		GuestComparator asc = new GuestComparator();
		GuestComparatorDes des = new GuestComparatorDes();
		Collection<Guest> guests = store.values();
		
		if(order)
		{
			Set<Guest> set = new TreeSet<Guest>(asc);
			set.addAll(guests);
			return set;
		}
		
	
			Set<Guest> set = new TreeSet<Guest>(des);
			set.addAll(guests);
			return set;
		
	}

}
