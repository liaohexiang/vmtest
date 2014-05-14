package org.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** 
 * The task requirement specified that "the 2 SORED collection", which means I don't need any sorting algorithm 
 * such as MergeSort, QuickSort which make the running time up to nlogn. So the program is running in the liner time.  
 * 
 * @author Tony Liao
 *
 * @param <T>
 */
public class Merge<T> {

	private List<T> arrayOutput;

	public  List<T> execute(List<T> t1, List<T> t2, SORTTYPE sorttype,Comparator<T> comparator){
		
		ArrayHolder<T> a1 = new ArrayHolder<T>(t1, sorttype,comparator);
		ArrayHolder<T> a2 = new ArrayHolder<T>(t2, sorttype,comparator);
		arrayOutput = new ArrayList<T>(a1.getArrayLength()+a2.getArrayLength());
		
			while(!a1.isEnd()&&!a2.isEnd()){
				if(sorttype == SORTTYPE.DECSEND){
					if (comparator.compare(a1.getCurrent(),a2.getCurrent())<=0){
						arrayOutput.add(a2.getCurrent());
						a2.next();
					}
					else{
						arrayOutput.add(a1.getCurrent());
						a1.next();
					}
				}
				else{
					if (comparator.compare(a1.getCurrent(),a2.getCurrent())<=0){
						arrayOutput.add(a1.getCurrent());
						a1.next();
					}
					else{
						arrayOutput.add(a2.getCurrent());
						a2.next();
					}
				}
				
			}
		if(a1.isEnd()) copyRest(this.arrayOutput, a2);
		else copyRest(this.arrayOutput,a1);
		
		return arrayOutput;
	}

	private void copyRest(final List<T> arrayOutput, final ArrayHolder<T> array){
		arrayOutput.addAll(array.copyRest());
	}
	public enum SORTTYPE {
		DECSEND, ASEND;
	}

}
