/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author felix
 */
public class Practica3 {


    public static void main(String[] args) {
        /*Cola<String> a = new Cola(10);
        a.push("Leo");
        a.push("Siete");
        a.push("Rangu");
        a.push("Are ");
        a.push("You");
        //System.out.println(a.peek());
        Cola<String> b = new Cola(a);
        b.pop();
        b.pop();
        a.pop();
        System.out.println(a.toString());
        System.out.println(b.peek());
        */
        /*Random rndm = new Random ();
        System.out.println(rndm.nextInt(5, 10));
        System.out.println(rndm.nextInt(5, 7));
        System.out.println(rndm.nextInt(5, 7));
        System.out.println(rndm.nextInt(5, 7));
        System.out.println(rndm.nextInt(5, 7));
        */
        /*
        ControlJuego c = new ControlJuego();
        Caja b = new Caja();
        c.añadirCliente(new Cliente(10), 1);//-11
        c.añadirCliente(new Cliente(11), 0);//+11
        c.añadirCliente(new Cliente(1), 0);//-11
        c.añadirCliente(new Cliente(22), 0);//+11
        c.añadirCliente(new Cliente(15), 3);//+11
        c.añadirCliente(new Cliente(8), 2);//-11
        c.añadirCliente(new Cliente(45), 1);//+11
        c.añadirCliente(new Cliente(2), 1);//-11
        c.añadirCliente(new Cliente(3), 1);
        c.añadirCliente(new Cliente(4), 2);
        c.añadirCliente(new Cliente(18), 3);
        c.añadirCliente(new Cliente(82), 0);
        c.añadirCliente(new Cliente(63), 2);
        c.añadirCliente(new Cliente(23), 2);
        c.añadirCliente(new Cliente(12), 0);
         c.añadirCliente(new Cliente(12), 1);
         c.añadirCliente(new Cliente(2), 0);
        c.añadirCliente(new Cliente(9), 0);
         c.añadirCliente(new Cliente(4), 0);
        c.asignarACajaAbierta(new Cliente(7));
        c.asignarACajaAbierta(new Cliente(31));
        c.asignarACajaAbierta(new Cliente(43));
        
        
        System.out.println(c.toString());
        c.revisarSiAbrirCaja();
        System.out.println(c.toString());
        System.out.println("Encontrar Caja abierta: " + c.encontrarCajaCerrada(true));
        */
        /*
        ControlJuego control = new ControlJuego();
        control.añadirCliente(new Cliente(55), 0);
        control.cajasMásOnce[0].añadirCliente(new Cliente(666));
        control.cajasMásOnce[0].añadirCliente(new Cliente(732));
        control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
        control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
        control.cajasMásOnce[0].añadirCliente(new Cliente(666));
        control.cajasMásOnce[0].añadirCliente(new Cliente(732));
        control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
        control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
        Cliente aux;
        aux = control.generarCliente();
        control.abrirCajasIniciales();
        while (control.getContadorTiempo() < 600 )
        {
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
        }
        //*/
        /*
            ControlJuego control = new ControlJuego();
            control.añadirCliente(new Cliente(55), 0);
            control.cajasMásOnce[0].añadirCliente(new Cliente(666));
            control.cajasMásOnce[0].añadirCliente(new Cliente(732));
            control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
            control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
            control.cajasMásOnce[0].añadirCliente(new Cliente(666));
            control.cajasMásOnce[0].añadirCliente(new Cliente(732));
            control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
            control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
            control.generarCliente();
            control.abrirCajasIniciales();
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
            
        };
        int delay = 5000;//Milisegundos
        Timer timer = new Timer(delay, task);
        timer.start();
        if (control.getContadorTiempo() == 600)
        {
            timer.stop();
        }
        */
            /*
            control.añadirCliente(new Cliente(55), 0);
            control.cajasMásOnce[0].añadirCliente(new Cliente(666));
            control.cajasMásOnce[0].añadirCliente(new Cliente(732));
            control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
            control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
            control.cajasMásOnce[0].añadirCliente(new Cliente(666));
            control.cajasMásOnce[0].añadirCliente(new Cliente(732));
            control.cajasMásOnce[0].añadirCliente(new Cliente(9287442));
            control.cajasMásOnce[0].añadirCliente(new Cliente(3283));
            */
        ControlJuego control;
        Timer timer;
        TimerTask task;
        control = new ControlJuego();
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
