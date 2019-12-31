package service;

import java.util.Set;

import dao.IGuestDao;
import entities.Guest;
import exceptions.IdIncorrectException;

public class GuestServiceImpl implements IGuestService {
	
	private IGuestDao dao;
	public GuestServiceImpl(IGuestDao dao) {
		this.dao = dao;
	}

	@Override
	public void addGuest(Guest g) {

		dao.addGuest(g);
	}

	@Override
	public Guest findGuestById(int id) {

		if(id<0)
		{
			throw new IdIncorrectException("id incorrect");
		}
		
		Guest g = dao.findGuestById(id);
		return g;
	}

	@Override
	public Set<Guest> allGuest() {

		Set<Guest> guests = dao.allGuest();
	
		return guests;
	}
	
	
	@Override
	public Set<Guest> allGuestInOrder(boolean order)
	{
		Set<Guest> guests = dao.allGuestInOrder(order);
		return guests;
	}

}
