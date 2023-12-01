/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author felix
 */
public class Cliente implements Comparator{
    private int articulos;
    private int tiempoDeLlegada;
    private int tiempoDeSalida;
    public Cliente (int art)
    {
        this.articulos = art;
    }
    public Cliente (int art, int llegada, int salida)
    {
        this.articulos = art;
        this.tiempoDeLlegada = llegada;
        this.tiempoDeSalida = salida;
    }
    public int getArticulos() {
        return articulos;
    }

    public int getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public int getTiempoDeSalida() {
        return tiempoDeSalida;
    }
    public int calcularEntrada (int tiempoActual)
    {
        Random rndm = new Random();
        if (articulos >= 11)
        {
            this.tiempoDeLlegada = tiempoActual +  rndm.nextInt(5, 11);
        }
        else
        {
            this.tiempoDeLlegada = tiempoActual + rndm.nextInt(1, 4);
        }
        return tiempoDeLlegada;
    }
    public int calcularSalida (int tiempoActual)
    {
        Random rndm = new Random();
        if (articulos >= 11)
        {
            this.tiempoDeSalida = tiempoActual +  rndm.nextInt(20, 32);
            //this.tiempoDeSalida = tiempoActual +  rndm.nextInt(10, 16);
        }
        else
        {
            this.tiempoDeSalida = tiempoActual + rndm.nextInt(10, 22);
            //this.tiempoDeSalida = tiempoActual + rndm.nextInt(5, 11);
        }
        return tiempoDeLlegada;
    }
    @Override 
    public String toString ()
    {
        String salida = "";
        salida += "[ " + articulos + "]";
        return salida;
    }
    @Override
    public int compare(Object o1, Object o2)
    {
        Cliente x = (Cliente)o1;
        Cliente y = (Cliente)o2;
        return (x.getArticulos()-y.getArticulos());
    }
}
