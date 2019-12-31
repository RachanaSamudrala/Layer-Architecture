package service;

import java.util.Set;

import entities.Guest;

public interface IGuestService {

	void addGuest(Guest g);
	
	Guest findGuestById(int id);
	
	Set<Guest> allGuest();
	
	Set<Guest> allGuestInOrder(boolean order);
	
	
}

