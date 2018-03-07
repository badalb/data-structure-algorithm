package com.test.concurrency;

public class UserService {

	public static User getUserDetails(String userId) {
		User user = new User("Badal", "Baidya", 10.00D, userId);
		return user;
	}

}
