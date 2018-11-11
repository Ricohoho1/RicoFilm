package ricohoho.mongo;

import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.DBCursor;

public class MongoManager {

	
	MongoClient mongoClient = null;
	String dbMongoName="";
	MongoClient mongo =null;
	DB db = null;
	
	public MongoManager(String dbMongoName) {
		this.dbMongoName=dbMongoName;
		this.mongo = new MongoClient("192.168.1.10", 27017);
		this.db = mongo.getDB(dbMongoName);
	}
	
	
	public String insertJSON(String collectionName,DBObject  _DBObject) {
		String sreturn=null; 
		try {
			 DBCollection table = this.db.getCollection(collectionName);
			 table.insert(_DBObject);
			 //System.out.println("_DBObject="+_DBObject.get( "_id" ));
			 sreturn =_DBObject.get( "_id" ).toString();
		    //} catch (UnknownHostException e) {
			//e.printStackTrace();
		 } catch (MongoException e) {
			e.printStackTrace();
		 }
		return sreturn;
	}
	
	//return lenb de ligne qui match
	public int selectDB(String collectionName, BasicDBObject whereQuery ,BasicDBObject fields) {			  
		    DBCollection table = this.db.getCollection(collectionName);
		    DBCursor cursor = table.find(whereQuery, fields);
		    int i_i= 0;
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next());
		        i_i++;
		    }
		    return i_i;
	}
	
	public void updateDB(String collectionName,BasicDBObject query, BasicDBObject updateObj) {
		DBCollection table = this.db.getCollection(collectionName);
		table.update(query, updateObj);
	}
	
	public void removeDB(String collectionName,BasicDBObject query) {
		DBCollection table = this.db.getCollection(collectionName);
		table.findAndRemove(query);
	}
}
