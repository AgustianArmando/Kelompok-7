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
public class server extends JFrame implements ActionListener
{
ServerSocket ss;
Socket s[]=new Socket[10];
PrintWriter pw;
JTextArea ta;
JTextField tf;
JButton b;
String s1;
 
public server()
    {
   try  {
    setLayout(new FlowLayout(0));
    ta=new JTextArea(25,25);
    add(ta);
    tf=new JTextField(25);
    add(tf);
    b=new JButton("Send");
    add(b);
    b.addActionListener(this);
    setVisible(true);
    setSize(300,500);
    ss=new ServerSocket(8000);
    for(int i=0;i<4;i++)
        {
        s[i]=ss.accept();
        }
    }
  catch(Exception ee)
    {
    System.out.println(ee);
    }   
    }
public void actionPerformed(ActionEvent ev)
    {
    if(ev.getSource()==b)
    {
   try  {
    s1=tf.getText();
    ta.append("\nServer:: "+s1);
    for(int i=0;i<4;i++)
        {
        pw=new PrintWriter(s[i].getOutputStream(),true);
        pw.println(s1);
        }
    }
   catch(Exception ee)
    {
    System.out.println(ee);
    }
    }
    }
public static void main(String arg[])
    {
    new server();
    }
}
