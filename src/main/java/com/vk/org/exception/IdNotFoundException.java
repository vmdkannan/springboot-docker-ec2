package com.vk.org.exception;


public class IdNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

    public IdNotFoundException(int id) {
        super("Requested ID "+id+" not found.");
    }

}
