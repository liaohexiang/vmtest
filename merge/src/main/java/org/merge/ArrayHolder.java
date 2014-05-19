package org.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.merge.Merge.SORTTYPE;

public class ArrayHolder<T>{

	private List<T> array;
	private int arrayLength;
	private int index;
	private int startIndex;
	
	private SORTTYPE sortType;
	
	public ArrayHolder(List<T> array, SORTTYPE sort,Comparator<T> comparator ){
		
		this.array = array;
		this.arrayLength = array.size();
		if(comparator.compare(this.array.get(0),this.array.get(arrayLength-1))>0)
			this.sortType = SORTTYPE.DECSEND;
		else
			this.sortType = SORTTYPE.ASEND;
		
		if(sort == SORTTYPE.DECSEND){
			if (this.sortType == SORTTYPE.DECSEND){
				this.startIndex = 0;
				this.index=0;
			}
			else
				{
				this.startIndex = this.arrayLength-1;
				this.index = this.arrayLength-1;
				}
		}
		else{
			if(this.sortType == SORTTYPE.DECSEND){
				this.startIndex = this.arrayLength-1;
				this.index = this.arrayLength-1;
			}
				
			else{
					this.startIndex = 0;
					this.index = 0;
			}
		}
	}

	public int getArrayLength() {
		return arrayLength;
	}
	public int getIndex() {
		return index;
	}
	public T getCurrent(){
		return this.array.get(index);
	}
	public SORTTYPE getSortType() {
		return sortType;
	}
	public void next(){
	
		if(this.startIndex == 0)
			++this.index;
		else --this.index;
		
	}
	public boolean isEnd(){
		if(this.startIndex==0&&index==this.arrayLength)
			return true;
		else if(this.startIndex==this.arrayLength-1&&this.index<0)
			return true;
		else
			return false;
	}
	public List<T> copyRest(){
		if(this.startIndex == 0)
			return this.array.subList(index, this.arrayLength);
		List<T> remains = new ArrayList<T>(index+1);
		remains.addAll(this.array.subList(0, index+1));
		T temp = null;
		for(int i=0;i<index+1/2;i++){
			temp = remains.get(i);
			remains.set(i, remains.get(index-i));
			remains.set(index-i, temp);
		}
		return remains;
	}
}
