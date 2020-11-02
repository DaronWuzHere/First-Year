//Exceptions to be used with the DeleteField class
public class UuencodeException extends Exception
{
  //UuencodeException with no message and no cause
  public UuencodeException()
  {
    super();
  }//UuencodeException
  
  //UuencodeException with message but no cause
  public UuencodeException(String message)
  {
    super(message);
  }//UuencodeException

  //UuencodeException with message and cause
  public UuencodeException(String message, Throwable cause)
  {
    super(message, cause);
  }//UuencodeException
  
  //UuencodeException with no message but a cause
  public UuencodeException(Throwable cause)
  {
    super(cause);
  }//UuencodeException
}//UuencodeException
