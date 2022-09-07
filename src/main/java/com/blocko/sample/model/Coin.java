package com.blocko.sample.model;

public abstract class Coin extends BaseModel {
	enum Type {
		NONE, BITCOIN, ETHEREUM
	}

	public abstract Type getType();

	public String addr;
	public String from;
	public String to;
}
