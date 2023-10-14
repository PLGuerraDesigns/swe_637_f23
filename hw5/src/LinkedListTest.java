package hw5.src;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

public class LinkedListTest {

    @Test
    public void testEntry(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> 
            list.entry(-1));
    }

    @Test
    public void testGetFirst(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        
        assertEquals(1, list.getFirst());
    }

    @Test
    public void testGetFirstEmptyList(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        assertThrows(NoSuchElementException.class, () -> 
            list.getFirst());
    }
    
    @Test
    public void testGetLast(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        
        assertEquals(2, list.getLast());
    }

    @Test
    public void testGetLastEmptyList(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        assertThrows(NoSuchElementException.class, () -> 
            list.getLast());
    }


    @Test
    public void testAddE(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        
        assertEquals(true, list.add(9));
    }

    @Test
    public void testAdd(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1,9);
        
        assertEquals(4, list.size());
        assertEquals(true, list.contains(9));
    }

    @Test
    public void testRemoveNull(){
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("String1");
        list.add(null);
        list.add("String3");
        boolean result = list.remove(list.get(1)); 

        assertEquals(true,result);
    }

    @Test
    public void testRemoveNonNull(){
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.remove(list.get(2));

        assertFalse(list.contains("String3"));
    }

    @Test
    public void testRemoveHeader(){
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.remove(list.get(0));

        assertFalse(list.contains("String1"));
    }

    @Test
    public void testRemoveInvalidObject(){
       LinkedList<String> list = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");
        
        boolean result = list.remove("String4");

        assertFalse(result);
    }

    @Test
    public void testRemoveFromEmptyList(){
        LinkedList<String> list= new LinkedList<String>();
        LinkedList.Entry<Integer> entry = new LinkedList.Entry<>(null, null, null);
        

        list.add("string1");
        list.add("string2");
        list.add("string3");
        

        assertEquals(false, list.remove(entry));

    }

    @Test
    public void testRemoveNullDoesNotExist(){
        LinkedList<String> list = new LinkedList<String>();
        list.add("string1");
        list.add("string2");
        list.add("string3");

        Object nullVal = null;

        assertEquals(false, list.remove(nullVal));
    }


    @Test
    public void testAddAllWithoutIndex(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list2.add("String4");
        list2.add("String5");
        list2.add("String6");

        list.addAll(list2);

        assertEquals(6, list.size());
    }
    
     @Test
    public void testAddAllWithValidIndex(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list2.add("String4");
        list2.add("String5");
        list2.add("String6");

        list.addAll(0,list2);

        assertEquals("String4",list.get(0));
    }

    @Test
    public void testAddAllIndexGreaterThanListSize(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list2.add("String4");
        list2.add("String5");
        list2.add("String6");

        assertThrows(IndexOutOfBoundsException.class, () -> 
            list.addAll(4,list2));
    }
    
    @Test
    public void testAddAllIndexLessThan0(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list2.add("String4");
        list2.add("String5");
        list2.add("String6");

        assertThrows(IndexOutOfBoundsException.class, () ->
            list.addAll(-1,list2));
    }

    @Test
    public void testAddAllEmptyList(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

    
        assertFalse(list.addAll(2,list2));
        
    }

    @Test
    public void testAddAllWithListSizeAsIndex(){
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list2.add("String4");
        list2.add("String5");
        list2.add("String6");

       assertTrue(list.addAll(3,list2));

        
    }


    @Test
    public void testClear(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void testGet(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.get(2));
    }

    @Test
    public void testSetException(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class, () ->
        	list.set(9, 1)
        );

    }

    @Test
    public void testSet(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        
        assertEquals(2, list.set(1,9));

    }

    @Test
    public void testAddtoSize(){
        LinkedList<String> list = new LinkedList<String>();
        list.add("String1");
        list.add("String2");

        list.add(2,"String3");
        
        assertEquals("String3", list.get(2));
    }

 


    @Test
    public void testRemoveIndex(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer result = list.remove(2);
        assertEquals(3,result);
    }

    @Test 
    public void testIndexOfNull(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");

        assertEquals(1, list.indexOf(null));

    }

    @Test 
    public void testIndexOfNullDoesNoteExist(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add("string2");
        list.add("string3");


        assertEquals(-1, list.indexOf(null));

    }

    @Test 
    public void testIndexOf(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");

        assertEquals(2, list.indexOf("string2"));

    }

    @Test 
    public void testIndexOfDoesNotExist(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");

        assertEquals(-1, list.indexOf("string9"));

    }


    @ Test
    public void testLastIndexOfDuplicateObject(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add("string2");

        assertEquals(4, list.lastIndexOf("string2"));
    }

    @ Test
    public void testLastIndexOfNullDoesNotExist(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add("string2");
        list.add("string3");
        list.add("string2");

        assertEquals(-1, list.lastIndexOf(null));
    }

    @ Test
    public void testLastIndexOfNullObject(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add("string2");

        assertEquals(1, list.lastIndexOf(null));
    }
    @ Test
    public void testLastIndexOfNonExistObj(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add("string2");

        assertEquals(-1, list.lastIndexOf("string9"));
    }

    

    @Test
    public void testRemoveLastOccurrence(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add("string2");

        assertEquals(true, list.removeLastOccurrence("string2"));

        assertThrows(IndexOutOfBoundsException.class, () -> 
            list.get(4));
    }

    @Test
    public void testRemoveLastOccurrenceNull(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add(null);
        

        assertEquals(true, list.removeLastOccurrence(null));

        assertThrows(IndexOutOfBoundsException.class, () -> 
            list.get(4));
    }

    @Test
    public void testRemoveLastOccurrenceDoesNoteExist(){
        LinkedList<String> list= new LinkedList<String>();

        list.add("string1");
        list.add(null);
        list.add("string2");
        list.add("string3");
        list.add(null);
        

        assertEquals(false, list.removeLastOccurrence("string9"));

    }

    @Test
    public void testRemoveLastOccurrenceFromEmptyList(){
        LinkedList<String> list= new LinkedList<String>();
        list.add("string1");
        list.add("string2");
        list.add("string3");

        assertEquals(false, list.removeLastOccurrence(null));

    }


    @Test
    public void testAddBefore() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList.Entry<Integer> entry1 = new LinkedList.Entry<>(1, null, null);
        LinkedList.Entry<Integer> entry3 = new LinkedList.Entry<>(3, null, null);


        list.header.next = entry1;
        entry1.previous = list.header;
        entry1.next = entry3;
        entry3.previous = entry1;
        list.size = 2;

        list.addBefore(2, entry3);

        assertEquals(3, list.size());
        assertEquals(2, (int) entry1.next.element);
        assertEquals(2, (int) entry3.previous.element);
    }
    
    @Test
    public void testRemove(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);

        list.remove();
        assertEquals(1, list.size());
    }
    

    @Test
    public void testRemoveWithEntry(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList.Entry<Integer> entry1 = new LinkedList.Entry<>(1, null, null);
        LinkedList.Entry<Integer> entry2 = new LinkedList.Entry<>(2, null, null);

        
        list.header.next = entry1;
        entry1.previous = list.header;
        entry1.next = entry2;
        entry2.previous = entry1;
        list.size = 2;


        assertEquals(entry1.element, list.remove(entry1));
    }

    @Test
    public void testRemoveWithEntryHeader(){
        LinkedList<Integer> list = new LinkedList<Integer>();

        assertThrows(NoSuchElementException.class, () ->
            list.remove(list.header));
    }

    @Test
    public void testToArray() {
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        String[] array = list.toArray(new String[0]);

        assertEquals(3, array.length);
    }

    @Test
    public void testToArrayGreaterThanSize() {
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        String[] array = list.toArray(new String[4]);

        assertEquals(null, array[3]);
    }


    @Test
    public void testPeekSizeZero(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null, list.peek());
    }
    
    @Test
    public void testPeek(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1", list.peek());
    }


    
    @Test
    public void testElementSizeZero(){
        LinkedList<String> list = new LinkedList<String>();

        assertThrows(NoSuchElementException.class, () -> 
            list.element());
    }

    @Test
    public void testElement(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1", list.element());
    }

    @Test
    public void testPollSizeZero(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null, list.poll());
    }

    @Test
    public void testPoll(){
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1", list.poll());
    }

    
    @Test
    public void testRemoveFirst(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1",list.removeFirst());
    }

    @Test 
    public void testOffer(){
        LinkedList<String> list = new LinkedList<String>();

        boolean res=list.offer("String1");
        assertTrue(res);

    }
    

    @Test 
    public void testOfferFirst(){
        LinkedList<String> list = new LinkedList<String>();

        boolean res=list.offerFirst("String1");
        assertTrue(res);

    }


    @Test 
    public void testOfferLast(){
        LinkedList<String> list = new LinkedList<String>();

        boolean res=list.offerLast("String1");
        assertTrue(res);

    }

    @Test
    public void testPeekFirst(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1",list.peekFirst());
    }
    
    @Test
    public void testPeekFirstWithSize0(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null,list.peekFirst());
    }

    @Test
    public void testPeekLast(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String3",list.peekLast());
    }

    @Test
    public void testPeekLastWithSize0(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null,list.peekLast());
    }

    @Test
    public void testPollFirst(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String1",list.pollFirst());
    }

    @Test
    public void testPollFirstWihSize0(){
        LinkedList<String> list = new LinkedList<String>();

        assertEquals(null,list.pollFirst());
    }

    @Test
    public void testPollLast(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");

        assertEquals("String3",list.pollLast());
    }

    @Test
    public void testPollLastWithSize0(){
        LinkedList<String> list = new LinkedList<String>();


        assertEquals(null,list.pollLast());
    }


    @Test 
    public void testPushElement(){
        LinkedList<String> list = new LinkedList<String>();
        list.push("String1");
        assertEquals("String1",list.getFirst());        
    }



    @Test 
    public void testPopElement(){
        LinkedList<String> list = new LinkedList<String>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        assertEquals("String1",list.pop());        
    }



    @Test
    public void testremoveFirstOccurance(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String2");

        list.removeFirstOccurrence("String2");
        assertTrue(list.contains("String2"));
        
    }

    @Test 
    public void testNewLinkedList(){
        LinkedList<String> list = new LinkedList<String>();
        list.add("String1");
        list.add("String2");

        LinkedList<String> list2 = new LinkedList<String>(list);
        assertEquals(list.getFirst(), list2.getFirst());
    }

}