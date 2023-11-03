package module11.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import java.lang.Thread;

public class McasTest {


    //Predicate 1: if predicate is true, MCAS will set state to ARMED. Otherwise, the state will remain INACTIVE
    //Row 1b
    //S: T (Inactive)
    //P: T (autopilot on)
    //F: F (flaps up)
    //AOA>threshold: F (AOA<12)
    //Expected value of predicate: False (INACTIVE)
    @Test
    public void test7(){
        boolean autoPilot = true;
        boolean flapsDown = false;

        Mcas m = new Mcas();
        m.trim(autoPilot, flapsDown, 10);

        assertEquals(Mcas.State.INACTIVE, m.getState());
    }

    //Row 1c
    //S: T (Inactive)
    //P: F (autopilot off)
    //F: T (flaps down)
    //AOA>threshold: F (AOA<12)
    //Expected value of predicate: False (INACTIVE)
    @Test
    public void test11(){
        boolean autoPilot = false;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(autoPilot, flapsDown, 10);

        assertEquals(Mcas.State.INACTIVE, m.getState());
    }

    //Row 1d
    //S: T (Inactive)
    //P: F (autopilot off)
    //F: F (flaps up)
    //AOA>threshold: F (AOA<12)
    //Expected value of predicate: true (ARMED)
    @Test
    public void test15(){
        boolean autoPilot = false;
        boolean flapsDown = false;

        Mcas m = new Mcas();
        m.trim(autoPilot, flapsDown, 10);

        assertEquals(Mcas.State.ARMED, m.getState());
    }

    //Row 1h
    //S: F (not Inactive)
    //P: F (autopilot off)
    //F: F (flaps up)
    //AOA>threshold: T (AOA>12)
    //Expected value of predicate: true (ARMED)
    @Test
    public void test45(){
        Mcas m = new Mcas(); //state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE 

        assertNotEquals(Mcas.State.ARMED, m.getState());
    }

    
    ////////////////////////////////////////////////////////////////////////////
    //Predicate 2: 
    //Row 2b
    //S: T (ARMED)
    //P: T (autopilot on)
    //F: F (flaps up)
    //Expected value of predicate: True (INACTIVE)
    @Test
    public void test24(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.ARMED, m.getState());
        
        m.trim(autoPilotOn, flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }

    //Predicate 2: 
    //Row 2c
    //S: T (Active)
    //P: F (autopilot off)
    //F: T (flaps down)
    //Expected value of predicate: True (INACTIVE)
    @Test
    public void test27(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.ARMED, m.getState());
        
        m.trim(!autoPilotOn, flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }
    
    //Predicate 2: 
    //Row 2d
    //S: T (ARMED)
    //P: F (autopilot off)
    //F: F (flaps up)
    //Expected value of predicate: False (ARMED)
    @Test
    public void test32(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.ARMED, m.getState());
        
        m.trim(!autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.ARMED, m.getState());
    }

    //Predicate 2: 
    //Row 2f
    //S: F (INACTIVE)
    //P: T (autopilot on)
    //F: F (flaps up)
    //Expected value of predicate: False (INACTIVE)
    @Test
    public void test8b(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        
        m.trim(autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }

    //Predicate 2: 
    //Row 2b
    //S: T (ACTIVE)
    //P: T (autopilot on)
    //F: F (flaps up)
    //Expected value of predicate: False (INACTIVE)
    @Test
    public void test37(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0); //ARMED
        m.trim(!autoPilotOn, !flapsDown, 13); //Changing to ACTIVE
        assertEquals(Mcas.State.ACTIVE, m.getState());
        
        m.trim(autoPilotOn, flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }


    //Predicate 2: 
    //Row 2c
    //S: T (Active)
    //P: F (autopilot off)
    //F: T (flaps down)
    //Expected value of predicate: True (INACTIVE)
    @Test
    public void test41(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0); //ARMED
        m.trim(!autoPilotOn, !flapsDown, 13); //Changing to ACTIVE
        assertEquals(Mcas.State.ACTIVE, m.getState());
        
        m.trim(!autoPilotOn, flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }
    
    //Predicate 2: 
    //Row 2d
    //S: T (Active)
    //P: F (autopilot off)
    //F: F (flaps up)
    //Expected value of predicate: True (INACTIVE)
    @Test
    public void test45b(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilotOn, !flapsDown, 0); //ARMED
        m.trim(!autoPilotOn, !flapsDown, 13); //Changing to ACTIVE
        assertEquals(Mcas.State.ACTIVE, m.getState());
        
        m.trim(!autoPilotOn, !flapsDown, 13);
        assertEquals(Mcas.State.ACTIVE, m.getState());
    }

    //Predicate 2: 
    //Row 2f
    //S: F (INACTIVE)
    //P: T (autopilot on)
    //F: F (flaps up)
    //Expected value of predicate: False (INACTIVE)
    @Test
    public void test8(){
        boolean autoPilotOn = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        
        m.trim(autoPilotOn, !flapsDown, 0);
        assertEquals(Mcas.State.INACTIVE, m.getState());
    }

    ////////////////////////////////////////////////////////////////////////////
    //Predicate 3

    //Row3a
    //S: T (ARMED)
    //A: T (AOA > threshold)
    //Expected value of predicate: True (ACTIVE)
    @Test
    public void test29(){
        boolean autoPilot = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilot, !flapsDown, 0); //ARMED

        m.trim(!autoPilot, !flapsDown, 13); //Changing to ACTIVE

        assertEquals(Mcas.State.ACTIVE, m.getState());
    }
    
    //Row3b
    //S: T (ARMED)
    //A: F (AOA<=threshold)
    //Expected value of predicate: False (Not ACTIVE)
    @Test
    public void test31(){
        boolean autoPilot = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(!autoPilot, !flapsDown, 0); //ARMED

        m.trim(!autoPilot, !flapsDown, 10); //ARMED

        assertEquals(Mcas.State.ARMED, m.getState());
    }

    //Row3c
    //S: F (Not active)
    //A: T (AOA > threshold)
    //Expected value of predicate: False (Not Active)
    @Test
    public void test1(){
        boolean autoPilot = true;
        boolean flapsDown = true;

        Mcas m = new Mcas();
        m.trim(autoPilot, flapsDown, 15); //Changing to INACTIVE

        assertEquals(Mcas.State.INACTIVE, m.getState());
    }
    
    

    ////////////////////////////////////////////////////////////////////////////
    //Predicate 4: predicate is true,MCAS System will set the state of the system to ARMED
    //Row 4a
    //S: T (Active)
    //A: T (AOA <= Threshold)
    //Expected value of predicate: False 
    @Test
    public void test47b(){
        Mcas m = new Mcas(); //state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE and timer has started
        m.trim(false, false, 10); //state is ARMED

        assertEquals(Mcas.State.ARMED, m.getState());
        
    }
    //Row 4b
    // S: T (ACTIVE)
    // A: F (AOA <= Threshold)
    // Expected value of predicate: True 
    @Test
    public void test48()
    {
        Mcas m = new Mcas(); // state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE and timer has started
        m.trim(false, false, 8); //state is ARMED

        assertEquals(Mcas.State.ARMED, m.getState());
        
    }
    // Row 4d
    // S: F (INACTIVE)
    // A: F (AOA <= Threshold)
    // Expected value of predicate: False
    @Test
    public void test3()
    {
        Mcas m = new Mcas(); // state is INACTIVE
        m.trim(true, true, 10); //state is INACTIVE

        assertEquals(Mcas.State.INACTIVE, m.getState());

    }





    ////////////////////////////////////////////////////////////////////////////
    //Predicate 5: if predicate is true, MCAS will execute the DOWN command and the timer will be reset
    //Row 5a
    //S: T (Active)
    //A: T (AOA > Threshold)
    //T: T (timer is expired)
    //AOA>threshold: F (AOA<12)
    //Expected value of predicate: True (ACTIVE, DOWN)
    @Test
    public void test33(){
        Mcas m = new Mcas(); //state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE and timer has started

        try {
            Thread.sleep(10100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Mcas.Command command = m.trim(false, false, 15); //state is ACTIVE, timer has expired, command is still DOWN
        
        assertEquals(Mcas.State.ACTIVE, m.getState());
        assertEquals(command, Mcas.Command.DOWN);
    }

    //Row 5b
    //S: T (Active)
    //A: T (AOA > Threshold)
    //T: F (timer is not expired)
    //Expected value of predicate: False (ACTIVE, NO command)
    @Test
    public void test46(){
        Mcas m = new Mcas(); //state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE and timer has started  
        Mcas.Command command = m.trim(false, false, 15); //state is ACTIVE, timer has expired, command is still DOWN
        
        assertEquals(Mcas.State.ACTIVE, m.getState());
        assertEquals(command, Mcas.Command.NONE);
    }
    
    //Row 5c
    //S: T (Active)
    //A: F (AOA <= Threshold)
    //T: T (timer is expired)
    //Expected value of predicate: False (ACTIVE, NO command)
    @Test
    public void test47(){
        Mcas m = new Mcas(); //state is INACTIVE
        m.trim(false, false, 10); //state is ARMED
        m.trim(false, false, 15); //state is ACTIVE and timer has started

       try {
            Thread.sleep(10100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Mcas.Command command = m.trim(false, false, 8); //state is ACTIVE, timer has expired, command is still DOWN
        
        assertEquals(Mcas.State.ARMED, m.getState());
        assertEquals(command, Mcas.Command.NONE);
    }

    //Row 5e
    //S: F (A state other than Active)
    //A: T (AOA > Threshold)
    //T: T (timer is expired)
    //Expected value of predicate: False (ARMED state)
    @Test
    public void test13(){
        Mcas m = new Mcas(); //state is INACTIVE

        try {
            Thread.sleep(10100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.trim(false, false, 8); //state is ARMED

        
        assertEquals(Mcas.State.ARMED, m.getState());
    }
}
