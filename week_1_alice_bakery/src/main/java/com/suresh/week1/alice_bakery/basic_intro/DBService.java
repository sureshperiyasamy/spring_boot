package com.suresh.week1.alice_bakery.basic_intro;


import org.springframework.stereotype.Service;

@Service
public class DBService {

    // FIELD INJECTION
//    @Autowired
//    DB db;

    final DB db;

    // CONSTRUCTOR INJECTION
    public DBService(DB db){
        this.db = db;
    }

    String getData() {
        return db.getDB();
    }
}
