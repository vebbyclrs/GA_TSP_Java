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
public class City {
    private int x;
    private int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public City() {
        this.x = ((int)Math.random()*100); //random nilai integer dari 0-99
        this.y = ((int)Math.random()*100); //random nilai integer dari 0-99        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public double getJarak(City city) {
        int deltaX = Math.abs(this.x - city.getX()); //abs: absolute value/nilai mutlak. Kalo -, jadi +
        int deltaY = Math.abs(this.y - city.getY());
        double jarak = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        return jarak;
    }
    
    
    @Override
    public String toString() {
        return this.getX()+","+this.getY();
    }
    
    
}
