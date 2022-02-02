package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException, InvalidTypeException;
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException;
	public String deleteSubscriptionById(String id) throws IdNotFoundException;
	public Optional<List<Subscription>> getAllSubscriptionsDetails()
			throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException;
	


}
