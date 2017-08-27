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
public class GA {
    private static final double pMutasi = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitisme = true;
    
        public static Population evolvePopulation(Population pop) {
        Population tmpPop = new Population(pop.tours.length, false);

        int elitismOffset = 0;
        if (elitisme) {
            tmpPop.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }
        
        for (int i = elitismOffset; i < tmpPop.tours.length; i++) {
            
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            //Anak adalah hasil Crossover orang tua
            Tour child = crossover(parent1, parent2);
            
            tmpPop.saveTour(i, child);
        }
        
        for (int i = elitismOffset; i < tmpPop.tours.length; i++) {
            mutasi(tmpPop.getTour(i));
        }
        return tmpPop;
    }
        
    public static Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();
        
        int point1 = (int) (Math.random() * parent1.tourSize());
        int point2 = (int) (Math.random() * parent1.tourSize());
        //Mungkin saja point2 lebih besar di banding point1
        
        for (int i = 0; i < child.tourSize(); i++) {
            if (point1 < point2 && i > point1 && i < point2) {
                child.setCity(i, parent1.getCity(i));
            }
            else if (point1 > point2) {
                if (!(i < point1 && i > point2)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.mengandungKota(parent2.getCity(i))) {
                for (int j = 0; j < child.tourSize(); j++) {
                    if (child.getCity(j) == null) {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
    
    private static void mutasi(Tour tour) {
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            if(Math.random() < pMutasi){
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }

    private static Tour tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.tours.length);
            tournament.saveTour(i, pop.getTour(randomId));
        }
        Tour fittest = tournament.getFittest();
        return fittest;
    }
}


