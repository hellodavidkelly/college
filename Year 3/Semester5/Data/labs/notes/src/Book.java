class Book{
	private String title;
	private String author;
	private double price;

    Book(){
		title  = "Data Structures and Algorithms";
		author = "Goodrich and Tamassia";
		price  = 0.0;
	}

    Book(String t, String a, double p){
		title  = t;
		author = a;
		price  = p;
	}

	public String getTitle(){
	   return title;
	}

	public String getAuthor(){
	   return author;
    }

    public double getPrice(){
		   return price;
	}

	public void setTitle(String t){
	   title=t;
	}

	public void setAuthor(String a){
	   author=a;
	}

	public void setPrice(double p){
	    price=p;
	}

	public void displayBook(){
      System.out.println("\nName :" + title +
      "\nAuthor :" + author + "\nPrice :" + price);
    }


}