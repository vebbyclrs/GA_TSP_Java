/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author vebbyclrs
 */
public class TSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cities cities = new Cities();
        City city0 = new City(82,76);
        cities.tambahKota(city0);
        City city1 = new City(96,44);
        cities.tambahKota(city1);
        City city2 = new City(50,5);
        cities.tambahKota(city2);
        City city3 = new City(49,8);
        cities.tambahKota(city3);
        City city4 = new City(13,7);
        cities.tambahKota(city4);
        City city5 = new City(29,89);
        cities.tambahKota(city5);
        City city6 = new City(58,30);
        cities.tambahKota(city6);
        City city7 = new City(84,39);
        cities.tambahKota(city7);
        City city8 = new City(14,24);
        cities.tambahKota(city8);
        City city9 = new City(2,39);
        cities.tambahKota(city9);
        City city10 = new City(3,82);
        cities.tambahKota(city10);
        City city11 = new City(5,10);
        cities.tambahKota(city11);
        City city12 = new City(98,52);
        cities.tambahKota(city12);
        City city13 = new City(84,25);
        cities.tambahKota(city13);
        City city14 = new City(61,59);
        cities.tambahKota(city14);
        City city15 = new City(1,65);
        cities.tambahKota(city15);
        
        Population pop = new Population(20, true);
        System.out.println("Jarak awal: "+pop.getFittest().getJarakTur());
    }
    
}
