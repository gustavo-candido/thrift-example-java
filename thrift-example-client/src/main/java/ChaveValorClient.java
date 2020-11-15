package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ChaveValorClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ChaveValor.Client client = new ChaveValor.Client(protocol);

            String s1 = client.setKV(1, "Value of key 1");
            String s2 = client.setKV(2, "Value of key 2");
            String s3 = client.setKV(1, "Update key 1");

            System.out.println("'" + s1 + "'");
            System.out.println("'" + s2 + "'");
            System.out.println("'" + s3 + "'");

            System.out.println("Get on key 1: " + client.getKV(1));


            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}