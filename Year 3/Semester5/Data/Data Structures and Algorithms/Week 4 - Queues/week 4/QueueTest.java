public class QueueTest{
   public static void main(String[]args){
	// QueueReferenceBased q = new QueueReferenceBased();

    // QueueArrayBased q = new QueueArrayBased();

    QueueListBased q = new QueueListBased();

	for(char i='a';i<'k';i++)
	  q.enqueue (new Character(i));


	for(int i=0;i<10;i++){
	  Object o = q.dequeue();
	  System.out.println((Character) o);
	}
   }
}