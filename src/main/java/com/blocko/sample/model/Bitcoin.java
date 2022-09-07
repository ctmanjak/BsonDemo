package com.blocko.sample.model;

public class Bitcoin extends Coin {
	@Override
	public Type getType() {
		return Type.BITCOIN;
	}
}
