package src.polimorphism;


//        What is Cohesion?
//        Cohesion is a measure of how related the responsibilities of a class are.  A class must be highly cohesive
//        i.e. its responsibilities (methods) should be highly related to one another.
//        Example Problem
//        Example class below is  downloading  from  internet,  parsing  data  and  storing  data  to  database. The
//        responsibilities of this class are not really related. This is not cohesive class.
class DownloadAndStore {
    void downloadFromInternet() {
    }

    void parseData() {
    }

    void storeIntoDatabase() {
    }

    void doEverything() {
        downloadFromInternet();
        parseData();
        storeIntoDatabase();
    }
}


public class TestCohesion { }
