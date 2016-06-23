/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.MetodosNodos;
import Vista.FRM_VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Marko
 */
public class Controlador_FRM_VentanaPrincipal implements ActionListener{
    FRM_VentanaPrincipal ventana;
    public boolean registrarse=false;
    MetodosNodos metodos;
     public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal ventana)
  {
    this.ventana=ventana;  
    metodos=new MetodosNodos();
    ventana.generarNumerFicha(registrarse);
        ventana.generarNumerFichaElimar(registrarse);

  }
    
    public void actionPerformed(ActionEvent e)
    {
    if(e.getActionCommand().equals("Registrar"))
        {
                                  ventana.generarNumerFicha(registrarse);
                      String[] arreglo=ventana.devolverInformacion();
          registrarse=true;

          metodos.agregar(arreglo[0],arreglo[1],Integer.parseInt(arreglo[2]),arreglo[3],arreglo[4],Integer.parseInt(arreglo[5]),null);
                      ventana.imprimir(metodos.imprimir()); 
                      ventana.limpiarCampos();

        
        }
      if(e.getActionCommand().equals("Siguiente"))
        {
                    ventana.limpiarJTA();
                        registrarse=true;
metodos.eliminar(Integer.parseInt(ventana.getJt_FichaEliminar()));
          ventana.generarNumerFichaElimar(registrarse);

                      ventana.imprimir(metodos.imprimir());            

        
        
        }
        if(e.getActionCommand().equals("Modificar"))
        {
                        ventana.limpiarJTA();

                    metodos.modificar(ventana.devolverInformacion());
                                ventana.imprimir(metodos.imprimir());
                      ventana.limpiarCampos();

        
        }
        
          if(e.getActionCommand().equals("Mostrar Cola"))
        {
            ventana.limpiarJTA();
            metodos.imprimirLista();
            ventana.imprimir(metodos.imprimir());
        
        
        }
          
             if(e.getActionCommand().equals("Cantidad de Personas"))
        {
        ventana.limpiarJTA();;
        metodos.devolverCantidadNodos();
        ventana.imprimir(metodos.imprimir());
        
        }
             
                  if(e.getActionCommand().equals("Mayor a menor"))
        {
         ventana.limpiarJTA();

            metodos.ordenarMayorAMenor();
            ventana.imprimir(metodos.imprimir());
        
        }
                  
                  
                            if(e.getActionCommand().equals("Menor a mayot"))
        {
                 ventana.limpiarJTA();

            metodos.ordenarMenorAMayor();
            ventana.imprimir( metodos.imprimir());
            
        
        }
      
     if(e.getActionCommand().equals("Reporte"))
        {
                
            ventana.imprimir( metodos.reportes());
            
        
        }                  
             
             
             
          
    
    
    
    
    
    }
}
