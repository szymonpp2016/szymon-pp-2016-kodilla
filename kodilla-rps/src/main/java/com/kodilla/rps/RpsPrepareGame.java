package com.kodilla.rps;

import java.util.HashMap;

class RpsPrepareGame

{
    private HashMap<Integer, String> rpsSchema = new HashMap<>();


    public void listPossibleAnswer(Integer version) {
        rpsSchema3option();
        if(version==2) rpsSchema5option();
    }

    private void rpsSchema3option() {
        rpsSchema.put(1,"key 1 - play \"rock\",");
        rpsSchema.put(2,"key 2 - play \"paper\",");
        rpsSchema.put(3,"key 3 - play \"scissors\".");
    }

    private void rpsSchema5option() {
        rpsSchema.put(4,"key 4 - play \"Spock\",");
        rpsSchema.put(5,"key 5 - play \"lizard\".");
    }

    public HashMap<Integer, String> getRpsSchema() {
        return rpsSchema;
    }
}
