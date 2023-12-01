 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3;

import java.util.ArrayList;

/**
 *
 * @author felix
 */
public class Cola<T> {
    private int inicio;
    private int fin;
    private T[] cola;
    public Cola (int max)
    {
        cola = (T[]) new Object[max];
        inicio = -1;
        fin = -1;
    }
    public Cola (Cola colaCopiar)
    {
        this.cola = (T[]) new Object[colaCopiar.getCola().length];
        //System.arraycopy(cola, 0, colaCopiar.getCola(), 0, colaCopiar.getCola().length);
        for (int i = 0; i < colaCopiar.getCola().length; i++)
        {
            cola[i] = (T)colaCopiar.getCola()[i];
        }
        this.fin = colaCopiar.getFin();
        this.inicio = colaCopiar.getInicio();
        
    }
    //Getters
    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }

    public T[] getCola() {
        return cola;
    }
    
    //push
    public void push(T nuevo)
    {
        if (isFull())
        {
            System.out.println("Desbordamiento");
        }
        else
        {
            fin += 1;
            if (fin == 0)
            {
                inicio = 0;
            }
            else if (fin == cola.length)
            {
                fin = 0;
            }
            cola[fin] = nuevo;
        }
    }
    //pop
    public T pop ()
    {
        if (isEmpty())
        {
            System.out.println("Subdesbordamiento");
            return null;
        }
        else
        {
            T aux = cola[inicio];
            if (inicio == fin)
            {
                inicio = -1;
                fin = -1;
            }
            else
            {
                inicio += 1;
                if (inicio == cola.length)
                {
                    inicio = 0;
                }
            }
            return aux;
        }
    }
    //peek
    public T peek ()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            return cola[inicio];
        }
    }
    //isEmpty
    public boolean isEmpty ()
    {
        if (fin == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //isFull
    public boolean isFull ()
    {
        if (fin+1 == inicio || (inicio == 0 && fin == cola.length-1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int devolverCantidadElementos()
    {
        if (inicio == -1)
        {
            return 0;
        }
        else
        {
        return (Math.abs(inicio - fin)+1);
        }
    }
    public void reemplazarFrente (T nuevoFrente)
    {
        if (inicio != -1)
        {
        this.cola[this.inicio] = nuevoFrente;
        }
    }
    public ArrayList<String> getArrayStrings ()
    {
        ArrayList<String> salida = new ArrayList();
        Cola aux = new Cola(this);
        while (aux.isEmpty() != true)
        {
            salida.add(aux.pop().toString());
        }
        return salida;
    }
    //ToString
    @Override 
    public String toString ()
    {
        String salida = "";
        Cola aux = new Cola(this);
        while (aux.isEmpty() != true)
        {
            salida += aux.pop().toString();
        }
        return salida;
    }
}
