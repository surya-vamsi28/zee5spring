package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;
@Component
public class SubscriptionServiceImpl implements SubscriptionService {


	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	private SubscriptionServiceImpl() {
		
	}

	@Override
	public String addSubscription(Subscription subscription) {
		Subscription subscription2 =  subscriptionRepository.save(subscription);
		
		if(subscription2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}
		                   
	}

	@Override
	public String updateSubscription(String id, Subscription subscription)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, 
			InvalidIdLengthException {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
		
	}

	@Override
	public Subscription[] getAllSubscriptions()
			throws InvalidIdLengthException{
		// TODO Auto-generated method stub
		
		List<Subscription> subscription1 = subscriptionRepository.findAll();
		Subscription[] array = new Subscription[subscription1.size()];
		return subscription1.toArray(array);
		
	}

	@Override
	public String deleteSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
			Optional<Subscription> optional;
			try {
				optional = this.getSubscriptionById(id);
				if(optional.isEmpty()) {
					throw new IdNotFoundException("record not found");
				}
				else {
					subscriptionRepository.deleteById(id);
					return "Success";
				}
			} catch (IdNotFoundException | InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}


	@Override
	public Optional<List<Subscription>> getAllSubscriptionsDetails()
			throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

	

	

}
