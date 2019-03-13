package com.yssec.model;

public class TextRange {
    private int startLine;

    private int endLine;

    private int startOffset;

    private int endOffset;

    public void setStartLine(int startLine){
        this.startLine = startLine;
    }
    public int getStartLine(){
        return this.startLine;
    }
    public void setEndLine(int endLine){
        this.endLine = endLine;
    }
    public int getEndLine(){
        return this.endLine;
    }
    public void setStartOffset(int startOffset){
        this.startOffset = startOffset;
    }
    public int getStartOffset(){
        return this.startOffset;
    }
    public void setEndOffset(int endOffset){
        this.endOffset = endOffset;
    }
    public int getEndOffset(){
        return this.endOffset;
    }

}
