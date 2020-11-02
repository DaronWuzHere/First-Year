import sys
from ex3utils import Server



class MyServer(Server):

	def onStart(self):
                self.count = 0
		print "My server has started"
                self.tokens = dict()

	def onMessage(self, socket, message):
                (self.command, self.sep, self.parameter) = message.strip().partition(" ")
                if (self.command == "REG"):
                    self.UserName = str(self.parameter)
                    socket.send("You have been registered as: " + self.UserName)
                    self.tokens.update({str(self.UserName):socket})

                if (self.command == "ALL"):
                    print "Command is " + self.command
                    self.message = str(self.parameter)
                    self.lCount = self.count - 1
                    for self.token in self.tokens:
                        socket.send(self.UserName + ": " + self.message),
       
                if (str(self.command) in self.tokens):
                    self.tokens[str(self.command)].send(self.parameter)
                
                if (self.command == "END"):
                    return False
                    self.onDisconnect(self, socket, message)
                else:
                    return True


        def onConnect(self, socket):
                self.count = self.count + 1
                if self.count == 1:
                    socket.send("Connection has been established, this chat has %s\n" % self.count + "person")
                else:
                    socket.send("Connection has been established, this chat has %s\n" % self.count + "people")  
                socket.send("Use the command REG and a username to register")    
                              

        def onDisconnect(self, socket, message):
                socket.send("Connection terminated")
                print "Connection terminated"
                self.count = 0
                return False
		

ip = sys.argv[1]
port = int(sys.argv[2])

server = MyServer()
server.start(ip, port)

