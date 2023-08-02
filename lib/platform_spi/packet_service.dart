import '../platform_android/packet_service_impl.dart';

abstract class PacketService {
  Future<void> packetSync(String packetId);

  factory PacketService() => getPacketServiceImpl();
}
