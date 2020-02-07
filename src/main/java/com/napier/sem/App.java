package com.napier.sem;


import com.mongodb.MongoClient;	import java.sql.*;
import com.mongodb.client.MongoDatabase;	
import com.mongodb.client.MongoCollection;	public class App {
import org.bson.Document;	


public class App	
{	
    public static void main(String[] args)	    public static void main(String[] args)
    {	    {
        // Connect to MongoDB on local system - we're using port 27000	        // Create new Application
        MongoClient mongoClient = new MongoClient("localhost", 27000);	        App a = new App();
        // Get a database - will create when we use it	
        MongoDatabase database = mongoClient.getDatabase("mydb");	        // Connect to database
        // Get a collection from the database	        a.connect();
        MongoCollection<Document> collection = database.getCollection("test");	
        // Create a document to store	        // Disconnect from database
        Document doc = new Document("name", "George Washington")	        a.disconnect();
                .append("class", "Presidenting Methods")	    }
                .append("year", "1789")	
                .append("result", new Document("CW", 75).append("EX", 90));	    //Create a connection to MySQL database
        // Add document to collection	    private Connection con = null;
        collection.insertOne(doc);	

     //Connect to the MySQL database.
        // Check document in collection	    public void connect() {
        Document myDoc = collection.find().first();	        try {
        System.out.println(myDoc.toJson());	            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("The SQL driver couldn't be loaded...");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Connection was a success!");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to the database. (Attempt: " + Integer.toString(i) + ")" );
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted...");
            }
        }
    }


     //Disconnect from the MySQL database.
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("ERORR: During closing of the connection to the database");
            }
        }
    }	    }
} 	} 
