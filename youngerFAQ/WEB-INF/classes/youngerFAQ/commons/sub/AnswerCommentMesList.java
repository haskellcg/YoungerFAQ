package youngerFAQ.commons.sub;

import java.util.ArrayList;

public class AnswerCommentMesList {

	ArrayList<AnswerCommentMes> answerList = null;
	private int num;
	private int pos;
	private int defaultSize = 25;

	public AnswerCommentMesList() {
		setup(defaultSize);
	}

	public AnswerCommentMesList(int size) {
		setup(size);
	}

	private void setup(int size) {
		answerList = new ArrayList<AnswerCommentMes>(size);
		num=pos=0;
	}
	
	public void insert(AnswerCommentMes item)
	{
			this.answerList.add(this.pos, item);
			this.num++;
	}
	
	public void append(AnswerCommentMes item)
	{
		this.answerList.add(item);
		this.num++;
	}
	
	public AnswerCommentMes remove()
	{
		AnswerCommentMes temp=(AnswerCommentMes)this.answerList.get(pos);
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
	
	public void setValue(AnswerCommentMes item)
	{
		this.answerList.set(pos, item);
	}
	
	public AnswerCommentMes currValue()
	{
		return (AnswerCommentMes)this.answerList.get(pos);
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
