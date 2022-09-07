package com.blocko.sample;

import java.io.File;
import java.nio.file.Files;

import com.blocko.bson.BLogger;
import com.blocko.bson.BSon;
import com.blocko.sample.model.Bitcoin;
import com.blocko.sample.model.Ethereum;
import com.blocko.sample.model.User;

public class BsonTest {

	public static void main(String[] args) {
		BSon bson = new BSon();
		try {
			File userJsonFile = new File("src/main/resources/json/User.json");
			String userJson = new String(Files.readAllBytes(userJsonFile.toPath()));
			User user = bson.parse(User.class, userJson);
			BLogger.log(user.toString());

			File bitcoinJsonFile = new File("src/main/resources/json/Bitcoin.json");
			String bitcoinJson = new String(Files.readAllBytes(bitcoinJsonFile.toPath()));
			Bitcoin bitcoin = bson.parse(Bitcoin.class, bitcoinJson);
			BLogger.log(bitcoin.toString());

			File ethereumJsonFile = new File("src/main/resources/json/Ethereum.json");
			String ethereumJson = new String(Files.readAllBytes(ethereumJsonFile.toPath()));
			Ethereum ethereum = bson.parse(Ethereum.class, ethereumJson);
			BLogger.log(ethereum.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
