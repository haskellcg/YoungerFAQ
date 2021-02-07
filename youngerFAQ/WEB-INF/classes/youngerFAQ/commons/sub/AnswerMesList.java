package youngerFAQ.commons.sub;

import java.util.ArrayList;

public class AnswerMesList {
	
	
	ArrayList<AnswerMes> answerList = null;
	private int num;
	private int pos;
	private int defaultSize = 25;

	public AnswerMesList() {
		setup(defaultSize);
	}

	public AnswerMesList(int size) {
		setup(size);
	}

	private void setup(int size) {
		answerList = new ArrayList<AnswerMes>(size);
		num=pos=0;
	}
	
	public void insert(AnswerMes item)
	{
			this.answerList.add(this.pos, item);
			this.num++;
	}
	
	public void append(AnswerMes item)
	{
		this.answerList.add(item);
		this.num++;
	}
	
	public AnswerMes remove()
	{
		AnswerMes temp=(AnswerMes)this.answerList.get(pos);
		this.answerList.remove(this.pos);
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
	
	public void setValue(AnswerMes item)
	{
		this.answerList.set(pos, item);
	}
	
	public AnswerMes currValue()
	{
		return (AnswerMes)this.answerList.get(pos);
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
