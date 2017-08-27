/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 * Class ini digunakan untuk menyimpan populasi dari kandidat2 tur
 * Akan ada array yang menyimpan alur-alur tur yang nanti akan di evolusi untuk mencari jalur terbaik
 * @author vebbyclrs
 */
public class Population {
    Tour[] tours;

    public Population(int nPop , boolean initialize) {
        //initialize: Apakah ingin memasukkan individu acak ke array tours
        tours = new Tour[nPop];
        if (initialize) {
            for (int i = 0; i < nPop; i++) {
                Tour tour =  new Tour();
                tour.generateIndividu();
                saveTour(i, tour);
            }
        }
    }
    public void saveTour(int index, Tour tour) {
        //Menyimpan tur baru ke dlm array tours
        tours[index] = tour;
    }
    
    public Tour getTour(int idx) {
        return tours[idx];
    }
    
    public Tour getFittest() {
        //Digunakan untuk mencari jalur terbaik pada populasi
        Tour fittest = tours[0];
        for (int i = 0; i < tours.length; i++) {
            //kalo tours[0] fitnessnya lebih kecil dari toursi[i]
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }
    
    public int populationSize() {
        return tours.length;
    }
}
