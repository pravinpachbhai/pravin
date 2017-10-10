package com.pravin.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravin
 */
@JsonAutoDetect
public class ValidationError implements Serializable {
    private static final long serialVersionUID = 1L;
    List<FieldErrorMessage> messages = new ArrayList<>();

    public List<FieldErrorMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<FieldErrorMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(final FieldErrorMessage message){
        messages.add(message);
    }

}
