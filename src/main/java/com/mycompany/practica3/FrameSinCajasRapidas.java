/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica3;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 *
 * @author felix
 */
public class FrameSinCajasRapidas extends javax.swing.JFrame {
    ImageIcon cashier;
    ControlDeJuegoSinCajasRapidas control;
    Timer timer;
    TimerTask task;
    JTabbedPane tabbedPane;
    /**
     * Creates new form FrameSinCajasRapidas
     */
    public FrameSinCajasRapidas() {
        initComponents();
        control = new ControlDeJuegoSinCajasRapidas();
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
                //System.out.println(control.toString());
                System.out.println("SIN CAJAS RAPIDAS!!");
                ArrayList<String> aux;
                //Cajas 
                //Caja  1
                aux = control.getColaString(0);
                ImageIcon auxIcon = new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\clienteIcono.png");
                
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
                aux = control.getColaString(1);
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
                aux = control.getColaString(2);
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
                aux = control.getColaString(3);
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
                aux = control.getColaString(4);
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
                aux = control.getColaString(5);
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
                aux = control.getColaString(6);
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
                
                //Articulos cajas normales
                
                for (javax.swing.JLabel i:articulos)
                {
                    i.setText( "|"+ String.valueOf(control.getCajaNormal(contador).getArticulos()) + "|");
                    i.setFont(new Font(Font.SERIF, Font.BOLD, 20));
                    //cajasRegistradoras.get(contador+3).setText(String.valueOf(control.getCajaNormal(contador).getEstaAbierto()));
                    //cajasRegistradoras.get(contador+3).setIcon(new ImageIcon("C:\\Users\\felix\\OneDrive\\Documentos\\NetBeansProjects\\Practica3\\src\\main\\java\\com\\mycompany\\practica3\\cajaRegistradora.png"));
                    if (control.getCajaNormal(contador).getEstaAbierto() == true)
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
        this.articulos.add(this.articulosCajaLabel1);
        this.articulos.add(this.articulosCajaLabel2);
        this.articulos.add(this.articulosCajaLabel3);
        this.articulos.add(this.articulosCajaLabel4);
        this.articulos.add(this.articulosCajaLabel5);
        this.articulos.add(this.articulosCajaLabel6);
        this.articulos.add(this.articulosCajaLabel7);
        //Cajas registradoras
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

        clientesTexto = new javax.swing.JLabel();
        clientesLabel = new javax.swing.JLabel();
        minutoTexto = new javax.swing.JLabel();
        minutosLabel = new javax.swing.JLabel();
        articulosTexto = new javax.swing.JLabel();
        articulosLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 640));
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

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 3, 72, 30);

        normalLine.setText("Normal lines:");
        getContentPane().add(normalLine);
        normalLine.setBounds(10, 70, 100, 30);

        articulosCajaLabel1.setText("####");
        getContentPane().add(articulosCajaLabel1);
        articulosCajaLabel1.setBounds(10, 110, 43, 16);

        articulosCajaLabel2.setText("####");
        getContentPane().add(articulosCajaLabel2);
        articulosCajaLabel2.setBounds(10, 160, 43, 16);

        articulosCajaLabel3.setText("####");
        getContentPane().add(articulosCajaLabel3);
        articulosCajaLabel3.setBounds(10, 200, 43, 16);

        articulosCajaLabel4.setText("####");
        getContentPane().add(articulosCajaLabel4);
        articulosCajaLabel4.setBounds(10, 240, 43, 16);

        articulosCajaLabel5.setText("####");
        getContentPane().add(articulosCajaLabel5);
        articulosCajaLabel5.setBounds(10, 290, 43, 16);

        articulosCajaLabel6.setText("####");
        getContentPane().add(articulosCajaLabel6);
        articulosCajaLabel6.setBounds(10, 330, 43, 16);

        articulosCajaLabel7.setText("####");
        getContentPane().add(articulosCajaLabel7);
        articulosCajaLabel7.setBounds(10, 380, 43, 16);
        getContentPane().add(cajaRegistradora4);
        cajaRegistradora4.setBounds(60, 100, 30, 30);
        getContentPane().add(cajaRegistradora5);
        cajaRegistradora5.setBounds(60, 150, 30, 40);
        getContentPane().add(cajaRegistradora6);
        cajaRegistradora6.setBounds(60, 190, 30, 30);
        getContentPane().add(cajaRegistradora7);
        cajaRegistradora7.setBounds(60, 230, 30, 30);
        getContentPane().add(cajaRegistradora8);
        cajaRegistradora8.setBounds(60, 280, 30, 30);
        getContentPane().add(cajaRegistradora9);
        cajaRegistradora9.setBounds(60, 320, 30, 30);
        getContentPane().add(cajaRegistradora10);
        cajaRegistradora10.setBounds(60, 370, 30, 30);

        caja1Art1.setText("[##]");
        getContentPane().add(caja1Art1);
        caja1Art1.setBounds(130, 110, 22, 16);
        getContentPane().add(caja1Cliente1);
        caja1Cliente1.setBounds(170, 100, 35, 40);

        caja2Art1.setText("[##]");
        getContentPane().add(caja2Art1);
        caja2Art1.setBounds(130, 160, 22, 16);

        caja2Cliente1.setText("jLabel11");
        getContentPane().add(caja2Cliente1);
        caja2Cliente1.setBounds(170, 150, 35, 40);

        caja3Art1.setText("[##]");
        getContentPane().add(caja3Art1);
        caja3Art1.setBounds(130, 200, 22, 16);

        caja3Cliente1.setText("jLabel11");
        getContentPane().add(caja3Cliente1);
        caja3Cliente1.setBounds(170, 190, 35, 40);

        caja4Art1.setText("[##]");
        getContentPane().add(caja4Art1);
        caja4Art1.setBounds(130, 240, 22, 16);

        caja4Cliente1.setText("jLabel11");
        getContentPane().add(caja4Cliente1);
        caja4Cliente1.setBounds(170, 230, 35, 40);

        caja5Art1.setText("[##]");
        getContentPane().add(caja5Art1);
        caja5Art1.setBounds(130, 290, 22, 16);

        caja5Cliente1.setText("jLabel11");
        getContentPane().add(caja5Cliente1);
        caja5Cliente1.setBounds(170, 280, 35, 40);

        caja6Art1.setText("[##]");
        getContentPane().add(caja6Art1);
        caja6Art1.setBounds(130, 330, 22, 16);

        caja6Cliente1.setText("jLabel11");
        getContentPane().add(caja6Cliente1);
        caja6Cliente1.setBounds(170, 320, 35, 40);

        caja7Art1.setText("[##]");
        getContentPane().add(caja7Art1);
        caja7Art1.setBounds(130, 380, 22, 16);

        caja7Cliente1.setText("jLabel11");
        getContentPane().add(caja7Cliente1);
        caja7Cliente1.setBounds(170, 370, 35, 40);

        caja1Art2.setText("[##]");
        getContentPane().add(caja1Art2);
        caja1Art2.setBounds(210, 110, 22, 16);
        getContentPane().add(caja1Cliente2);
        caja1Cliente2.setBounds(240, 100, 35, 40);

        caja1Art3.setText("[##]");
        getContentPane().add(caja1Art3);
        caja1Art3.setBounds(290, 110, 22, 16);

        caja1Cliente3.setText("jLabel11");
        getContentPane().add(caja1Cliente3);
        caja1Cliente3.setBounds(320, 100, 35, 40);

        caja1Art4.setText("[##]");
        getContentPane().add(caja1Art4);
        caja1Art4.setBounds(360, 110, 22, 16);

        caja1Cliente4.setText("jLabel11");
        getContentPane().add(caja1Cliente4);
        caja1Cliente4.setBounds(390, 100, 35, 40);

        caja1Art5.setText("[##]");
        getContentPane().add(caja1Art5);
        caja1Art5.setBounds(430, 110, 22, 16);

        caja1Cliente5.setText("jLabel11");
        getContentPane().add(caja1Cliente5);
        caja1Cliente5.setBounds(460, 100, 35, 40);

        caja1Art6.setText("[##]");
        getContentPane().add(caja1Art6);
        caja1Art6.setBounds(500, 110, 22, 16);

        caja1Cliente6.setText("jLabel11");
        getContentPane().add(caja1Cliente6);
        caja1Cliente6.setBounds(520, 100, 35, 40);

        caja1Art7.setText("[##]");
        getContentPane().add(caja1Art7);
        caja1Art7.setBounds(570, 110, 22, 16);

        caja1Cliente7.setText("jLabel11");
        getContentPane().add(caja1Cliente7);
        caja1Cliente7.setBounds(590, 100, 35, 40);

        caja1Art8.setText("[##]");
        getContentPane().add(caja1Art8);
        caja1Art8.setBounds(630, 110, 22, 16);

        caja1Cliente8.setText("jLabel11");
        getContentPane().add(caja1Cliente8);
        caja1Cliente8.setBounds(660, 100, 35, 40);

        caja1Art9.setText("[##]");
        getContentPane().add(caja1Art9);
        caja1Art9.setBounds(700, 110, 22, 16);

        caja1Cliente9.setText("jLabel11");
        getContentPane().add(caja1Cliente9);
        caja1Cliente9.setBounds(730, 100, 35, 40);

        caja1Art10.setText("[##]");
        getContentPane().add(caja1Art10);
        caja1Art10.setBounds(770, 110, 22, 16);

        caja1Cliente10.setText("jLabel11");
        getContentPane().add(caja1Cliente10);
        caja1Cliente10.setBounds(800, 100, 35, 40);

        caja2Cliente2.setText("jLabel11");
        getContentPane().add(caja2Cliente2);
        caja2Cliente2.setBounds(240, 150, 35, 40);

        caja2Art2.setText("[##]");
        getContentPane().add(caja2Art2);
        caja2Art2.setBounds(210, 160, 22, 16);

        caja2Cliente3.setText("jLabel11");
        getContentPane().add(caja2Cliente3);
        caja2Cliente3.setBounds(320, 150, 35, 40);

        caja2Art3.setText("[##]");
        getContentPane().add(caja2Art3);
        caja2Art3.setBounds(290, 160, 22, 16);

        caja2Cliente4.setText("jLabel11");
        getContentPane().add(caja2Cliente4);
        caja2Cliente4.setBounds(390, 150, 35, 40);

        caja2Art4.setText("[##]");
        getContentPane().add(caja2Art4);
        caja2Art4.setBounds(360, 160, 22, 16);

        caja2Cliente5.setText("jLabel11");
        getContentPane().add(caja2Cliente5);
        caja2Cliente5.setBounds(460, 150, 35, 40);

        caja2Art5.setText("[##]");
        getContentPane().add(caja2Art5);
        caja2Art5.setBounds(430, 160, 22, 16);

        caja2Cliente6.setText("jLabel11");
        getContentPane().add(caja2Cliente6);
        caja2Cliente6.setBounds(520, 150, 35, 40);

        caja2Art6.setText("[##]");
        getContentPane().add(caja2Art6);
        caja2Art6.setBounds(500, 160, 22, 16);

        caja2Cliente7.setText("jLabel11");
        getContentPane().add(caja2Cliente7);
        caja2Cliente7.setBounds(590, 150, 35, 40);

        caja2Art7.setText("[##]");
        getContentPane().add(caja2Art7);
        caja2Art7.setBounds(570, 160, 22, 16);

        caja2Cliente8.setText("jLabel11");
        getContentPane().add(caja2Cliente8);
        caja2Cliente8.setBounds(660, 150, 35, 40);

        caja2Art8.setText("[##]");
        getContentPane().add(caja2Art8);
        caja2Art8.setBounds(630, 160, 22, 16);

        caja2Cliente9.setText("jLabel11");
        getContentPane().add(caja2Cliente9);
        caja2Cliente9.setBounds(730, 150, 35, 40);

        caja2Art9.setText("[##]");
        getContentPane().add(caja2Art9);
        caja2Art9.setBounds(700, 160, 22, 16);

        caja2Cliente10.setText("jLabel11");
        getContentPane().add(caja2Cliente10);
        caja2Cliente10.setBounds(800, 150, 35, 40);

        caja2Art10.setText("[##]");
        getContentPane().add(caja2Art10);
        caja2Art10.setBounds(770, 160, 22, 16);

        caja3Cliente2.setText("jLabel11");
        getContentPane().add(caja3Cliente2);
        caja3Cliente2.setBounds(240, 190, 35, 40);

        caja3Art2.setText("[##]");
        getContentPane().add(caja3Art2);
        caja3Art2.setBounds(210, 200, 22, 16);

        caja3Cliente3.setText("jLabel11");
        getContentPane().add(caja3Cliente3);
        caja3Cliente3.setBounds(320, 190, 35, 40);

        caja3Art3.setText("[##]");
        getContentPane().add(caja3Art3);
        caja3Art3.setBounds(290, 200, 22, 16);

        caja3Cliente4.setText("jLabel11");
        getContentPane().add(caja3Cliente4);
        caja3Cliente4.setBounds(390, 190, 35, 40);

        caja3Art4.setText("[##]");
        getContentPane().add(caja3Art4);
        caja3Art4.setBounds(360, 200, 22, 16);

        caja3Cliente5.setText("jLabel11");
        getContentPane().add(caja3Cliente5);
        caja3Cliente5.setBounds(460, 190, 35, 40);

        caja3Art5.setText("[##]");
        getContentPane().add(caja3Art5);
        caja3Art5.setBounds(430, 200, 22, 16);

        caja3Cliente6.setText("jLabel11");
        getContentPane().add(caja3Cliente6);
        caja3Cliente6.setBounds(520, 190, 35, 40);

        caja3Art6.setText("[##]");
        getContentPane().add(caja3Art6);
        caja3Art6.setBounds(500, 200, 22, 16);

        caja3Cliente7.setText("jLabel11");
        getContentPane().add(caja3Cliente7);
        caja3Cliente7.setBounds(590, 190, 35, 40);

        caja3Art7.setText("[##]");
        getContentPane().add(caja3Art7);
        caja3Art7.setBounds(570, 200, 22, 16);

        caja3Cliente8.setText("jLabel11");
        getContentPane().add(caja3Cliente8);
        caja3Cliente8.setBounds(660, 190, 35, 40);

        caja3Art8.setText("[##]");
        getContentPane().add(caja3Art8);
        caja3Art8.setBounds(630, 200, 22, 16);

        caja3Cliente9.setText("jLabel11");
        getContentPane().add(caja3Cliente9);
        caja3Cliente9.setBounds(730, 190, 35, 40);

        caja3Art9.setText("[##]");
        getContentPane().add(caja3Art9);
        caja3Art9.setBounds(700, 200, 22, 16);

        caja3Cliente10.setText("jLabel11");
        getContentPane().add(caja3Cliente10);
        caja3Cliente10.setBounds(800, 190, 35, 40);

        caja3Art10.setText("[##]");
        getContentPane().add(caja3Art10);
        caja3Art10.setBounds(770, 200, 22, 16);

        caja4Art2.setText("[##]");
        getContentPane().add(caja4Art2);
        caja4Art2.setBounds(210, 240, 22, 16);

        caja4Cliente2.setText("jLabel11");
        getContentPane().add(caja4Cliente2);
        caja4Cliente2.setBounds(240, 230, 35, 40);

        caja4Art3.setText("[##]");
        getContentPane().add(caja4Art3);
        caja4Art3.setBounds(290, 240, 22, 16);

        caja4Cliente3.setText("jLabel11");
        getContentPane().add(caja4Cliente3);
        caja4Cliente3.setBounds(320, 230, 35, 40);

        caja4Cliente4.setText("jLabel11");
        getContentPane().add(caja4Cliente4);
        caja4Cliente4.setBounds(390, 230, 35, 40);

        caja4Art4.setText("[##]");
        getContentPane().add(caja4Art4);
        caja4Art4.setBounds(360, 240, 22, 16);

        caja4Cliente5.setText("jLabel11");
        getContentPane().add(caja4Cliente5);
        caja4Cliente5.setBounds(460, 230, 35, 40);

        caja4Art5.setText("[##]");
        getContentPane().add(caja4Art5);
        caja4Art5.setBounds(430, 240, 22, 16);

        caja4Cliente6.setText("jLabel11");
        getContentPane().add(caja4Cliente6);
        caja4Cliente6.setBounds(520, 230, 35, 40);

        caja4Art6.setText("[##]");
        getContentPane().add(caja4Art6);
        caja4Art6.setBounds(500, 240, 22, 16);

        caja4Cliente7.setText("jLabel11");
        getContentPane().add(caja4Cliente7);
        caja4Cliente7.setBounds(590, 230, 35, 40);

        caja4Art7.setText("[##]");
        getContentPane().add(caja4Art7);
        caja4Art7.setBounds(570, 240, 22, 16);

        caja4Cliente8.setText("jLabel11");
        getContentPane().add(caja4Cliente8);
        caja4Cliente8.setBounds(660, 230, 35, 40);

        caja4Art8.setText("[##]");
        getContentPane().add(caja4Art8);
        caja4Art8.setBounds(630, 240, 22, 16);

        caja4Cliente9.setText("jLabel11");
        getContentPane().add(caja4Cliente9);
        caja4Cliente9.setBounds(730, 230, 35, 40);

        caja4Art9.setText("[##]");
        getContentPane().add(caja4Art9);
        caja4Art9.setBounds(700, 240, 22, 16);

        caja4Cliente10.setText("jLabel11");
        getContentPane().add(caja4Cliente10);
        caja4Cliente10.setBounds(800, 230, 35, 40);

        caja4Art10.setText("[##]");
        getContentPane().add(caja4Art10);
        caja4Art10.setBounds(770, 240, 22, 16);

        caja5Art2.setText("[##]");
        getContentPane().add(caja5Art2);
        caja5Art2.setBounds(210, 290, 22, 16);

        caja5Cliente2.setText("jLabel11");
        getContentPane().add(caja5Cliente2);
        caja5Cliente2.setBounds(240, 280, 35, 40);

        caja5Art3.setText("[##]");
        getContentPane().add(caja5Art3);
        caja5Art3.setBounds(290, 290, 22, 16);

        caja5Cliente3.setText("jLabel11");
        getContentPane().add(caja5Cliente3);
        caja5Cliente3.setBounds(320, 280, 35, 40);

        caja5Cliente4.setText("jLabel11");
        getContentPane().add(caja5Cliente4);
        caja5Cliente4.setBounds(390, 280, 35, 40);

        caja5Art4.setText("[##]");
        getContentPane().add(caja5Art4);
        caja5Art4.setBounds(360, 290, 22, 16);

        caja5Cliente5.setText("jLabel11");
        getContentPane().add(caja5Cliente5);
        caja5Cliente5.setBounds(460, 280, 35, 40);

        caja5Art5.setText("[##]");
        getContentPane().add(caja5Art5);
        caja5Art5.setBounds(430, 290, 22, 16);

        caja5Cliente6.setText("jLabel11");
        getContentPane().add(caja5Cliente6);
        caja5Cliente6.setBounds(520, 280, 35, 40);

        caja5Art6.setText("[##]");
        getContentPane().add(caja5Art6);
        caja5Art6.setBounds(500, 290, 22, 16);

        caja5Cliente7.setText("jLabel11");
        getContentPane().add(caja5Cliente7);
        caja5Cliente7.setBounds(590, 280, 35, 40);

        caja5Art7.setText("[##]");
        getContentPane().add(caja5Art7);
        caja5Art7.setBounds(570, 290, 22, 16);

        caja5Cliente8.setText("jLabel11");
        getContentPane().add(caja5Cliente8);
        caja5Cliente8.setBounds(660, 280, 35, 40);

        caja5Art8.setText("[##]");
        getContentPane().add(caja5Art8);
        caja5Art8.setBounds(630, 290, 22, 16);

        caja5Cliente9.setText("jLabel11");
        getContentPane().add(caja5Cliente9);
        caja5Cliente9.setBounds(730, 280, 35, 40);

        caja5Art9.setText("[##]");
        getContentPane().add(caja5Art9);
        caja5Art9.setBounds(700, 290, 22, 16);

        caja5Cliente10.setText("jLabel11");
        getContentPane().add(caja5Cliente10);
        caja5Cliente10.setBounds(800, 280, 35, 40);

        caja5Art10.setText("[##]");
        getContentPane().add(caja5Art10);
        caja5Art10.setBounds(770, 290, 22, 16);

        caja6Art2.setText("[##]");
        getContentPane().add(caja6Art2);
        caja6Art2.setBounds(210, 330, 22, 16);

        caja6Cliente2.setText("jLabel11");
        getContentPane().add(caja6Cliente2);
        caja6Cliente2.setBounds(240, 320, 35, 40);

        caja6Art3.setText("[##]");
        getContentPane().add(caja6Art3);
        caja6Art3.setBounds(290, 330, 22, 16);

        caja6Cliente3.setText("jLabel11");
        getContentPane().add(caja6Cliente3);
        caja6Cliente3.setBounds(320, 320, 35, 40);

        caja6Cliente4.setText("jLabel11");
        getContentPane().add(caja6Cliente4);
        caja6Cliente4.setBounds(390, 320, 35, 40);

        caja6Art4.setText("[##]");
        getContentPane().add(caja6Art4);
        caja6Art4.setBounds(360, 330, 22, 16);

        caja6Cliente5.setText("jLabel11");
        getContentPane().add(caja6Cliente5);
        caja6Cliente5.setBounds(460, 320, 35, 40);

        caja6Art5.setText("[##]");
        getContentPane().add(caja6Art5);
        caja6Art5.setBounds(430, 330, 22, 16);

        caja6Cliente6.setText("jLabel11");
        getContentPane().add(caja6Cliente6);
        caja6Cliente6.setBounds(520, 320, 35, 40);

        caja6Art6.setText("[##]");
        getContentPane().add(caja6Art6);
        caja6Art6.setBounds(500, 330, 22, 16);

        caja6Cliente7.setText("jLabel11");
        getContentPane().add(caja6Cliente7);
        caja6Cliente7.setBounds(590, 320, 35, 40);

        caja6Art7.setText("[##]");
        getContentPane().add(caja6Art7);
        caja6Art7.setBounds(570, 330, 22, 16);

        caja6Cliente8.setText("jLabel11");
        getContentPane().add(caja6Cliente8);
        caja6Cliente8.setBounds(660, 320, 35, 40);

        caja6Art8.setText("[##]");
        getContentPane().add(caja6Art8);
        caja6Art8.setBounds(630, 330, 22, 16);

        caja6Cliente9.setText("jLabel11");
        getContentPane().add(caja6Cliente9);
        caja6Cliente9.setBounds(730, 320, 35, 40);

        caja6Art9.setText("[##]");
        getContentPane().add(caja6Art9);
        caja6Art9.setBounds(700, 330, 22, 16);

        caja6Cliente10.setText("jLabel11");
        getContentPane().add(caja6Cliente10);
        caja6Cliente10.setBounds(800, 320, 35, 40);

        caja6Art10.setText("[##]");
        getContentPane().add(caja6Art10);
        caja6Art10.setBounds(770, 330, 22, 16);

        caja7Art2.setText("[##]");
        getContentPane().add(caja7Art2);
        caja7Art2.setBounds(210, 380, 22, 16);

        caja7Cliente2.setText("jLabel11");
        getContentPane().add(caja7Cliente2);
        caja7Cliente2.setBounds(240, 370, 35, 40);

        caja7Art3.setText("[##]");
        getContentPane().add(caja7Art3);
        caja7Art3.setBounds(290, 380, 22, 16);

        caja7Cliente3.setText("jLabel11");
        getContentPane().add(caja7Cliente3);
        caja7Cliente3.setBounds(320, 370, 35, 40);

        caja7Cliente4.setText("jLabel11");
        getContentPane().add(caja7Cliente4);
        caja7Cliente4.setBounds(390, 370, 35, 40);

        caja7Art4.setText("[##]");
        getContentPane().add(caja7Art4);
        caja7Art4.setBounds(360, 380, 22, 16);

        caja7Cliente5.setText("jLabel11");
        getContentPane().add(caja7Cliente5);
        caja7Cliente5.setBounds(460, 370, 35, 40);

        caja7Art5.setText("[##]");
        getContentPane().add(caja7Art5);
        caja7Art5.setBounds(430, 380, 22, 16);

        caja7Cliente6.setText("jLabel11");
        getContentPane().add(caja7Cliente6);
        caja7Cliente6.setBounds(520, 370, 35, 40);

        caja7Art6.setText("[##]");
        getContentPane().add(caja7Art6);
        caja7Art6.setBounds(500, 380, 22, 16);

        caja7Cliente7.setText("jLabel11");
        getContentPane().add(caja7Cliente7);
        caja7Cliente7.setBounds(590, 370, 35, 40);

        caja7Art7.setText("[##]");
        getContentPane().add(caja7Art7);
        caja7Art7.setBounds(570, 380, 22, 16);

        caja7Cliente8.setText("jLabel11");
        getContentPane().add(caja7Cliente8);
        caja7Cliente8.setBounds(660, 370, 35, 40);

        caja7Art8.setText("[##]");
        getContentPane().add(caja7Art8);
        caja7Art8.setBounds(630, 380, 22, 16);

        caja7Cliente9.setText("jLabel11");
        getContentPane().add(caja7Cliente9);
        caja7Cliente9.setBounds(730, 370, 35, 40);

        caja7Art9.setText("[##]");
        getContentPane().add(caja7Art9);
        caja7Art9.setBounds(700, 380, 22, 16);

        caja7Cliente10.setText("jLabel11");
        getContentPane().add(caja7Cliente10);
        caja7Cliente10.setBounds(800, 370, 35, 40);

        caja7Art10.setText("[##]");
        getContentPane().add(caja7Art10);
        caja7Art10.setBounds(770, 380, 22, 16);

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
                new FrameSinCajasRapidas().setVisible(true);
            }
        });
    }
    ArrayList<javax.swing.JLabel> pisos = new ArrayList();
    ArrayList<javax.swing.JLabel> articulos = new ArrayList(); //Ya
    ArrayList<javax.swing.JLabel> articulosRapidos = new ArrayList(); //Ya
    ArrayList<javax.swing.JLabel> cajasRegistradoras = new ArrayList(); //Ya
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
    private javax.swing.JLabel cajaRegistradora10;
    private javax.swing.JLabel cajaRegistradora4;
    private javax.swing.JLabel cajaRegistradora5;
    private javax.swing.JLabel cajaRegistradora6;
    private javax.swing.JLabel cajaRegistradora7;
    private javax.swing.JLabel cajaRegistradora8;
    private javax.swing.JLabel cajaRegistradora9;
    private javax.swing.JLabel clientesLabel;
    private javax.swing.JLabel clientesTexto;
    private javax.swing.JButton jButton1;
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
