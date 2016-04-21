class BracketChecker
{
	private String input;
	boolean balanced=true;
	public BracketChecker(String in)
	{
		input = in;
	}
	
	public void check()
	{
		LinkStack theStack = new LinkStack();
		
		for(int j=0; j<input.length(); j++)
		{
			char ch = input.charAt(j);
			
			switch(ch)
			{
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if( !theStack.isEmpty())
				{
					char chx = theStack.pop();
					if
					(
						(ch=='}' && chx!='{') ||
						(ch==']' && chx!='[') ||
						(ch==')' && chx!='(')	
					)
					{
						balanced=false;
					}

				}
				else
					balanced = false;
					break;
					default: //No action on other characters
					break;
					
			}//end switch
			//theStack.displayStack();
				
		}//end for
		
		if(!theStack.isEmpty())
		{
			balanced=false;
		}		
		
		////////////////////////////Results
		if(balanced==true)
		{
			System.out.println("Balanced");
		}	

		if(balanced==false)
		{
			System.out.println("Not Balanced");		
		}		
	}//end check
}