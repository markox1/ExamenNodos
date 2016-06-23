/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marko
 */
public class MetodosNodos {
Nodo primero;
    public MetodosNodos() {
    }
    
     public void agregar(String cedula,String nombre, int edad, String fecha,String prioridad,  int numeroFicha, Nodo siguiente){
        if(primero==null){
            primero =  new Nodo(cedula,nombre,edad,fecha,prioridad,numeroFicha,null);
        }
        else{
            if(prioridad.equals("Normal")){
                        agregarAlFinal(cedula,nombre,edad,fecha,prioridad,numeroFicha,null);

            }else{ 
                Nodo temporal=new Nodo (cedula,nombre,edad,fecha,prioridad,numeroFicha,null);
            temporal.setSiguiente(primero);
            primero=temporal;
            
            
            }
        
        
        }
//        else{
//            if(verificar(arreglo)){
//            }
//            else{
//                Nodo temporal=devolverUltimoNodo();
//                temporal.setSiguiente(new Nodo(arreglo[0],Integer.parseInt( arreglo[1]),arreglo[2], arreglo[3],Integer.parseInt(arreglo[4]),null));
//            }
//        }
    }
 public void agregarAlFinal(String cedula,String nombre, int edad, String fecha,String prioridad,  int numeroFicha, Nodo siguiente){
        Nodo temporal=devolverUltimoNodo();
        temporal.setSiguiente(new Nodo(cedula,nombre,  edad,  fecha,prioridad,  numeroFicha, null));
    }
 public boolean verificar(String arreglo[]){
        Nodo temporal=primero;
        boolean encontro=false;
        while(temporal!=null){
         
            temporal=temporal.getSiguiente();
        }
        return encontro;
    }
  
    
    public Nodo devolverUltimoNodo()
    { //METODO PARA AGREGAR AL FINAL.
        Nodo temporal = primero;
        while(temporal.getSiguiente()!=null){
            temporal=temporal.getSiguiente();
        }
            return temporal;
    }
    public String imprimir(){
        String valores="";
        Nodo temporal=primero;
        while( temporal.getSiguiente()!=null){
        valores+=temporal.getNombre()+" Nombre: "+temporal.getCedula()+" Ficha: "+temporal.getNumeroFicha()+" Fecha :"+temporal.getFecha()+" prioridad: "+temporal.getPrioridad()+" Edad: "+temporal.getEdad()+"\n";
        temporal=temporal.getSiguiente();
    }//FIN WHILE
        //System.out.println(temporal.getDato()); //EN EL WHILE NO IBA A IMPRMIR EL ULTIMO PORQUE EL SIGUIENTE ESTABA NULL; SO SE PONE AFUERA
        valores+=temporal.getNombre()+" Cedula: "+temporal.getCedula()+ " Ficha: "+temporal.getNumeroFicha()+" Fecha :"+temporal.getFecha()+" prioridad: "+temporal.getPrioridad()+" Edad: "+temporal.getEdad()+"\n";

        return valores;
    }
    public int devolverCantidadNodos()
    {
        int contador=1;
        Nodo auxiliar=primero;
        while(auxiliar.siguiente!=null)
        {
            contador++;
            auxiliar=auxiliar.siguiente;
        }
        
        return contador;
    }
    public void ordenarMayorAMenor()
    {
        int cantidadNodos=devolverCantidadNodos();
        int datoTemporal;
        Nodo auxiliar=primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=primero;
            while(auxiliar.siguiente!=null)
            {
                if(auxiliar.edad<auxiliar.siguiente.edad)
                {
                    datoTemporal=auxiliar.edad;
                    auxiliar.edad=auxiliar.siguiente.edad;
                    auxiliar.siguiente.edad=datoTemporal;
                }
                auxiliar=auxiliar.siguiente;
            }
        }
    }
    public void ordenarMenorAMayor()
    {
        int cantidadNodos=devolverCantidadNodos();
        int datoTemporal;
        Nodo auxiliar=primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=primero;
            while(auxiliar.siguiente!=null)
            {
                if(auxiliar.edad>auxiliar.siguiente.edad)
                {
                    datoTemporal=auxiliar.edad;
                    auxiliar.edad=auxiliar.siguiente.edad;
                    auxiliar.siguiente.edad=datoTemporal;
                }
                auxiliar=auxiliar.siguiente;
            }
        }
    }
    public String imprimirLista()
    {
        String lista="";
        Nodo auxiliar=primero;
        while(auxiliar.siguiente!=null)
        {
            lista+="El valor del nodo es: "+auxiliar.edad+"\n";
            auxiliar=auxiliar.siguiente;
        }
        lista+="El valor del nodo es: "+auxiliar.edad+"\n";
        
        return lista;
    }
    
    
    public void eliminar(int datoEliminar)
    {
        Nodo auxiliar=primero;
        boolean haEliminado=false;
        if(auxiliar.numeroFicha==datoEliminar)
        {
            primero=primero.siguiente;
            haEliminado=true;
        }
        else
        {
            auxiliar=devolverUltimoNodo();
            if(auxiliar.numeroFicha==datoEliminar)
            {
                auxiliar=devolverAntepenultimoNodo();
                auxiliar.siguiente=null;
                haEliminado=true;
            }
        }
        if(!haEliminado)
        {
            Nodo temporal;
            auxiliar=devolverNodoAnterior(datoEliminar);
            temporal=auxiliar.siguiente.siguiente;
            auxiliar.siguiente=temporal;
        }
    }
    public Nodo devolverNodoAnterior(int datoBuscar)
    {
        Nodo auxiliar=primero;
        while(auxiliar.siguiente.numeroFicha!=datoBuscar)
        {
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    }
    public Nodo devolverAntepenultimoNodo()
    {
        Nodo auxiliar=primero;
        while(auxiliar.siguiente.siguiente!=null)
        {
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    }
 
//    public void modificar(String datoModificar, String datoNuevo)
//    {
//        Nodo auxiliar;
//        auxiliar=buscarNodo(Integer.parseInt(datoModificar));
//        auxiliar.edad=Integer.parseInt(datoNuevo);
//    }
//    public Nodo buscarNodo(int datoModificar)
//    {
//        Nodo auxiliar=primero;
//        while(auxiliar.edad!=datoModificar)
//        {
//            auxiliar=auxiliar.siguiente;
//        }
//        return auxiliar;
//    }
//    public Nodo buscarNodoFecha(String datoModificar)
//    {
//        Nodo auxiliar=primero;
//        while(auxiliar.fecha!=datoModificar)
//        {
//            auxiliar=auxiliar.siguiente;
//        }
//        return auxiliar;
//        
//    }
    public boolean modificar(String arreglo[]){
        Nodo temporal=primero;
        boolean encontro=false;
        while(temporal!=null){
            if(temporal.getCedula().equals(arreglo[0])){
                temporal.setNombre(temporal.getNombre());
                                temporal.setEdad(temporal.getEdad());
                                temporal.setFecha(temporal.getFecha());
                                temporal.setPrioridad(temporal.getPrioridad());

                encontro=true;
            }
            temporal=temporal.getSiguiente();
        }
        return encontro;
    }
public String reportes(){
        String valores="";
        int promedio=0;
        Nodo temporal= primero;
        while(temporal.getSiguiente()!=null){
            promedio+=temporal.getEdad();
            valores+="Cedula: "+temporal.getCedula()+" Nombre: "+temporal.getNombre()+" Edad: "+temporal.getEdad()+"\n";
            temporal=temporal.getSiguiente();
        }
        promedio+=temporal.getEdad();
        promedio=promedio/devolverCantidadNodos();
        valores+="Cedula: "+temporal.getCedula()+" Nombre: "+temporal.getNombre()+" Edad: "+temporal.getEdad()+"\n\nPromedio de Edad: "+promedio+"\n\nCantidad de personas el cola: "+devolverCantidadNodos();
        return valores;
    }

}
    
  
