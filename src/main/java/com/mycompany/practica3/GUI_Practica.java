/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica3;

import java.awt.Color;
import java.awt.Font;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 *
 * @author felix
 */
public class GUI_Practica extends javax.swing.JFrame {
    ImageIcon cashier;
    ControlJuego control;
    Timer timer;
    TimerTask task;
    JTabbedPane tabbedPane;
    
    /**
     * Creates new form GUI_Practica
     */
    public GUI_Practica() {
        initComponents();
        control = new ControlJuego();
        control.generarCliente();
        control.abrirCajasIniciales();
        timer = new Timer();
        tabbedPane = new JTabbedPane();
        this.add(tabbedPane);
        tabbedPane.add(new javax.swing.JLabel("Panel 1"));
        //clientesTexto.setBackground(Color.black);
        clientesTexto.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        //clientesTexto.setForeground(Color.white);
        clientesTexto.setOpaque(false);
        this.clientesLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.minutoTexto.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.minutosLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.articulosTexto.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.articulosLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.sigClienteTexto.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.siguienteClienteLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        this.normalLine.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        this.fastLine.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        for (javax.swing.JLabel i: this.articulos)
        {
            i.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        }
        for (javax.swing.JLabel i: this.articulosRapidos)
        {
            i.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        }
        task = new TimerTask() {
            @Override
            public void run() {
                //System.out.println("----------------------------------");
                //System.out.println("Paso " + control.getContadorTiempo());
                minutosLabel.setText(String.valueOf(control.getContadorTiempo()));
                //System.out.println("Tiempo para el siguiente: " + control.getTiempoLlegadaDelÚlitmoCliente());
                siguienteClienteLabel.setText(String.valueOf(control.getTiempoLlegadaDelÚlitmoCliente()));
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
                ArrayList<String> aux;
                //Cajas rápidas
                //Caja rapida 1
                aux = control.getColaString(0, true);
                ImageIcon auxIcon = new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png");
                
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCajaRapida1.get(j).setVisible(true);
                        articulosCajaRapida1.get(j).setText(aux.get(j));
                        clientesCajaRapida1.get(j).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png"));
                        clientesCajaRapida1.get(j).setOpaque(false);
                        clientesCajaRapida1.get(j).setVisible(true);
                        //clientesCajaRapida1.get(j).setText("cliente");
                       
                    }
                    else
                    {
                        articulosCajaRapida1.get(j).setVisible(false);
                        clientesCajaRapida1.get(j).setVisible(false);
                    }
                }
                //Caja rapida 2
                aux = control.getColaString(1, true);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCajaRapida2.get(j).setText(aux.get(j));
                        articulosCajaRapida2.get(j).setVisible(true);
                        clientesCajaRapida2.get(j).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png"));
                        clientesCajaRapida2.get(j).setOpaque(false);
                        clientesCajaRapida2.get(j).setVisible(true);
                        //clientesCajaRapida2.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCajaRapida2.get(j).setVisible(false);
                        clientesCajaRapida2.get(j).setVisible(false);
                    }
                }
                //Caja rapida 3
                aux = control.getColaString(2, true);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCajaRapida3.get(j).setText(aux.get(j));
                        articulosCajaRapida3.get(j).setVisible(true);
                        clientesCajaRapida3.get(j).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png"));
                        clientesCajaRapida3.get(j).setOpaque(false);
                        clientesCajaRapida3.get(j).setVisible(true);
                        //clientesCajaRapida3.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCajaRapida3.get(j).setVisible(false);
                        clientesCajaRapida3.get(j).setVisible(false);
                    }
                }
                //Cajas normales
                //Caja 1
                aux = control.getColaString(0, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja1.get(j).setVisible(true);
                        articulosCaja1.get(j).setText(aux.get(j));
                        clientesCaja1.get(j).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png"));
                        clientesCaja1.get(j).setOpaque(false);
                        clientesCaja1.get(j).setVisible(true);
                        //clientesCaja1.get(j).setText("cliente");
                        
                        
                    }
                    else
                    {
                        articulosCaja1.get(j).setVisible(false);
                        clientesCaja1.get(j).setVisible(false);
                    }
                }
                //Caja 2
                aux = control.getColaString(1, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja2.get(j).setVisible(true);
                        articulosCaja2.get(j).setText(aux.get(j));
                        clientesCaja2.get(j).setIcon(auxIcon);
                        clientesCaja2.get(j).setOpaque(false);
                        clientesCaja2.get(j).setVisible(true);
                        //clientesCaja2.get(j).setText("cliente");
                       
                    }
                    else
                    {
                        articulosCaja2.get(j).setVisible(false);
                        clientesCaja2.get(j).setVisible(false);
                    }
                }
                //Caja 3
                aux = control.getColaString(2, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja3.get(j).setVisible(true);
                        articulosCaja3.get(j).setText(aux.get(j));
                        clientesCaja3.get(j).setIcon(auxIcon);
                        clientesCaja3.get(j).setOpaque(false);
                        clientesCaja3.get(j).setVisible(true);
                        //clientesCaja3.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCaja3.get(j).setVisible(false);
                        clientesCaja3.get(j).setVisible(false);
                    }
                }
                //Caja 4
                aux = control.getColaString(3, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja4.get(j).setVisible(true);
                        articulosCaja4.get(j).setText(aux.get(j));
                        clientesCaja4.get(j).setIcon(auxIcon);
                        clientesCaja4.get(j).setOpaque(false);
                        clientesCaja4.get(j).setVisible(true);
                        //clientesCaja4.get(j).setText("cliente");
                       
                    }
                    else
                    {
                        articulosCaja4.get(j).setVisible(false);
                        clientesCaja4.get(j).setVisible(false);
                    }
                }
                //Caja 5
                aux = control.getColaString(4, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja5.get(j).setVisible(true);
                        articulosCaja5.get(j).setText(aux.get(j));
                        clientesCaja5.get(j).setVisible(true);
                        clientesCaja5.get(j).setIcon(auxIcon);
                        clientesCaja5.get(j).setOpaque(false);
                        //clientesCaja5.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCaja5.get(j).setVisible(false);
                        clientesCaja5.get(j).setVisible(false);
                    }
                }
                //Caja 6
                aux = control.getColaString(5, false);
                for (int j = 0; j < 10; j++)
                {
                    if (j < aux.size())
                    {
                        articulosCaja6.get(j).setVisible(true);
                        articulosCaja6.get(j).setText(aux.get(j));
                        clientesCaja6.get(j).setIcon(auxIcon);
                        clientesCaja6.get(j).setOpaque(false);
                        clientesCaja6.get(j).setVisible(true);
                        //clientesCaja6.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCaja6.get(j).setVisible(false);
                        clientesCaja6.get(j).setVisible(false);
                    }
                }
                //Caja 7
                aux = control.getColaString(6, false);
                for (int j = 0; j < 10; j++)
                {
                    
                    if (j < aux.size())
                    {
                        articulosCaja7.get(j).setVisible(true);
                        articulosCaja7.get(j).setText(aux.get(j));
                        clientesCaja7.get(j).setIcon(auxIcon);
                        clientesCaja7.get(j).setOpaque(false);
                        clientesCaja7.get(j).setVisible(true);
                        //clientesCaja7.get(j).setText("cliente");
                        
                    }
                    else
                    {
                        articulosCaja7.get(j).setVisible(false);
                        clientesCaja7.get(j).setVisible(false);
                    }
                }
                //Contadores de articulos
                //Articulos cajas rapidas
                int contador = 0;
                for (javax.swing.JLabel i:articulosRapidos)
                {
                    i.setText("|"+String.valueOf(control.getCajaRapida(contador).getArticulos())+"|");
                    i.setFont(new Font(Font.SERIF, Font.BOLD, 20));
                    //cajasRegistradoras.get(contador).setText(String.valueOf(control.getCajaRapida(contador).getEstaAbierto()));
                    if (control.getCajaRapida(contador).getEstaAbierto() == true)
                    {
                        cajasRegistradoras.get(contador).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cajaRegistradora.png"));
                    }
                    else
                    {
                        cajasRegistradoras.get(contador).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cerrado.png"));
                    }
                    cajasRegistradoras.get(contador).setOpaque(false);
                    contador += 1;
                }
                //Articulos cajas normales
                contador = 0;
                for (javax.swing.JLabel i:articulos)
                {
                    i.setText( "|"+ String.valueOf(control.getCajaNormal(contador).getArticulos()) + "|");
                    i.setFont(new Font(Font.SERIF, Font.BOLD, 20));
                    //cajasRegistradoras.get(contador+3).setText(String.valueOf(control.getCajaNormal(contador).getEstaAbierto()));
                    //cajasRegistradoras.get(contador+3).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cajaRegistradora.png"));
                    if (control.getCajaNormal(contador).getEstaAbierto() == true)
                    {
                        cajasRegistradoras.get(contador+3).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cajaRegistradora.png"));
                    }
                    else
                    {
                        cajasRegistradoras.get(contador+3).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cerrado.png"));
                    }
                    cajasRegistradoras.get(contador+3).setOpaque(false);
                    
                    contador += 1;
                }
                //System.out.println("----------------------------------");
                //System.out.println("Clientes atendidos: " + control.getClientesAtendidos());
                clientesLabel.setText(String.valueOf(control.getClientesAtendidos()));
                //System.out.println("Articulos comprados: " + control.calcularArticulosAtendidos());
                articulosLabel.setText(String.valueOf(control.calcularArticulosAtendidos()));
                
                if (control.getContadorTiempo() == 601)
                {
                    timer.cancel();
                }
            }
        };
        //Pisos 
        this.pisos.add(piso1);
        this.pisos.add(piso2);
        this.pisos.add(piso3);
        this.pisos.add(piso4);
        this.pisos.add(piso5);
        this.pisos.add(piso6);
        this.pisos.add(piso7);
        this.pisos.add(piso8);
        this.pisos.add(piso9);
        this.pisos.add(piso10);
        this.pisos.add(piso11);
        this.pisos.add(piso12);
        this.pisos.add(piso13);
        this.pisos.add(piso14);
        this.pisos.add(piso15);
        this.pisos.add(piso16);
        this.pisos.add(piso17);
        this.pisos.add(piso18);
        this.pisos.add(piso19);
        this.pisos.add(piso20);
        for (javax.swing.JLabel i:pisos)
        {
            i.setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\piso.jpg"));
        }
        //Caja rapida 1
        this.clientesCajaRapida1.add(this.cajaRapida1cliente1);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente2);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente3);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente4);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente5);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente6);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente7);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente8);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente9);
        this.clientesCajaRapida1.add(this.cajaRapida1cliente10);
        this.articulosCajaRapida1.add(this.cajaRapida1Art1);
        this.articulosCajaRapida1.add(this.cajaRapida1Art2);
        this.articulosCajaRapida1.add(this.cajaRapida1Art3);
        this.articulosCajaRapida1.add(this.cajaRapida1Art4);
        this.articulosCajaRapida1.add(this.cajaRapida1Art5);
        this.articulosCajaRapida1.add(this.cajaRapida1Art6);
        this.articulosCajaRapida1.add(this.cajaRapida1Art7);
        this.articulosCajaRapida1.add(this.cajaRapida1Art8);
        this.articulosCajaRapida1.add(this.cajaRapida1Art9);
        this.articulosCajaRapida1.add(this.cajaRapida1Art10);
        //Caja rapida 2
        this.clientesCajaRapida2.add(this.cajaRapida2cliente1);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente2);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente3);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente4);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente5);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente6);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente7);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente8);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente9);
        this.clientesCajaRapida2.add(this.cajaRapida2cliente10);
        this.articulosCajaRapida2.add(this.cajaRapida2Art1);
        this.articulosCajaRapida2.add(this.cajaRapida2Art2);
        this.articulosCajaRapida2.add(this.cajaRapida2Art3);
        this.articulosCajaRapida2.add(this.cajaRapida2Art4);
        this.articulosCajaRapida2.add(this.cajaRapida2Art5);
        this.articulosCajaRapida2.add(this.cajaRapida2Art6);
        this.articulosCajaRapida2.add(this.cajaRapida2Art7);
        this.articulosCajaRapida2.add(this.cajaRapida2Art8);
        this.articulosCajaRapida2.add(this.cajaRapida2Art9);
        this.articulosCajaRapida2.add(this.cajaRapida2Art10);
        //Caja rapida 3
        this.clientesCajaRapida3.add(this.cajaRapida3cliente1);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente2);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente3);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente4);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente5);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente6);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente7);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente8);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente9);
        this.clientesCajaRapida3.add(this.cajaRapida3cliente10);
        this.articulosCajaRapida3.add(this.cajaRapida3Art1);
        this.articulosCajaRapida3.add(this.cajaRapida3Art2);
        this.articulosCajaRapida3.add(this.cajaRapida3Art3);
        this.articulosCajaRapida3.add(this.cajaRapida3Art4);
        this.articulosCajaRapida3.add(this.cajaRapida3Art5);
        this.articulosCajaRapida3.add(this.cajaRapida3Art6);
        this.articulosCajaRapida3.add(this.cajaRapida3Art7);
        this.articulosCajaRapida3.add(this.cajaRapida3Art8);
        this.articulosCajaRapida3.add(this.cajaRapida3Art9);
        this.articulosCajaRapida3.add(this.cajaRapida3Art10);
        ////////////////////////////////////////////////////
        //Cajas normales
        //Caja 1
        this.clientesCaja1.add(this.caja1Cliente1);
        this.clientesCaja1.add(this.caja1Cliente2);
        this.clientesCaja1.add(this.caja1Cliente3);
        this.clientesCaja1.add(this.caja1Cliente4);
        this.clientesCaja1.add(this.caja1Cliente5);
        this.clientesCaja1.add(this.caja1Cliente6);
        this.clientesCaja1.add(this.caja1Cliente7);
        this.clientesCaja1.add(this.caja1Cliente8);
        this.clientesCaja1.add(this.caja1Cliente9);
        this.clientesCaja1.add(this.caja1Cliente10);
        this.articulosCaja1.add(this.caja1Art1);
        this.articulosCaja1.add(this.caja1Art2);
        this.articulosCaja1.add(this.caja1Art3);
        this.articulosCaja1.add(this.caja1Art4);
        this.articulosCaja1.add(this.caja1Art5);
        this.articulosCaja1.add(this.caja1Art6);
        this.articulosCaja1.add(this.caja1Art7);
        this.articulosCaja1.add(this.caja1Art8);
        this.articulosCaja1.add(this.caja1Art9);
        this.articulosCaja1.add(this.caja1Art10);
        //Caja 2
        this.clientesCaja2.add(this.caja2Cliente1);
        this.clientesCaja2.add(this.caja2Cliente2);
        this.clientesCaja2.add(this.caja2Cliente3);
        this.clientesCaja2.add(this.caja2Cliente4);
        this.clientesCaja2.add(this.caja2Cliente5);
        this.clientesCaja2.add(this.caja2Cliente6);
        this.clientesCaja2.add(this.caja2Cliente7);
        this.clientesCaja2.add(this.caja2Cliente8);
        this.clientesCaja2.add(this.caja2Cliente9);
        this.clientesCaja2.add(this.caja2Cliente10);
        this.articulosCaja2.add(this.caja2Art1);
        this.articulosCaja2.add(this.caja2Art2);
        this.articulosCaja2.add(this.caja2Art3);
        this.articulosCaja2.add(this.caja2Art4);
        this.articulosCaja2.add(this.caja2Art5);
        this.articulosCaja2.add(this.caja2Art6);
        this.articulosCaja2.add(this.caja2Art7);
        this.articulosCaja2.add(this.caja2Art8);
        this.articulosCaja2.add(this.caja2Art9);
        this.articulosCaja2.add(this.caja2Art10);
        //Caja 3
        this.clientesCaja3.add(this.caja3Cliente1);
        this.clientesCaja3.add(this.caja3Cliente2);
        this.clientesCaja3.add(this.caja3Cliente3);
        this.clientesCaja3.add(this.caja3Cliente4);
        this.clientesCaja3.add(this.caja3Cliente5);
        this.clientesCaja3.add(this.caja3Cliente6);
        this.clientesCaja3.add(this.caja3Cliente7);
        this.clientesCaja3.add(this.caja3Cliente8);
        this.clientesCaja3.add(this.caja3Cliente9);
        this.clientesCaja3.add(this.caja3Cliente10);
        this.articulosCaja3.add(this.caja3Art1);
        this.articulosCaja3.add(this.caja3Art2);
        this.articulosCaja3.add(this.caja3Art3);
        this.articulosCaja3.add(this.caja3Art4);
        this.articulosCaja3.add(this.caja3Art5);
        this.articulosCaja3.add(this.caja3Art6);
        this.articulosCaja3.add(this.caja3Art7);
        this.articulosCaja3.add(this.caja3Art8);
        this.articulosCaja3.add(this.caja3Art9);
        this.articulosCaja3.add(this.caja3Art10);
        //Caja 4
        this.clientesCaja4.add(this.caja4Cliente1);
        this.clientesCaja4.add(this.caja4Cliente2);
        this.clientesCaja4.add(this.caja4Cliente3);
        this.clientesCaja4.add(this.caja4Cliente4);
        this.clientesCaja4.add(this.caja4Cliente5);
        this.clientesCaja4.add(this.caja4Cliente6);
        this.clientesCaja4.add(this.caja4Cliente7);
        this.clientesCaja4.add(this.caja4Cliente8);
        this.clientesCaja4.add(this.caja4Cliente9);
        this.clientesCaja4.add(this.caja4Cliente10);
        this.articulosCaja4.add(this.caja4Art1);
        this.articulosCaja4.add(this.caja4Art2);
        this.articulosCaja4.add(this.caja4Art3);
        this.articulosCaja4.add(this.caja4Art4);
        this.articulosCaja4.add(this.caja4Art5);
        this.articulosCaja4.add(this.caja4Art6);
        this.articulosCaja4.add(this.caja4Art7);
        this.articulosCaja4.add(this.caja4Art8);
        this.articulosCaja4.add(this.caja4Art9);
        this.articulosCaja4.add(this.caja4Art10);
        //Caja 5
        this.clientesCaja5.add(this.caja5Cliente1);
        this.clientesCaja5.add(this.caja5Cliente2);
        this.clientesCaja5.add(this.caja5Cliente3);
        this.clientesCaja5.add(this.caja5Cliente4);
        this.clientesCaja5.add(this.caja5Cliente5);
        this.clientesCaja5.add(this.caja5Cliente6);
        this.clientesCaja5.add(this.caja5Cliente7);
        this.clientesCaja5.add(this.caja5Cliente8);
        this.clientesCaja5.add(this.caja5Cliente9);
        this.clientesCaja5.add(this.caja5Cliente10);
        this.articulosCaja5.add(this.caja5Art1);
        this.articulosCaja5.add(this.caja5Art2);
        this.articulosCaja5.add(this.caja5Art3);
        this.articulosCaja5.add(this.caja5Art4);
        this.articulosCaja5.add(this.caja5Art5);
        this.articulosCaja5.add(this.caja5Art6);
        this.articulosCaja5.add(this.caja5Art7);
        this.articulosCaja5.add(this.caja5Art8);
        this.articulosCaja5.add(this.caja5Art9);
        this.articulosCaja5.add(this.caja5Art10);
        //Caja 6
        this.clientesCaja6.add(this.caja6Cliente1);
        this.clientesCaja6.add(this.caja6Cliente2);
        this.clientesCaja6.add(this.caja6Cliente3);
        this.clientesCaja6.add(this.caja6Cliente4);
        this.clientesCaja6.add(this.caja6Cliente5);
        this.clientesCaja6.add(this.caja6Cliente6);
        this.clientesCaja6.add(this.caja6Cliente7);
        this.clientesCaja6.add(this.caja6Cliente8);
        this.clientesCaja6.add(this.caja6Cliente9);
        this.clientesCaja6.add(this.caja6Cliente10);
        this.articulosCaja6.add(this.caja6Art1);
        this.articulosCaja6.add(this.caja6Art2);
        this.articulosCaja6.add(this.caja6Art3);
        this.articulosCaja6.add(this.caja6Art4);
        this.articulosCaja6.add(this.caja6Art5);
        this.articulosCaja6.add(this.caja6Art6);
        this.articulosCaja6.add(this.caja6Art7);
        this.articulosCaja6.add(this.caja6Art8);
        this.articulosCaja6.add(this.caja6Art9);
        this.articulosCaja6.add(this.caja6Art10);
        //Caja 7
        this.clientesCaja7.add(this.caja7Cliente1);
        this.clientesCaja7.add(this.caja7Cliente2);
        this.clientesCaja7.add(this.caja7Cliente3);
        this.clientesCaja7.add(this.caja7Cliente4);
        this.clientesCaja7.add(this.caja7Cliente5);
        this.clientesCaja7.add(this.caja7Cliente6);
        this.clientesCaja7.add(this.caja7Cliente7);
        this.clientesCaja7.add(this.caja7Cliente8);
        this.clientesCaja7.add(this.caja7Cliente9);
        this.clientesCaja7.add(this.caja7Cliente10);
        this.articulosCaja7.add(this.caja7Art1);
        this.articulosCaja7.add(this.caja7Art2);
        this.articulosCaja7.add(this.caja7Art3);
        this.articulosCaja7.add(this.caja7Art4);
        this.articulosCaja7.add(this.caja7Art5);
        this.articulosCaja7.add(this.caja7Art6);
        this.articulosCaja7.add(this.caja7Art7);
        this.articulosCaja7.add(this.caja7Art8);
        this.articulosCaja7.add(this.caja7Art9);
        this.articulosCaja7.add(this.caja7Art10);
        //Cantidad de articulos
        this.articulosRapidos.add(this.jLabel5);
        this.articulosRapidos.add(this.jLabel7);
        this.articulosRapidos.add(this.jLabel8);
        this.articulos.add(this.articulosCajaLabel1);
        this.articulos.add(this.articulosCajaLabel2);
        this.articulos.add(this.articulosCajaLabel3);
        this.articulos.add(this.articulosCajaLabel4);
        this.articulos.add(this.articulosCajaLabel5);
        this.articulos.add(this.articulosCajaLabel6);
        this.articulos.add(this.articulosCajaLabel7);
        //Cajas registradoras
        this.cajasRegistradoras.add(this.cajaRegistradora1);
        this.cajasRegistradoras.add(this.cajaRegistradora2);
        this.cajasRegistradoras.add(this.cajaRegistradora3);
        this.cajasRegistradoras.add(this.cajaRegistradora4);
        this.cajasRegistradoras.add(this.cajaRegistradora5);
        this.cajasRegistradoras.add(this.cajaRegistradora6);
        this.cajasRegistradoras.add(this.cajaRegistradora7);
        this.cajasRegistradoras.add(this.cajaRegistradora8);
        this.cajasRegistradoras.add(this.cajaRegistradora9);
        this.cajasRegistradoras.add(this.cajaRegistradora10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        clientesTexto = new javax.swing.JLabel();
        clientesLabel = new javax.swing.JLabel();
        minutoTexto = new javax.swing.JLabel();
        minutosLabel = new javax.swing.JLabel();
        articulosTexto = new javax.swing.JLabel();
        articulosLabel = new javax.swing.JLabel();
        fastLine = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cajaRegistradora1 = new javax.swing.JLabel();
        cajaRegistradora2 = new javax.swing.JLabel();
        cajaRegistradora3 = new javax.swing.JLabel();
        normalLine = new javax.swing.JLabel();
        articulosCajaLabel1 = new javax.swing.JLabel();
        articulosCajaLabel2 = new javax.swing.JLabel();
        articulosCajaLabel3 = new javax.swing.JLabel();
        articulosCajaLabel4 = new javax.swing.JLabel();
        articulosCajaLabel5 = new javax.swing.JLabel();
        articulosCajaLabel6 = new javax.swing.JLabel();
        articulosCajaLabel7 = new javax.swing.JLabel();
        cajaRegistradora4 = new javax.swing.JLabel();
        cajaRegistradora5 = new javax.swing.JLabel();
        cajaRegistradora6 = new javax.swing.JLabel();
        cajaRegistradora7 = new javax.swing.JLabel();
        cajaRegistradora8 = new javax.swing.JLabel();
        cajaRegistradora9 = new javax.swing.JLabel();
        cajaRegistradora10 = new javax.swing.JLabel();
        cajaRapida1Art1 = new javax.swing.JLabel();
        cajaRapida1cliente1 = new javax.swing.JLabel();
        cajaRapida1Art2 = new javax.swing.JLabel();
        cajaRapida1cliente2 = new javax.swing.JLabel();
        cajaRapida1Art3 = new javax.swing.JLabel();
        cajaRapida1cliente3 = new javax.swing.JLabel();
        cajaRapida1cliente4 = new javax.swing.JLabel();
        cajaRapida1Art4 = new javax.swing.JLabel();
        cajaRapida1cliente5 = new javax.swing.JLabel();
        cajaRapida1Art5 = new javax.swing.JLabel();
        cajaRapida1cliente6 = new javax.swing.JLabel();
        cajaRapida1Art6 = new javax.swing.JLabel();
        cajaRapida1cliente7 = new javax.swing.JLabel();
        cajaRapida1Art7 = new javax.swing.JLabel();
        cajaRapida1Art8 = new javax.swing.JLabel();
        cajaRapida1cliente8 = new javax.swing.JLabel();
        cajaRapida1Art9 = new javax.swing.JLabel();
        cajaRapida1cliente9 = new javax.swing.JLabel();
        cajaRapida1Art10 = new javax.swing.JLabel();
        cajaRapida1cliente10 = new javax.swing.JLabel();
        cajaRapida2Art1 = new javax.swing.JLabel();
        cajaRapida2cliente1 = new javax.swing.JLabel();
        cajaRapida3Art1 = new javax.swing.JLabel();
        cajaRapida3cliente1 = new javax.swing.JLabel();
        caja1Art1 = new javax.swing.JLabel();
        caja1Cliente1 = new javax.swing.JLabel();
        caja2Art1 = new javax.swing.JLabel();
        caja2Cliente1 = new javax.swing.JLabel();
        caja3Art1 = new javax.swing.JLabel();
        caja3Cliente1 = new javax.swing.JLabel();
        caja4Art1 = new javax.swing.JLabel();
        caja4Cliente1 = new javax.swing.JLabel();
        caja5Art1 = new javax.swing.JLabel();
        caja5Cliente1 = new javax.swing.JLabel();
        caja6Art1 = new javax.swing.JLabel();
        caja6Cliente1 = new javax.swing.JLabel();
        caja7Art1 = new javax.swing.JLabel();
        caja7Cliente1 = new javax.swing.JLabel();
        cajaRapida2cliente2 = new javax.swing.JLabel();
        cajaRapida2Art2 = new javax.swing.JLabel();
        cajaRapida2cliente3 = new javax.swing.JLabel();
        cajaRapida2Art3 = new javax.swing.JLabel();
        cajaRapida2Art4 = new javax.swing.JLabel();
        cajaRapida2cliente4 = new javax.swing.JLabel();
        cajaRapida2Art5 = new javax.swing.JLabel();
        cajaRapida2cliente5 = new javax.swing.JLabel();
        cajaRapida2Art6 = new javax.swing.JLabel();
        cajaRapida2cliente6 = new javax.swing.JLabel();
        cajaRapida2Art7 = new javax.swing.JLabel();
        cajaRapida2cliente7 = new javax.swing.JLabel();
        cajaRapida2Art8 = new javax.swing.JLabel();
        cajaRapida2cliente8 = new javax.swing.JLabel();
        cajaRapida2Art9 = new javax.swing.JLabel();
        cajaRapida2cliente9 = new javax.swing.JLabel();
        cajaRapida2Art10 = new javax.swing.JLabel();
        cajaRapida2cliente10 = new javax.swing.JLabel();
        cajaRapida3Art2 = new javax.swing.JLabel();
        cajaRapida3cliente2 = new javax.swing.JLabel();
        cajaRapida3Art3 = new javax.swing.JLabel();
        cajaRapida3cliente3 = new javax.swing.JLabel();
        cajaRapida3Art4 = new javax.swing.JLabel();
        cajaRapida3cliente4 = new javax.swing.JLabel();
        cajaRapida3Art5 = new javax.swing.JLabel();
        cajaRapida3cliente5 = new javax.swing.JLabel();
        cajaRapida3Art6 = new javax.swing.JLabel();
        cajaRapida3cliente6 = new javax.swing.JLabel();
        cajaRapida3Art7 = new javax.swing.JLabel();
        cajaRapida3cliente7 = new javax.swing.JLabel();
        cajaRapida3Art8 = new javax.swing.JLabel();
        cajaRapida3cliente8 = new javax.swing.JLabel();
        cajaRapida3Art9 = new javax.swing.JLabel();
        cajaRapida3cliente9 = new javax.swing.JLabel();
        cajaRapida3Art10 = new javax.swing.JLabel();
        cajaRapida3cliente10 = new javax.swing.JLabel();
        caja1Art2 = new javax.swing.JLabel();
        caja1Cliente2 = new javax.swing.JLabel();
        caja1Art3 = new javax.swing.JLabel();
        caja1Cliente3 = new javax.swing.JLabel();
        caja1Art4 = new javax.swing.JLabel();
        caja1Cliente4 = new javax.swing.JLabel();
        caja1Art5 = new javax.swing.JLabel();
        caja1Cliente5 = new javax.swing.JLabel();
        caja1Art6 = new javax.swing.JLabel();
        caja1Cliente6 = new javax.swing.JLabel();
        caja1Art7 = new javax.swing.JLabel();
        caja1Cliente7 = new javax.swing.JLabel();
        caja1Art8 = new javax.swing.JLabel();
        caja1Cliente8 = new javax.swing.JLabel();
        caja1Art9 = new javax.swing.JLabel();
        caja1Cliente9 = new javax.swing.JLabel();
        caja1Art10 = new javax.swing.JLabel();
        caja1Cliente10 = new javax.swing.JLabel();
        caja2Cliente2 = new javax.swing.JLabel();
        caja2Art2 = new javax.swing.JLabel();
        caja2Cliente3 = new javax.swing.JLabel();
        caja2Art3 = new javax.swing.JLabel();
        caja2Cliente4 = new javax.swing.JLabel();
        caja2Art4 = new javax.swing.JLabel();
        caja2Cliente5 = new javax.swing.JLabel();
        caja2Art5 = new javax.swing.JLabel();
        caja2Cliente6 = new javax.swing.JLabel();
        caja2Art6 = new javax.swing.JLabel();
        caja2Cliente7 = new javax.swing.JLabel();
        caja2Art7 = new javax.swing.JLabel();
        caja2Cliente8 = new javax.swing.JLabel();
        caja2Art8 = new javax.swing.JLabel();
        caja2Cliente9 = new javax.swing.JLabel();
        caja2Art9 = new javax.swing.JLabel();
        caja2Cliente10 = new javax.swing.JLabel();
        caja2Art10 = new javax.swing.JLabel();
        caja3Cliente2 = new javax.swing.JLabel();
        caja3Art2 = new javax.swing.JLabel();
        caja3Cliente3 = new javax.swing.JLabel();
        caja3Art3 = new javax.swing.JLabel();
        caja3Cliente4 = new javax.swing.JLabel();
        caja3Art4 = new javax.swing.JLabel();
        caja3Cliente5 = new javax.swing.JLabel();
        caja3Art5 = new javax.swing.JLabel();
        caja3Cliente6 = new javax.swing.JLabel();
        caja3Art6 = new javax.swing.JLabel();
        caja3Cliente7 = new javax.swing.JLabel();
        caja3Art7 = new javax.swing.JLabel();
        caja3Cliente8 = new javax.swing.JLabel();
        caja3Art8 = new javax.swing.JLabel();
        caja3Cliente9 = new javax.swing.JLabel();
        caja3Art9 = new javax.swing.JLabel();
        caja3Cliente10 = new javax.swing.JLabel();
        caja3Art10 = new javax.swing.JLabel();
        caja4Art2 = new javax.swing.JLabel();
        caja4Cliente2 = new javax.swing.JLabel();
        caja4Art3 = new javax.swing.JLabel();
        caja4Cliente3 = new javax.swing.JLabel();
        caja4Cliente4 = new javax.swing.JLabel();
        caja4Art4 = new javax.swing.JLabel();
        caja4Cliente5 = new javax.swing.JLabel();
        caja4Art5 = new javax.swing.JLabel();
        caja4Cliente6 = new javax.swing.JLabel();
        caja4Art6 = new javax.swing.JLabel();
        caja4Cliente7 = new javax.swing.JLabel();
        caja4Art7 = new javax.swing.JLabel();
        caja4Cliente8 = new javax.swing.JLabel();
        caja4Art8 = new javax.swing.JLabel();
        caja4Cliente9 = new javax.swing.JLabel();
        caja4Art9 = new javax.swing.JLabel();
        caja4Cliente10 = new javax.swing.JLabel();
        caja4Art10 = new javax.swing.JLabel();
        caja5Art2 = new javax.swing.JLabel();
        caja5Cliente2 = new javax.swing.JLabel();
        caja5Art3 = new javax.swing.JLabel();
        caja5Cliente3 = new javax.swing.JLabel();
        caja5Cliente4 = new javax.swing.JLabel();
        caja5Art4 = new javax.swing.JLabel();
        caja5Cliente5 = new javax.swing.JLabel();
        caja5Art5 = new javax.swing.JLabel();
        caja5Cliente6 = new javax.swing.JLabel();
        caja5Art6 = new javax.swing.JLabel();
        caja5Cliente7 = new javax.swing.JLabel();
        caja5Art7 = new javax.swing.JLabel();
        caja5Cliente8 = new javax.swing.JLabel();
        caja5Art8 = new javax.swing.JLabel();
        caja5Cliente9 = new javax.swing.JLabel();
        caja5Art9 = new javax.swing.JLabel();
        caja5Cliente10 = new javax.swing.JLabel();
        caja5Art10 = new javax.swing.JLabel();
        caja6Art2 = new javax.swing.JLabel();
        caja6Cliente2 = new javax.swing.JLabel();
        caja6Art3 = new javax.swing.JLabel();
        caja6Cliente3 = new javax.swing.JLabel();
        caja6Cliente4 = new javax.swing.JLabel();
        caja6Art4 = new javax.swing.JLabel();
        caja6Cliente5 = new javax.swing.JLabel();
        caja6Art5 = new javax.swing.JLabel();
        caja6Cliente6 = new javax.swing.JLabel();
        caja6Art6 = new javax.swing.JLabel();
        caja6Cliente7 = new javax.swing.JLabel();
        caja6Art7 = new javax.swing.JLabel();
        caja6Cliente8 = new javax.swing.JLabel();
        caja6Art8 = new javax.swing.JLabel();
        caja6Cliente9 = new javax.swing.JLabel();
        caja6Art9 = new javax.swing.JLabel();
        caja6Cliente10 = new javax.swing.JLabel();
        caja6Art10 = new javax.swing.JLabel();
        caja7Art2 = new javax.swing.JLabel();
        caja7Cliente2 = new javax.swing.JLabel();
        caja7Art3 = new javax.swing.JLabel();
        caja7Cliente3 = new javax.swing.JLabel();
        caja7Cliente4 = new javax.swing.JLabel();
        caja7Art4 = new javax.swing.JLabel();
        caja7Cliente5 = new javax.swing.JLabel();
        caja7Art5 = new javax.swing.JLabel();
        caja7Cliente6 = new javax.swing.JLabel();
        caja7Art6 = new javax.swing.JLabel();
        caja7Cliente7 = new javax.swing.JLabel();
        caja7Art7 = new javax.swing.JLabel();
        caja7Cliente8 = new javax.swing.JLabel();
        caja7Art8 = new javax.swing.JLabel();
        caja7Cliente9 = new javax.swing.JLabel();
        caja7Art9 = new javax.swing.JLabel();
        caja7Cliente10 = new javax.swing.JLabel();
        caja7Art10 = new javax.swing.JLabel();
        sigClienteTexto = new javax.swing.JLabel();
        siguienteClienteLabel = new javax.swing.JLabel();
        piso1 = new javax.swing.JLabel();
        piso2 = new javax.swing.JLabel();
        piso3 = new javax.swing.JLabel();
        piso4 = new javax.swing.JLabel();
        piso5 = new javax.swing.JLabel();
        piso6 = new javax.swing.JLabel();
        piso7 = new javax.swing.JLabel();
        piso8 = new javax.swing.JLabel();
        piso9 = new javax.swing.JLabel();
        piso10 = new javax.swing.JLabel();
        piso11 = new javax.swing.JLabel();
        piso12 = new javax.swing.JLabel();
        piso13 = new javax.swing.JLabel();
        piso14 = new javax.swing.JLabel();
        piso15 = new javax.swing.JLabel();
        piso16 = new javax.swing.JLabel();
        piso17 = new javax.swing.JLabel();
        piso18 = new javax.swing.JLabel();
        piso19 = new javax.swing.JLabel();
        piso20 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 586));
        getContentPane().setLayout(null);

        clientesTexto.setText("Clientes Atendidos: ");
        getContentPane().add(clientesTexto);
        clientesTexto.setBounds(10, 0, 130, 30);

        clientesLabel.setText("###");
        getContentPane().add(clientesLabel);
        clientesLabel.setBounds(140, 0, 30, 30);

        minutoTexto.setText("Minuto:");
        getContentPane().add(minutoTexto);
        minutoTexto.setBounds(220, 0, 60, 30);

        minutosLabel.setText("###");
        getContentPane().add(minutosLabel);
        minutosLabel.setBounds(290, 0, 37, 30);

        articulosTexto.setText("Articulos totales:");
        getContentPane().add(articulosTexto);
        articulosTexto.setBounds(340, 0, 120, 30);

        articulosLabel.setText("####");
        getContentPane().add(articulosLabel);
        articulosLabel.setBounds(470, 0, 50, 30);

        fastLine.setText("Fast lines:");
        getContentPane().add(fastLine);
        fastLine.setBounds(15, 31, 70, 32);

        jLabel5.setText("####");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(15, 81, 37, 16);

        jLabel7.setText("####");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(15, 127, 37, 16);

        jLabel8.setText("####");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(15, 173, 37, 16);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 3, 72, 30);
        getContentPane().add(cajaRegistradora1);
        cajaRegistradora1.setBounds(64, 69, 30, 30);
        getContentPane().add(cajaRegistradora2);
        cajaRegistradora2.setBounds(64, 115, 30, 30);
        getContentPane().add(cajaRegistradora3);
        cajaRegistradora3.setBounds(64, 161, 30, 30);

        normalLine.setText("Normal lines:");
        getContentPane().add(normalLine);
        normalLine.setBounds(10, 200, 100, 30);

        articulosCajaLabel1.setText("####");
        getContentPane().add(articulosCajaLabel1);
        articulosCajaLabel1.setBounds(15, 243, 43, 16);

        articulosCajaLabel2.setText("####");
        getContentPane().add(articulosCajaLabel2);
        articulosCajaLabel2.setBounds(15, 289, 43, 16);

        articulosCajaLabel3.setText("####");
        getContentPane().add(articulosCajaLabel3);
        articulosCajaLabel3.setBounds(15, 333, 43, 16);

        articulosCajaLabel4.setText("####");
        getContentPane().add(articulosCajaLabel4);
        articulosCajaLabel4.setBounds(15, 373, 43, 16);

        articulosCajaLabel5.setText("####");
        getContentPane().add(articulosCajaLabel5);
        articulosCajaLabel5.setBounds(15, 419, 43, 16);

        articulosCajaLabel6.setText("####");
        getContentPane().add(articulosCajaLabel6);
        articulosCajaLabel6.setBounds(15, 465, 43, 16);

        articulosCajaLabel7.setText("####");
        getContentPane().add(articulosCajaLabel7);
        articulosCajaLabel7.setBounds(15, 511, 43, 16);
        getContentPane().add(cajaRegistradora4);
        cajaRegistradora4.setBounds(64, 231, 30, 30);
        getContentPane().add(cajaRegistradora5);
        cajaRegistradora5.setBounds(64, 277, 30, 40);
        getContentPane().add(cajaRegistradora6);
        cajaRegistradora6.setBounds(64, 321, 30, 30);
        getContentPane().add(cajaRegistradora7);
        cajaRegistradora7.setBounds(64, 361, 30, 30);
        getContentPane().add(cajaRegistradora8);
        cajaRegistradora8.setBounds(64, 407, 30, 30);
        getContentPane().add(cajaRegistradora9);
        cajaRegistradora9.setBounds(64, 453, 30, 30);
        getContentPane().add(cajaRegistradora10);
        cajaRegistradora10.setBounds(64, 499, 30, 30);

        cajaRapida1Art1.setText("[##]");
        getContentPane().add(cajaRapida1Art1);
        cajaRapida1Art1.setBounds(135, 81, 22, 16);
        getContentPane().add(cajaRapida1cliente1);
        cajaRapida1cliente1.setBounds(169, 69, 35, 40);

        cajaRapida1Art2.setText("[##]");
        getContentPane().add(cajaRapida1Art2);
        cajaRapida1Art2.setBounds(216, 81, 22, 16);

        cajaRapida1cliente2.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente2);
        cajaRapida1cliente2.setBounds(244, 69, 35, 40);

        cajaRapida1Art3.setText("[##]");
        getContentPane().add(cajaRapida1Art3);
        cajaRapida1Art3.setBounds(291, 81, 22, 16);

        cajaRapida1cliente3.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente3);
        cajaRapida1cliente3.setBounds(319, 69, 35, 40);

        cajaRapida1cliente4.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente4);
        cajaRapida1cliente4.setBounds(388, 69, 35, 40);

        cajaRapida1Art4.setText("[##]");
        getContentPane().add(cajaRapida1Art4);
        cajaRapida1Art4.setBounds(360, 81, 22, 16);

        cajaRapida1cliente5.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente5);
        cajaRapida1cliente5.setBounds(457, 69, 35, 40);

        cajaRapida1Art5.setText("[##]");
        getContentPane().add(cajaRapida1Art5);
        cajaRapida1Art5.setBounds(429, 81, 22, 16);

        cajaRapida1cliente6.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente6);
        cajaRapida1cliente6.setBounds(526, 69, 35, 40);

        cajaRapida1Art6.setText("[##]");
        getContentPane().add(cajaRapida1Art6);
        cajaRapida1Art6.setBounds(498, 81, 22, 16);

        cajaRapida1cliente7.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente7);
        cajaRapida1cliente7.setBounds(595, 69, 35, 40);

        cajaRapida1Art7.setText("[##]");
        getContentPane().add(cajaRapida1Art7);
        cajaRapida1Art7.setBounds(567, 81, 22, 16);

        cajaRapida1Art8.setText("[##]");
        getContentPane().add(cajaRapida1Art8);
        cajaRapida1Art8.setBounds(636, 81, 22, 16);

        cajaRapida1cliente8.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente8);
        cajaRapida1cliente8.setBounds(664, 69, 35, 40);

        cajaRapida1Art9.setText("[##]");
        getContentPane().add(cajaRapida1Art9);
        cajaRapida1Art9.setBounds(705, 81, 22, 16);

        cajaRapida1cliente9.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente9);
        cajaRapida1cliente9.setBounds(733, 69, 35, 40);

        cajaRapida1Art10.setText("[##]");
        getContentPane().add(cajaRapida1Art10);
        cajaRapida1Art10.setBounds(774, 81, 22, 16);

        cajaRapida1cliente10.setText("jLabel11");
        getContentPane().add(cajaRapida1cliente10);
        cajaRapida1cliente10.setBounds(802, 69, 35, 40);

        cajaRapida2Art1.setText("[##]");
        getContentPane().add(cajaRapida2Art1);
        cajaRapida2Art1.setBounds(135, 127, 22, 16);
        getContentPane().add(cajaRapida2cliente1);
        cajaRapida2cliente1.setBounds(169, 115, 35, 40);

        cajaRapida3Art1.setText("[##]");
        getContentPane().add(cajaRapida3Art1);
        cajaRapida3Art1.setBounds(135, 173, 22, 16);

        cajaRapida3cliente1.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente1);
        cajaRapida3cliente1.setBounds(169, 161, 35, 40);

        caja1Art1.setText("[##]");
        getContentPane().add(caja1Art1);
        caja1Art1.setBounds(135, 243, 22, 16);
        getContentPane().add(caja1Cliente1);
        caja1Cliente1.setBounds(169, 231, 35, 40);

        caja2Art1.setText("[##]");
        getContentPane().add(caja2Art1);
        caja2Art1.setBounds(135, 289, 22, 16);

        caja2Cliente1.setText("jLabel11");
        getContentPane().add(caja2Cliente1);
        caja2Cliente1.setBounds(169, 277, 35, 40);

        caja3Art1.setText("[##]");
        getContentPane().add(caja3Art1);
        caja3Art1.setBounds(135, 333, 22, 16);

        caja3Cliente1.setText("jLabel11");
        getContentPane().add(caja3Cliente1);
        caja3Cliente1.setBounds(169, 321, 35, 40);

        caja4Art1.setText("[##]");
        getContentPane().add(caja4Art1);
        caja4Art1.setBounds(135, 373, 22, 16);

        caja4Cliente1.setText("jLabel11");
        getContentPane().add(caja4Cliente1);
        caja4Cliente1.setBounds(169, 361, 35, 40);

        caja5Art1.setText("[##]");
        getContentPane().add(caja5Art1);
        caja5Art1.setBounds(135, 419, 22, 16);

        caja5Cliente1.setText("jLabel11");
        getContentPane().add(caja5Cliente1);
        caja5Cliente1.setBounds(169, 407, 35, 40);

        caja6Art1.setText("[##]");
        getContentPane().add(caja6Art1);
        caja6Art1.setBounds(135, 465, 22, 16);

        caja6Cliente1.setText("jLabel11");
        getContentPane().add(caja6Cliente1);
        caja6Cliente1.setBounds(169, 453, 35, 40);

        caja7Art1.setText("[##]");
        getContentPane().add(caja7Art1);
        caja7Art1.setBounds(135, 511, 22, 16);

        caja7Cliente1.setText("jLabel11");
        getContentPane().add(caja7Cliente1);
        caja7Cliente1.setBounds(169, 499, 35, 40);

        cajaRapida2cliente2.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente2);
        cajaRapida2cliente2.setBounds(244, 115, 35, 40);

        cajaRapida2Art2.setText("[##]");
        getContentPane().add(cajaRapida2Art2);
        cajaRapida2Art2.setBounds(216, 127, 22, 16);

        cajaRapida2cliente3.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente3);
        cajaRapida2cliente3.setBounds(319, 115, 35, 40);

        cajaRapida2Art3.setText("[##]");
        getContentPane().add(cajaRapida2Art3);
        cajaRapida2Art3.setBounds(291, 127, 22, 16);

        cajaRapida2Art4.setText("[##]");
        getContentPane().add(cajaRapida2Art4);
        cajaRapida2Art4.setBounds(360, 127, 22, 16);

        cajaRapida2cliente4.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente4);
        cajaRapida2cliente4.setBounds(388, 115, 35, 40);

        cajaRapida2Art5.setText("[##]");
        getContentPane().add(cajaRapida2Art5);
        cajaRapida2Art5.setBounds(429, 127, 22, 16);

        cajaRapida2cliente5.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente5);
        cajaRapida2cliente5.setBounds(457, 115, 35, 40);

        cajaRapida2Art6.setText("[##]");
        getContentPane().add(cajaRapida2Art6);
        cajaRapida2Art6.setBounds(498, 127, 22, 16);

        cajaRapida2cliente6.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente6);
        cajaRapida2cliente6.setBounds(526, 115, 35, 40);

        cajaRapida2Art7.setText("[##]");
        getContentPane().add(cajaRapida2Art7);
        cajaRapida2Art7.setBounds(567, 127, 22, 16);

        cajaRapida2cliente7.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente7);
        cajaRapida2cliente7.setBounds(595, 115, 35, 40);

        cajaRapida2Art8.setText("[##]");
        getContentPane().add(cajaRapida2Art8);
        cajaRapida2Art8.setBounds(636, 127, 22, 16);

        cajaRapida2cliente8.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente8);
        cajaRapida2cliente8.setBounds(664, 115, 35, 40);

        cajaRapida2Art9.setText("[##]");
        getContentPane().add(cajaRapida2Art9);
        cajaRapida2Art9.setBounds(705, 127, 22, 16);

        cajaRapida2cliente9.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente9);
        cajaRapida2cliente9.setBounds(733, 115, 35, 40);

        cajaRapida2Art10.setText("[##]");
        getContentPane().add(cajaRapida2Art10);
        cajaRapida2Art10.setBounds(774, 127, 22, 16);

        cajaRapida2cliente10.setText("jLabel11");
        getContentPane().add(cajaRapida2cliente10);
        cajaRapida2cliente10.setBounds(802, 115, 35, 40);

        cajaRapida3Art2.setText("[##]");
        getContentPane().add(cajaRapida3Art2);
        cajaRapida3Art2.setBounds(216, 173, 22, 16);

        cajaRapida3cliente2.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente2);
        cajaRapida3cliente2.setBounds(244, 161, 35, 40);

        cajaRapida3Art3.setText("[##]");
        getContentPane().add(cajaRapida3Art3);
        cajaRapida3Art3.setBounds(291, 173, 22, 16);

        cajaRapida3cliente3.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente3);
        cajaRapida3cliente3.setBounds(319, 161, 35, 40);

        cajaRapida3Art4.setText("[##]");
        getContentPane().add(cajaRapida3Art4);
        cajaRapida3Art4.setBounds(360, 173, 22, 16);

        cajaRapida3cliente4.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente4);
        cajaRapida3cliente4.setBounds(388, 161, 35, 40);

        cajaRapida3Art5.setText("[##]");
        getContentPane().add(cajaRapida3Art5);
        cajaRapida3Art5.setBounds(429, 173, 22, 16);

        cajaRapida3cliente5.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente5);
        cajaRapida3cliente5.setBounds(457, 161, 35, 40);

        cajaRapida3Art6.setText("[##]");
        getContentPane().add(cajaRapida3Art6);
        cajaRapida3Art6.setBounds(498, 173, 22, 16);

        cajaRapida3cliente6.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente6);
        cajaRapida3cliente6.setBounds(526, 161, 35, 40);

        cajaRapida3Art7.setText("[##]");
        getContentPane().add(cajaRapida3Art7);
        cajaRapida3Art7.setBounds(567, 173, 22, 16);

        cajaRapida3cliente7.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente7);
        cajaRapida3cliente7.setBounds(595, 161, 35, 40);

        cajaRapida3Art8.setText("[##]");
        getContentPane().add(cajaRapida3Art8);
        cajaRapida3Art8.setBounds(636, 173, 22, 16);

        cajaRapida3cliente8.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente8);
        cajaRapida3cliente8.setBounds(664, 161, 35, 40);

        cajaRapida3Art9.setText("[##]");
        getContentPane().add(cajaRapida3Art9);
        cajaRapida3Art9.setBounds(705, 173, 22, 16);

        cajaRapida3cliente9.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente9);
        cajaRapida3cliente9.setBounds(733, 161, 35, 40);

        cajaRapida3Art10.setText("[##]");
        getContentPane().add(cajaRapida3Art10);
        cajaRapida3Art10.setBounds(774, 173, 22, 16);

        cajaRapida3cliente10.setText("jLabel11");
        getContentPane().add(cajaRapida3cliente10);
        cajaRapida3cliente10.setBounds(802, 161, 35, 40);

        caja1Art2.setText("[##]");
        getContentPane().add(caja1Art2);
        caja1Art2.setBounds(216, 243, 22, 16);
        getContentPane().add(caja1Cliente2);
        caja1Cliente2.setBounds(244, 231, 35, 40);

        caja1Art3.setText("[##]");
        getContentPane().add(caja1Art3);
        caja1Art3.setBounds(291, 243, 22, 16);

        caja1Cliente3.setText("jLabel11");
        getContentPane().add(caja1Cliente3);
        caja1Cliente3.setBounds(319, 231, 35, 40);

        caja1Art4.setText("[##]");
        getContentPane().add(caja1Art4);
        caja1Art4.setBounds(360, 243, 22, 16);

        caja1Cliente4.setText("jLabel11");
        getContentPane().add(caja1Cliente4);
        caja1Cliente4.setBounds(388, 231, 35, 40);

        caja1Art5.setText("[##]");
        getContentPane().add(caja1Art5);
        caja1Art5.setBounds(429, 243, 22, 16);

        caja1Cliente5.setText("jLabel11");
        getContentPane().add(caja1Cliente5);
        caja1Cliente5.setBounds(457, 231, 35, 40);

        caja1Art6.setText("[##]");
        getContentPane().add(caja1Art6);
        caja1Art6.setBounds(498, 243, 22, 16);

        caja1Cliente6.setText("jLabel11");
        getContentPane().add(caja1Cliente6);
        caja1Cliente6.setBounds(526, 231, 35, 40);

        caja1Art7.setText("[##]");
        getContentPane().add(caja1Art7);
        caja1Art7.setBounds(567, 243, 22, 16);

        caja1Cliente7.setText("jLabel11");
        getContentPane().add(caja1Cliente7);
        caja1Cliente7.setBounds(595, 231, 35, 40);

        caja1Art8.setText("[##]");
        getContentPane().add(caja1Art8);
        caja1Art8.setBounds(636, 243, 22, 16);

        caja1Cliente8.setText("jLabel11");
        getContentPane().add(caja1Cliente8);
        caja1Cliente8.setBounds(664, 231, 35, 40);

        caja1Art9.setText("[##]");
        getContentPane().add(caja1Art9);
        caja1Art9.setBounds(705, 243, 22, 16);

        caja1Cliente9.setText("jLabel11");
        getContentPane().add(caja1Cliente9);
        caja1Cliente9.setBounds(733, 231, 35, 40);

        caja1Art10.setText("[##]");
        getContentPane().add(caja1Art10);
        caja1Art10.setBounds(774, 243, 22, 16);

        caja1Cliente10.setText("jLabel11");
        getContentPane().add(caja1Cliente10);
        caja1Cliente10.setBounds(802, 231, 35, 40);

        caja2Cliente2.setText("jLabel11");
        getContentPane().add(caja2Cliente2);
        caja2Cliente2.setBounds(244, 277, 35, 40);

        caja2Art2.setText("[##]");
        getContentPane().add(caja2Art2);
        caja2Art2.setBounds(216, 289, 22, 16);

        caja2Cliente3.setText("jLabel11");
        getContentPane().add(caja2Cliente3);
        caja2Cliente3.setBounds(319, 277, 35, 40);

        caja2Art3.setText("[##]");
        getContentPane().add(caja2Art3);
        caja2Art3.setBounds(291, 289, 22, 16);

        caja2Cliente4.setText("jLabel11");
        getContentPane().add(caja2Cliente4);
        caja2Cliente4.setBounds(388, 277, 35, 40);

        caja2Art4.setText("[##]");
        getContentPane().add(caja2Art4);
        caja2Art4.setBounds(360, 289, 22, 16);

        caja2Cliente5.setText("jLabel11");
        getContentPane().add(caja2Cliente5);
        caja2Cliente5.setBounds(457, 277, 35, 40);

        caja2Art5.setText("[##]");
        getContentPane().add(caja2Art5);
        caja2Art5.setBounds(429, 289, 22, 16);

        caja2Cliente6.setText("jLabel11");
        getContentPane().add(caja2Cliente6);
        caja2Cliente6.setBounds(526, 277, 35, 40);

        caja2Art6.setText("[##]");
        getContentPane().add(caja2Art6);
        caja2Art6.setBounds(498, 289, 22, 16);

        caja2Cliente7.setText("jLabel11");
        getContentPane().add(caja2Cliente7);
        caja2Cliente7.setBounds(595, 277, 35, 40);

        caja2Art7.setText("[##]");
        getContentPane().add(caja2Art7);
        caja2Art7.setBounds(567, 289, 22, 16);

        caja2Cliente8.setText("jLabel11");
        getContentPane().add(caja2Cliente8);
        caja2Cliente8.setBounds(664, 277, 35, 40);

        caja2Art8.setText("[##]");
        getContentPane().add(caja2Art8);
        caja2Art8.setBounds(636, 289, 22, 16);

        caja2Cliente9.setText("jLabel11");
        getContentPane().add(caja2Cliente9);
        caja2Cliente9.setBounds(733, 277, 35, 40);

        caja2Art9.setText("[##]");
        getContentPane().add(caja2Art9);
        caja2Art9.setBounds(705, 289, 22, 16);

        caja2Cliente10.setText("jLabel11");
        getContentPane().add(caja2Cliente10);
        caja2Cliente10.setBounds(802, 277, 35, 40);

        caja2Art10.setText("[##]");
        getContentPane().add(caja2Art10);
        caja2Art10.setBounds(774, 289, 22, 16);

        caja3Cliente2.setText("jLabel11");
        getContentPane().add(caja3Cliente2);
        caja3Cliente2.setBounds(244, 321, 35, 40);

        caja3Art2.setText("[##]");
        getContentPane().add(caja3Art2);
        caja3Art2.setBounds(216, 333, 22, 16);

        caja3Cliente3.setText("jLabel11");
        getContentPane().add(caja3Cliente3);
        caja3Cliente3.setBounds(319, 321, 35, 40);

        caja3Art3.setText("[##]");
        getContentPane().add(caja3Art3);
        caja3Art3.setBounds(291, 333, 22, 16);

        caja3Cliente4.setText("jLabel11");
        getContentPane().add(caja3Cliente4);
        caja3Cliente4.setBounds(388, 321, 35, 40);

        caja3Art4.setText("[##]");
        getContentPane().add(caja3Art4);
        caja3Art4.setBounds(360, 333, 22, 16);

        caja3Cliente5.setText("jLabel11");
        getContentPane().add(caja3Cliente5);
        caja3Cliente5.setBounds(457, 321, 35, 40);

        caja3Art5.setText("[##]");
        getContentPane().add(caja3Art5);
        caja3Art5.setBounds(429, 333, 22, 16);

        caja3Cliente6.setText("jLabel11");
        getContentPane().add(caja3Cliente6);
        caja3Cliente6.setBounds(526, 321, 35, 40);

        caja3Art6.setText("[##]");
        getContentPane().add(caja3Art6);
        caja3Art6.setBounds(498, 333, 22, 16);

        caja3Cliente7.setText("jLabel11");
        getContentPane().add(caja3Cliente7);
        caja3Cliente7.setBounds(595, 321, 35, 40);

        caja3Art7.setText("[##]");
        getContentPane().add(caja3Art7);
        caja3Art7.setBounds(567, 333, 22, 16);

        caja3Cliente8.setText("jLabel11");
        getContentPane().add(caja3Cliente8);
        caja3Cliente8.setBounds(664, 321, 35, 40);

        caja3Art8.setText("[##]");
        getContentPane().add(caja3Art8);
        caja3Art8.setBounds(636, 333, 22, 16);

        caja3Cliente9.setText("jLabel11");
        getContentPane().add(caja3Cliente9);
        caja3Cliente9.setBounds(733, 321, 35, 40);

        caja3Art9.setText("[##]");
        getContentPane().add(caja3Art9);
        caja3Art9.setBounds(705, 333, 22, 16);

        caja3Cliente10.setText("jLabel11");
        getContentPane().add(caja3Cliente10);
        caja3Cliente10.setBounds(802, 321, 35, 40);

        caja3Art10.setText("[##]");
        getContentPane().add(caja3Art10);
        caja3Art10.setBounds(774, 333, 22, 16);

        caja4Art2.setText("[##]");
        getContentPane().add(caja4Art2);
        caja4Art2.setBounds(216, 373, 22, 16);

        caja4Cliente2.setText("jLabel11");
        getContentPane().add(caja4Cliente2);
        caja4Cliente2.setBounds(244, 361, 35, 40);

        caja4Art3.setText("[##]");
        getContentPane().add(caja4Art3);
        caja4Art3.setBounds(291, 373, 22, 16);

        caja4Cliente3.setText("jLabel11");
        getContentPane().add(caja4Cliente3);
        caja4Cliente3.setBounds(319, 361, 35, 40);

        caja4Cliente4.setText("jLabel11");
        getContentPane().add(caja4Cliente4);
        caja4Cliente4.setBounds(388, 361, 35, 40);

        caja4Art4.setText("[##]");
        getContentPane().add(caja4Art4);
        caja4Art4.setBounds(360, 373, 22, 16);

        caja4Cliente5.setText("jLabel11");
        getContentPane().add(caja4Cliente5);
        caja4Cliente5.setBounds(457, 361, 35, 40);

        caja4Art5.setText("[##]");
        getContentPane().add(caja4Art5);
        caja4Art5.setBounds(429, 373, 22, 16);

        caja4Cliente6.setText("jLabel11");
        getContentPane().add(caja4Cliente6);
        caja4Cliente6.setBounds(526, 361, 35, 40);

        caja4Art6.setText("[##]");
        getContentPane().add(caja4Art6);
        caja4Art6.setBounds(498, 373, 22, 16);

        caja4Cliente7.setText("jLabel11");
        getContentPane().add(caja4Cliente7);
        caja4Cliente7.setBounds(595, 361, 35, 40);

        caja4Art7.setText("[##]");
        getContentPane().add(caja4Art7);
        caja4Art7.setBounds(567, 373, 22, 16);

        caja4Cliente8.setText("jLabel11");
        getContentPane().add(caja4Cliente8);
        caja4Cliente8.setBounds(664, 361, 35, 40);

        caja4Art8.setText("[##]");
        getContentPane().add(caja4Art8);
        caja4Art8.setBounds(636, 373, 22, 16);

        caja4Cliente9.setText("jLabel11");
        getContentPane().add(caja4Cliente9);
        caja4Cliente9.setBounds(733, 361, 35, 40);

        caja4Art9.setText("[##]");
        getContentPane().add(caja4Art9);
        caja4Art9.setBounds(705, 373, 22, 16);

        caja4Cliente10.setText("jLabel11");
        getContentPane().add(caja4Cliente10);
        caja4Cliente10.setBounds(802, 361, 35, 40);

        caja4Art10.setText("[##]");
        getContentPane().add(caja4Art10);
        caja4Art10.setBounds(774, 373, 22, 16);

        caja5Art2.setText("[##]");
        getContentPane().add(caja5Art2);
        caja5Art2.setBounds(216, 419, 22, 16);

        caja5Cliente2.setText("jLabel11");
        getContentPane().add(caja5Cliente2);
        caja5Cliente2.setBounds(244, 407, 35, 40);

        caja5Art3.setText("[##]");
        getContentPane().add(caja5Art3);
        caja5Art3.setBounds(291, 419, 22, 16);

        caja5Cliente3.setText("jLabel11");
        getContentPane().add(caja5Cliente3);
        caja5Cliente3.setBounds(319, 407, 35, 40);

        caja5Cliente4.setText("jLabel11");
        getContentPane().add(caja5Cliente4);
        caja5Cliente4.setBounds(388, 407, 35, 40);

        caja5Art4.setText("[##]");
        getContentPane().add(caja5Art4);
        caja5Art4.setBounds(360, 419, 22, 16);

        caja5Cliente5.setText("jLabel11");
        getContentPane().add(caja5Cliente5);
        caja5Cliente5.setBounds(457, 407, 35, 40);

        caja5Art5.setText("[##]");
        getContentPane().add(caja5Art5);
        caja5Art5.setBounds(429, 419, 22, 16);

        caja5Cliente6.setText("jLabel11");
        getContentPane().add(caja5Cliente6);
        caja5Cliente6.setBounds(526, 407, 35, 40);

        caja5Art6.setText("[##]");
        getContentPane().add(caja5Art6);
        caja5Art6.setBounds(498, 419, 22, 16);

        caja5Cliente7.setText("jLabel11");
        getContentPane().add(caja5Cliente7);
        caja5Cliente7.setBounds(595, 407, 35, 40);

        caja5Art7.setText("[##]");
        getContentPane().add(caja5Art7);
        caja5Art7.setBounds(567, 419, 22, 16);

        caja5Cliente8.setText("jLabel11");
        getContentPane().add(caja5Cliente8);
        caja5Cliente8.setBounds(664, 407, 35, 40);

        caja5Art8.setText("[##]");
        getContentPane().add(caja5Art8);
        caja5Art8.setBounds(636, 419, 22, 16);

        caja5Cliente9.setText("jLabel11");
        getContentPane().add(caja5Cliente9);
        caja5Cliente9.setBounds(733, 407, 35, 40);

        caja5Art9.setText("[##]");
        getContentPane().add(caja5Art9);
        caja5Art9.setBounds(705, 419, 22, 16);

        caja5Cliente10.setText("jLabel11");
        getContentPane().add(caja5Cliente10);
        caja5Cliente10.setBounds(802, 407, 35, 40);

        caja5Art10.setText("[##]");
        getContentPane().add(caja5Art10);
        caja5Art10.setBounds(774, 419, 22, 16);

        caja6Art2.setText("[##]");
        getContentPane().add(caja6Art2);
        caja6Art2.setBounds(216, 465, 22, 16);

        caja6Cliente2.setText("jLabel11");
        getContentPane().add(caja6Cliente2);
        caja6Cliente2.setBounds(244, 453, 35, 40);

        caja6Art3.setText("[##]");
        getContentPane().add(caja6Art3);
        caja6Art3.setBounds(291, 465, 22, 16);

        caja6Cliente3.setText("jLabel11");
        getContentPane().add(caja6Cliente3);
        caja6Cliente3.setBounds(319, 453, 35, 40);

        caja6Cliente4.setText("jLabel11");
        getContentPane().add(caja6Cliente4);
        caja6Cliente4.setBounds(388, 453, 35, 40);

        caja6Art4.setText("[##]");
        getContentPane().add(caja6Art4);
        caja6Art4.setBounds(360, 465, 22, 16);

        caja6Cliente5.setText("jLabel11");
        getContentPane().add(caja6Cliente5);
        caja6Cliente5.setBounds(457, 453, 35, 40);

        caja6Art5.setText("[##]");
        getContentPane().add(caja6Art5);
        caja6Art5.setBounds(429, 465, 22, 16);

        caja6Cliente6.setText("jLabel11");
        getContentPane().add(caja6Cliente6);
        caja6Cliente6.setBounds(526, 453, 35, 40);

        caja6Art6.setText("[##]");
        getContentPane().add(caja6Art6);
        caja6Art6.setBounds(498, 465, 22, 16);

        caja6Cliente7.setText("jLabel11");
        getContentPane().add(caja6Cliente7);
        caja6Cliente7.setBounds(595, 453, 35, 40);

        caja6Art7.setText("[##]");
        getContentPane().add(caja6Art7);
        caja6Art7.setBounds(567, 465, 22, 16);

        caja6Cliente8.setText("jLabel11");
        getContentPane().add(caja6Cliente8);
        caja6Cliente8.setBounds(664, 453, 35, 40);

        caja6Art8.setText("[##]");
        getContentPane().add(caja6Art8);
        caja6Art8.setBounds(636, 465, 22, 16);

        caja6Cliente9.setText("jLabel11");
        getContentPane().add(caja6Cliente9);
        caja6Cliente9.setBounds(733, 453, 35, 40);

        caja6Art9.setText("[##]");
        getContentPane().add(caja6Art9);
        caja6Art9.setBounds(705, 465, 22, 16);

        caja6Cliente10.setText("jLabel11");
        getContentPane().add(caja6Cliente10);
        caja6Cliente10.setBounds(802, 453, 35, 40);

        caja6Art10.setText("[##]");
        getContentPane().add(caja6Art10);
        caja6Art10.setBounds(774, 465, 22, 16);

        caja7Art2.setText("[##]");
        getContentPane().add(caja7Art2);
        caja7Art2.setBounds(216, 511, 22, 16);

        caja7Cliente2.setText("jLabel11");
        getContentPane().add(caja7Cliente2);
        caja7Cliente2.setBounds(244, 499, 35, 40);

        caja7Art3.setText("[##]");
        getContentPane().add(caja7Art3);
        caja7Art3.setBounds(291, 511, 22, 16);

        caja7Cliente3.setText("jLabel11");
        getContentPane().add(caja7Cliente3);
        caja7Cliente3.setBounds(319, 499, 35, 40);

        caja7Cliente4.setText("jLabel11");
        getContentPane().add(caja7Cliente4);
        caja7Cliente4.setBounds(388, 499, 35, 40);

        caja7Art4.setText("[##]");
        getContentPane().add(caja7Art4);
        caja7Art4.setBounds(360, 511, 22, 16);

        caja7Cliente5.setText("jLabel11");
        getContentPane().add(caja7Cliente5);
        caja7Cliente5.setBounds(457, 499, 35, 40);

        caja7Art5.setText("[##]");
        getContentPane().add(caja7Art5);
        caja7Art5.setBounds(429, 511, 22, 16);

        caja7Cliente6.setText("jLabel11");
        getContentPane().add(caja7Cliente6);
        caja7Cliente6.setBounds(526, 499, 35, 40);

        caja7Art6.setText("[##]");
        getContentPane().add(caja7Art6);
        caja7Art6.setBounds(498, 511, 22, 16);

        caja7Cliente7.setText("jLabel11");
        getContentPane().add(caja7Cliente7);
        caja7Cliente7.setBounds(595, 499, 35, 40);

        caja7Art7.setText("[##]");
        getContentPane().add(caja7Art7);
        caja7Art7.setBounds(567, 511, 22, 16);

        caja7Cliente8.setText("jLabel11");
        getContentPane().add(caja7Cliente8);
        caja7Cliente8.setBounds(664, 499, 35, 40);

        caja7Art8.setText("[##]");
        getContentPane().add(caja7Art8);
        caja7Art8.setBounds(636, 511, 22, 16);

        caja7Cliente9.setText("jLabel11");
        getContentPane().add(caja7Cliente9);
        caja7Cliente9.setBounds(733, 499, 35, 40);

        caja7Art9.setText("[##]");
        getContentPane().add(caja7Art9);
        caja7Art9.setBounds(705, 511, 22, 16);

        caja7Cliente10.setText("jLabel11");
        getContentPane().add(caja7Cliente10);
        caja7Cliente10.setBounds(802, 499, 35, 40);

        caja7Art10.setText("[##]");
        getContentPane().add(caja7Art10);
        caja7Art10.setBounds(774, 511, 22, 16);

        sigClienteTexto.setText("Siguiente cliente:");
        getContentPane().add(sigClienteTexto);
        sigClienteTexto.setBounds(550, 0, 110, 30);

        siguienteClienteLabel.setText("##");
        getContentPane().add(siguienteClienteLabel);
        siguienteClienteLabel.setBounds(670, 0, 50, 30);
        getContentPane().add(piso1);
        piso1.setBounds(0, 0, 250, 160);
        getContentPane().add(piso2);
        piso2.setBounds(250, 0, 250, 160);
        getContentPane().add(piso3);
        piso3.setBounds(500, 0, 250, 160);
        getContentPane().add(piso4);
        piso4.setBounds(750, 0, 250, 160);
        getContentPane().add(piso5);
        piso5.setBounds(1000, 0, 250, 160);
        getContentPane().add(piso6);
        piso6.setBounds(1000, 160, 250, 160);
        getContentPane().add(piso7);
        piso7.setBounds(750, 160, 250, 160);
        getContentPane().add(piso8);
        piso8.setBounds(500, 160, 250, 160);
        getContentPane().add(piso9);
        piso9.setBounds(250, 160, 250, 160);
        getContentPane().add(piso10);
        piso10.setBounds(0, 160, 250, 160);
        getContentPane().add(piso11);
        piso11.setBounds(0, 320, 250, 160);
        getContentPane().add(piso12);
        piso12.setBounds(250, 320, 250, 160);
        getContentPane().add(piso13);
        piso13.setBounds(1000, 470, 250, 160);
        getContentPane().add(piso14);
        piso14.setBounds(750, 320, 250, 160);
        getContentPane().add(piso15);
        piso15.setBounds(500, 320, 250, 160);
        getContentPane().add(piso16);
        piso16.setBounds(0, 480, 250, 160);
        getContentPane().add(piso17);
        piso17.setBounds(250, 480, 250, 160);
        getContentPane().add(piso18);
        piso18.setBounds(500, 470, 250, 160);
        getContentPane().add(piso19);
        piso19.setBounds(750, 480, 250, 160);
        getContentPane().add(piso20);
        piso20.setBounds(1000, 320, 250, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        for (javax.swing.JLabel i: this.articulos)
        {
            i.setText("funciona");
        }
         timer.schedule(task, 0, 1);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Practica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Practica().setVisible(true);
            }
        });
    }
    ArrayList<javax.swing.JLabel> pisos = new ArrayList();
    ArrayList<javax.swing.JLabel> articulos = new ArrayList(); //Ya
    ArrayList<javax.swing.JLabel> articulosRapidos = new ArrayList(); //Ya
    ArrayList<javax.swing.JLabel> cajasRegistradoras = new ArrayList(); //Ya
    ArrayList<javax.swing.JLabel> clientesCajaRapida1 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> articulosCajaRapida1 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCajaRapida2 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCajaRapida2 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCajaRapida3 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCajaRapida3 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja1 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja1 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja2 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja2 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja3 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja3 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja4 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja4 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja5 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja5 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja6 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja6 = new ArrayList(); 
    ArrayList<javax.swing.JLabel> clientesCaja7 = new ArrayList();
    ArrayList<javax.swing.JLabel> articulosCaja7 = new ArrayList(); 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel articulosCajaLabel1;
    private javax.swing.JLabel articulosCajaLabel2;
    private javax.swing.JLabel articulosCajaLabel3;
    private javax.swing.JLabel articulosCajaLabel4;
    private javax.swing.JLabel articulosCajaLabel5;
    private javax.swing.JLabel articulosCajaLabel6;
    private javax.swing.JLabel articulosCajaLabel7;
    private javax.swing.JLabel articulosLabel;
    private javax.swing.JLabel articulosTexto;
    private javax.swing.JLabel caja1Art1;
    private javax.swing.JLabel caja1Art10;
    private javax.swing.JLabel caja1Art2;
    private javax.swing.JLabel caja1Art3;
    private javax.swing.JLabel caja1Art4;
    private javax.swing.JLabel caja1Art5;
    private javax.swing.JLabel caja1Art6;
    private javax.swing.JLabel caja1Art7;
    private javax.swing.JLabel caja1Art8;
    private javax.swing.JLabel caja1Art9;
    private javax.swing.JLabel caja1Cliente1;
    private javax.swing.JLabel caja1Cliente10;
    private javax.swing.JLabel caja1Cliente2;
    private javax.swing.JLabel caja1Cliente3;
    private javax.swing.JLabel caja1Cliente4;
    private javax.swing.JLabel caja1Cliente5;
    private javax.swing.JLabel caja1Cliente6;
    private javax.swing.JLabel caja1Cliente7;
    private javax.swing.JLabel caja1Cliente8;
    private javax.swing.JLabel caja1Cliente9;
    private javax.swing.JLabel caja2Art1;
    private javax.swing.JLabel caja2Art10;
    private javax.swing.JLabel caja2Art2;
    private javax.swing.JLabel caja2Art3;
    private javax.swing.JLabel caja2Art4;
    private javax.swing.JLabel caja2Art5;
    private javax.swing.JLabel caja2Art6;
    private javax.swing.JLabel caja2Art7;
    private javax.swing.JLabel caja2Art8;
    private javax.swing.JLabel caja2Art9;
    private javax.swing.JLabel caja2Cliente1;
    private javax.swing.JLabel caja2Cliente10;
    private javax.swing.JLabel caja2Cliente2;
    private javax.swing.JLabel caja2Cliente3;
    private javax.swing.JLabel caja2Cliente4;
    private javax.swing.JLabel caja2Cliente5;
    private javax.swing.JLabel caja2Cliente6;
    private javax.swing.JLabel caja2Cliente7;
    private javax.swing.JLabel caja2Cliente8;
    private javax.swing.JLabel caja2Cliente9;
    private javax.swing.JLabel caja3Art1;
    private javax.swing.JLabel caja3Art10;
    private javax.swing.JLabel caja3Art2;
    private javax.swing.JLabel caja3Art3;
    private javax.swing.JLabel caja3Art4;
    private javax.swing.JLabel caja3Art5;
    private javax.swing.JLabel caja3Art6;
    private javax.swing.JLabel caja3Art7;
    private javax.swing.JLabel caja3Art8;
    private javax.swing.JLabel caja3Art9;
    private javax.swing.JLabel caja3Cliente1;
    private javax.swing.JLabel caja3Cliente10;
    private javax.swing.JLabel caja3Cliente2;
    private javax.swing.JLabel caja3Cliente3;
    private javax.swing.JLabel caja3Cliente4;
    private javax.swing.JLabel caja3Cliente5;
    private javax.swing.JLabel caja3Cliente6;
    private javax.swing.JLabel caja3Cliente7;
    private javax.swing.JLabel caja3Cliente8;
    private javax.swing.JLabel caja3Cliente9;
    private javax.swing.JLabel caja4Art1;
    private javax.swing.JLabel caja4Art10;
    private javax.swing.JLabel caja4Art2;
    private javax.swing.JLabel caja4Art3;
    private javax.swing.JLabel caja4Art4;
    private javax.swing.JLabel caja4Art5;
    private javax.swing.JLabel caja4Art6;
    private javax.swing.JLabel caja4Art7;
    private javax.swing.JLabel caja4Art8;
    private javax.swing.JLabel caja4Art9;
    private javax.swing.JLabel caja4Cliente1;
    private javax.swing.JLabel caja4Cliente10;
    private javax.swing.JLabel caja4Cliente2;
    private javax.swing.JLabel caja4Cliente3;
    private javax.swing.JLabel caja4Cliente4;
    private javax.swing.JLabel caja4Cliente5;
    private javax.swing.JLabel caja4Cliente6;
    private javax.swing.JLabel caja4Cliente7;
    private javax.swing.JLabel caja4Cliente8;
    private javax.swing.JLabel caja4Cliente9;
    private javax.swing.JLabel caja5Art1;
    private javax.swing.JLabel caja5Art10;
    private javax.swing.JLabel caja5Art2;
    private javax.swing.JLabel caja5Art3;
    private javax.swing.JLabel caja5Art4;
    private javax.swing.JLabel caja5Art5;
    private javax.swing.JLabel caja5Art6;
    private javax.swing.JLabel caja5Art7;
    private javax.swing.JLabel caja5Art8;
    private javax.swing.JLabel caja5Art9;
    private javax.swing.JLabel caja5Cliente1;
    private javax.swing.JLabel caja5Cliente10;
    private javax.swing.JLabel caja5Cliente2;
    private javax.swing.JLabel caja5Cliente3;
    private javax.swing.JLabel caja5Cliente4;
    private javax.swing.JLabel caja5Cliente5;
    private javax.swing.JLabel caja5Cliente6;
    private javax.swing.JLabel caja5Cliente7;
    private javax.swing.JLabel caja5Cliente8;
    private javax.swing.JLabel caja5Cliente9;
    private javax.swing.JLabel caja6Art1;
    private javax.swing.JLabel caja6Art10;
    private javax.swing.JLabel caja6Art2;
    private javax.swing.JLabel caja6Art3;
    private javax.swing.JLabel caja6Art4;
    private javax.swing.JLabel caja6Art5;
    private javax.swing.JLabel caja6Art6;
    private javax.swing.JLabel caja6Art7;
    private javax.swing.JLabel caja6Art8;
    private javax.swing.JLabel caja6Art9;
    private javax.swing.JLabel caja6Cliente1;
    private javax.swing.JLabel caja6Cliente10;
    private javax.swing.JLabel caja6Cliente2;
    private javax.swing.JLabel caja6Cliente3;
    private javax.swing.JLabel caja6Cliente4;
    private javax.swing.JLabel caja6Cliente5;
    private javax.swing.JLabel caja6Cliente6;
    private javax.swing.JLabel caja6Cliente7;
    private javax.swing.JLabel caja6Cliente8;
    private javax.swing.JLabel caja6Cliente9;
    private javax.swing.JLabel caja7Art1;
    private javax.swing.JLabel caja7Art10;
    private javax.swing.JLabel caja7Art2;
    private javax.swing.JLabel caja7Art3;
    private javax.swing.JLabel caja7Art4;
    private javax.swing.JLabel caja7Art5;
    private javax.swing.JLabel caja7Art6;
    private javax.swing.JLabel caja7Art7;
    private javax.swing.JLabel caja7Art8;
    private javax.swing.JLabel caja7Art9;
    private javax.swing.JLabel caja7Cliente1;
    private javax.swing.JLabel caja7Cliente10;
    private javax.swing.JLabel caja7Cliente2;
    private javax.swing.JLabel caja7Cliente3;
    private javax.swing.JLabel caja7Cliente4;
    private javax.swing.JLabel caja7Cliente5;
    private javax.swing.JLabel caja7Cliente6;
    private javax.swing.JLabel caja7Cliente7;
    private javax.swing.JLabel caja7Cliente8;
    private javax.swing.JLabel caja7Cliente9;
    private javax.swing.JLabel cajaRapida1Art1;
    private javax.swing.JLabel cajaRapida1Art10;
    private javax.swing.JLabel cajaRapida1Art2;
    private javax.swing.JLabel cajaRapida1Art3;
    private javax.swing.JLabel cajaRapida1Art4;
    private javax.swing.JLabel cajaRapida1Art5;
    private javax.swing.JLabel cajaRapida1Art6;
    private javax.swing.JLabel cajaRapida1Art7;
    private javax.swing.JLabel cajaRapida1Art8;
    private javax.swing.JLabel cajaRapida1Art9;
    private javax.swing.JLabel cajaRapida1cliente1;
    private javax.swing.JLabel cajaRapida1cliente10;
    private javax.swing.JLabel cajaRapida1cliente2;
    private javax.swing.JLabel cajaRapida1cliente3;
    private javax.swing.JLabel cajaRapida1cliente4;
    private javax.swing.JLabel cajaRapida1cliente5;
    private javax.swing.JLabel cajaRapida1cliente6;
    private javax.swing.JLabel cajaRapida1cliente7;
    private javax.swing.JLabel cajaRapida1cliente8;
    private javax.swing.JLabel cajaRapida1cliente9;
    private javax.swing.JLabel cajaRapida2Art1;
    private javax.swing.JLabel cajaRapida2Art10;
    private javax.swing.JLabel cajaRapida2Art2;
    private javax.swing.JLabel cajaRapida2Art3;
    private javax.swing.JLabel cajaRapida2Art4;
    private javax.swing.JLabel cajaRapida2Art5;
    private javax.swing.JLabel cajaRapida2Art6;
    private javax.swing.JLabel cajaRapida2Art7;
    private javax.swing.JLabel cajaRapida2Art8;
    private javax.swing.JLabel cajaRapida2Art9;
    private javax.swing.JLabel cajaRapida2cliente1;
    private javax.swing.JLabel cajaRapida2cliente10;
    private javax.swing.JLabel cajaRapida2cliente2;
    private javax.swing.JLabel cajaRapida2cliente3;
    private javax.swing.JLabel cajaRapida2cliente4;
    private javax.swing.JLabel cajaRapida2cliente5;
    private javax.swing.JLabel cajaRapida2cliente6;
    private javax.swing.JLabel cajaRapida2cliente7;
    private javax.swing.JLabel cajaRapida2cliente8;
    private javax.swing.JLabel cajaRapida2cliente9;
    private javax.swing.JLabel cajaRapida3Art1;
    private javax.swing.JLabel cajaRapida3Art10;
    private javax.swing.JLabel cajaRapida3Art2;
    private javax.swing.JLabel cajaRapida3Art3;
    private javax.swing.JLabel cajaRapida3Art4;
    private javax.swing.JLabel cajaRapida3Art5;
    private javax.swing.JLabel cajaRapida3Art6;
    private javax.swing.JLabel cajaRapida3Art7;
    private javax.swing.JLabel cajaRapida3Art8;
    private javax.swing.JLabel cajaRapida3Art9;
    private javax.swing.JLabel cajaRapida3cliente1;
    private javax.swing.JLabel cajaRapida3cliente10;
    private javax.swing.JLabel cajaRapida3cliente2;
    private javax.swing.JLabel cajaRapida3cliente3;
    private javax.swing.JLabel cajaRapida3cliente4;
    private javax.swing.JLabel cajaRapida3cliente5;
    private javax.swing.JLabel cajaRapida3cliente6;
    private javax.swing.JLabel cajaRapida3cliente7;
    private javax.swing.JLabel cajaRapida3cliente8;
    private javax.swing.JLabel cajaRapida3cliente9;
    private javax.swing.JLabel cajaRegistradora1;
    private javax.swing.JLabel cajaRegistradora10;
    private javax.swing.JLabel cajaRegistradora2;
    private javax.swing.JLabel cajaRegistradora3;
    private javax.swing.JLabel cajaRegistradora4;
    private javax.swing.JLabel cajaRegistradora5;
    private javax.swing.JLabel cajaRegistradora6;
    private javax.swing.JLabel cajaRegistradora7;
    private javax.swing.JLabel cajaRegistradora8;
    private javax.swing.JLabel cajaRegistradora9;
    private javax.swing.JLabel clientesLabel;
    private javax.swing.JLabel clientesTexto;
    private javax.swing.JLabel fastLine;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel minutoTexto;
    private javax.swing.JLabel minutosLabel;
    private javax.swing.JLabel normalLine;
    private javax.swing.JLabel piso1;
    private javax.swing.JLabel piso10;
    private javax.swing.JLabel piso11;
    private javax.swing.JLabel piso12;
    private javax.swing.JLabel piso13;
    private javax.swing.JLabel piso14;
    private javax.swing.JLabel piso15;
    private javax.swing.JLabel piso16;
    private javax.swing.JLabel piso17;
    private javax.swing.JLabel piso18;
    private javax.swing.JLabel piso19;
    private javax.swing.JLabel piso2;
    private javax.swing.JLabel piso20;
    private javax.swing.JLabel piso3;
    private javax.swing.JLabel piso4;
    private javax.swing.JLabel piso5;
    private javax.swing.JLabel piso6;
    private javax.swing.JLabel piso7;
    private javax.swing.JLabel piso8;
    private javax.swing.JLabel piso9;
    private javax.swing.JLabel sigClienteTexto;
    private javax.swing.JLabel siguienteClienteLabel;
    // End of variables declaration//GEN-END:variables
}
