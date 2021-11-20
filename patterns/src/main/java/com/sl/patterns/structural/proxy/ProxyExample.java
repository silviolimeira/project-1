package com.sl.patterns.structural.proxy;

interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }

}

class DatabaseExecuterProxy implements DatabaseExecuter {
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String name, String passwd) {
        if(name == "Admin" && passwd == "Admin@123") {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if(ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if(query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

/*
Proxy Design pattern - Properties

- Structural design pattern
- Used when you want to control access. i.e In Databases, you would
  want to control the 'delete' query available only certain users like
  admin.

* Implementation

  - In general, we've class which is executing interface executer method
    which is executing all commands.
  - To control this, we add a Proxy class which implements the same
    interface & write the conditions for 'admin' user before proceeding to
    actual executer.



 */

public class ProxyExample {

    public static void main(String[] args) throws Exception {

        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");



        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");

    }
}
