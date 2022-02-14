package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.IdNotValidException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	public SubscriptionRepository repository;


	@Override
	public Subscription addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		Subscription subscription2 = repository.save(subscription);
		if (subscription2 != null) {
			return subscription2;
		} else {
			return null;
		}
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Subscription optional;
		try {
			optional = this.getSubscriptionById(id);
			if(optional == null) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "subscription record deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional =  repository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id does not exists");
		}
		else {
			return optional.get();
		}

	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}
