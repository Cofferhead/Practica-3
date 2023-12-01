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
public class ControlJuego {
    private int tiempoLlegadaDelÚlitmoCliente;
    private int clientesAtendidos;
    private Caja[] cajasMásOnce; 
    private Caja[] cajasMenosOnce; 
    private Cliente aux;
    private int contadorTiempo;
    private int articulosComprados;
    private Random rndm;
    public ControlJuego ()
    {
        cajasMásOnce = new Caja[7];
        for (int i = 0; i < 7; i++)
        {
            cajasMásOnce[i] = new Caja();
            cajasMásOnce[i].cerrarCaja();
        }
        cajasMenosOnce = new Caja[3];
        for (int i = 0; i < 3; i++)
        {
            cajasMenosOnce[i] = new Caja();
            cajasMenosOnce[i].cerrarCaja();
        }
        cajasMenosOnce[0].abrirCaja();
        cajasMásOnce[0].abrirCaja();
        contadorTiempo = 0;
        clientesAtendidos = 0;
        articulosComprados = 0;
        rndm = new Random();
    }

    public int getTiempoLlegadaDelÚlitmoCliente() {
        return tiempoLlegadaDelÚlitmoCliente;
    }
    public int getContadorTiempo() {
        return contadorTiempo;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }
    
    //Servicios
    //Servicios
    //Paso 1 a 3. Verificar si cuando añadir, generar un cliente
    //Y asignar el cliente a una fila.
    public void añadirCliente (Cliente cliente, int index)
    {
        //Menos 11
        if (cliente.compare(new Cliente(11), cliente) > 0)
        {
            if (this.cajasMenosOnce[index].devolverCantidadElementos() == 0)
            {
                cliente.calcularSalida(this.contadorTiempo);
            }
            this.cajasMenosOnce[index].añadirCliente(cliente);
            //this.cajasMenosOnce[index].abrirCaja();
        }
        //11 o más
        else
        {
            if (this.cajasMásOnce[index].devolverCantidadElementos() == 0)
            {
                cliente.calcularSalida(this.contadorTiempo);
            }
            this.cajasMásOnce[index].añadirCliente(cliente);
            //this.cajasMásOnce[index].abrirCaja();
        }
    }
    //Generar un cliente
    public Cliente generarCliente()
    {
        aux = new Cliente(rndm.nextInt(1, 30));
        aux.calcularEntrada(contadorTiempo);
        this.tiempoLlegadaDelÚlitmoCliente = aux.getTiempoDeLlegada();
        return aux;
    }
    public int calcularArticulosAtendidos ()
    {
        int salida = 0;
        for (Caja i: cajasMenosOnce)
        {
            salida += i.getArticulos();
        }
        for (Caja i: cajasMásOnce)
        {
            salida += i.getArticulos();
        }
        articulosComprados = salida;
        return salida;
    }
    public Cliente getAux ()
    {
        return aux;
    }
    //Vereificar cuando añadir
    public boolean revisarSiTiempoLlegadaCumplido()
    {
        return (contadorTiempo == this.tiempoLlegadaDelÚlitmoCliente);
    }
    public void añadirTiempo (int tiempo)
    {
        contadorTiempo += tiempo;
    }
    //Asignar al cliente
    ////Encontramos la caja abierta
    ////Calculamos su minuto de salida **Aún no esta hecho
    //
    public void asignarACajaAbierta(Cliente cliente)
    {
        int index = encontrarCajaAbierta(cliente);
        añadirCliente(cliente, index);
    }
    public int encontrarCajaAbierta (Cliente cliente)
    {
        int indiceDelMenor= 0;
        //Menos de once
        if (cliente.compare(new Cliente(11), cliente) > 0)
        {
            for (int i = 0; i < this.cajasMenosOnce.length; i++)
            {
                if ((cajasMenosOnce[i].estaAbierto == true) && 
                (cajasMenosOnce[indiceDelMenor].devolverCantidadElementos() > cajasMenosOnce[i].devolverCantidadElementos()))
                {
                    indiceDelMenor = i;
                }
            }
        }
        else
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if ((cajasMásOnce[i].estaAbierto == true) &&
                (cajasMásOnce[indiceDelMenor].devolverCantidadElementos() > cajasMásOnce[i].devolverCantidadElementos()))
                {
                    indiceDelMenor = i;
                }
            }
        }
        return indiceDelMenor;
    }
    public void abrirCajasIniciales ()
    {
        this.cajasMenosOnce[0].abrirCaja();
        this.cajasMásOnce[0].abrirCaja();
    }
    /////////////////////////////////////
    /////////////////////////////////////
    /////////////////////////////////////
    //Paso 4: Verificar si debemos cerrar caja
    //Revisamos si quedan cajas abiertas.
    public boolean revisarSiQuedanCajasAbiertas (boolean esMayorOnce)
    {
        if (esMayorOnce == false)
        {
            for (Caja i:this.cajasMenosOnce)
            {
                if (i.getEstaAbierto() == true)
                {
                    return true;
                }
            }
        }
        else
        {
            for (Caja i:this.cajasMásOnce)
            {
                if (i.getEstaAbierto() == true)
                {
                    return true;
                }
            }
        }
        return false;
    }
    //Revisamos cada fila si ha tenido tres o menos clientes 
    //en los últimos diez minutos
    public void revisarSiCerrarCajas ()
    {
        for (int i = 0; i < this.cajasMenosOnce.length; i++)
        {
            if (cajasMenosOnce[i].getContadorParaCerrarCaja() >= 10 && i != 0)
            {
                cajasMenosOnce[i].cerrarCaja();
            }
        }
        for (int i = 0; i < this.cajasMásOnce.length; i++)
        {
            if (cajasMásOnce[i].getContadorParaCerrarCaja() >= 10 && i != 0)
            {
                cajasMásOnce[i].cerrarCaja();
            }
            
        }
    }
    //Si lo hay cerramos la caja.
    //Calculamos el contador de las cajas.
    /////////////////////////////////////
    /////////////////////////////////////
    //Paso 5: Verificar si abrir una caja.
    public void revisarSiAbrirCaja (Cliente cliente)
    {
        //Cajas menos once
        if (cliente.compare(new Cliente(11), cliente) > 0)
        {
        if (revisarSiQuedanCajasCerradas(true) == true)
        {
            for (int i = 0; i < this.cajasMenosOnce.length; i++)
            {
                if (verificarCajaMás5(i, true) == true)
                {
                    abrirCaja(encontrarCajaCerrada(true), true);
                    break;
                }
            }
        }
        }
        else
        {
        if (revisarSiQuedanCajasCerradas(false) == true)
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (verificarCajaMás5(i, false) == true)
                {
                    abrirCaja(encontrarCajaCerrada(false), false);
                    break;
                }
            }
        }
        }
        //Cajas más once
    }
    ////Verificar si quedan cajas cerradas
    public boolean revisarSiQuedanCajasCerradas (boolean menorDeOnce)
    {
        if (menorDeOnce == true)
        {
            for (int i = 0; i < this.cajasMenosOnce.length; i++ )
            {
                if (cajasMenosOnce[i].getEstaAbierto() == false)
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (cajasMásOnce[i].getEstaAbierto() == false)
                {
                    return true;
                }
            }
            return false;
        }
    }
    ////Verificar si hay más de 5 clientes en una caja.
    public boolean verificarCajaMás5 (int index, boolean menorDeOnce)
    {
        if (menorDeOnce == true)
        {
            return (this.cajasMenosOnce[index].devolverCantidadElementos() >= 5);
        }
        else
        {
            return (this.cajasMásOnce[index].devolverCantidadElementos() >= 5);
        }
    }
    ////Abrir caja
    public void abrirCaja(int index, boolean menorDeOnce)
    {
        if (menorDeOnce == true)
        {
            this.cajasMenosOnce[index].abrirCaja();
        }
        else
        {
            this.cajasMásOnce[index].abrirCaja();
        }
    }
    //Encontrar caja cerrada
    public int encontrarCajaCerrada (boolean menorOnce)
    {
        int indiceDelMenor = -1;
        if (menorOnce == true)
        {
            //Obtenemos el indice de la caja cerrada con 
            //el indice más bajo
            for (int i = 0; i < this.cajasMenosOnce.length; i++)
            {
                if (cajasMenosOnce[i].getEstaAbierto() == false)
                {
                    indiceDelMenor = i;
                    break;
                }
            }
            //Si hay una caja cerrada con menos clientes asignamos esa
            //como la caja a cerrada
            for (int i = 0; i < this.cajasMenosOnce.length; i++)
            {
                if ((cajasMenosOnce[i].getEstaAbierto() == false) &&
                    (cajasMenosOnce[i].devolverCantidadElementos() > 0) &&
                    (cajasMenosOnce[indiceDelMenor].devolverCantidadElementos() > cajasMenosOnce[i].devolverCantidadElementos()))
                {
                    indiceDelMenor = i;
                }
            }
            
        }
        else
        {
            //Obtenemos el indice de la caja cerrada con 
            //el indice más bajo
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (this.cajasMásOnce[i].getEstaAbierto() == false)
                {
                    indiceDelMenor = i;
                    break;
                }
            }
            //Si hay una caja cerrada con menos clientes asignamos esa
            //como la caja a cerrada
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if ((this.cajasMásOnce[i].getEstaAbierto() == false) &&
                     (this.cajasMásOnce[i].devolverCantidadElementos() > 0) &&
                    (this.cajasMásOnce[indiceDelMenor].devolverCantidadElementos() > this.cajasMásOnce[i].devolverCantidadElementos()))
                {
                    indiceDelMenor = i;
                }
            }
        }
        return indiceDelMenor;
    }
    ////////////////////////////////////////////////
    //////////////////////////////////////////////7
    //Paso 6: Verificamos si debemos de atender un cliente.
    public void atenderTodosLosClientes ()
    {
        //Menos once
        if (revisarSiQuedanClientes(true) == true)
        {
            for (int i = 0; i < this.cajasMenosOnce.length; i++)
            {
                if (this.cajasMenosOnce[i].devolverCantidadElementos() > 0)
                {
                atenderCliente(i, false);
                }
            }
        }
        //Más once
        if (revisarSiQuedanClientes(false) == true)
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (this.cajasMásOnce[i].devolverCantidadElementos() > 0)
                {
                atenderCliente(i, true);
                }
            }
        }
    }
    //Revisar que quedan clientes
    private boolean revisarSiQuedanClientes (boolean menosOnce)
    {
        //Cajas rápidas
        if (menosOnce == true)
        {
            for (Caja i:this.cajasMenosOnce)
            {
                if (i.devolverCantidadElementos() > 0)
                {
                    return true;
                }
            }
            return false;
        }
        //Cajas más de once
        else
        {
            for (Caja i:this.cajasMásOnce)
            {
                if(i.devolverCantidadElementos() > 0)
                {
                    return true;
                }
            }
            return false;
        }
    }
    //Atender un cliente
    public void atenderCliente (int index, boolean mayorOnce)
    {
        //Cajas rápidas
        if (mayorOnce == false)
        {
            if (this.contadorTiempo == this.cajasMenosOnce[index].peek().getTiempoDeSalida())
            {
                this.cajasMenosOnce[index].descartarCliente();
                //Aqui calculamos el tiempo de salida del elemento frontal
                if (this.cajasMenosOnce[index].devolverCantidadElementos() > 0)
                {
                    this.cajasMenosOnce[index].calcularTiempoDeSalidaDelFrente(this.contadorTiempo);
                }
                this.clientesAtendidos += 1;
            }
        }
        //Cajas normales
        else
        {
            if (this.contadorTiempo == this.cajasMásOnce[index].peek().getTiempoDeSalida())
            {
                this.cajasMásOnce[index].descartarCliente();
                if (this.cajasMásOnce[index].devolverCantidadElementos() > 0)
                {
                    this.cajasMásOnce[index].calcularTiempoDeSalidaDelFrente(this.contadorTiempo);
                }
                this.clientesAtendidos += 1;
            }
        }
    }
            
    ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    public void calcularCronometrosDeCerrado ()
    {
        for (Caja i:this.cajasMenosOnce)
        {
            i.calcularContador();
        }
        for (Caja i:this.cajasMásOnce)
        {
            i.calcularContador();
        }
    }
    public ArrayList<String> getColaString (int index, boolean menorOnce)
    {
        if (menorOnce == true)
        {
            return this.cajasMenosOnce[index].getStringCola();
        }
        else
        {
            return this.cajasMásOnce[index].getStringCola();
        }
    }
    //Más getters
    public Caja getCajaRapida (int index)
    {
        return this.cajasMenosOnce[index];
    }
    public Caja getCajaNormal (int index)
    {
        return this.cajasMásOnce[index];
    }
   @Override 
   public String toString ()
   {
       String salida = "";
       salida += "Cajas rápidas: \n";
       for (int i = 0; i < 3; i++)
       {
           salida += i + " ";
           salida += cajasMenosOnce[i].toString() + "\n";
       }
       salida += "Cajas +11: \n";
       for (int i = 0; i < 7; i++)
       {
           salida += i + " ";
           salida += cajasMásOnce[i].toString() + "\n";
       }
       return salida;
   }
   
}
