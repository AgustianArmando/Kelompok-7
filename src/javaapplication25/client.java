/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

/**
 *
 * @author Rifqie
 */

import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
public class client extends JFrame
{
JTextArea ta;
Socket s;
BufferedReader br;
String st;
public client()
    {
  try   {
    setLayout(new FlowLayout(0));
    ta=new JTextArea(25,25);
    add(ta);
    setVisible(true);
    setSize(300,500);
    s=new Socket("localhost",8000);
    br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        do{
        st=br.readLine();
        ta.append("\n"+st);
        }while(!st.equals("exit"));
    }catch(Exception ee)
    {
    System.out.println(ee);
    }
    }
 
public static void main(String arg[])
    {
    new client();
    }
}
