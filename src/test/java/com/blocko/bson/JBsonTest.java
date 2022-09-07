package com.blocko.bson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.blocko.sample.model.Bitcoin;
import com.blocko.sample.model.Ethereum;
import com.blocko.sample.model.User;

class JBsonTest {
	@Test
	void testUser() {
		BSon bson = new BSon();
		String testData = "{\"name\":\"blocko\",\"age\":5,\"addr\":\"Seoul\"}";
		try {
			User user = bson.parse(User.class, testData);
			assertEquals("blocko", user.name);
			assertEquals(5, user.age);
			assertEquals("Seoul", user.addr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testBitcoin() {
		BSon bson = new BSon();
		String testData = "{\"from\":\"alice\",\"to\":\"bob\",\"addr\":\"addr bitcoin blur blur\"}";
		try {
			Bitcoin model = bson.parse(Bitcoin.class, testData);
			assertEquals("alice", model.from);
			assertEquals("bob", model.to);
			assertEquals("addr bitcoin blur blur", model.addr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testEthereum() {
		BSon bson = new BSon();
		String testData = "{\"from\":\"foo\",\"to\":\"bar\",\"addr\":\"addr ethereum blur blur\"}";
		try {
			Ethereum model = bson.parse(Ethereum.class, testData);
			assertEquals("foo", model.from);
			assertEquals("bar", model.to);
			assertEquals("addr ethereum blur blur", model.addr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}