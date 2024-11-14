package com.tunehub.services;

import com.tunehub.entities.Users;

public interface UsersService 
{
	public String addUsers(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email , String password);
	public String getRole(String email);

}
