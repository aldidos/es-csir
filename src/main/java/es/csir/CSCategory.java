package es.csir;

//** A Pylint code smell category.

public enum CSCategory 
{
	Fatal,
	Error,
	Warning,
	Convention,
	Refactor ;

	public static String category(String msgId)
	{
		char c = msgId.charAt(0);
		switch ( c ) 
		{
			case 'C' : 
				return Convention.toString();
			case 'E' : 
				return Error.toString();
			case 'W' : 
				return Warning.toString();
			case 'F' : 
				return Fatal.toString();
			case 'R' : 
				return Refactor.toString();
		}

		return null;
	}
}
