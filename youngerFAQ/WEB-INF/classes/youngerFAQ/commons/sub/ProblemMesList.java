package youngerFAQ.commons.sub;

import java.util.ArrayList;

public class ProblemMesList {
	
	ArrayList<ProblemMes> problemList = null;
	private int num;
	private int pos;
	private int defaultSize = 25;

	public ProblemMesList() {
		setup(defaultSize);
	}

	public ProblemMesList(int size) {
		setup(size);
	}

	private void setup(int size) {
		problemList = new ArrayList<ProblemMes>(size);
		num=pos=0;
	}
	
	public void insert(ProblemMes item)
	{
			this.problemList.add(this.pos, item);
			this.num++;
	}
	
	public void append(ProblemMes item)
	{
		this.problemList.add(item);
		this.num++;
	}
	
	public ProblemMes remove()
	{
		ProblemMes temp=(ProblemMes)this.problemList.get(pos);
		this.problemList.remove(this.pos);
		num--;
		return temp;
	}

	public void setFirst()
	{
		this.pos=0;
	}
	
	public void next()
	{
		if(pos<=num-1)
			pos++;
	}
	
	public void prev()
	{
		if(pos>=0)
			pos--;
	}
	
	public int length()
	{
		return this.num;
	}
	
	public void setPos(int pos)
	{
		if(pos>=0 &&  pos<=num-1)
			this.pos=pos;
		else
			System.out.println("当前位置不合法，无法更改!");
	}
	
	public void setValue(ProblemMes item)
	{
		this.problemList.set(pos, item);
	}
	
	public ProblemMes currValue()
	{
		return (ProblemMes)this.problemList.get(pos);
	}
	
	public boolean isEmpty()
	{
		return this.num==0;
	}
	
	public boolean isInList()
	{
		return (pos>=0)&&(pos<=num-1);
	}

}
