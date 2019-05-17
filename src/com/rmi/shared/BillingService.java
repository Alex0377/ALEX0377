package com.rmi.shared;

import java.rmi.*;


public interface BillingService extends Remote
{

	public void addNewCostomer(СustomerCard card) throws RemoteException;


	public void addinfoCostomer(СustomerCard card) throws RemoteException;


	public void subinfoCostomer(СustomerCard card) throws RemoteException;


	public void getCardinfo(СustomerCard card) throws RemoteException;  
}
