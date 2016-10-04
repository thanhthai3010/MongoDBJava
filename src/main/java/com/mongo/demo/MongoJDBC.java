package com.mongo.demo;

import com.google.common.collect.Lists;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoJDBC {

	public static void main(String[] args) {
		try {

			// hello

			MongoClientOptions mongoOptions = new MongoClientOptions.Builder().minConnectionsPerHost(1)
					.socketTimeout(15000).connectTimeout(10000).build();

			char[] password = new char[] {};

			MongoCredential credential = MongoCredential.createCredential("12", "test_java", password);

			MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27107),
					Lists.newArrayList(credential), mongoOptions);

			MongoDatabase database = mongoClient.getDatabase("test_java");
			System.out.println("Connect to database sucsessfully");

			MongoCollection<Document> collect = database.getCollection("information");

			System.out.println(collect.count());

			mongoClient.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
