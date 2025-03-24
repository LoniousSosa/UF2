package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private final List<Tabac> tabacs = new ArrayList<>();
    private final List<Paper> papers = new ArrayList<>();
    private final List<Llumi> llumis = new ArrayList<>();
    private boolean obert = true;

    public synchronized void nouSubministrament() {
        if (!obert) return;
        Random rand = new Random();
        int random = rand.nextInt(3);
        if (random == 0) {
            tabacs.add(new Tabac());
        } else if (random == 1) {
            papers.add(new Paper());
        } else {
            llumis.add(new Llumi());
        }
        notifyAll();
    }

    public synchronized void venTabac() throws InterruptedException {
        while (tabacs.isEmpty() && obert) {
            wait();
        }
        if (!tabacs.isEmpty()) {
            tabacs.remove(tabacs.size() - 1);
        }
    }

    public synchronized void venPaper() throws InterruptedException {
        while (papers.isEmpty() && obert) {
            wait();
        }
        if (!papers.isEmpty()) {
            papers.remove(papers.size() - 1);
        }
    }

    public synchronized void venLlumi() throws InterruptedException {
        while (llumis.isEmpty() && obert) {
            wait();
        }
        if (!llumis.isEmpty()) {
            llumis.remove(llumis.size() - 1);
        }
    }

    public synchronized boolean tancarEstanc() {
        obert = false;
        notifyAll();
        return false;
    }

    public List<Tabac> getTabacs() {
        return tabacs;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public List<Llumi> getLlumis() {
        return llumis;
    }

    public boolean isObert() {
        return obert;
    }
}
