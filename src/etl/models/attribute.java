/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etl.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suren
 */
public class attribute {
    private String attrName;
    private List<String> rules;
    private String matchingField;

    public attribute(String attrName) {
        this.attrName = attrName;
        rules = new ArrayList<>();
    }
    
    public attribute() {
        rules = new ArrayList<>();
    }

    public String getAttrName() {
        return attrName;
    }

    public List<String> getRules() {
        return rules;
    }

    public boolean setRule(String newRule){
        for (String rule : rules) {
            if(rule.equals(newRule))
                return false;
        }
        this.rules.add(newRule);
        return true;
    }
    
    public void removeRule(String ruleToRemove){
        for (String rule : rules) {
            if(rule.equals(ruleToRemove)){
                rules.remove(ruleToRemove);
                return;
            }                
        }
    } 

    public String getMatchingField() {
        return matchingField;
    }

    public void setMatchingField(String matchingField) {
        this.matchingField = matchingField;
    }   
    
}
