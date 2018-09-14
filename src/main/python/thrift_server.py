# -*- coding: utf-8 -*-
import sys

sys.path.append("../thrift")

from thrift.transport import TSocket
from thrift.server import TServer
from uic.UserService import UserService


class UserServiceHandler:
    def getName(self):
        print("[Server] Handling client request")
        return "你好 thrift, from the python server"


handler = UserServiceHandler()
processor = UserService.Processor(handler)
listening_socket = TSocket.TServerSocket(port=9090)
server = TServer.TSimpleServer(processor, listening_socket)
print("[Server] Started")
server.serve()
