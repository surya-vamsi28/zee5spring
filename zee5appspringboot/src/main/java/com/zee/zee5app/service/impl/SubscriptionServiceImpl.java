package com.zee.zee5app.service.impl;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

@Component

public class SubscriptionServiceImpl implements SubscriptionService {
private static SubscriptionService service;
	
	private SubscriptionRepository subscriptionRepository;
	
	public SubscriptionServiceImpl() throws IOException{
		
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.addSubscription(subscription);
	}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.updateSubscription(id, subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		return subscriptionRepository.getAllSubscriptions();
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscriptionById(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionsDetails()
			throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getAllSubscriptionsDetails();
	}


}
