package crackingTheCodingInterview.chapter7ObjectOrientedDesign;

import java.util.List;

/*
Call Center: Imagine you have a call center with three levels of employees: respondent, manager,
and director. An incoming telephone call must be first allocated to a respondent who is free. If the
respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not
free or not able to handle it, then the call should be escalated to a director. Design the classes and
data structures for this problem. Implement a method dispatchCall () which assigns a call to
the first available employee.
 */
public class CallCenter {

    //Represent a call from a user
    class Call {
        private Rank rank;
        private Caller caller;
        private Employee handler;
        public Call(Caller c) {
            rank = Rank.Respondant;
            caller = c;
        }
        //Set employee who is handling call
        public void setHandler(Employee e) {
            handler = e;
        }
        public Rank getRank(){
            return rank;
        }
        public void reply(String message) {}
    }

    //Body of the program
    class CallHandler {
        private final int LEVELS = 3;
        private final int NUM_RESPONDENTS = 10;
        private final int NUM_MANAGERS = 4;
        private final int NUM_DIRECTORS = 2;
        List<List<Employee>> employeeLevels;
        //Queue for each call
        List<List<Call>> callQueues;
        public Employee getHandlerFroCall(Call call) { return new Respondant();}
        public void dispatchCall(Caller caller) {
            Call call = new Call(caller);
            dispatchCaller(call);
        }
        private void dispatchCaller(Call call) {
            //Try to route the call to an employee with minimal rank
            Employee emp = getHandlerFroCall(call);
            if(emp != null) {
                emp.receiveCall(call);
            } else {
                call.reply("Please wait for free employee");
                callQueues.get(call.getRank().getRankValue()).add(call);
            }
        }
    }

    class Caller {

    }

    abstract class Employee {
        private Call currentCall = null;
        protected Rank rank;
        public Employee(CallHandler handler) {}
        public Employee() {}
        //Start conversation
        public void receiveCall(Call call) {

        }
        //The issue is resolved, finish the call
        public void callCompleted() {

        }
        //The issue has not been resolved, ecalate the call
        public void escalateAndReassign() {}
        //Assign a new call if employee is free
        public boolean assignNewCall() {return true;}
        public boolean isFree() {
            return currentCall == null;
        }
        public Rank getRank() {return rank;}
    }

    class Director extends Employee {
        public Director() {
            rank = Rank.Director;
        }
    }
    class Manager extends Employee {
        public Manager() {
            rank = Rank.Manager;
        }
    }
    class Respondant extends Employee {
        public Respondant() {
            rank = Rank.Respondant;
        }
    }

    enum Rank {
        Respondant (1), Manager (2), Director (3);
        int rankValue;
        private Rank(int value) {
            rankValue = value;
        }
        public int getRankValue(){
            return rankValue;
        }
    }

}
