package com.jack.utils.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.Map;

/**
 * @author Jack
 */
public class MongoDbUtil extends AbstractMongoDbUtils{

    /**
     * 单例模式
     */
    private MongoDbUtil(){}

    private static MongoDbUtil mongoDbUtil = null;

    private static MongoClient mongoClient = null;

    private static MongoDatabase mongoDatabase = null;

    @Override
    public Object startService(Object object) {
        if (mongoClient == null){
            Map<String,Object> configMap = (Map<String, Object>) object;
            mongoClient = new MongoClient(configMap.get("Address").toString(),(int)configMap.get("port"));
        }
        return mongoClient;
    }

    @Override
    public Object connection(Object object) {
        if (mongoDatabase == null){
            mongoDatabase = mongoClient.getDatabase(object.toString());
        }
        return mongoDatabase;
    }

    public static MongoDbUtil newInstance(){
        if (mongoDbUtil == null){
            mongoDbUtil = new MongoDbUtil();
        }
        return  mongoDbUtil;
    }
}
