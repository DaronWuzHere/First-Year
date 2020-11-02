//Exceptions to be used with the DeleteField class
public class DeleteFieldException extends Exception
{
  //DeleteFieldException with no message and no cause
  public DeleteFieldException()
  {
    super();
  }//DeleteFieldException
  
  //DeleteFieldException with message but no cause
  public DeleteFieldException(String message)
  {
    super(message);
  }//DeleteFieldException

  //DeleteFieldException with message and cause
  public DeleteFieldException(String message, Throwable cause)
  {
    super(message, cause);
  }//DeleteFieldException
  
  //DeleteFieldException with no message but a cause
  public DeleteFieldException(Throwable cause)
  {
    super(cause);
  }//DeleteFieldException
}//DeleteFieldException
