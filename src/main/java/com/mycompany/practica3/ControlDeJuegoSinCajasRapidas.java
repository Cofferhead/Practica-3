/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author felix
 */
public class ControlDeJuegoSinCajasRapidas {
    private int tiempoLlegadaDelÚlitmoCliente;
    private int clientesAtendidos;
    Caja[] cajasMásOnce; //Poner en privado más tarde
    private Cliente aux;
    private int contadorTiempo;
    private int articulosComprados;
    private Random rndm;
    public ControlDeJuegoSinCajasRapidas ()
    {
        cajasMásOnce = new Caja[7];
        for (int i = 0; i < 7; i++)
        {
            cajasMásOnce[i] = new Caja();
            cajasMásOnce[i].cerrarCaja();
        }
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
        
            if (this.cajasMásOnce[index].devolverCantidadElementos() == 0)
            {
                cliente.calcularSalida(this.contadorTiempo);
            }
            this.cajasMásOnce[index].añadirCliente(cliente);
            //this.cajasMásOnce[index].abrirCaja();
       
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
        
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if ((cajasMásOnce[i].estaAbierto == true) &&
                (cajasMásOnce[indiceDelMenor].devolverCantidadElementos() > cajasMásOnce[i].devolverCantidadElementos()))
                {
                    indiceDelMenor = i;
                }
            }
        
        return indiceDelMenor;
    }
    public void abrirCajasIniciales ()
    {
        this.cajasMásOnce[0].abrirCaja();
    }
    /////////////////////////////////////
    /////////////////////////////////////
    /////////////////////////////////////
    //Paso 4: Verificar si debemos cerrar caja
    //Revisamos si quedan cajas abiertas.
    public boolean revisarSiQuedanCajasAbiertas ()
    {
        
            for (Caja i:this.cajasMásOnce)
            {
                if (i.getEstaAbierto() == true)
                {
                    return true;
                }
            }
        
        return false;
    }
    //Revisamos cada fila si ha tenido tres o menos clientes 
    //en los últimos diez minutos
    public void revisarSiCerrarCajas ()
    {
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
        
        if (revisarSiQuedanCajasCerradas() == true)
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (verificarCajaMás5(i) == true)
                {
                    abrirCaja(encontrarCajaCerrada());
                    break;
                }
            }
        }
        
        //Cajas más once
    }
    ////Verificar si quedan cajas cerradas
    public boolean revisarSiQuedanCajasCerradas ()
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
    ////Verificar si hay más de 5 clientes en una caja.
    public boolean verificarCajaMás5 (int index)
    {
        
        
            return (this.cajasMásOnce[index].devolverCantidadElementos() >= 5);
        
    }
    ////Abrir caja
    public void abrirCaja(int index)
    {
            this.cajasMásOnce[index].abrirCaja();
        
    }
    //Encontrar caja cerrada
    public int encontrarCajaCerrada ()
    {
        int indiceDelMenor = -1;
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
        
        return indiceDelMenor;
    }
    ////////////////////////////////////////////////
    //////////////////////////////////////////////7
    //Paso 6: Verificamos si debemos de atender un cliente.
    public void atenderTodosLosClientes ()
    {
        
        //Más once
        if (revisarSiQuedanClientes() == true)
        {
            for (int i = 0; i < this.cajasMásOnce.length; i++)
            {
                if (this.cajasMásOnce[i].devolverCantidadElementos() > 0)
                {
                atenderCliente(i);
                }
            }
        }
    }
    //Revisar que quedan clientes
    private boolean revisarSiQuedanClientes ()
    {
        //Cajas rápidas
        
        //Cajas más de once
        
            for (Caja i:this.cajasMásOnce)
            {
                if(i.devolverCantidadElementos() > 0)
                {
                    return true;
                }
            }
            return false;
        
    }
    //Atender un cliente
    public void atenderCliente (int index)
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
            
    ////////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    public void calcularCronometrosDeCerrado ()
    {
        for (Caja i:this.cajasMásOnce)
        {
            i.calcularContador();
        }
    }
    public ArrayList<String> getColaString (int index)
    {
            return this.cajasMásOnce[index].getStringCola();
        
    }
    public Caja getCajaNormal (int index)
    {
        return this.cajasMásOnce[index];
    }
   @Override 
   public String toString ()
   {
       String salida = "";
       
       salida += "Cajas: \n";
       for (int i = 0; i < 7; i++)
       {
           salida += i + " ";
           salida += cajasMásOnce[i].toString() + "\n";
       }
       return salida;
   }
     public static void main(String[] args) {
         ControlDeJuegoSinCajasRapidas control;
        Timer timer;
        TimerTask task;
        control = new ControlDeJuegoSinCajasRapidas();
        control.generarCliente();
        control.abrirCajasIniciales();
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("----------------------------------");
                System.out.println("Paso " + control.getContadorTiempo());
                System.out.println("Tiempo para el siguiente: " + control.getTiempoLlegadaDelÚlitmoCliente());
                if (control.revisarSiTiempoLlegadaCumplido() == true)
                {

                    control.revisarSiAbrirCaja(control.getAux());
                    control.asignarACajaAbierta(control.getAux());
                    control.generarCliente();
                }
                //control.revisarSiAbrirCaja();
                control.atenderTodosLosClientes();
                control.calcularCronometrosDeCerrado();
                control.revisarSiCerrarCajas();
                control.añadirTiempo(1);
                System.out.println(control.toString());
                System.out.println("----------------------------------");
                System.out.println("Clientes atendidos: " + control.getClientesAtendidos());
                System.out.println("Articulos comprados: " + control.calcularArticulosAtendidos());
                
                if (control.getContadorTiempo() == 100)
                {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 0, 500);
     }
}
