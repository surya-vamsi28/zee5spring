package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidTypeException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;
@Component
public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	static private DBUtils dbUtils = null;
public SubscriptionRepositoryImpl() throws IOException{
	DBUtils dbUtils = DBUtils.getInstance();
	}
	
	
	
	
	
	private ArrayList<Subscription> arraylist = new ArrayList<>();

	@Override
	public String addSubscription(Subscription subscription) {
		Connection connection = dbUtils.getConnection();
		String insertQuery = "insert into subscription" + "(id,sub_dop,sub_doe,sub_amount,sub_paymentmode,sub_status,sub_type,sub_autorenewal,reg_id)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1,subscription.getSub_id());
			prepStatement.setString(2,subscription.getSub_dop());
			prepStatement.setString(3,subscription.getSub_expiry());
			prepStatement.setInt(4,subscription.getSub_amount());
			prepStatement.setString(5,subscription.getSub_payment_mode());
			prepStatement.setString(6,subscription.getSub_status());
			prepStatement.setString(7,subscription.getSub_type());
			prepStatement.setString(8,subscription.getSub_autorenewal());
			prepStatement.setString(9,subscription.getReg_id());
			int result = prepStatement.executeUpdate();
			if(result > 0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "fail";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return "fail";
		
		}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbUtils.getConnection();
		String updateStatement = "update subscription SET (id=?,sub_dop=?,sub_doe=?,sub_amount=?,sub_paymentmode=?,sub_status=?,sub_type=?,sub_autorenewal=?,reg_id=? where id = ?" ;
		try {
			PreparedStatement prepStatement = connection.prepareStatement(updateStatement);
			prepStatement.setString(1,subscription.getSub_id());
			prepStatement.setString(2,subscription.getSub_dop());
			prepStatement.setString(3,subscription.getSub_expiry());
			prepStatement.setInt(4,subscription.getSub_amount());
			prepStatement.setString(5,subscription.getSub_payment_mode());
			prepStatement.setString(6,subscription.getSub_status());
			prepStatement.setString(7,subscription.getSub_type());
			prepStatement.setString(8,subscription.getSub_autorenewal());
			prepStatement.setString(9,subscription.getReg_id());
			prepStatement.setString(10, id);
			int result = prepStatement.executeUpdate();
			if(result > 0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "fail";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return "fail";
		
		}
		
		


	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from subscription where id=?";
		connection = dbUtils.getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
			
				Subscription subscription = new Subscription();
				subscription.setSub_id(resultset.getString("id"));
				subscription.setSub_amount(resultset.getInt("sub_amount"));
				subscription.setStatus(resultset.getString("sub_status"));
				subscription.setSub_autorenewal(resultset.getString("sub_autorenewal"));
				subscription.setSub_dop(resultset.getString("sub_dop"));
				subscription.setSub_expiry(resultset.getString("sub_doe"));
				subscription.setSub_id(resultset.getString("id"));
				subscription.setStatus(resultset.getString("sub_status"));
				subscription.setSub_payment_mode(resultset.getString("sub_paymentmode"));
				subscription.setSub_type(resultset.getString("sub_type"));
				subscription.setReg_id(resultset.getString("reg_id"));
				
				return Optional.of(subscription);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
		return null;
		
		
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionsDetails() throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from subscription";
		connection = dbUtils.getConnection();
		List<Subscription> arraylist = new ArrayList<>(); 
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
			
				Subscription subscription = new Subscription();
				subscription.setSub_id(resultset.getString("id"));
				subscription.setSub_amount(resultset.getInt("sub_amount"));
				subscription.setStatus(resultset.getString("sub_status"));
				subscription.setSub_autorenewal(resultset.getString("sub_autorenewal"));
				subscription.setSub_dop(resultset.getString("sub_dop"));
				subscription.setSub_expiry(resultset.getString("sub_doe"));
				subscription.setSub_id(resultset.getString("id"));
				subscription.setStatus(resultset.getString("sub_status"));
				subscription.setSub_payment_mode(resultset.getString("sub_paymentmode"));
				subscription.setSub_type(resultset.getString("sub_type"));
				subscription.setReg_id(resultset.getString("reg_id"));
				arraylist.add(subscription);
				
			}
			return Optional.ofNullable(arraylist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
		
		
		
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbUtils.getConnection();
		String deleteStatement = "delete from subscription where id = ?";
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			int result = preparedStatement.executeUpdate();
			if(result > 0 ) {
				connection.commit();
				return "success";
				
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		return "success";
	}

	@Override
	public Subscription[] getAllSubscriptions()
			throws InvalidIdLengthException, InvalidAmountException, InvalidTypeException {
Optional<List<Subscription>> optional = getAllSubscriptionsDetails();
		
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Subscription> list = optional.get();
			Subscription[] subscription = new Subscription[list.size()];
			return list.toArray(subscription);
		}

	}

}
