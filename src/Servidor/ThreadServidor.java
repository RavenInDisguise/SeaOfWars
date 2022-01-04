/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Command.CommandManager;
import Command.ICommand;
import Logica.Casilla;
import Logica.Juego;
import Logica.Jugador;
import Logica.Luchador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diemo
 */
class ThreadServidor extends Thread{
    // DATOS DEL SERVER
    private Socket socketRef;
    private DataInputStream reader;
    private DataOutputStream writer;
    private boolean running = true;
    Servidor server;
    
    //DATOS DEL JUEGO
    Juego juegoActual;
    
    // DATOS DEL JUGADOR
    Jugador jugadorActual;
    private String nombre;
    
    //DATOS DEL COMMAND MANAGER
     CommandManager manager = CommandManager.getIntance();

    public ThreadServidor(Socket socketRef, Servidor server, Juego _juegoActual) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
        this.juegoActual=_juegoActual;
    }
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // pasan el nombre del usuario
                        nombre = reader.readUTF();      
                        writer.writeInt(5);
                        writer.writeUTF(nombre);
                        jugadorActual=new Jugador(nombre);
                        juegoActual.agregarJugadores(jugadorActual);
                        for(int i=0; i<juegoActual.getJugadores().size();i++){
                            System.out.println(juegoActual.getJugadores().get(i).getNombreUsuario());
                        }
                    break;
                    case 2: // pasan un mensaje por el chat
                        String mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(2);
                            current.writer.writeUTF(nombre);
                            current.writer.writeUTF(mensaje);
                        }
                    break;
                    case 3: //Comando de instrucciones
                        String datos1=reader.readUTF();
                        ICommand command1=manager.getCommand(datos1.trim());  
                        String mensajeRetorno1=command1.mostrarInstrucciones();
                        writer.writeInt(3);
                        writer.writeUTF(mensajeRetorno1);
                    break;
                    case 4: //Comandos generales
                        String datos2=reader.readUTF();
                        String[] datosArray=splitCommands(datos2);
                        ICommand command2=manager.getCommand(datosArray[0].trim());  
                        String mensajeRetorno2=command2.execute(datos2, jugadorActual);
                        writer.writeInt(4);
                        writer.writeUTF(mensajeRetorno2);
                    break;
                    case 5: //Cargar matriz
                        try {
                            jugadorActual.generarMatrizCasillas(jugadorActual.getLuchadores().get(0),jugadorActual.getLuchadores().get(1),jugadorActual.getLuchadores().get(2));
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    writer.writeInt(7);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                                    writer.writeUTF(casillasJugador[i][j].color);
                                }
                             }
                           
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break; 
                    case 6:
                        try{
                            for(int i=0; i<jugadorActual.getLuchadores().size();i++){
                                int casillasVivas1=calcularCasillas(jugadorActual.getLuchadores().get(i),jugadorActual);
                                int casillasTotales1=calcularCasillasTotales(jugadorActual.getLuchadores().get(i),jugadorActual);
                                writer.writeInt(6);
                                writer.writeInt(i);
                                writer.writeUTF(jugadorActual.getLuchadores().get(i).getNombreLuchador());
                                writer.writeInt(casillasTotales1);
                                writer.writeInt(casillasVivas1);
                            }
                        }catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                    case 7:
                        String datos7=reader.readUTF();
                        String[] datosMensaje=splitCommands(datos7);
                        ICommand command7=manager.getCommand(datosMensaje[0].trim());
                        String mensajeRetorno7=command7.execute(datos7, jugadorActual);
                        if(datosMensaje[1].equals("GENERAL")){
                            nombre = jugadorActual.getNombreUsuario();
                            for(int i=0; i<juegoActual.getJugadores().size();i++){
                                ThreadServidor current = server.conexiones.get(i);
                                current.writer.writeInt(8);
                                current.writer.writeUTF(nombre);
                                current.writer.writeUTF(mensajeRetorno7);
                            }
                            }else{
                            String nombreMen = nombre;
                            for(int i=0; i<juegoActual.getJugadores().size();i++){
                                if(datosMensaje[1].equals(juegoActual.getJugadores().get(i).getNombreUsuario())){
                                    nombreMen = jugadorActual.getNombreUsuario()+" (individual)";
                                    ThreadServidor current = server.conexiones.get(i);
                                    current.writer.writeInt(8);
                                    current.writer.writeUTF(nombreMen);
                                    current.writer.writeUTF(mensajeRetorno7);
                                }else if(juegoActual.getJugadores().get(i).getNombreUsuario().equals(jugadorActual.getNombreUsuario())){
                                    nombreMen = jugadorActual.getNombreUsuario()+" (individual para "+datosMensaje[1]+")";
                                    ThreadServidor current = server.conexiones.get(i);
                                    current.writer.writeInt(8);
                                    current.writer.writeUTF(nombreMen);
                                    current.writer.writeUTF(mensajeRetorno7);
                                }
                            }
                        }
                    break;
                    case 8: 
                        int cantPersonajes=jugadorActual.getSizeLuchadores();
                        String listo=reader.readUTF();
                        ICommand command8=manager.getCommand(listo.trim());
                        String mensajeRetorno8=command8.execute(listo, jugadorActual);
                        if (mensajeRetorno8.equals("true")){
                            juegoActual.contListos +=1;
                            if(juegoActual.contListos==server.conexiones.size() && server.conexiones.size()<=6 && server.conexiones.size()>=2){
                                server.partidaIniciada=true;
                                generarOrdenAleatorio();
                                String jugadoresOrden="";
                                for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){
                                    jugadoresOrden=jugadoresOrden+" - "+juegoActual.getJugadoresTurnados().get(i).getNombreUsuario();
                                    }
                                for(int i=0; i<juegoActual.getJugadores().size();i++){
                                    ThreadServidor current = server.conexiones.get(i);
                                    current.writer.writeInt(4);
                                    current.writer.writeUTF("Todos los jugadores están listos. \n La partida inicia y el orden es: \n"+jugadoresOrden);
                                    }
                            }
                        }
                        else{
                            for(int i=0; i<juegoActual.getJugadores().size();i++){
                              ThreadServidor current = server.conexiones.get(i);
                              if (current.nombre.equals(jugadorActual.getNombreUsuario())){
                                current.writer.writeInt(4);
                                current.writer.writeUTF("Debe agregar 3 luchadores para jugar.");
                              }
                            }
                        }
                    break;
                    case 9:
                        String datos6=reader.readUTF();
                        String mensajeRetorno5="";
                        ICommand command5=manager.getCommand("SALTARTURNO"); 
                        mensajeRetorno5=command5.execute(datos6, jugadorActual);
                        turnoSiguiente();
                        String siguiente2="";
                        for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){ //Hace los turnos
                            if(juegoActual.getJugadoresTurnados().get(i).isTurno()){
                                siguiente2=juegoActual.getJugadoresTurnados().get(i).getNombreUsuario();
                            }
                        }
                        for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                            current.writer.writeUTF(mensajeRetorno5);
                            current.writer.writeInt(4);
                            current.writer.writeUTF("Turno de ataque: "+siguiente2);
                        }
                    break;
                    case 10:
                        String datos3=reader.readUTF();
                        String[] datosArray3=splitCommands(datos3);
                        String mensajeRetorno3="";
                        String historialAtaque="";
                        ICommand command3=manager.getCommand(datosArray3[0].trim()); 
                        if (jugadorActual.isTurno()){ //Si es el turno del jugador
                            for(int i=0; i<server.conexiones.size();i++){ //Busca el jugador a Atacar
                                ThreadServidor current = server.conexiones.get(i);
                                if(current.jugadorActual.getNombreUsuario().trim().toUpperCase().equals(datosArray3[2].trim().toUpperCase())){
                                    mensajeRetorno3="Ataque ejecutado por: "+nombre+"\n";
                                    mensajeRetorno3+=command3.execute(datos3, jugadorActual);
                                    mensajeRetorno3+=command3.execute(datos3, current.jugadorActual);
                                    historialAtaque+=recorrerCasillas(current.jugadorActual);
                                    jugadorActual.setLogJugadorEnviado(historialAtaque);
                                    //current.jugadorActual.setLogJugadorRecibido(historialAtaque);
                                    int celdasVivasActuales=0;
                                    for(int j=0; j<current.jugadorActual.getLuchadores().size();j++){ //Busca las casillas afectadas y las actualiza
                                        int casillasVivas1=calcularCasillas(current.jugadorActual.getLuchadores().get(j),juegoActual.getJugadores().get(i));
                                        int casillasTotales1=calcularCasillasTotales(current.jugadorActual.getLuchadores().get(j), juegoActual.getJugadores().get(i));
                                        celdasVivasActuales+=casillasVivas1;
                                        current.writer.writeInt(6);
                                        current.writer.writeInt(j);
                                        current.writer.writeUTF(current.jugadorActual.getLuchadores().get(j).getNombreLuchador());
                                        current.writer.writeInt(casillasTotales1);
                                        current.writer.writeInt(casillasVivas1);
                                    }
                                    current.writer.writeInt(11);
                                    current.writer.writeInt(celdasVivasActuales);
                                }
                            }
                                for(int i=0; i<server.conexiones.size();i++){ //Rellena la bitacora y la lista de ataques
                                     ThreadServidor current = server.conexiones.get(i);
                                     current.writer.writeInt(4);
                                     current.writer.writeUTF(mensajeRetorno3);
                                     current.writer.writeInt(9);
                                     current.writer.writeUTF(historialAtaque);
                                }
                                boolean ganador = revisarGanador();
                                if (ganador){
                                    for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){
                                        if(juegoActual.getJugadoresTurnados().get(i).vivo){
                                            for(int j=0; j<server.conexiones.size();j++){ //Muestra los turnos
                                            ThreadServidor current = server.conexiones.get(i);
                                            current.writer.writeInt(10);
                                            current.writer.writeUTF("Ganador: "+juegoActual.getJugadoresTurnados().get(i).getNombreUsuario());
                                            }
                                        }
                                    }
                                }
                                turnoSiguiente();
                                String siguiente="";
                                for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){ //Hace los turnos
                                    if(juegoActual.getJugadoresTurnados().get(i).isTurno()){
                                        siguiente=juegoActual.getJugadoresTurnados().get(i).getNombreUsuario();
                                    }
                                }
                                for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                                    ThreadServidor current = server.conexiones.get(i);
                                    current.writer.writeInt(4);
                                    current.writer.writeUTF("Turno de ataque: "+siguiente);
                                }
                            }else{
                                writer.writeInt(4);
                                writer.writeUTF("NO puede atacar. No es su turno.");
                            }
                    break;
                    case 11:
                        String datos4=reader.readUTF();
                        String[] datosArray4=splitCommands(datos4);
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray4[4]));
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray4[5]));
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray4[6]));
                        jugadorActual.setAtacante(true);
                        for(int i=0; i<server.conexiones.size();i++){ 
                            ThreadServidor current = server.conexiones.get(i);
                            if(current.jugadorActual.getNombreUsuario().trim().toUpperCase().equals(datosArray4[2].trim().toUpperCase())){
                               current.writer.writeInt(3);
                               current.writer.writeUTF("Ingrese tres numeros con el comando EnviarNum.\n");
                            }
                        }
                    break;   
                    case 12:
                        jugadorActual.setAtacado(true);
                        String datos5=reader.readUTF();
                        String[] datosArray5=splitCommands(datos5);
                        ICommand command9=manager.getCommand(datosArray5[0]);
                        String mensajeRetorno9=command9.execute(datos5, jugadorActual);
                        String[] datosArray6=splitCommands(mensajeRetorno9);
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray6[1]));
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray6[2]));
                        jugadorActual.getNumeros().add(Integer.parseInt(datosArray6[3]));
                    break;
                    case 13:
                        Jugador atacante=null;
                        Jugador atacado=null;
                        String mensajeRetorno4="";
                        for(int i=0; i<server.conexiones.size();i++){ 
                            ThreadServidor current = server.conexiones.get(i);
                            if(current.jugadorActual.isAtacante()){
                                atacante=current.jugadorActual;
                            }
                            if(current.jugadorActual.isAtacado()){
                                atacado=current.jugadorActual;
                            }
                        }
                        ICommand command4=manager.getCommand("ATTACK");
                        mensajeRetorno4+="Ataque ejecutado por: "+atacante.getNombreUsuario()+"\n";
                        String numero="";
                        for(int i=0;i<atacante.getNumeros().size();i++){
                            numero+=atacante.getNumeros().get(i);
                        }
                        mensajeRetorno4+=command4.execute(numero,atacante);
                        mensajeRetorno4+=command4.execute(numero,atacado);
                        
                    break; 
                    case 14:
                        String datos8=reader.readUTF();
                        String mensajeRetorno10="";
                        ICommand command10=manager.getCommand("RENDIRSE"); 
                        mensajeRetorno10=command10.execute(datos8, jugadorActual);
                        for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                            current.writer.writeUTF(mensajeRetorno10);
                        }
                        for(int j=0; j<juegoActual.getJugadores().size();j++){
                            if(juegoActual.getJugadores().get(j).getNombreUsuario().trim().toUpperCase().equals(jugadorActual.getNombreUsuario().trim().toUpperCase())){
                                    juegoActual.getJugadores().remove(j);
                            }
                        }
                     break;     
                     case 15:
                        String datos15=reader.readUTF();
                        String[] datosArray15=splitCommands(datos15);
                        ICommand command15=manager.getCommand(datosArray15[0].trim());  
                        String mensajeRetorno15=command15.execute(datos15, jugadorActual);
                        turnoSiguiente();
                                String siguiente="";
                                for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){ //Hace los turnos
                                    if(juegoActual.getJugadoresTurnados().get(i).isTurno()){
                                        siguiente=juegoActual.getJugadoresTurnados().get(i).getNombreUsuario();
                                    }
                                }
                                for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                                    ThreadServidor current = server.conexiones.get(i);
                                    current.writer.writeInt(4);
                                    current.writer.writeUTF(mensajeRetorno15);
                                    current.writer.writeInt(4);
                                    current.writer.writeUTF("Turno de ataque: "+siguiente);
                                }
                        
                     break;
                     case 16:
                        String datos16=reader.readUTF();
                        String[] datosArray16=splitCommands(datos16);
                        ICommand command16=manager.getCommand(datosArray16[0].trim());  
                        String mensajeRetorno16=command16.execute(datos16, jugadorActual);
                        for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                            current.writer.writeUTF(mensajeRetorno16);
                        }
                        
                     break;  
                     case 17:
                        for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                            ThreadServidor current = server.conexiones.get(i);
                            String historial = current.jugadorActual.getNombreUsuario()+"\n";
                            historial+=current.jugadorActual.getLogJugadorRecibido();
                            historial+=current.jugadorActual.getLogJugadorEnviado();
                            writer.writeInt(4);
                            writer.writeUTF(historial);
                        }
                        
                     break;
                     case 18:
                        String enemigo=reader.readUTF();
                        for(int i=0; i<juegoActual.getJugadores().size();i++){ //Muestra los turnos
                            ThreadServidor current = server.conexiones.get(i);
                            if(current.jugadorActual.getNombreUsuario().toUpperCase().equals(enemigo)){
                                int vivitas=0;
                                for(int j=0; j<current.jugadorActual.getLuchadores().size();j++){ //Busca las casillas afectadas y las actualiza
                                        int casillasVivas1=calcularCasillas(current.jugadorActual.getLuchadores().get(j),juegoActual.getJugadores().get(i));
                                        int casillasTotales1=calcularCasillasTotales(current.jugadorActual.getLuchadores().get(j), juegoActual.getJugadores().get(i));
                                        vivitas+=casillasVivas1;
                                    }
                                String datosEne=current.jugadorActual.getNombreUsuario()+"\n";
                                datosEne+="Vida: ";
                                datosEne=datosEne+""+((vivitas*100)/600);
                                datosEne+="\nCeldas muertas: ";
                                datosEne=datosEne+""+(600-vivitas);
                                writer.writeInt(4);
                                writer.writeUTF(datosEne);
                            }  
                        }
                     break;
                     case 19:
                        try {
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    writer.writeInt(12);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                                    String porcentajeCasilla = ""+casillasJugador[i][j].porcentajeVida;
                                    writer.writeUTF(porcentajeCasilla);
                                }
                             }
                            try
                                {
                                    Thread.sleep(15000);
                                }
                                catch(InterruptedException ex)
                                {
                                    Thread.currentThread().interrupt();
                                }
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    writer.writeInt(12);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    writer.writeUTF("");
                                }
                             }
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     break;
                     case 20:
                        try {
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    int boolViva;
                                    Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                                    if(casillasJugador[i][j].porcentajeVida>0){
                                        boolViva=1;
                                    }else{
                                        boolViva=0;
                                    }
                                    writer.writeInt(13);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    writer.writeInt(boolViva);
                                    writer.writeUTF(casillasJugador[i][j].color);
                                }
                            }
                                try
                                    {
                                        Thread.sleep(20000);
                                    }  
                                    catch(InterruptedException ex)
                                    {
                                        Thread.currentThread().interrupt();
                                    }
                             
                            for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
                                for (int j = 0; j <30; j++){ 
                                    writer.writeInt(7);
                                    writer.writeInt(i);
                                    writer.writeInt(j);
                                    Casilla [][]casillasJugador = jugadorActual.getMatrizCasillas();
                                    writer.writeUTF(casillasJugador[i][j].color);
                                }
                             }
                           
                        } catch (IOException ex) {
                            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     break;
                    default:
                    
                }
            } catch (IOException ex) {
                
            }
        }
    } 
    
    public String[] splitCommands(String datostxt) {
        String[] datos=datostxt.split("-");
        return datos;
    }
    
    public int calcularCasillas(Luchador luchador, Jugador jugador){
        int contador=0;
         for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){ 
                Casilla [][]casillasJugador = jugador.getMatrizCasillas();
                if(casillasJugador[i][j].luchadorRepresentado.equals(luchador)){
                    if(casillasJugador[i][j].porcentajeVida>0){
                        contador++;
                    }

                }
            }
        }
        return contador;
    }
    
    public int calcularCasillasTotales(Luchador luchador, Jugador jugador){
        int contador=0;
         for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){ 
                Casilla [][]casillasJugador = jugador.getMatrizCasillas();
                if(casillasJugador[i][j].luchadorRepresentado.equals(luchador)){
                   contador++;
                }
            }
        }
        return contador;
    }
    
    public ArrayList<Jugador> generarOrdenAleatorio(){
        ArrayList<Jugador> listaProvisional = new ArrayList<Jugador>();
        listaProvisional = clonarListaJugadores(juegoActual.getJugadores(), listaProvisional);
        for (int i = 0; i < juegoActual.getJugadores().size(); i++){ 
            if (listaProvisional.size()==1){
                juegoActual.jugadoresTurnados.add(listaProvisional.get(0));
            }else{
                int randomNum = (int) Math.floor(Math.random()*((listaProvisional.size()-1)-0+1)+0);
                juegoActual.jugadoresTurnados.add(listaProvisional.get(randomNum));
                listaProvisional.remove(listaProvisional.get(randomNum));
            }
        }
        juegoActual.getJugadoresTurnados().get(0).turno = true;
        juegoActual.contVivos = juegoActual.getJugadoresTurnados().size();
        return juegoActual.getJugadoresTurnados();
    }
    
    public ArrayList<Jugador> clonarListaJugadores(ArrayList<Jugador> jugadoresOficial, ArrayList<Jugador> jugadoresClonados){
        for (int i = 0; i <jugadoresOficial.size(); i++){ 
            jugadoresClonados.add(jugadoresOficial.get(i));
        }
        return jugadoresClonados;
    }
    
        public String recorrerCasillas(Jugador jugador){
         String historialTemp="";
         for (int i = 0; i <20; i++){ // El primer índice recorre las filas.
            for (int j = 0; j <30; j++){ 
                Casilla [][]casillasJugador = jugador.getMatrizCasillas();
                    if(casillasJugador[i][j].ataqueReciente){
                        historialTemp+=casillasJugador[i][j].historialAtaques;
                        casillasJugador[i][j].ataqueReciente=false;
                    }

                }
            }
            return historialTemp;
        }
        
        public void turnoSiguiente(){
        for(int i=0; i<juegoActual.getJugadoresTurnados().size();i++){
            if(juegoActual.getJugadoresTurnados().get(i).isTurno()){
                juegoActual.getJugadoresTurnados().get(i).setTurno(false);
                if(i==juegoActual.getJugadoresTurnados().size()-1){
                    juegoActual.getJugadoresTurnados().get(0).setTurno(true);
                    break;
                }else{
                    juegoActual.getJugadoresTurnados().get(i+1).setTurno(true);
                    break;
                }
            }
        }
        }
        
    public boolean revisarGanador(){
        for(int i=0; i<juegoActual.getJugadores().size();i++){
            juegoActual.getJugadores().get(i).vivo = revisarCasillas(juegoActual.getJugadores().get(i));
            System.out.println("Vivo: "+juegoActual.getJugadores().get(i).getNombreUsuario()+" - "+juegoActual.getJugadores().get(i).vivo);
            if(juegoActual.getJugadores().get(i).vivo==false){
                juegoActual.contVivos-=1;
            }
            if(juegoActual.contVivos == 1){
                return true;
            }
        }
        return false;
    }
    
    public boolean revisarCasillas(Jugador jugador){
        for (int i = 0; i <20; i++){
            for (int j = 0; j <30; j++){ 
                if(jugador.casillas[i][j].porcentajeVida>0){
                    return true;
                }
            }
        }
        jugador.turno=false;
        for(int i=0; i<juegoActual.jugadoresTurnados.size();i++){
            if(juegoActual.jugadoresTurnados.get(i).getNombreUsuario().equals(jugador.getNombreUsuario())){
                juegoActual.jugadoresTurnados.remove(i);
                return false;
            }
        }
        return false;
    }
}
