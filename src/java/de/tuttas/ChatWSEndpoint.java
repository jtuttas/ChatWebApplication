/**
 * Websocket Endpunkt verwaltet die Clients und stellt die statische Methode send zur Verfügung, mit der die 
 * Clients aktualisiert werden!
 */
package de.tuttas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Jörg
 */
@ServerEndpoint("/chat")
public class ChatWSEndpoint {

    private static ArrayList<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection"); 
        try {
            session.getBasicRemote().sendText("Connection Established");
            sessions.add(session);
            System.out.println ("Total Number of Clients ="+sessions.size());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    @OnMessage
    public String onMessage(String message) {
        System.out.println ("ChatWSEndpoint:"+message);
        return null;
    }
    
    
    @OnClose
    public void onClose(Session session){
        System.out.println("Session " +session.getId()+" has ended");
        sessions.remove(session);
    }
    public static void send(String msg) {
        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendText(msg);
                System.out.println ("Nachricht gesendet an "+s.getId());
            } catch (IOException ex) {
                Logger.getLogger(ChatWSEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
    }
    
}
