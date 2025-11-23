package models;

import java.util.ArrayList;

public class ResourcesAccessManager {
    private int nReaders;
    private boolean writing;

    public ResourcesAccessManager(){
        this.nReaders = 0;
        this.writing = false;
    }

    public synchronized void startReading(){
        while (writing) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.nReaders ++;
    }

    public synchronized void finishReading(){
        this.nReaders --;

        if (nReaders == 0) {
            notifyAll();
        }
    }

    public synchronized void startWriting(){
        while (writing || nReaders > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.writing = true;
    }

    public synchronized void finishWriting(){
        this.writing = false;

        notifyAll();
    }
}
