/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.julio.CampoMinado.model;

import br.com.julio.CampoMinado.exception.ExplosionException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class Field {

    private boolean mined;
    private boolean opened;
    private boolean marked;

    private final int xLine;
    private final int yColumn;

    private List<Field> neighbours = new ArrayList<>();
    
    Field(int xLine, int yColumn) {
        this.xLine = xLine;
        this.yColumn = yColumn;
    }
    
    Field(boolean mined, boolean opened, boolean marked, int xLine, int yColumn){
        this.mined = mined;
        this.opened = opened;
        this.marked = marked;
        this.xLine = xLine;
        this.yColumn = yColumn;
    }
    
    boolean addNeighbour (Field field){
        
        boolean added =  isNeighbour(field) ? neighbours.add(field) : false;
        
        return added;
    }
    
    boolean isNeighbour(Field field){
        
        boolean isNeighbour = false;
        
        boolean isDiagonal = (this.xLine != field.xLine)
                                &&
                             (this.yColumn != field.yColumn);
        
        int difference = Math.abs(this.xLine - field.xLine)
                            + 
                         Math.abs(this.yColumn - field.yColumn);
        
        if(difference == 1 || (isDiagonal == true && difference == 2)){
            isNeighbour = true;
        }
        
        return isNeighbour;
    }
    
    void alterMarked() {
        if(opened == false){
            marked = !marked;
        }
    }
    
    boolean open(){
        
        if(opened == false && marked == false){
            opened = true;
            
            if(mined) {
                throw new ExplosionException();
            }
            
            if (safeNeighbour()){
            neighbours.forEach(a -> a.open());
        }
            
            return true;
            
        }
        
        return false;
    }
    
    boolean safeNeighbour(){
        return neighbours.stream().noneMatch(a -> a.mined);
    }
    
    public boolean getMarked(){
        return marked;
    }    
    
    void setMined(boolean mined){
        this.mined = mined;
    }
}
