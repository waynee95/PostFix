package me.waynee95.postfix.lex;

public class Token {
    
    public String id;
    public String value;
    
    public Token(String id, String value) {
        this.id = id;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return id + " " + (value != null ? value : "");
    }

}
