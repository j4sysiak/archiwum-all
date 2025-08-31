package src.polimorphism.solutionCohesion;


// Solution: This is a better way of approaching the problem. Different classes have their own responsibilities.
class InternetDownloader {
    public void downloadFromInternet() {
    }
}

class DataParser {
    public void parseData() {
    }
}

class DatabaseStorer {
    public void storeIntoDatabase() {
    }
}

class DownloadAndStore {
    void doEverything() {
        new InternetDownloader().downloadFromInternet();
        new DataParser().parseData();
        new DatabaseStorer().storeIntoDatabase();
    }
}


public class TestCohesionSolution {
}
