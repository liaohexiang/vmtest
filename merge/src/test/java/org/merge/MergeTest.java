package org.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.merge.Merge.SORTTYPE;

public class MergeTest {

	Merge<TestObject> tested;
	@Before
	public void setup(){
		tested = new Merge<TestObject>();
	}
	
	@Test public void testDESCENDMerge(){
		List<TestObject> l1 = new ArrayList<TestObject>();
		l1.add(new TestObject(1));
		l1.add(new TestObject(2));
		l1.add(new TestObject(4));
		
		l1.add(new TestObject(6));
		
		List<TestObject> l2 = new ArrayList<TestObject>();
		l2.add(new TestObject(3));
		l2.add(new TestObject(5));
		l2.add(new TestObject(7));
		l2.add(new TestObject(9));
		l2.add(new TestObject(10));
		
		List<TestObject> output = tested.execute(l1, l2,SORTTYPE.DECSEND,new TestObjectComparator());
		
		for(TestObject obj: output){
			System.out.println(obj.value);
		}
		System.out.println("===============================");
	}
	@Test public void testASENDMerge(){
		List<TestObject> l1 = new ArrayList<TestObject>();
		l1.add(new TestObject(1));
		l1.add(new TestObject(2));
		l1.add(new TestObject(4));
		
		l1.add(new TestObject(6));
		
		List<TestObject> l2 = new ArrayList<TestObject>();
		l2.add(new TestObject(3));
		l2.add(new TestObject(5));
		l2.add(new TestObject(7));
		l2.add(new TestObject(9));
		
		List<TestObject> output = tested.execute(l1, l2,SORTTYPE.ASEND, new TestObjectComparator());
		
		for(TestObject obj: output){
			System.out.println(obj.value);
		}
		System.out.println("===============================");
		
	}
	@Test public void testASEND_WITH_DESCENDArrayMerge(){
		List<TestObject> l1 = new ArrayList<TestObject>();
		l1.add(new TestObject(1));
		l1.add(new TestObject(2));
		l1.add(new TestObject(4));
		
		l1.add(new TestObject(6));
		
		List<TestObject> l2 = new ArrayList<TestObject>();
		l2.add(new TestObject(9));
		l2.add(new TestObject(7));
		l2.add(new TestObject(5));
		l2.add(new TestObject(3));
		
		List<TestObject> output = tested.execute(l1, l2,SORTTYPE.ASEND,new TestObjectComparator());
		
		for(TestObject obj: output){
			System.out.println(obj.value);
		}
		System.out.println("===============================");
		
	}
	
	@Test public void testDESCEND_WITH_ASEND_ArrayMerge(){
		List<TestObject> l1 = new ArrayList<TestObject>();
		l1.add(new TestObject(1));
		l1.add(new TestObject(2));
		l1.add(new TestObject(4));
		
		l1.add(new TestObject(6));
		l1.add(new TestObject(8));
		
		List<TestObject> l2 = new ArrayList<TestObject>();
		l2.add(new TestObject(9));
		l2.add(new TestObject(7));
		l2.add(new TestObject(5));
		l2.add(new TestObject(3));
		
		List<TestObject> output = tested.execute(l1, l2,SORTTYPE.DECSEND,new TestObjectComparator());
		
		for(TestObject obj: output){
			System.out.println(obj.value);
		}
		System.out.println("===============================");
		
	}
	
	@Test public void testDESCEND_WITH_ASEND_Array_INT_Merge(){
		Merge<Integer> tested = new Merge<Integer>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		
		l1.add(7);
		l1.add(12);
		
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(8);
		l2.add(34);
		l2.add(34);
		l2.add(55);
		l2.add(55);
		l2.add(55);
		l2.add(55);
		
		List<Integer> output = tested.execute(l1, l2,SORTTYPE.DECSEND,new Comparator<Integer>(){

			public int compare(Integer o1, Integer o2) {
				
				if(o1 > o2)
					return 1;
				else if(o1==o2)
					return 0;
				else 
					return -1;
			}
			
		});
		
		for(Integer obj: output){
			System.out.println(obj);
		}
		System.out.println("===============================");
		
	}
	
	
	@After
	public void shutdown(){
		tested = null;
	}
	
	public static class TestObject{

		private int value;
		
		public TestObject(int v){
			this.value= v;
		}
		
	}
	public static class TestObjectComparator implements Comparator<TestObject>
	{

		public int compare(TestObject o1, TestObject o2) {
			if(o1.value > o2.value)
				return 1;
			else if(o1.value==o2.value)
				return 0;
			else 
				return -1;
		}
		
	}
}
