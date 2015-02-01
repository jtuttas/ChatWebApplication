/**
 * Das Chat Bean nimmz die zu dennden Nachrichten pro CLient Session und und leitet Sie an den Websocket Endpoint weiter
 */
package de.tuttas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jörg
 */
@ManagedBean
@SessionScoped
public class ChatBean {

    String msg="";
    /**
     * Creates a new instance of ChatBean
     */
    public ChatBean() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String msgChanged() {
        ChatWSEndpoint.send(msg);
        msg="";
        return "";
    }
    
}
