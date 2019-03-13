package com.yssec.model;

public class Locations {
    private String component;

    private TextRange textRange;

    private String msg;

    public void setComponent(String component){
        this.component = component;
    }
    public String getComponent(){
        return this.component;
    }
    public void setTextRange(TextRange textRange){
        this.textRange = textRange;
    }
    public TextRange getTextRange(){
        return this.textRange;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }

}
