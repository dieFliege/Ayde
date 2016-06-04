package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vistas.Form;

public class ActionListenerSalir implements ActionListener
{
	
   private Form form;
   
   public ActionListenerSalir(Form form){
	   this.form = form;
   }
   
   public void actionPerformed (ActionEvent e)
   { 
	  this.form.exit();
   }
}
