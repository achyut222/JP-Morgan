package interfaces;

import java.util.List;

import bo.EntityDetails;

public interface Settled {
	
	public void settle(List<EntityDetails> entityDetailsList);
}
