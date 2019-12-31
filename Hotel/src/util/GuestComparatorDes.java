package util;

import java.util.Comparator;

import entities.Guest;

public class GuestComparatorDes implements Comparator<Guest>{
	
	@Override
	public int compare(Guest g1 , Guest g2)
	{
		if(g1.getId()<g2.getId())
		{
			return 1;
		}
		else if(g1.getId()>g2.getId())
		{
			return -1;
		}
		return 0;
	}

}
