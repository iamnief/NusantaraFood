/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nusantarafood;

/**
 *
 * @author User
 */
public class Makanan {
    private Integer id;
    private String nama;
    private String asal;

    public Makanan(Integer id, String nama, String asal) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
    }

    public Integer getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }
    
}
