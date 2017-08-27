/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class buat encode rutenya.
 * Yang "Jalan-jalan" nyari rute tercepat lewat mana
 * @author vebbyclrs
 */
public class Tour {
    private ArrayList tour = new ArrayList<City>();//nyimpen kota2 tur
    /**
     * Ada array static kota, disini akan langsung di panggil sbg Cities
     */
    private double fitness=0;
    private int jarak=0;

    public Tour() {
        for (int i = 0; i < Cities.jumlahKotaTujuan(); i++) {
            tour.add(null);
        }
    }

    public Tour(ArrayList tour) {
        this.tour=tour;
    }
    
    //Bikin individual random
    public void generateIndividu(){
        for (int i = 0; i < Cities.jumlahKotaTujuan(); i++) {
            setCity(i, Cities.getKotaTujuan(i));
            //Kota static (Cities) indeks ke-i di letakkan 
            //dalam array tour indeks ke i (Disalin)
        }
        Collections.shuffle(tour);
    }
    
    //menetapkan kota dalam posisi tertentu dalam tour
    public void setCity (int posisiTur, City city) {
        tour.set(posisiTur, city);
        fitness = 0;
        jarak = 0;
    }
    
    public City getCity (int posisiTur) {
        return (City)tour.get(posisiTur);
    }
    
    public double getFitness() {
        if (fitness==0) {
            fitness = 1/(0.01+getJarakTur());
        }
        return fitness;
    }
    
    public int getJarakTur() {
    //Akan mereturn jarak total dari perjalanan tur
    //modified
        if (jarak == 0 ) {
            for (int i = 0; i < tour.size() ; i++) {
                if (i+1 < tour.size()) { //kota1 di awal-tengah array
                    jarak += (int)(getCity(i).getJarak(getCity(i+1))); //jarak=jarak(kota[i]---kota[i+1])
                }
                else {
                    jarak += (int)(getCity(i).getJarak(getCity(0)));
                }
            }
        }
        return jarak; 
    }
    
    public boolean mengandungKota (City cariKota) {
        return tour.contains(cariKota);
    }
//
//    @Override
//    public String toString() {
//        
//    }
    
    
}
