package pl.devfoundry.testing.order;

import java.io.*;

class OrderBackup {

    private Writer writer;

    Writer getWriter() {
        return this.writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        this.writer = new BufferedWriter(outputStreamWriter);
    }

    void backupOrder(Order order) throws IOException {

        if(this.writer == null) {
            throw new IOException("Backup file not created");
        }

        this.writer.append(order.toString());
    }

    void closeFile() throws IOException {
        this.writer.close();
    }

}
