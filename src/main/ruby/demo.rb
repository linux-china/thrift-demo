$:.push('../thrift/uic')

require 'thrift'
require 'user_service'


transport = Thrift::BufferedTransport.new(Thrift::Socket.new('localhost', 9090))
protocol = Thrift::BinaryProtocol.new(transport)
client = UserService::Client.new(protocol)
transport.open
# Run a remote calculation
result = client.getName
puts result
transport.close
