import im
import time 
server= im.IMServerProxy('http://webdev.cs.manchester.ac.uk/~z20375dm/IMServer.php')
if server['message1'] != None:
    print server['message1']
    del server['message1']
number = 1
while number == 1:
    myMessage1 = raw_input('User, type your message: ')
    server['message1'] = myMessage1
    userInput1 = myMessage1
    time.sleep(15)
    if server['message1'] != myMessage1:
        if userInput1 != server['message1']:
            print "Other User: " + server['message1']
        else:
            print "No response from other user"
            del server['message1']
   
       
        

