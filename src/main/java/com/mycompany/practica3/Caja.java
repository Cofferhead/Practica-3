/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author felix
 */
public class Caja { 
    int contadorParaCerrarCaja;
    Cola<Cliente> clientes;
    boolean estaAbierto;
    int cantidadDeElementos;
    int articulos;
    public Caja ()
    {
        clientes = new Cola(10);
        contadorParaCerrarCaja = 0;
        articulos = 0;
        estaAbierto = true;
    }
    //Abrirse
    public void abrirCaja ()
    {
        estaAbierto = true;
    }
    //Cerrarse
    public void cerrarCaja ()
    {
        estaAbierto = false;
    }
    //Descartar cliente
    public void descartarCliente ()
    {
        articulos += clientes.peek().getArticulos();
        clientes.pop();
    }
    public int devolverCantidadElementos()
    {
        this.cantidadDeElementos = this.clientes.devolverCantidadElementos();
        return this.cantidadDeElementos;
    }
    //Añadir cliente
    public void añadirCliente (Cliente newCliente)
    {
        clientes.push(newCliente);
    }
    public Cliente peek ()
    {
        return this.clientes.peek();
    }
    //Getters
    public boolean getEstaAbierto() {
        return estaAbierto;
    }
    public int calcularContador ()
    {
        if (this.devolverCantidadElementos() > 3 || this.estaAbierto == false)
        {
            this.contadorParaCerrarCaja = 0;
        }
        else
        {
            this.contadorParaCerrarCaja += 1;
        }
        return this.contadorParaCerrarCaja;
    }

    public int getContadorParaCerrarCaja() {
        return contadorParaCerrarCaja;
    }
    public void calcularTiempoDeSalidaDelFrente (int tiempoActual)
    {
        Cliente aux = this.clientes.peek();
        aux.calcularSalida(tiempoActual);
        this.clientes.reemplazarFrente(aux);
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }

    public int getArticulos() {
        return articulos;
    }
    public ArrayList<String> getStringCola ()
    {
        return this.clientes.getArrayStrings();
    }
    //toString
    @Override
    public String toString()
    {
        String salida = "";
        //Articulos se puede conseguir de otra forma
        salida = "|Arti. " + articulos + "| "; 
        //estaAbierto se puede conseguir de otra forma
        if (this.estaAbierto == true)
        {
            salida += "Abierta: ";
        }
        else
        {
            salida += "Cerrada: ";
        }
        //Minutos 
        salida += "Minutos: " + this.contadorParaCerrarCaja + ": ";
        salida += clientes.toString();
        return salida;
    }
}
