package com.yssec.model;

import java.util.List;

public class Issues{
    private String key;

    private String rule;

    private String severity;

    private String component;

    private String project;

    private String subProject;

    private int line;

    private String hash;

    private TextRange textRange;

    private List<Flows> flows ;

    private String resolution;

    private String status;

    private String message;

    private String effort;

    private String debt;

    private String author;

    private List<String> tags ;

    private String creationDate;

    private String updateDate;

    private String closeDate;

    private String type;

    private String organization;

    private boolean fromHotspot;

    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
    public void setRule(String rule){
        this.rule = rule;
    }
    public String getRule(){
        return this.rule;
    }
    public void setSeverity(String severity){
        this.severity = severity;
    }
    public String getSeverity(){
        return this.severity;
    }
    public void setComponent(String component){
        this.component = component;
    }
    public String getComponent(){
        return this.component;
    }
    public void setProject(String project){
        this.project = project;
    }
    public String getProject(){
        return this.project;
    }
    public void setLine(int line){
        this.line = line;
    }
    public int getLine(){
        return this.line;
    }
    public void setHash(String hash){
        this.hash = hash;
    }
    public String getHash(){
        return this.hash;
    }
    public void setTextRange(TextRange textRange){
        this.textRange = textRange;
    }
    public TextRange getTextRange(){
        return this.textRange;
    }
    public void setFlows(List<Flows> flows){
        this.flows = flows;
    }
    public List<Flows> getFlows(){
        return this.flows;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setEffort(String effort){
        this.effort = effort;
    }
    public String getEffort(){
        return this.effort;
    }
    public void setDebt(String debt){
        this.debt = debt;
    }
    public String getDebt(){
        return this.debt;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }

    public List<String> getTags() {
        return tags;
    }


    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }
    public String getCreationDate(){
        return this.creationDate;
    }
    public void setUpdateDate(String updateDate){
        this.updateDate = updateDate;
    }
    public String getUpdateDate(){
        return this.updateDate;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setOrganization(String organization){
        this.organization = organization;
    }
    public String getOrganization(){
        return this.organization;
    }
    public void setFromHotspot(boolean fromHotspot){
        this.fromHotspot = fromHotspot;
    }
    public boolean getFromHotspot() {
        return this.fromHotspot;
    }

    public String getSubProject() {
        return subProject;
    }

    public void setSubProject(String subProject) {
        this.subProject = subProject;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
}

