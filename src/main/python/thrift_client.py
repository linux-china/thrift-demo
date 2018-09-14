import sys

sys.path.append("../thrift")

from thrift.transport import TTransport, TSocket
from thrift.protocol import TCompactProtocol
from uic.UserService import UserService

socket = TTransport.TFramedTransport(TSocket.TSocket("localhost", 9090))
socket.open()
protocol = TCompactProtocol.TCompactProtocol(socket)
client = UserService.Client(protocol)
msg = client.getNick(1)
print("[Client] received: %s" % msg)