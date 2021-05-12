package files;

public class payload {
		
		public static String postAddBook(String name, String isbn, String aisle, String author) {
			return "{\r\n" + 
					"\r\n" + 
					"\"name\":\""+name+"\",\r\n" + 
					"\"isbn\":\""+isbn+"\",\r\n" + 
					"\"aisle\":\""+aisle+"\",\r\n" + 
					"\"author\":\""+author+"\"\r\n" + 
					"}";
		}
}