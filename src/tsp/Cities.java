/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;

/**
 * Di pake buat nyimpen semua kota yang di tuju.
 * @author vebbyclrs
 */
public class Cities {
    private static ArrayList kotaTujuan= new ArrayList<City>();

    public void tambahKota (City city) {
        kotaTujuan.add(city);
    }

    public static City getKotaTujuan(int idx) {
        return (City)kotaTujuan.get(idx); //downcast object jadi City
    }
    
    public static int jumlahKotaTujuan() {
        return kotaTujuan.size();
    }
}
