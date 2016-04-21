public class QueueListBased implements QueueInterface
{
  private ListReferenceBased list;

  public QueueListBased()
  {
    list = new ListReferenceBased();
  }  // end default constructor

  // queue operations:
  public boolean isEmpty()
  {
    return list.isEmpty();
  }  // end isEmpty

  public void enqueue(Object newItem)
  {
    list.add(list.size()+1, newItem);
  }  // end enqueue

  public Object dequeue() throws QueueException
  {
    if (!isEmpty()) {
      // queue is not empty; remove front
      Object queueFront = list.get(1);
      list.remove(1);
      return queueFront;
    }
    else
    {
      throw new QueueException("Queue exception on dequeue: " + "queue empty");
    }  // end if
  }  // end dequeue

  public void dequeueAll()
  {
    list.removeAll();
  }  // end dequeueAll

  public Object peek() throws QueueException
  {
    if (!isEmpty())
    {
      // queue is not empty; retrieve front
      return list.get(1);
    }
    else
    {
      throw new QueueException("Queue exception on peek: " + "queue empty");
    }  // end if
  }  // end peek
}  // end QueueListBased