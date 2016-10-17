/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author dorra
 */
@ManagedBean(name="MessageView")
@RequestScoped

public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    private Message message;
 
    public MessageView(){
        this.message=new Message();}
    
    public Message getMessage(){
            return message;
        }
    public int getNumberOfMessage(){
        return messageFacade.findAll().size();
    }
    public String postMessage(){
        this.messageFacade.create(message);
        return "theend";
    }
    
}
